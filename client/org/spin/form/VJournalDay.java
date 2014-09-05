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


import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
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
		//m_frame = frame;
		Env.setContext(Env.getCtx(), m_WindowNo, "IsSOTrx", "Y");   //  defaults to no
		try
		{
			dyInit();
			jbInit();
			frame.getContentPane().add(mainPanel);
			
		}
		catch(Exception e)
		{
			
		}
	}
	/**	Window No			*/
	private int         m_WindowNo = 0;
	/**	FormFrame			*/
	//private FormFrame 	m_frame;
	
	
	private CPanel 		mainPanel    = new CPanel();
	private CPanel 		northPanel   = new CPanel();
	private CPanel		hourPanel	 = new CPanel();
	private CPanel		rightPanel	 = new CPanel();
	private CPanel		leftPanel	 = new CPanel();
	private JSplitPane	detailPanel  = new JSplitPane();
	private JLabel	 	conceptLabel = new JLabel();
	private String	trxName = null;
	/** Journal */
	private JLabel 		journalLabel = new JLabel();
	private VLookup 	journalSearch = null;
	
	
	/** Save */
	private JButton		bSave = new JButton();
	
	/** Incidence */


	private void jbInit() {
		CompiereColor.setBackground(mainPanel);
		mainPanel.setPreferredSize(new Dimension(800,400));
		//
		journalLabel.setText(Msg.translate(Env.getCtx(), "Journal"));
		
		northPanel.add(journalSearch);
		northPanel.add(bSave);
		bSave.setText(Msg.translate(Env.getCtx(), "Save"));
	
	    
	    //	Label Concept
	   
		detailPanel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		detailPanel.setBorder(BorderFactory.createEtchedBorder());
		detailPanel.setPreferredSize(new Dimension(800,250));
		detailPanel.setDividerLocation(150);
		detailPanel.setLeftComponent(leftPanel);
		detailPanel.setRightComponent(rightPanel);
		
		//	Slider Hours
		for(int i = 1; i < 11; i++) {
			
			
			RangeSlider hourSlider = new RangeSlider();
			
			hourSlider.setPreferredSize(new Dimension(240, hourSlider.getPreferredSize().height));
			hourSlider.setMinimum(0);
		    hourSlider.setMaximum(100);
		    hourSlider.setValue(5);
		    hourSlider.setUpperValue(23);

			rightPanel.add(hourSlider);
			}
		mainPanel.add(northPanel);
		mainPanel.add(detailPanel);
	}
	public void dyInit() throws Exception{
		//	Bussines Journal
		int AD_Column_ID = 1000077;		//	C_Order.C_BPartner_ID
		MLookup lookupBPartner = MLookupFactory.get(Env.getCtx(), m_WindowNo, 0, AD_Column_ID, DisplayType.TableDir);
		journalSearch = new VLookup("HR_Journal_ID", true, false, true, lookupBPartner);
		
		ArrayList<KeyNamePair> data = getIncidenceData(trxName);
		//	Editar
		for(KeyNamePair pp : data) {
			JLabel groupInLabel = new JLabel();
			groupInLabel.setText("1");
			leftPanel.add(groupInLabel);
		}
		
		
	}
	@Override
	public void dispose() {
		

	}
	@Override
	public void stateChanged(ChangeEvent e) {
		
		
	}
	

}
