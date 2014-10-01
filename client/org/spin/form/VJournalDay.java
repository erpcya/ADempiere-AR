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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.Calendar;

import java.sql.Time;
import java.sql.Timestamp;
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
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.compiere.apps.form.FormFrame;
import org.compiere.apps.form.FormPanel;
import org.compiere.grid.ed.VLookup;
import org.compiere.model.MLookup;
import org.compiere.model.MLookupFactory;
import org.compiere.plaf.CompiereColor;
import org.compiere.swing.CComboBox;
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
			implements FormPanel, ChangeListener,ActionListener,MouseListener, VetoableChangeListener {

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
	/** Arrays for Line Journal */
	private JCheckBox[] conceptBox;
	private JButton[] 	h_IncidenceButton;
	private JButton[] 	a_IncidenceButton;
	private JPanel[] 	sliderPanel;
	private JPanel[] 	hPanel;
	private int[] 		HR_Incidence;
	/** 						*/
	private CPanel 		mainPanel    	 = new CPanel();
	private CPanel 		northPanel   	 = new CPanel();
	private CPanel		rightPanel	 	 = new CPanel();
	private CPanel		leftPanel	 	 = new CPanel();
	private CPanel		hoursPanel    	 = new CPanel();
	private JSplitPane	detailPanel  	 = new JSplitPane();
	private String		trxName 		 = Trx.createTrxName("GM");
	/** Journal 				*/
	private JLabel 		journalLabel     = new JLabel();
	private VLookup 	journalSearch    = null;
	/** Hours Slot 				*/
	private JLabel		s_SlotLabel	     = new JLabel();
	private JLabel		e_SlotLabel	     = new JLabel();
	private JTextField	s_SlotButton 	= new JTextField(5);
	private JTextField	e_SlotButton 	= new JTextField(5);

	/**	Group Incidence			*/
	private JLabel 		groupLabel  	 = new JLabel();
	private JScrollPane scrollPane;
	/** Save */
	private JButton		bSave 			 = new JButton();
	private JDialog 	hour_Dialog;
	/** Label Title 			*/
	private JLabel title_Label = new JLabel();
	/**  Start Slot Hour 		*/    
    private JLabel 		s_HourLabel 	 = new JLabel();
	private CComboBox 	s_HourList 		 = new CComboBox();
	/**  Start Slot Min 		*/
	private JLabel 		s_MinLabel 	  	 = new JLabel();
	private CComboBox 	s_MinList 		 = new CComboBox();
	/**  End Slot Hour 			*/
	private JLabel 		e_HourLabel		 = new JLabel();
	private CComboBox 	e_HourList 		 = new CComboBox();
	/**  End Slot Min 			*/
	private JLabel 		e_MinLabel		 = new JLabel();
	private CComboBox 	e_MinList 		 = new CComboBox();
	/**  Save Slot Button 		*/
    private JButton 	s_HourButton	 = new JButton();
	private JButton 	c_HourButton	 = new JButton();
	/**  Save Slot Button 		*/
	private int 		s_IncideceButton = 0;
	private int 		aux 			 = 0;
	/**  Total Button 		*/
	private int 		t_Button  		 = 0;
	/** Incidence */
	static final int 	N_HOUR 			 = 24;
	static final int 	N_MIN  			 = 60;
	private int 		s_Hour      	 = 120;
	private int 		start_Hour  	 = 1;
	private int 		start_Min  		 = 1;
	private int 		end_Hour 		 = 1;
	private int 		end_Min 		 = 1;
	Calendar cal2 = Calendar.getInstance();
	
	private void jbInit() {
		CompiereColor.setBackground(mainPanel);
		mainPanel.setLayout(mainLayout);
		
		
		//	North Panel
		northPanel.setLayout(new GridBagLayout());	
		journalLabel.setText(Msg.translate(Env.getCtx(), "Journal"));
		s_SlotLabel.setText("Inicio Hora Descanso");
		e_SlotLabel.setText("Fin Hora Descanso");
		s_SlotButton.setEditable(false);
		e_SlotButton.setEditable(false);
		bSave.setText(Msg.translate(Env.getCtx(), "Save"));
		northPanel.add(journalLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0)); 
		northPanel.add(journalSearch, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		northPanel.add(bSave, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		northPanel.add(s_SlotLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		northPanel.add(s_SlotButton, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		northPanel.add(e_SlotLabel, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		northPanel.add(e_SlotButton, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		//	Hour Edit Hours Dialog
		hour_Dialog = new JDialog(m_frame, true);
		hour_Dialog.setBounds(500,800  - 200 - 320, 245, 200);
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
		s_HourList.setMaximumSize(new Dimension(4, 10));
		s_HourList.setEditable(true);
		for(int i = 0; i < 24; i++) {
			s_HourList.addItem(i);
			e_HourList.addItem(i);
		}
		for(int i = 1; i < 60; i++) {
			s_MinList.addItem(i);
			e_MinList.addItem(i);
		}
		
        Container editHourPanel = hour_Dialog.getContentPane();
        editHourPanel.setLayout(new GridBagLayout());
        // add element containers
        editHourPanel.add(title_Label,  new GridBagConstraints(2, 0, 3, 1, 1.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
        editHourPanel.add(s_HourLabel,  new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(s_HourList, new GridBagConstraints(2, 1, 1, 1, 1.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(s_MinLabel, new GridBagConstraints(3, 1, 1, 1, 1.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(s_MinList, new GridBagConstraints(4, 1, 1, 1, 1.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(e_HourLabel, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(e_HourList, new GridBagConstraints(2, 2, 1, 1, 1.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(e_MinLabel,  new GridBagConstraints(3, 2, 1, 1, 1.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(e_MinList, new GridBagConstraints(4, 2, 1, 1, 1.0, 0.0
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
		journalSearch.addVetoableChangeListener(this);
		hoursPanel.setBackground(Color.BLUE);
		hoursPanel.setMaximumSize(new Dimension(s_Hour*25, 15));
		
		leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
		hoursPanel.setLayout(experimentLayout);
		rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
		groupLabel.setFont(new Font("SanSerif", Font.PLAIN, 14));
		groupLabel.setText("Grupos de Incidencias:");

		groupLabel.setMinimumSize(new Dimension(170, 15));
	
	 	
		
	
		
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
		leftPanel.add(groupLabel);
		rightPanel.add(hoursPanel);
	}
	
	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 10/09/2014, 09:21:46
	 * @return void
	 */
	public void addItems(int p_HR_Journal_ID) {
		int i=0;
		
		rightPanel.removeAll();
		leftPanel.removeAll();
		  aux=0;
		  t_Button=0;
		rightPanel.setMinimumSize(new Dimension(170,800));
		leftPanel.add(groupLabel);
		rightPanel.add(hoursPanel);
		//	Add element (incidence)
		ArrayList<KeyNamePair> data = getGroupIncidenceData(p_HR_Journal_ID,trxName);
		setStartHour(p_HR_Journal_ID,trxName);
		setEndHour(p_HR_Journal_ID,trxName);
		conceptBox = new JCheckBox[data.size()];
		h_IncidenceButton = new JButton[30];
		a_IncidenceButton = new JButton[data.size()];
		sliderPanel = new JPanel[30];
		HR_Incidence=new int[data.size()];
	    
		hPanel = new JPanel[data.size()];
		for (int j = 0; j < 30; j++){
			  h_IncidenceButton[j]  = new JButton();
		}
		for(KeyNamePair pp : data) {
			sliderPanel[i] = new JPanel();	
			conceptBox[i]  = new JCheckBox(pp.toString(), true);
			HR_Incidence[i]=Integer.parseInt(pp.getID());
		    
		    a_IncidenceButton[i]  = new JButton();
		    hPanel[i] = new JPanel();
		    
		    conceptBox[i].setFont(new Font("SanSerif", Font.PLAIN, 14));
			conceptBox[i].addActionListener(this);
		    conceptBox[i].setName("--"+i);
		    conceptBox[i].setMinimumSize(new Dimension(130, 15));
		    
		    a_IncidenceButton[i].setMinimumSize(new Dimension(10,10));
		    a_IncidenceButton[i].setMaximumSize(new Dimension(11,11));
		    a_IncidenceButton[i].setText("+");
		    a_IncidenceButton[i].setName("--"+i);
		  
		    a_IncidenceButton[i].addActionListener(this);
			   
			   
		    sliderPanel[i].setLayout(null);
  		    sliderPanel[i].setMaximumSize(new Dimension(s_Hour*25, 15));
				  
		    //	Add Hours Button Line
	    	rightPanel.add(sliderPanel[i]);
			addButtonHour(i,i);
			//	Add Label Cocept rightPanel
			hPanel[i].setLayout(new BorderLayout()); 
			hPanel[i].setMaximumSize(new Dimension(250, 15));
			hPanel[i].add(conceptBox[i], BorderLayout.CENTER);
			hPanel[i].add(a_IncidenceButton[i], BorderLayout.LINE_END);
		    leftPanel.add(hPanel[i]);
		    //	Add Slider Hours rightPanel
		    i++;
		}

		 leftPanel.repaint();
		 rightPanel.repaint();
	}

/**
 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a>29/09/2014, 09:21:46
 *	Add Button Hour
 */
public void addButtonHour(int i, int j) {
	//	Set HR_Incidence_ID for Get RGBColor
    setRGB(HR_Incidence[i],trxName);
    //calculate(m_StartHour, m_EndHour);
    start_Hour = ((int) m_StartHour.getTime() /3600000)-4 ;
	end_Hour   =((int) m_EndHour.getTime() /3600000)-4;
	float fstart_Hour   =(float) ((((int) m_EndHour.getTime() /3600000)-4)*1.6);
	float fend_Hour   =(float) ((((int) m_EndHour.getTime() /3600000)-4));
	
	  h_IncidenceButton[j].setName(String.valueOf(j));
	  h_IncidenceButton[j].setIconTextGap(i);
	  h_IncidenceButton[j].setBackground(new Color(m_RColor, m_GColor, m_BColor));
	  h_IncidenceButton[j].setForeground(new Color(m_RColor, m_GColor, m_BColor));
	  Border thickBorder = new LineBorder(new Color(m_RColor, m_GColor, m_BColor), 0);
	  h_IncidenceButton[j].setBorder(thickBorder);
	  h_IncidenceButton[j].setSize(new Dimension(((end_Hour+ (int) fstart_Hour)-(start_Hour+(int) fend_Hour))*120,11));
	  h_IncidenceButton[j].setLocation(start_Hour*120, 0);
	  h_IncidenceButton[j].addActionListener(this);
	  h_IncidenceButton[j].addMouseListener(this);
	  h_IncidenceButton[j].setText(String.valueOf(j));
	  sliderPanel[i].add(h_IncidenceButton[j]);
	  sliderPanel[i].repaint();
	  t_Button++;
	} //	addPanelHour

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
		int j=0; 
		if(e.getActionCommand().equals(c_HourButton.getText())){
			hour_Dialog.setVisible(false);
		}
		
		if(e.getActionCommand().equals(s_HourButton.getText())){
			//calculate((Integer) s_HourList.getSelectedItem(),(Integer) e_HourList.getSelectedItem());
			if(start_Hour<end_Hour){
				hour_Dialog.setVisible(false);
				
				start_Hour = (Integer) s_HourList.getSelectedItem() * s_Hour;
				end_Hour   = (Integer) e_HourList.getSelectedIndex() * s_Hour;
				start_Min  = (Integer) s_MinList.getSelectedIndex() * s_Hour / N_MIN;
				end_Min    = (Integer) e_MinList.getSelectedItem() * s_Hour / N_MIN;
				s_IncideceButton = (end_Hour+end_Min)-(start_Hour+start_Min);
				h_IncidenceButton[aux].setLocation(start_Hour+start_Min, 0);
			    
				Timer timer = new Timer(10, new ActionListener() {
						 int  n=0;
					   public void actionPerformed(ActionEvent e) {
					    if(n<=s_IncideceButton){
					    	h_IncidenceButton[aux].setSize(new Dimension(n,11));
					     n=n+10;
					     	
					    }
					   }
					  });
					  
					  timer.start();
			}
			else{
				JOptionPane.showMessageDialog(null, "Invalid Hour");
			}
	    }
		for(int i = 0;  i< count; i++ ){
			if(conceptBox[i].isSelected()){
				for(int x = 0; x<t_Button; x++){
					a_IncidenceButton[i].setVisible(true);
				if(h_IncidenceButton[x].getIconTextGap()==i)
					h_IncidenceButton[x].setVisible(true);		
				}
			}
			else { 
				for(int x = 0; x<t_Button; x++){
					a_IncidenceButton[i].setVisible(false);
				if(h_IncidenceButton[x].getIconTextGap()==i)
					h_IncidenceButton[x].setVisible(false);
				}
			}
			if(e.getSource().equals(a_IncidenceButton[i])){
				addButtonHour(i,t_Button);
				aux=t_Button-1;
				hour_Dialog.setVisible(true);	
			}
		}
		while(true){
			j++;
			if(e.getActionCommand().equals(h_IncidenceButton[j-1].getText())){
				aux=j-1;
				hour_Dialog.setVisible(true);	
				break;
			}	if(j==t_Button)break;
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
		int i = 0;
		while( true ){
			 i++;
				if(e.getComponent().getName().equals(h_IncidenceButton[i-1].getName())){
			Border thickBorder = new LineBorder(Color.WHITE, 3);
			h_IncidenceButton[i-1].setBorder(thickBorder);
			break;
			}
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {   
		int i = 0;
		while(true){
			i++;
			if(e.getComponent().getName().equals(h_IncidenceButton[i-1].getName())){
			Border thickBorder = new LineBorder(new Color(m_RColor, m_GColor, m_BColor), 0);
			h_IncidenceButton[i-1].setBorder(thickBorder);
			break;
			} 
		}		
	}	

	@Override
	public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
		if(evt.getSource().equals(journalSearch)){
			m_HR_Journal_ID=(Integer) journalSearch.getValue();
			setTime(m_HR_Journal_ID,trxName);
			addItems(m_HR_Journal_ID);
			m_startTime.toString();
			
			s_SlotButton.setText(String.valueOf(new Time (m_startTime.getTime())));
			e_SlotButton.setText(String.valueOf(new Time (m_endTime.getTime())));
		}
	}
	 public void calculate(Timestamp p_SHour, Timestamp p_EHour){

		 start_Hour = 4 - (int) p_SHour.getTime() /3600000 ;
			end_Hour   =(int) p_EHour.getTime() /3600000;
			s_IncideceButton = (end_Hour+end_Min)-(start_Hour+start_Min);
	 }

}

