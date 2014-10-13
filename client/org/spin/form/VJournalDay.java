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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
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
		trx = Trx.get(trxName, true);
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
	private int         	m_WindowNo = 0;
	/**	FormFrame			*/
	private FormFrame 		m_frame;
	private BorderLayout 	mainLayout = new BorderLayout();
	private JDialog 		journal_Dialog;
	/** 						*/
	private CPanel 			mainPanel    	 = new CPanel();
	private CPanel 			northPanel   	 = new CPanel();

	private String			trxName 		 = Trx.createTrxName("GM");
	private Trx				trx 			 = null;
	/** Calendar 				*/
	private JLabel 			calendarLabel     = new JLabel();
	private VLookup 		calendarSearch    = null;
	/** Year 				*/
	private JLabel 			yearLabel		  = new JLabel();
	private VLookup 		yearSearch	      = null;
	/** Journal 				*/
	private JLabel 			journalLabel		  = new JLabel();
	private JLabel 			title_Label		  = new JLabel();
	private VLookup 		journalSearch	      = null;
	/**  Save Journal Button 		*/
    private JButton 	s_HourButton	 = new JButton();
	private JButton 	c_HourButton	 = new JButton();
	/** Save */
	private JButton			bSave 	  		  = new JButton();
	private JToggleButton[] 		dayButton;
	private Calendar 		cal		  		  = Calendar.getInstance();
	private JPanel 			centerPanel		  = new JPanel();
	private JPanel			rightPanel		  = new JPanel();
	private JPanel 			journalPanel	  = new JPanel();
	private GridLayout 		DayLayout 		  = new GridLayout(0,7);
	private GridLayout 		JournalLayout 	  = new GridLayout(0,1);
	private Vector<Timestamp> dayYear	  	  = null;
	private	JButton 		monday		   = null;
	private	JButton 		tuesday		   = null;
	private	JButton 		wednesday	   = null;
	private	JButton 		thursday	   = null;
	private	JButton 		friday		   = null;
	private	JButton 		saturday	   = null;
	private	JButton 		sunday		   = null;
	private	int				startDay	   = 0;
	private	int				cont	   = 0;
	private int cols=0;
	private int row=0;
	
	private void jbInit() {
		CompiereColor.setBackground(mainPanel);
		mainPanel.setLayout(mainLayout);
		mainPanel.setMinimumSize(new Dimension(500, 500));
		//	North Panel
		northPanel.setLayout(new GridBagLayout());	
		calendarLabel.setText(Msg.translate(Env.getCtx(), "Calendar"));
		yearLabel.setText(Msg.translate(Env.getCtx(), "Year"));
		bSave.setText(Msg.translate(Env.getCtx(), "Save"));
		bSave.addActionListener(this);
		northPanel.add(calendarLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0)); 
		northPanel.add(calendarSearch, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		northPanel.add(bSave, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		northPanel.add(yearLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		northPanel.add(yearSearch, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));

		journal_Dialog = new JDialog(m_frame, true);
		journal_Dialog.setBounds(500,800  - 200 - 320, 245, 200);
		Container selectJournal = journal_Dialog.getContentPane();
		selectJournal.setLayout(new GridBagLayout());
		title_Label.setText("Seleccione Jornada:");
		journalLabel.setText("Journal");
		s_HourButton.setText("Save");
		s_HourButton.addActionListener(this);
		c_HourButton.setText("Cancel");
		c_HourButton.addActionListener(this);
		
		selectJournal.add(title_Label,  new GridBagConstraints(0, 0, 3, 1, 1.0, 0.0
				,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		selectJournal.add(journalLabel,  new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		selectJournal.add(journalSearch,  new GridBagConstraints(1, 1, 2, 1, 1.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		
		selectJournal.add(s_HourButton, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0)); 
		selectJournal.add(c_HourButton, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
       	centerPanel.setLayout(new GridBagLayout());
       	centerPanel.setPreferredSize(new Dimension(800, 800));
       	rightPanel.setLayout(JournalLayout);
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(rightPanel, BorderLayout.EAST);
		
	}
	public void dyInit() throws Exception{
		//	GET Journal
		int AD_Column_ID = 1000030;		//	HR_Calendar.HR_Calendar_ID
		
		MLookup lookupCalendar = MLookupFactory.get(Env.getCtx(), m_WindowNo, 0, AD_Column_ID, DisplayType.TableDir);
		
		calendarSearch = new VLookup("HR_Calendar_ID", true, false, true, lookupCalendar);
		calendarSearch.addVetoableChangeListener(this);
	
		AD_Column_ID = 54927;		//	HR_Year.HR_Year_Id
		MLookup lookupYear = MLookupFactory.get(Env.getCtx(), m_WindowNo, 0, AD_Column_ID, DisplayType.TableDir);
		yearSearch = new VLookup("C_Year_ID", true, false, true, lookupYear);
		yearSearch.addVetoableChangeListener(this);

		AD_Column_ID = 1000139;		//	HR_Journal.HR_Journal_ID
		MLookup lookupJournal = MLookupFactory.get(Env.getCtx(), m_WindowNo, 0, AD_Column_ID, DisplayType.ID);
		journalSearch = new VLookup("HR_Journal_ID", true, false, true, lookupJournal);
		journalSearch.addVetoableChangeListener(this);
		
		journalPanel.setPreferredSize(new Dimension(200,20));
		journalPanel.add(new JLabel("Jornadas:"));
		ArrayList<KeyNamePair> dataIG = getJournal(trxName);
		for(KeyNamePair pp : dataIG) {
			JLabel jornalLabel = new JLabel(pp.toString());
			journalPanel.add(jornalLabel);
		}
		rightPanel.add(journalPanel);
	}

	 public void dayMonth(int year, int month) {
		 
		  startDay = getStartDay(year, month);
	 
	      int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
	 
	      // Pad space before the first day of the month
	      int i = 0;
	      
	      JPanel 	dayNumPanel = new JPanel();
	      dayNumPanel.setMaximumSize(new Dimension(250,300));
	      dayNumPanel.setPreferredSize(new Dimension(200,150));
	  
	      dayNumPanel.setLayout(DayLayout);
	      for (i = 0; i < startDay; i++){
	    	  JLabel dayMonthLabel = new JLabel();
	    	  dayMonthLabel.setText("   ");
	    	  dayNumPanel.add(dayMonthLabel);
	      }
	      for (i = 1; i <= numberOfDaysInMonth; i++) {
	    	  dayButton[cont] = new JToggleButton();
	    	  dayButton[cont].setText(String.valueOf(i));
	    	  dayButton[cont].setMaximumSize(new Dimension(10,10));
	    	  dayNumPanel.add(dayButton[cont]);
	    	  cont++;
	      }	
	      centerPanel.add(dayNumPanel,  new GridBagConstraints(cols, row+2, 1, 1, 0.0, 0.0
					,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
	   }
	 
	
	static String getMonthName(int month) {
	      String monthName = null;
	      switch (month) {
	        case 1: monthName = "January"; break;
	        case 2: monthName = "February"; break;
	        case 3: monthName = "March"; break;
	        case 4: monthName = "April"; break;
	        case 5: monthName = "May"; break;
	        case 6: monthName = "June"; break;
	        case 7: monthName = "July"; break;
	        case 8: monthName = "August"; break;
	        case 9: monthName = "September"; break;
	        case 10: monthName = "October"; break;
	        case 11: monthName = "November"; break;
	        case 12: monthName = "December";
	      }
	      return monthName;
	    }
		 
	    /** Get the start day of the first day in a month */
	 
	public int getStartDay(int year, int month) {
	 
	      //Get total number of days since 1/1/1800
	      int startDay1800 = 3;
	      int totalNumberOfDays = getTotalNumberOfDays(year, month);
	 
	      //Return the start day
	      return (totalNumberOfDays + startDay1800) % 7;
	    }
	 
	    /** Get the total number of days since January 1, 1800 */
	 
	public int getTotalNumberOfDays(int year, int month) {
	     int total = 0;
	 
	     //Get the total days from 1800 to year - 1
	     for (int i = 1800; i < year; i++)
	     if (isLeapYear(i))
	        total = total + 366;
	      else
	        total = total + 365;
	 
	      //Add days from January to the month prior to the calendar month
	      for (int i = 1; i < month; i++)
	        total = total + getNumberOfDaysInMonth(year, i);
	 
	      return total;
	    }
	 
	    /** Get the number of days in a month */
	 
	public int getNumberOfDaysInMonth(int year, int month) {
	      if (month == 1 || month == 3 || month == 5 || month == 7 ||
	        month == 8 || month == 10 || month == 12)
	        return 31;
	 
	      if (month == 4 || month == 6 || month == 9 || month == 11)
	        return 30;
	 
	      if (month == 2) return isLeapYear(year) ? 29 : 28;
	 
	      return 0; // If month is incorrect
	    }
	 
	    /** Determine if it is a leap year */
	public boolean isLeapYear(int year) {
	      return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	    }
	
	  @Override
	  public void mousePressed(MouseEvent e) {
		 
	    }

	@Override
	public void stateChanged(ChangeEvent e) {
	
	}
	
	public void actionPerformed(ActionEvent e){
		int start=12;
		int day=0;
		 
		if(e.getActionCommand().equals(sunday.getText())){
			while(cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
				
				cal.set(m_Year, 12, day);
				start=day;
				day++;
			}
			if(isLeapYear(m_Year)==false)
				start-=1;
			journal_Dialog.setVisible(true);
			for(int i = start; i < 365; i+=7){
				if(dayButton[i].isSelected()){
					dayButton[i].setBackground(new Color(m_RColor, m_GColor, m_BColor));
				}
			}
		}
		if(e.getActionCommand().equals(saturday.getText())){
			start=10-startDay;
			for(int i = start; i < 365; i+=7){
				dayButton[i].setBackground(Color.RED);
			}
		}
		if(e.getActionCommand().equals(s_HourButton.getText())){
			journal_Dialog.setVisible(false);
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
		
	}
	@Override
	public void mouseExited(MouseEvent e) {   
	
	}	

	@Override
	public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
		Object value = evt.getNewValue();
		if(evt.getSource().equals(calendarSearch)){
			m_HR_Calendar_ID=(Integer) calendarSearch.getValue();
			
		}
		if(evt.getSource().equals(journalSearch)){
//			JOptionPane.showMessageDialog(null, );
			setRGB((Integer) journalSearch.getValue(),trxName);
		}
		if(evt.getSource().equals(yearSearch)){

			
			m_C_Year_ID = ((Integer)value).intValue();
			dayYear 	= getDayYear(m_C_Year_ID, trxName);
			if(dayYear.size()==0){
				JOptionPane.showMessageDialog(null, "Generate Day");
			}
			else{
				dayButton = new JToggleButton[dayYear.size()];
				for(int x = 1; x<13; x++){
			      JPanel 	dayTitlePanel  = new JPanel();
			       	JLabel  monthLabel	   = new JLabel();
			    	JPanel 	monthYearPanel = new JPanel();
			    	monday		   = new JButton("L ");
			    	monday.addActionListener(this);
			    	tuesday		   = new JButton("M ");
			    	tuesday.addActionListener(this);
			    	wednesday	   = new JButton("M ");
					wednesday.addActionListener(this);
			    	thursday	   = new JButton("J ");
					thursday.addActionListener(this);
			    	friday		   = new JButton("V ");
					friday.addActionListener(this);
			    	saturday	   = new JButton("S ");
					saturday.addActionListener(this);
			    	sunday		   = new JButton("D ");
					sunday.addActionListener(this);
					
			    	monthLabel.setText(getMonthName(x));
					monthYearPanel.add(monthLabel);
					
					dayTitlePanel.setPreferredSize(new Dimension(200,20));
					dayTitlePanel.add(monthYearPanel);
					dayTitlePanel.setLayout(new GridLayout(0, 7));
					dayTitlePanel.add(monday);
					dayTitlePanel.add(tuesday);
					dayTitlePanel.add(wednesday);
					dayTitlePanel.add(thursday);
					dayTitlePanel.add(friday);
					dayTitlePanel.add(saturday);
					dayTitlePanel.add(sunday);
			        if(cols==4){ 
			        	row=x; cols=0;     
			        }
	        	   centerPanel.add(monthYearPanel,  new GridBagConstraints(cols, row, 1, 1, 0.0, 0.0
	        			   		,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				   centerPanel.add(dayTitlePanel,  new GridBagConstraints(cols, row+1, 1, 1, 0.0, 0.0
							,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));

					cal.set(m_Year, x-1, 1);
					dayMonth(m_Year,x);
				     
			    cols++;	
				}
			}
		}
		
	}
	public void loadDay(){
		
	}
	
	public void clearData(){
		
	}
	/**
	 * Save Data
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 02/10/2014, 14:21:57
	 * @return void
	 */
	public void saveData(){
		
	}
	
}