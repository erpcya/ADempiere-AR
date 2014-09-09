/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * Copyright (C) 2003-2014 E.R.P. Consultores y Asociados, C.A.               *
 * All Rights Reserved.                                                       *
 * Contributor(s): Raul Muñoz www.erpconsultoresyasociados.com                *
 *****************************************************************************/
package org.spin.form;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolTip;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.compiere.apps.form.FormFrame;
import org.compiere.apps.form.FormPanel;
import org.compiere.grid.ed.VLookup;
import org.compiere.model.MLookup;
import org.compiere.model.MLookupFactory;
import org.compiere.plaf.CompiereColor;
import org.compiere.swing.CPanel;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;
import org.compiere.util.Trx;
import org.spin.util.RangeSlider;

/**
 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a>
 *
 */
public class VJournalDay extends JournalDay
			implements FormPanel, ChangeListener {

	
		
	@Override
	public void init(int WindowNo, FormFrame frame) {
		
		m_WindowNo = WindowNo;
		//	m_frame = frame;
		Env.setContext(Env.getCtx(), m_WindowNo, "IsSOTrx", "Y");   //  defaults to no
		try
		{
			dyInit();
			jbInit();
			frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
			
		}
		catch(Exception e)
		{
			
		}
	}
	/**	Window No			*/
	private int         m_WindowNo = 0;
	/**	FormFrame			*/
	//	private FormFrame 	m_frame;
	private BorderLayout 	mainLayout = new BorderLayout();
	
	
	private CPanel 		mainPanel    = new CPanel();
	private CPanel 		northPanel   = new CPanel();
	private CPanel		rightPanel	 = new CPanel();
	private CPanel		leftPanel	 = new CPanel();
	private JSplitPane	detailPanel  = new JSplitPane();
	private String		trxName = Trx.createTrxName("GM");
	/** Journal */
	private JLabel 		journalLabel  = new JLabel();
	private VLookup 	journalSearch = null;
	private CPanel		hoursPanel    = new CPanel();
	private JLabel 		groupLabel  = new JLabel();
	private JScrollPane scrollPane;
	/** Save */
	private JButton		bSave = new JButton();
	/** Incidence */

	private void jbInit() {
		CompiereColor.setBackground(mainPanel);
		mainPanel.setLayout(mainLayout);
		//
		journalLabel.setText(Msg.translate(Env.getCtx(), "Journal"));
		northPanel.add(journalSearch);
		northPanel.add(bSave);
		bSave.setText(Msg.translate(Env.getCtx(), "Save"));
		
	
	    //	Split Panel
		detailPanel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		detailPanel.setBorder(BorderFactory.createEtchedBorder());
		detailPanel.setPreferredSize(new Dimension(600,250));
		detailPanel.setMinimumSize(new Dimension(600, 200));
		detailPanel.setLeftComponent(leftPanel);
		detailPanel.setRightComponent(rightPanel);
		//	Scroll Panel
		scrollPane = new JScrollPane(rightPanel,
	            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		detailPanel.setRightComponent(scrollPane);
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(detailPanel, BorderLayout.CENTER);
	}
	public void dyInit() throws Exception{
		//	GET Journal
		int AD_Column_ID = 1000077;		//	C_Order.C_BPartner_ID
		String nameGroup="";
		MLookup lookupBPartner = MLookupFactory.get(Env.getCtx(), m_WindowNo, 0, AD_Column_ID, DisplayType.TableDir);
		journalSearch = new VLookup("HR_Journal_ID", true, false, true, lookupBPartner);
		hoursPanel.setBackground(Color.BLUE);
		hoursPanel.setPreferredSize(new Dimension(1600, 15));
		hoursPanel.setMaximumSize(new Dimension(1600, 15));
		leftPanel.setLayout(new BorderLayout()); 
		leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
		hoursPanel.setLayout(new GridBagLayout());
		
		rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
		groupLabel.setText("Grupos de Incidencias:");
		leftPanel.add(groupLabel);

		for(int i = 0; i <= 24; i++){
			JLabel hoursLabel = new JLabel(i+":00", JLabel.CENTER);
			hoursLabel.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.black));
			hoursLabel.setForeground(Color.WHITE);
			hoursLabel.setPreferredSize(new Dimension(60, 15));
			hoursLabel.setMinimumSize(new Dimension(60, 15));
			hoursLabel.setMaximumSize(new Dimension(60, 15));
			
			hoursPanel.add(hoursLabel,new GridBagConstraints(i, 0, 1, 0, 0.1, 0.0
			    ,GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		}

		rightPanel.add(hoursPanel);
		
		ArrayList<KeyNamePair> dataG = getGroupIncidenceData(trxName);
		
			for(KeyNamePair pp : dataG) {
				
				//	Add Label Incidence left Panel
				nameGroup= pp.toString();
				
				JLabel groupInLabel = new JLabel();
				groupInLabel.setText(nameGroup);
				leftPanel.add(groupInLabel);
				
				//	Add Slider Hours rightPanel
				ArrayList<KeyNamePair> dataI = getIncidenceData(trxName,pp.getKey());
				RangeSlider hourSlider = new RangeSlider();
				hourSlider.setMinimum(0);
			    hourSlider.setMaximum(48);
			    hourSlider.setValue(5);
			    hourSlider.setUpperValue(23);
			    hourSlider.setToolTipText(""+hourSlider.getValue());
			    rightPanel.add(hourSlider);
			   
		 	}
			
	}
	public void actionPerformed(ActionEvent e)
	{
			
				
	}
	@Override
	public void dispose() {
		

	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		
		
	}
	

}
