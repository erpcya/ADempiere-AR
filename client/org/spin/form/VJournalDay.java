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
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.poi.hssf.util.HSSFColor.WHITE;
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

/**
 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a>
 *
 */
public class VJournalDay extends JournalDay
			implements FormPanel, ChangeListener,ActionListener,MouseListener {

	
	@Override
	public void init(int WindowNo, FormFrame frame) {
		
		m_WindowNo = WindowNo;
			m_frame = frame;
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
		private FormFrame 	m_frame;
	private BorderLayout 	mainLayout = new BorderLayout();
	JCheckBox[] conceptBox;
	JButton[] h_IncidenceButton;
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
	static final int N_HOUR = 24;
	static final int N_MIN  = 60;
	private int s_Hour      = 120;
	private int start_Hour  = 1;
	private int start_Min  	= 1;
	private int end_Hour 	= 1;
	private int end_Min 	= 1;
    private JDialog hour_Dialog;
	/** Item JDialog */
	private JButton s_HourButton = new JButton();
	private JButton c_HourButton = new JButton();
	private JTextField s_HourText = new JTextField(4);
	private JTextField s_MinText = new JTextField(4);
	private JTextField e_HourText = new JTextField(4);
	private JTextField e_MinText = new JTextField(4);
	private JLabel title_Label = new JLabel();
	private JLabel s_HourLabel = new JLabel();
	private JLabel s_MinLabel = new JLabel();
	private JLabel e_HourLabel = new JLabel();
	private JLabel e_MinLabel = new JLabel();
	private int s_IncideceButton;
	private int aux = 0;
	
	private void jbInit() {
		CompiereColor.setBackground(mainPanel);
		mainPanel.setLayout(mainLayout);
		//	North Panel
		journalLabel.setText(Msg.translate(Env.getCtx(), "Journal"));
		northPanel.add(journalSearch);
		bSave.setText(Msg.translate(Env.getCtx(), "Save"));
		northPanel.add(bSave);
		
		//	Hour Edit frame
		hour_Dialog = new JDialog(m_frame, true);
		hour_Dialog.setBounds(500,800  - 200 - 320, 200, 200);
		s_HourText.setText("00");
		s_MinText.setText("00");
		e_HourText.setText("00");
		e_MinText.setText("00");
		s_HourLabel.setText("Hora Inicio");
		s_MinLabel.setSize(1, 8);
		s_MinLabel.setText(":");
		e_HourLabel.setText("Hora Final");
		e_MinLabel.setText(":");
		title_Label.setText("Ajustar Hora:");
		s_HourButton.setText("Save");
		s_HourButton.addActionListener(this);
		c_HourButton.setText("Cancel");
		c_HourButton.addActionListener(this);
		
        Container editHourPanel = hour_Dialog.getContentPane();
        editHourPanel.setLayout(new GridBagLayout());
        // add element containers
        editHourPanel.add(title_Label,  new GridBagConstraints(2, 0, 3, 1, 1.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
        editHourPanel.add(s_HourLabel,  new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(s_HourText, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(s_MinLabel, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(s_MinText, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(e_HourLabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(e_HourText, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(e_MinLabel,  new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(e_MinText, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(s_HourButton, new GridBagConstraints(2, 3, 2, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0)); 
		editHourPanel.add(c_HourButton, new GridBagConstraints(3, 3, 2, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
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
		GridLayout experimentLayout = new GridLayout(0,24,0,0);
		
		MLookup lookupBPartner = MLookupFactory.get(Env.getCtx(), m_WindowNo, 0, AD_Column_ID, DisplayType.TableDir);
		journalSearch = new VLookup("HR_Journal_ID", true, false, true, lookupBPartner);
		hoursPanel.setBackground(Color.BLUE);
		hoursPanel.setMaximumSize(new Dimension(s_Hour*25, 15));
		leftPanel.setLayout(new BorderLayout()); 
		leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
		hoursPanel.setLayout(experimentLayout);
		rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
		groupLabel.setFont(new Font("SanSerif", Font.PLAIN, 14));
		groupLabel.setText("Grupos de Incidencias:");
		leftPanel.add(groupLabel);

		for(int i = 0; i < 24; i++){
			JLabel hoursLabel = new JLabel("",JLabel.CENTER);
			if(i < 10)
				hoursLabel.setText("0"+i+":30");
			else 
				hoursLabel.setText(i+":30");
			//	Hours Label Line
			hoursLabel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
			hoursLabel.setForeground(Color.WHITE);
			hoursLabel.setFont(new Font("SanSerif", Font.PLAIN, 14));
			hoursLabel.setPreferredSize(new Dimension(s_Hour, 15));
			hoursLabel.setMinimumSize(new Dimension(s_Hour, 15));
			hoursLabel.setMaximumSize(new Dimension(s_Hour, 15));
			hoursPanel.add(hoursLabel);
		}

		rightPanel.add(hoursPanel);
		//	Add element (incidence)
		addItems();
	
	}
	
	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 10/09/2014, 09:21:46
	 * @return void
	 */
	public void addItems() {
		int i=0;
		ArrayList<KeyNamePair> data = getGroupIncidenceData(trxName);
		conceptBox = new JCheckBox[data.size()];
		h_IncidenceButton = new JButton[data.size()];
		sliderPanel = new JPanel[data.size()];
	
		for(KeyNamePair pp : data) {
				conceptBox[i]  = new JCheckBox(pp.toString(), true);
			    sliderPanel[i] = new JPanel();
			    conceptBox[i].setFont(new Font("SanSerif", Font.PLAIN, 14));
				conceptBox[i].addActionListener(this);
			    conceptBox[i].setMaximumSize(new Dimension(150, 15));
			    conceptBox[i].setName("--"+i);
			    //	Add Hours Button Line
			    addPanelHour(i);
			    sliderPanel[i].setLayout(null);
			    sliderPanel[i].setMaximumSize(new Dimension(s_Hour*25, 15));
			    sliderPanel[i].add(h_IncidenceButton[i]);
			    //	Add Label Cocept rightPanel
			    leftPanel.add(conceptBox[i]);
			    //	Add Slider Hours rightPanel
			    rightPanel.add(sliderPanel[i]);		   
			    i++;
		}
	}

/**
 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a>
 *
 */
public void addPanelHour(int i) {
			h_IncidenceButton[i]  = new JButton();
		 	h_IncidenceButton[i].setName(String.valueOf(i));
		    h_IncidenceButton[i].setBackground(Color.GREEN);
		    h_IncidenceButton[i].setForeground(Color.GREEN);
		    Border thickBorder = new LineBorder(Color.GREEN, 1);
		    h_IncidenceButton[i].setBorder(thickBorder);
		    h_IncidenceButton[i].setSize(new Dimension(40,11));
		    h_IncidenceButton[i].setLocation(20, 0);
		    h_IncidenceButton[i].addActionListener(this);
		    h_IncidenceButton[i].addMouseListener(this);
		    h_IncidenceButton[i].setText(String.valueOf(i));

	}
	  @Override
	  public void mousePressed(MouseEvent e) {
		  int count=conceptBox.length;

			for(int i = 0; i < count; i++){
				
			}
	    }

	@Override
	public void stateChanged(ChangeEvent e) {
		
		int count=conceptBox.length;
		for(int i = 0; i < count; i++){
			
		}
	}
	
	public void actionPerformed(ActionEvent e){
		int count=conceptBox.length;     
		for(int i = 0;  i< count; i++ ){
			if(e.getActionCommand().equals(h_IncidenceButton[i].getText())){
				aux=i;
				hour_Dialog.setVisible(true);
			}
			if(conceptBox[i].isSelected())
				h_IncidenceButton[i].setVisible(true);
			else 
				h_IncidenceButton[i].setVisible(false);	
		}
		
		if(e.getActionCommand().equals(s_HourButton.getText())){
			start_Hour = Integer.parseInt(s_HourText.getText())*s_Hour;
			end_Hour   = Integer.parseInt(e_HourText.getText())*s_Hour;
			start_Min  = Integer.parseInt(s_MinText.getText())*s_Hour/N_MIN;
			end_Min  = Integer.parseInt(e_MinText.getText())*s_Hour/N_MIN;
			s_IncideceButton = (end_Hour+end_Min)-(start_Hour+start_Min);
			if(start_Hour<end_Hour){
			h_IncidenceButton[aux].setSize(new Dimension(s_IncideceButton,11));
		    h_IncidenceButton[aux].setLocation(start_Hour+start_Min, 0);
		    hour_Dialog.setVisible(false);
			}
			else{
				JOptionPane.showMessageDialog(null, "La hora de inicio debe ser menor que la hora final");
			}
	    }

		if(e.getActionCommand().equals(c_HourButton.getText())){
			hour_Dialog.setVisible(false);
		}
	   
	} 	//  actionPerformed
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
		int count=conceptBox.length;     
		for(int i = 0;  i< count; i++ ){
			if(e.getComponent().getName().equals(h_IncidenceButton[i].getText())){
			Border thickBorder = new LineBorder(Color.WHITE, 3);
			h_IncidenceButton[i].setBorder(thickBorder);
			}
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		int count=conceptBox.length;     
		for(int i = 0;  i< count; i++ ){
			if(e.getComponent().getName().equals(h_IncidenceButton[i].getText())){
			Border thickBorder = new LineBorder(Color.GREEN, 1);
			h_IncidenceButton[i].setBorder(thickBorder);
			}
		}
		
	}
	
	

}


