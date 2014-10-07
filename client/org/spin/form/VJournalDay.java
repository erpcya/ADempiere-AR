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
import java.util.Vector;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.AbstractButton;
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

import org.compiere.apps.ADialog;
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
	private int         m_WindowNo = 0;
	/**	FormFrame			*/
	private FormFrame 	m_frame;
	private BorderLayout 	mainLayout = new BorderLayout();

	/** 						*/
	private CPanel 		mainPanel    	 = new CPanel();
	private CPanel 		northPanel   	 = new CPanel();

	private String		trxName 		 = Trx.createTrxName("GM");
	private Trx			trx 			 = null;
	/** Calendar 				*/
	private JLabel 		calendarLabel     = new JLabel();
	private VLookup 	calendarSearch    = null;
	/** Year 				*/
	private JLabel 		yearLabel		  = new JLabel();
	private VLookup 	yearSearch	      = null;
	/** Save */
	private JButton			  bSave 	  = new JButton();
	private Vector<Timestamp> dayYear	  = null;
	Calendar 				  cal2		  = Calendar.getInstance();
	private JPanel 		centerPanel		  = new JPanel();
	private GridLayout DayLayout = new GridLayout(0,7,0,0);
	private GridLayout WeekLayout = new GridLayout(0,1,0,0);
	private GridLayout YearLayout = new GridLayout(4,3,0,0);
	
	
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
		centerPanel.setLayout(YearLayout);
		centerPanel.setPreferredSize(new Dimension(800, 600));
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
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

	}

	  @Override
	  public void mousePressed(MouseEvent e) {
		 
	    }

	@Override
	public void stateChanged(ChangeEvent e) {
	
	}
	
	public void actionPerformed(ActionEvent e){
	
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
		if(evt.getSource().equals(yearSearch)){
//			int day=1;
			m_C_Year_ID = ((Integer)value).intValue();
			dayYear 	= getDayYear(m_C_Year_ID, trxName);
			
			for(int x = 1; x<13; x++){
			      JPanel 	dayYearPanel = new JPanel();
			       	JLabel  monthLabel	 = new JLabel();
			    	JLabel  sunLabel	 = new JLabel();
			    	JLabel  monLabel	 = new JLabel();
			    	JLabel  tueLabel	 = new JLabel();
			    	JLabel  wedLabel	 = new JLabel();
			    	JLabel  thuLabel	 = new JLabel();
			    	JLabel  friLabel	 = new JLabel();
			    	JLabel  satLabel	 = new JLabel();

			    	JPanel 	monthYearPanel = new JPanel();
			    	monthLabel.setText(getMonthName(x));
			    	monthYearPanel.add(monthLabel);

			    	dayYearPanel.setLayout(WeekLayout);
			    	dayYearPanel.add(monthYearPanel);

			    	sunLabel.setText(" Sun  ");
			    	monLabel.setText(" Mon  ");
			    	tueLabel.setText(" Tue  ");
			    	wedLabel.setText(" Wed  ");
			    	thuLabel.setText(" Thu ");
			    	friLabel.setText(" Fri ");
			    	satLabel.setText(" Sat ");

			    	dayYearPanel.setLayout(DayLayout);
			    	dayYearPanel.add(sunLabel);
			    	dayYearPanel.add(monLabel);
			    	dayYearPanel.add(tueLabel);
			    	dayYearPanel.add(wedLabel);
			    	dayYearPanel.add(thuLabel);
			    	dayYearPanel.add(friLabel);

				centerPanel.add(dayYearPanel);
				
				printMonth(2011,x);
				cal2.set(2011, x-1, 1);
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
	 public void printMonth(int year, int month) {
		 //  Print the headings of the calendar
	      printMonthTitle(year, month);
	     //  Print the body of the calendar
	      printMonthBody(year, month);
	    }
	 
	    /** Print the month title */
	 public void printMonthTitle(int year, int month) {
//	    	JPanel 	dayYearPanel = new JPanel();
//	       	JLabel  monthLabel	 = new JLabel();
//	    	JLabel  weekLabel	 = new JLabel();
//
//	    	JPanel 	monthYearPanel = new JPanel();
//	    	monthLabel.setText(getMonthName(month));
//	    	monthYearPanel.add(monthLabel);
//	    	dayYearPanel.setLayout(WeekLayout);
//	    	weekLabel.setText(" Sun Mon Tue Wed Thu Fri Sat ");
//
//	    	dayYearPanel.add(monthYearPanel);
//	    	dayYearPanel.add(weekLabel);
//
//		centerPanel.add(dayYearPanel);
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
	public String WM_Year(){
		return "";
	}
	public void printMonthBody(int year, int month) {
		 
	      // Get start day of the week for the first date in the month
	      int startDay = getStartDay(year, month);
	 
	      // Get number of days in the month
	      int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
	 
	      // Pad space before the first day of the month
	      int i = 0;
	      
	      JPanel 	dayYearPanel = new JPanel();

	      for (i = 0; i < startDay; i++){
	        JLabel dayMonthLabel = new JLabel();
	        
	        dayYearPanel.setLayout(DayLayout);
	    	  dayMonthLabel.setText("    ");
	    	  dayYearPanel.add(dayMonthLabel);
	    	  centerPanel.add(dayYearPanel);
	      }
	      for (i = 1; i <= numberOfDaysInMonth; i++) {
	    	  
		        	JLabel dayMonthLabel = new JLabel();
		        
		        dayYearPanel.setLayout(DayLayout);
		    	  dayMonthLabel.setText(String.valueOf(i));
		    	  dayYearPanel.add(dayMonthLabel);
		    	  centerPanel.add(dayYearPanel);
	       
	      }
	      
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
	
}