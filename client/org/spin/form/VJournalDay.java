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
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import org.compiere.util.Trx;
import org.spin.util.RangeSlider;

/**
 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a>
 *
 */
public class VJournalDay extends JournalDay
			implements FormPanel, ChangeListener,ActionListener,MouseListener {

	
		
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
	JCheckBox[] conceptBox;
	RangeSlider[] hourSlider;
	JPanel[] sliderPanel;
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

		MLookup lookupBPartner = MLookupFactory.get(Env.getCtx(), m_WindowNo, 0, AD_Column_ID, DisplayType.TableDir);
		journalSearch = new VLookup("HR_Journal_ID", true, false, true, lookupBPartner);
		hoursPanel.setBackground(Color.BLUE);
		hoursPanel.setMaximumSize(new Dimension(120*24, 15));
		leftPanel.setLayout(new BorderLayout()); 
		leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
		hoursPanel.setLayout(new GridBagLayout());
		
		rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
		groupLabel.setText("Grupos de Incidencias:");
		leftPanel.add(groupLabel);

		for(int i = 0; i <= 24; i++){
			JLabel hoursLabel = new JLabel("",JLabel.CENTER);
			if(i < 10)
				hoursLabel.setText("0"+i+":00");
			else 
				hoursLabel.setText(i+":00");
	
			hoursLabel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
			hoursLabel.setForeground(Color.WHITE);
			hoursLabel.setFont(new Font("SanSerif", Font.PLAIN, 14));
			hoursLabel.setPreferredSize(new Dimension(120, 15));
			hoursLabel.setMinimumSize(new Dimension(120, 15));
			hoursLabel.setMaximumSize(new Dimension(120, 15));
			
			hoursPanel.add(hoursLabel,new GridBagConstraints(i, 0, 1, 0, 0.0, 0.0
			    ,GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		}

		rightPanel.add(hoursPanel);
		addItems();
		
			
	}
	
	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 10/09/2014, 09:21:46
	 * @return void
	 */
	public void addItems() {
		int i=0;
		int n_Hour = 24;
		int s_Hour = 100;
		int s_division = 5;
		int s_Conv_Hour = s_Hour/s_division;
		int s_Slider = s_Conv_Hour*n_Hour;
		
		ArrayList<KeyNamePair> data = getGroupIncidenceData(trxName);
		conceptBox = new JCheckBox[data.size()];
		hourSlider = new RangeSlider[data.size()];
		sliderPanel = new JPanel[data.size()];
		for(KeyNamePair pp : data) {
			
				conceptBox[i]  = new JCheckBox(pp.toString(), true);
			    hourSlider[i]  = new RangeSlider();
			    sliderPanel[i] = new JPanel();
			    
				conceptBox[i].addActionListener(this);
			    conceptBox[i].setMaximumSize(new Dimension(150, 15));
			    
				hourSlider[i].setMinimum(0);
			    hourSlider[i].setMaximum(s_Slider);
			    hourSlider[i].setValue(30);
			    hourSlider[i].setUpperValue(50);
			    hourSlider[i].setToolTipText(""+hourSlider[i].getValue()+"-"+hourSlider[i].getUpperValue());
			    hourSlider[i].addMouseListener(this);
			    sliderPanel[i].setLayout(new BoxLayout(sliderPanel[i],BoxLayout.Y_AXIS));
			    sliderPanel[i].setMaximumSize(new Dimension(120*24, 15));
			    sliderPanel[i].add(hourSlider[i]);
			    //	Add Label Cocept rightPanel
			    leftPanel.add(conceptBox[i]);
			    //	Add Slider Hours rightPanel
			    rightPanel.add(sliderPanel[i]);		   
			    i++;
		}
		
	}	  
	  @Override
	  public void mousePressed(MouseEvent e) {
		  int count=conceptBox.length;

			for(int i = 0; i < count; i++){
				if(hourSlider[i].getValue()/200 < 10)
					hourSlider[i].setToolTipText("0"+hourSlider[i].getValue()+":00-"+hourSlider[i].getUpperValue()+":00");
				else
					hourSlider[i].setToolTipText(""+hourSlider[i].getValue()+":00-"+hourSlider[i].getUpperValue()+":00");
			}
	    }

	@Override
	public void stateChanged(ChangeEvent e) {
		int count=conceptBox.length;
		for(int i = 0; i < count; i++){
			if(hourSlider[i].getValue()/2 < 10)
				hourSlider[i].setToolTipText("0"+hourSlider[i].getValue()+"-"+hourSlider[i].getUpperValue());
			else
				hourSlider[i].setToolTipText(""+hourSlider[i].getValue()+":00-"+hourSlider[i].getUpperValue()+":00");
		}
	}
	public void actionPerformed(ActionEvent e){
		int count=conceptBox.length;
		for(int i = 0; i < count; i++){
			if(conceptBox[i].isSelected()) {
				hourSlider[i].setVisible(true);
				
			}
			else {
				hourSlider[i].setVisible(false);
			}
			
		}
	}
	@Override
	public void dispose() {
		

	}
	@Override
	public void mouseClicked(MouseEvent e) {
	
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	
		
	}
	@Override
	public void mouseExited(MouseEvent e) {

		
	}
	
	

}
