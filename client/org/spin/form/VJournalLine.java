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
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.compiere.apps.ADialog;
import org.compiere.apps.StatusBar;
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
import org.compiere.util.TrxRunnable;

/**
 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a>
 *
 */
public class VJournalLine extends JournalLine 
			implements FormPanel, ChangeListener,ActionListener,MouseListener, VetoableChangeListener, KeyListener  {
	@Override
	public void init(int WindowNo, FormFrame frame) {
		m_WindowNo = WindowNo;
			m_frame = frame;
		Env.setContext(Env.getCtx(), m_WindowNo, "IsSOTrx", "Y");   //  defaults to no
		Trx.get(trxName, true);
		try	{
			dyInit();
			jbInit();
			frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
			frame.getContentPane().add(statusBar, BorderLayout.SOUTH);
			
		}
		catch(Exception e) {
		}
	}
	/**	Window No									*/
	private int         			m_WindowNo 		 = 0;
	/**	FormFrame									*/
	private FormFrame 				m_frame;
	private BorderLayout 			mainLayout 		 = new BorderLayout();
	/** Arrays for Line Journal 					*/
	private JCheckBox[] 			conceptBox;
	/** Buttons for Incidences						*/
	private JButton[] 				IncidenceButton;
	/** Add Incidence Button    					*/
	private JButton[] 				a_IncidenceButton;
	private JPanel[] 				sliderPanel;
	private JPanel[] 				hPanel;
	/** 											*/
	private CPanel 					mainPanel    	 = new CPanel();
	private CPanel 					northPanel   	 = new CPanel();
	private CPanel					rightPanel	 	 = new CPanel();
	private CPanel					leftPanel	 	 = new CPanel();
	private JPanel 					southPanel	  	 = new JPanel();
	private CPanel					hoursPanel    	 = new CPanel();
	private JSplitPane				detailPanel  	 = new JSplitPane();
	private String					trxName 		 = Trx.createTrxName("GM");
	/** Journal 									*/
	private JLabel 					journalLabel     = new JLabel();
	private VLookup 				journalSearch    = null;
	/**	Time Format Text							*/
    private DateFormat 				timeFormat		 = new SimpleDateFormat("k:mm");
	/** Start Hours Slot 									*/
	private JLabel					s_SlotLabel	     = new JLabel();
	private JFormattedTextField		s_SlotText 	 = new JFormattedTextField(timeFormat);
	/** End Hours Slot 									*/
	private JLabel					e_SlotLabel	     = new JLabel();
	private JFormattedTextField				e_SlotText 	 = new JFormattedTextField(timeFormat);
	/**	Group Incidence								*/
	private JLabel 					groupLabel  	 = new JLabel();
	private JScrollPane 			scrollPane;
	/** Save 										*/
	private JButton					saveButton 		 = new JButton();
	private JDialog 				hour_Dialog;
	/** Label Title 								*/
	private JLabel 					title_Label 	 = new JLabel();

    /**	Date Format Text							*/
    private DateFormat 				dateFormat 		 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/** Start Slot Hour Label						*/    
    private JLabel 					s_HourLabel 	 = new JLabel();	
    /**	Start Slot Hour								*/
    private JFormattedTextField		s_HourText 		 = new JFormattedTextField(timeFormat);
    /**  End Slot Hour Label								*/
	private JLabel 					e_HourLabel		 = new JLabel();
    /**	Start Slot Hour								*/
	private JFormattedTextField 	e_HourText 		 = new JFormattedTextField(timeFormat);
	/**  Save Slot Button 							*/
    private JButton 				s_HourButton	 = new JButton();
    /**  Cancel Button 								*/
	private JButton 				c_HourButton	 = new JButton();
	/**  Save Slot Button 							*/
	private int 					s_IncideceButton = 0;
	/**  Total Button 								*/
	private int 					t_Button  		 = 0;
	/** Status Bar									*/
	private StatusBar 				statusBar 	 	 = new StatusBar();
	/** Quantity of Hour 							*/
	static final int 				N_HOUR 			 = 24;
	/** Quantity of Min 							*/
	static final int 				N_MIN  			 = 60;
	/** Size Hour 					*/ 
	private int 					s_Hour      	 = 120;
	/** Start Hour 									*/
	private int 					start_Hour  	 = 1;
	/** End Hour 									*/
	private int 					end_Hour 		 = 1;
	/** Float Start Min								*/
	private float 					fstart_Min		 = 0;
	/**	Float End Min								*/
	private float 					fend_Min		 = 0;
	private int 					aux 			 = 0;
	private String[] v_StartHour=null;
	private String[] v_EndHour=null;
	private void jbInit() {
		CompiereColor.setBackground(mainPanel);
		mainPanel.setLayout(mainLayout);
		//	North Panel
		northPanel.setLayout(new GridBagLayout());	
		journalLabel.setText(Msg.translate(Env.getCtx(), "Journal"));
		s_SlotLabel.setText("Inicio Hora Descanso");
		e_SlotLabel.setText("Fin Hora Descanso");
		s_SlotText.setPreferredSize(new Dimension(50, 20));
		e_SlotText.setPreferredSize(new Dimension(50, 20));
		s_SlotText.setEditable(false);
		e_SlotText.setEditable(false);
		s_SlotText.addKeyListener(this);
		e_SlotText.addKeyListener(this);
		saveButton.setText(Msg.translate(Env.getCtx(), "Save"));
		saveButton.addActionListener(this);

		northPanel.add(journalLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0)); 
		northPanel.add(journalSearch, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		northPanel.add(s_SlotLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		northPanel.add(s_SlotText, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		northPanel.add(e_SlotLabel, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		northPanel.add(e_SlotText, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		//	Hour Edit Hours Dialog
		hour_Dialog = new JDialog(m_frame, true);
		hour_Dialog.setBounds(500,800  - 200 - 320, 245, 200);
		title_Label.setText("Ajustar Hora:");
		s_HourLabel.setText("Hora Inicio");
		e_HourLabel.setText("Hora Final");
		
		s_HourButton.setText("Save");
		s_HourButton.addActionListener(this);
		c_HourButton.setText("Cancel");
		c_HourButton.addActionListener(this);
		s_HourText.setMaximumSize(new Dimension(4, 10));
		s_HourText.setPreferredSize(new Dimension(80, 25));	
		s_HourText.setText("0:00");
		s_HourText.addKeyListener(this);
		e_HourText.setPreferredSize(new Dimension(80, 25));
		e_HourText.setText("1:00");
		 v_StartHour = s_HourText.getText().split(":");
		 v_EndHour = e_HourText.getText().split(":");
		e_HourText.addKeyListener(this);	

		
        Container editHourPanel = hour_Dialog.getContentPane();
        editHourPanel.setLayout(new GridBagLayout());
        // add element containers
        editHourPanel.add(title_Label,  new GridBagConstraints(1, 0, 2, 1, 1.0, 0.0
				,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
        editHourPanel.add(s_HourLabel,  new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(s_HourText, new GridBagConstraints(2, 1, 1, 1, 1.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(e_HourLabel, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		editHourPanel.add(e_HourText, new GridBagConstraints(2, 2, 1, 1, 1.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		editHourPanel.add(s_HourButton, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0)); 
		editHourPanel.add(c_HourButton, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0
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
		scrollPane.getViewport().setViewPosition(new Point(960,0));
		southPanel.add(saveButton);
		
		detailPanel.setRightComponent(scrollPane);
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(detailPanel, BorderLayout.CENTER);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		
	}
	public void dyInit() throws Exception{
		//	GET Journal
		int AD_Column_ID = 1000177;		//	HR_Journal.HR_Journal_ID
		GridLayout experimentLayout = new GridLayout(0,24,0,0);
		MLookup lookupJournal = MLookupFactory.get(Env.getCtx(), m_WindowNo, 0, AD_Column_ID, DisplayType.TableDir);
		journalSearch = new VLookup("HR_Journal_ID", true, false, true, lookupJournal);
		journalSearch.addVetoableChangeListener(this);
		statusBar.setStatusLine(Msg.getMsg(Env.getCtx(), "Journal Line"));
		statusBar.setStatusDB("");
		
		hoursPanel.setBackground(Color.BLUE);
		hoursPanel.setMaximumSize(new Dimension(s_Hour*25, 15));
		
		leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
		hoursPanel.setLayout(experimentLayout);
		rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
		groupLabel.setFont(new Font("SanSerif", Font.PLAIN, 14));
		groupLabel.setMinimumSize(new Dimension(170, 15));
		groupLabel.setText("Grupos de Incidencias:");
	
		for(int i = 0; i < 24; i++) {
			JLabel hoursLabel = new JLabel("",JLabel.CENTER);
			if(i < 10)
				hoursLabel.setText("0"+ i +":30");
			else 
			//	Hours Label Line
			hoursLabel.setText(i +":30");
			hoursLabel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
			hoursLabel.setForeground(Color.WHITE);
			hoursLabel.setFont(new Font("SanSerif", Font.PLAIN, 14));
			hoursLabel.setPreferredSize(new Dimension(s_Hour, 15));
			hoursPanel.add(hoursLabel);
		}
		leftPanel.add(groupLabel);
		rightPanel.add(hoursPanel);
	}
	/**
	 *  Add Items From Journal Line
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 27/10/2014, 14:16:24
	 * @param p_HR_Journal_ID
	 * @return void
	 */
	public void addItems(int p_HR_Journal_ID) {
		rightPanel.removeAll();
		leftPanel.removeAll();
		clearData();
		rightPanel.setMinimumSize(new Dimension(170,800));
		leftPanel.add(groupLabel);
		rightPanel.add(hoursPanel);
		int cont=0;
		// Get Concept Data 
		KeyNamePair[] dataC = getConceptData(p_HR_Journal_ID);
		
		conceptBox 		  = new JCheckBox[dataC.length];
		IncidenceButton   = new JButton[getLineCount(trxName)];
		a_IncidenceButton = new JButton[dataC.length];
		sliderPanel 	  = new JPanel[dataC.length];
		hPanel 			  = new JPanel[dataC.length];	
		for(int i = 0; i < IncidenceButton.length; i++) {
			IncidenceButton[i] = new JButton();
		}
		for(int i = 0; i < dataC.length; i++) {
			sliderPanel[i] = new JPanel();	
			conceptBox[i]  = new JCheckBox(dataC[i].getName(), true);
			
	    	m_HR_Concept_ID.add(i, dataC[i].getKey());
			KeyNamePair[] dataJL = getJournalLineData(p_HR_Journal_ID,m_HR_Concept_ID.get(i));

			a_IncidenceButton[i]  = new JButton();
		    hPanel[i] = new JPanel();

		    //	Name of Incidence
		    conceptBox[i].setFont(new Font("SanSerif", Font.PLAIN, 14));
			conceptBox[i].addActionListener(this);
		    conceptBox[i].setName(String.valueOf(i));
		    conceptBox[i].setMinimumSize(new Dimension(130, 15));
		   
		    //	Button From Add Incidence 
		    a_IncidenceButton[i].setMinimumSize(new Dimension(10,10));
		    a_IncidenceButton[i].setMaximumSize(new Dimension(11,11));
		    a_IncidenceButton[i].setText("+");
		    a_IncidenceButton[i].setName(String.valueOf(i));
		    a_IncidenceButton[i].addActionListener(this);
				  
  		    //	Add Slider Hours in rightPanel
	    	rightPanel.add(sliderPanel[i]);
			//	Add Label Cocept in rightPanel
			hPanel[i].setLayout(new BorderLayout()); 
			hPanel[i].setMaximumSize(new Dimension(250, 15));
			hPanel[i].add(conceptBox[i], BorderLayout.CENTER);
			hPanel[i].add(a_IncidenceButton[i], BorderLayout.LINE_END);
		    leftPanel.add(hPanel[i]);
		  
		    for(int j = 0; j < dataJL.length; j++) {
	    		//	Get Start Hour and End Hour
		    	getSE_Hour(Integer.parseInt(dataJL[j].getID()),trxName);
	    		start_Hour = (((int) m_StartHour.get(cont).getTime() / 3600000) - 4) * s_Hour;
	    		end_Hour   = (((int) m_EndHour.get(cont).getTime() / 3600000) - 4) * s_Hour;
	    		fstart_Min = ((((float) m_StartHour.get(cont).getTime() / 3600000) - 4) * s_Hour) - start_Hour;
	    		fend_Min   = ((((float) m_EndHour.get(cont).getTime()   / 3600000) - 4) * s_Hour) - end_Hour;
	    		addButtonHour(i,cont);
	    		cont++;
	    	}
		}
		 leftPanel.repaint();
		 rightPanel.repaint();
	}
	/**
	 * Add Button for Incidence Hour
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 27/10/2014, 14:16:08
	 * @param iSlider
	 * @param iButton
	 * @return void
	 */
	public void addButtonHour(int iSlider, int iButton) {
		IncidenceButton[iButton] = new JButton();
		//	Set HR_Concept_ID for Get RGBColor
		getColor(m_HR_Concept_ID.get(iSlider),trxName);
		IncidenceButton[iButton].setName(String.valueOf(iButton));
		IncidenceButton[iButton].setText(String.valueOf(iButton));
		IncidenceButton[iButton].setIconTextGap(iSlider);
		//	Set Background Color
		IncidenceButton[iButton].setBackground(new Color(m_RColor, m_GColor, m_BColor));
		IncidenceButton[iButton].setForeground(new Color(m_RColor, m_GColor, m_BColor));
		IncidenceButton[iButton].setBorder(BorderFactory.createLineBorder(new Color(m_RColor, m_GColor, m_BColor), 0));
		// Set Size
		IncidenceButton[iButton].setSize(new Dimension(((end_Hour+ (int) fend_Min)-(start_Hour+(int) fstart_Min)),11));
		// Set Position
		IncidenceButton[iButton].setLocation(start_Hour+(int) fstart_Min, 0);
		IncidenceButton[iButton].addActionListener(this);
		IncidenceButton[iButton].addMouseListener(this);
		sliderPanel[iSlider].setLayout(null);
		sliderPanel[iSlider].setMaximumSize(new Dimension(s_Hour*25, 15));
		sliderPanel[iSlider].add(IncidenceButton[iButton]);
		sliderPanel[iSlider].repaint();
		t_Button++;
	} //  addButtonHour

	  @Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void stateChanged(ChangeEvent e) {
	}
	/** 
	 * 	Calculate Size and Position From Incidence 
	 *	@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 24/10/2014, 11:45:16
	 *  @return void
	 */
	public void calculate() {
			hour_Dialog.setVisible(false);
			
			String hourString = dateFormat.format(s_HourText.getValue());
			Timestamp hourTime = Timestamp.valueOf(hourString);
			m_StartHour.add(hourTime);
			//	Convert Timestamp to Hour Start
			start_Hour = (((int) hourTime.getTime() / 3600000) - 4) * s_Hour;
			//	Convert Timestamp to Minute Start
			fstart_Min = ((((float) hourTime.getTime() / 3600000) - 4) * s_Hour) - start_Hour;
			
			hourString = dateFormat.format(e_HourText.getValue());
			hourTime =Timestamp.valueOf(hourString);
			m_EndHour.add(hourTime);
			//	Convert Timestamp to Hour End
			end_Hour   = (((int) hourTime.getTime() / 3600000) - 4) * s_Hour;
			//	Convert Timestamp to Minute End
			fend_Min   = ((((float) hourTime.getTime() / 3600000) - 4) * s_Hour) - end_Hour;
			
			if(start_Hour <= end_Hour) {
				//	Set Position
				IncidenceButton[aux].setLocation(start_Hour + (int) fstart_Min, 0);
				//	Size
				s_IncideceButton = (end_Hour+ (int) fend_Min)-(start_Hour+ (int) fstart_Min);
			}
			else {
				//	Set Position
				IncidenceButton[aux].setLocation(end_Hour + (int) fend_Min, 0);
				//	Size
				s_IncideceButton = (start_Hour+ (int) fstart_Min)-(end_Hour+ (int) fend_Min);
			}
			Timer timer = new Timer(10, new ActionListener() {
				   int  num=0;
				   public void actionPerformed(ActionEvent e) {
					   if(num <= s_IncideceButton) {
						   //  Set Size
						   IncidenceButton[aux].setSize(new Dimension(num,11));
						   num=num+10;					     	
					   }
				   }
			});
			timer.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		int count = conceptBox.length;
		int j = 0; 
		if(e.getActionCommand().equals(c_HourButton.getText())) {
			hour_Dialog.setVisible(false);
		}
		if(e.getActionCommand().equals(s_HourButton.getText())) {
			calculate();
	    }
		for(int i = 0;  i< count; i++) {
			if(conceptBox[i].isSelected()) {
				for(int x = 0; x < t_Button; x++) {
					//	Show Incidence Line
					a_IncidenceButton[i].setVisible(true);
					if(IncidenceButton[x].getIconTextGap() == i)
						IncidenceButton[x].setVisible(true);		
				}
			}
			else { 
				for(int x = 0; x < t_Button; x++) {
					//	Hide Incidence Line
					a_IncidenceButton[i].setVisible(false);
					if(IncidenceButton[x].getIconTextGap() == i)
						IncidenceButton[x].setVisible(false);
				}
			}
		}
		for(int i = 0;  i < count; i++) {
			if(e.getSource().equals(a_IncidenceButton[i])) {
				addButtonHour(i,t_Button);
				aux = t_Button-1;
				hour_Dialog.setVisible(true);	
			}
		}
		if(e.getActionCommand().equals(saveButton.getText())) {
			saveData();
		}
		while(true) {
			j++;
			if(t_Button != 0 && e.getActionCommand().equals(IncidenceButton[j-1].getText())) {
				aux = j-1;
				hour_Dialog.setVisible(true);	
				break;
			}
			if(j == t_Button) break;
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
		while( true ) {
			
			if(e.getComponent().getName().equals(IncidenceButton[i].getName())) {
				//	Add Border in focus 
				IncidenceButton[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
				break;
			}
			i++;
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {   
		int i = 0;
		while(true) {
			
			if(e.getComponent().getName().equals(IncidenceButton[i].getName())) {
				//	Remove Border
				IncidenceButton[i].setBorder(BorderFactory.createLineBorder(new Color(m_RColor, m_GColor, m_BColor), 0));
				break;
			} i++;
		}		
	}	
	@Override
	public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
		if(evt.getSource().equals(journalSearch)) {
			m_HR_Journal_ID=(Integer) journalSearch.getValue();
			//	Get Time Slot Journal Line
			getTimeSlot(m_HR_Journal_ID,trxName);
			//	Add Items
			addItems(m_HR_Journal_ID);
			m_TimeSlotStart.toString();
			s_SlotText.setValue(m_TimeSlotStart.getTime());
			e_SlotText.setValue(m_TimeSlotEnd.getTime());
			s_SlotText.setEditable(true);
			e_SlotText.setEditable(true);

		}
	}
	/**
	 * Clear Data
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 21/10/2014, 14:07:38
	 * @return void
	 */
	public void clearData() {
		aux				  = 0;
		s_IncideceButton  = 0;
		t_Button  		  = 0;
		start_Hour  	  = 1;
		end_Hour 		  = 1;
		IncidenceButton   = null;
 		fstart_Min		  = 0;
		fend_Min		  = 0;
		a_IncidenceButton = null;
		sliderPanel 	  = null;
		hPanel 			  = null;
		m_HR_Concept_ID.clear();
		m_StartHour.clear();
		m_EndHour.clear();
		s_SlotText.setEditable(false);
		e_SlotText.setEditable(false);
	}
	/**
	 * Save Data
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 02/10/2014, 14:21:57
	 * @return void
	 */
	public void saveData() {
		
		m_StartSlotHour=Timestamp.valueOf("1800-01-01 "+s_SlotText.getText()+":00");

		m_EndSlotHour=Timestamp.valueOf("1800-01-01 "+e_SlotText.getText()+":00");
		try
		{
			Trx.run(new TrxRunnable() 
			{
				public void run(String trxName)
				{	
					
					statusBar.setStatusLine(saveJournalLine(sliderPanel,IncidenceButton,trxName));
					rightPanel.removeAll();
					leftPanel.removeAll();
					leftPanel.repaint();
					rightPanel.repaint();
					clearData();
				}
			});
		}
		catch (Exception e)
		{
			ADialog.error(m_WindowNo, mainPanel, "Error", e.getLocalizedMessage());
			return;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {  
		  //  Key Press
		 
		  //  Check if the key pressed is not a digit
	      if(Character.isLetter(e.getKeyChar())) {
	         e.consume();  //  ignore keyboard event
	      }
	      
	      if(e.getComponent().equals(s_HourText)) {
	    	  v_StartHour= s_HourText.getText().split(":");
	    	  
	    		  if(v_StartHour[1].length()==2 ) {
	    			  v_StartHour[0]=v_StartHour[0]+v_StartHour[1].charAt(0);
		    		  v_StartHour[1]=v_StartHour[1].substring(1,v_StartHour[1].length());
		    		  if(v_StartHour[0].length()>2 ) {
		    		  v_StartHour[0]=v_StartHour[0].substring(1,v_StartHour[0].length());
		    		  }
		    		  s_HourText.setText(v_StartHour[0]+":"+v_StartHour[1]);
		    		  if(Integer.parseInt(v_StartHour[0])>23 ) {
		    			  v_StartHour[0]=v_StartHour[0].substring(0,v_StartHour[0].length()-1);
		    			  s_HourText.setText("00"+":"+v_StartHour[1]);
		    			  e.consume();  //  ignore keyboard event
		    		  }
		    		  if(Integer.parseInt(v_StartHour[1])>59 ) {
		    			  v_StartHour[1]=v_StartHour[1].substring(0,v_StartHour[1].length()-1);
		    			  s_HourText.setText(v_StartHour[0]+":"+"00");
		    			  e.consume();  //  ignore keyboard event
		    		  }
	    		  }
//	    		  if(v_StartHour[0].length()==2 ) {
//		    		  v_StartHour[0]=v_StartHour[0].substring(1,v_StartHour[0].length());
//	    		  }
	    		 
	    	  
	    	  
	     }
	      if(e.getComponent().equals(e_HourText)) {
	    	  v_EndHour= e_HourText.getText().split(":");
	    	  if(v_EndHour[1].length()==2 ) {
    			  v_EndHour[0]=v_EndHour[0]+v_EndHour[1].charAt(0);
	    		  v_EndHour[1]=v_EndHour[1].substring(1,v_EndHour[1].length());
	    		  if(v_EndHour[0].length()>2 ) {
	    			  v_EndHour[0]=v_EndHour[0].substring(1,v_EndHour[0].length());
	    		  }
	    		  e_HourText.setText(v_EndHour[0]+":"+v_EndHour[1]);
	    		  if(Integer.parseInt(v_EndHour[0])>23 ) {
	    			  v_EndHour[0]=v_EndHour[0].substring(0,v_EndHour[0].length()-1);
	    			  e_HourText.setText("00"+":"+v_EndHour[1]);
	    			  e.consume();  //  ignore keyboard event
	    		  }
	    		  if(Integer.parseInt(v_EndHour[1])>59 ) {
	    			  v_EndHour[1]=v_EndHour[1].substring(0,v_EndHour[1].length()-1);
	    			  e_HourText.setText(v_EndHour[0]+":"+"00");
	    			  e.consume();  //  ignore keyboard event
	    		  }
	    	  }
	      }
	      if(e.getComponent().equals(s_SlotText)) {
	    	  v_EndHour= s_SlotText.getText().split(":");
	    	  if(v_EndHour[1].length()==2 ) {
    			  v_EndHour[0]=v_EndHour[0]+v_EndHour[1].charAt(0);
	    		  v_EndHour[1]=v_EndHour[1].substring(1,v_EndHour[1].length());
	    		  if(v_EndHour[0].length()>2 ) {
	    			  v_EndHour[0]=v_EndHour[0].substring(1,v_EndHour[0].length());
	    		  }
	    		  s_SlotText.setText(v_EndHour[0]+":"+v_EndHour[1]);
	    		  if(Integer.parseInt(v_EndHour[0])>23 ) {
	    			  v_EndHour[0]=v_EndHour[0].substring(0,v_EndHour[0].length()-1);
	    			  s_SlotText.setText("00"+":"+v_EndHour[1]);
	    			  e.consume();  //  ignore keyboard event
	    		  }
	    		  if(Integer.parseInt(v_EndHour[1])>59 ) {
	    			  v_EndHour[1]=v_EndHour[1].substring(0,v_EndHour[1].length()-1);
	    			  s_SlotText.setText(v_EndHour[0]+":"+"00");
	    			  e.consume();  //  ignore keyboard event
	    		  }
	    	  }
	      }
	      if(e.getComponent().equals(e_SlotText)) {
	    	  v_EndHour= e_SlotText.getText().split(":");
	    	  if(v_EndHour[1].length()==2 ) {
    			  v_EndHour[0]=v_EndHour[0]+v_EndHour[1].charAt(0);
	    		  v_EndHour[1]=v_EndHour[1].substring(1,v_EndHour[1].length());
	    		  if(v_EndHour[0].length()>2 ) {
	    			  v_EndHour[0]=v_EndHour[0].substring(1,v_EndHour[0].length());
	    		  }
	    		  e_SlotText.setText(v_EndHour[0]+":"+v_EndHour[1]);
	    		  if(Integer.parseInt(v_EndHour[0])>23 ) {
	    			  v_EndHour[0]=v_EndHour[0].substring(0,v_EndHour[0].length()-1);
	    			  e_SlotText.setText("00"+":"+v_EndHour[1]);
	    			  e.consume();  //  ignore keyboard event
	    		  }
	    		  if(Integer.parseInt(v_EndHour[1])>59 ) {
	    			  v_EndHour[1]=v_EndHour[1].substring(0,v_EndHour[1].length()-1);
	    			  e_SlotText.setText(v_EndHour[0]+":"+"00");
	    			  e.consume();  //  ignore keyboard event
	    		  }
	    	  }
	      }
	}
	@Override
	public void keyPressed(KeyEvent e) {
	    if(e.getKeyChar()==KeyEvent.VK_DELETE || e.getKeyChar()==KeyEvent.VK_BACK_SPACE) {
	         e.consume();  //  ignore keyboard event
	      }
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}