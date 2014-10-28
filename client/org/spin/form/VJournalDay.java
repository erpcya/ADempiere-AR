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
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
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
public class VJournalDay extends JournalDay
			implements FormPanel, ChangeListener,ActionListener,MouseListener, VetoableChangeListener {
	@Override
	public void init(int WindowNo, FormFrame frame) {
		m_WindowNo = WindowNo;
		
		Env.setContext(Env.getCtx(), m_WindowNo, "IsSOTrx", "Y");   //  defaults to no
		Trx.get(trxName, true);
		try	{
			dyInit();
			jbInit();
			frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
			frame.getContentPane().add(statusBar, BorderLayout.SOUTH);
		}
		catch(Exception e){
		}
	}
	/**	Window No				*/
	private int         	m_WindowNo = 0;
	private BorderLayout 	mainLayout = new BorderLayout();
	/** 	Panel				*/
	private CPanel 			mainPanel    	  = new CPanel();
	private CPanel 			northPanel   	  = new CPanel();
	private JPanel 			centerPanel		  = new JPanel();
	private JPanel			rightPanel		  = new JPanel();
	private JPanel 			southPanel	  	  = new JPanel();
	private JPanel 			journalPanel	  = new JPanel();
	private JPanel 			dayTitlePanel     = new JPanel();
	private JPanel 			monthYearPanel    = new JPanel();
	private JPanel 	  		dayNumPanel 	  = new JPanel();
	private GridLayout 		DayLayout 		  = new GridLayout(0,7);
	private GridLayout 		JournalLayout 	  = new GridLayout(0,1);
	private StatusBar		statusBar		  = new StatusBar(); 
	/** 						*/
	private String			trxName 		  = Trx.createTrxName("GM");
	/** Scroll */
	private JScrollPane 	scrollPane;
	/** Calendar 				*/
	private JLabel 			calendarLabel     = new JLabel();
	private VLookup 		calendarSearch    = null;
	/** Year 					*/
	private JLabel 			yearLabel		  = new JLabel();
	private VLookup 		yearSearch	      = null;
	/** Save */
	private JButton			saveButton		  = new JButton();
	/** Day Calendar 			*/
	private JToggleButton[] dayButton		  = null;
	private KeyNamePair[]   dayYear	  	  	  = null;
	/** Calendar				*/
	private Calendar 		cal				  = Calendar.getInstance();
	/**	First Day 				*/
	private	int				startDay	 	  = 0;
	/** Count Day 				*/
	private	int				count	  	  	  = 0;
	/** Columns calendar  		*/
	private int 			cols			  = 0;
	/** Rows calendar  			*/
	private int 			rows			  = 0;
	/** Formatter Month Title	*/
	private SimpleDateFormat mFormatter 	  = new SimpleDateFormat("MMMM");
	/** Formatter Day Title		*/
	private SimpleDateFormat dFormatter 	  = new SimpleDateFormat("E");
	/** Journal 				*/
	private JButton[] 		journalButton	  = null;
	/** Journal Color			*/
	private JLabel[] 		colorLabel 	  	  = null;
	/**  Month 					*/
	private JLabel  	    monthLabel		  = null;
	/** Day Week 				*/
	private JLabel  	    dayLabel		  = null;
	/** Get Date 				*/
	private Date 		    getDate 		  = null;
	/** Journal Label			*/
	private JLabel		    journalLabel	  = new JLabel();

	private void jbInit() throws Exception {
		CompiereColor.setBackground(mainPanel);
		mainPanel.setLayout(mainLayout);
		mainPanel.setMinimumSize(new Dimension(500, 500));
		//	North Panel
		northPanel.setLayout(new GridBagLayout());	
		calendarLabel.setText(Msg.translate(Env.getCtx(), "Calendar"));
		yearLabel.setText(Msg.translate(Env.getCtx(), "Year"));
		saveButton.setText(Msg.translate(Env.getCtx(), "Save"));
		saveButton.addActionListener(this);
		
		northPanel.add(calendarLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0)); 
		northPanel.add(calendarSearch, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		northPanel.add(yearLabel, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
		northPanel.add(yearSearch, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));

       	centerPanel.setLayout(new GridBagLayout());
       	centerPanel.setPreferredSize(new Dimension(900, 800));
       	centerPanel.setBorder(BorderFactory.createEtchedBorder());
       	//	Scroll From Right Panel
       	scrollPane = new JScrollPane(journalPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
       								 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       	rightPanel.setLayout(JournalLayout);
       	rightPanel.add(scrollPane);
       	//  Add Button Save
     		southPanel.add(saveButton);
       	//	Add North Panel
       	mainPanel.add(northPanel, BorderLayout.NORTH);
       	//	Add Center Panel
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		//	Add Right Panel
		mainPanel.add(rightPanel, BorderLayout.EAST);
		//	Add South Panel
		mainPanel.add(southPanel, BorderLayout.SOUTH);
	}
	
	public void dyInit() throws Exception {
		//	Get Calendar
		int AD_Column_ID = 1000167;		//	HR_Calendar.HR_Calendar_ID
		MLookup lookupCalendar = MLookupFactory.get(Env.getCtx(), m_WindowNo, 0, AD_Column_ID, DisplayType.TableDir);
		calendarSearch = new VLookup("HR_Calendar_ID", true, false, true, lookupCalendar);
		calendarSearch.addVetoableChangeListener(this);

		//	Get Year
		AD_Column_ID = 54927;		//	HR_Year.HR_Year_Id	
		MLookup lookupYear = MLookupFactory.get(Env.getCtx(), m_WindowNo, 0, AD_Column_ID, DisplayType.TableDir);
		yearSearch = new VLookup("C_Year_ID", true, false, true, lookupYear);
		yearSearch.addVetoableChangeListener(this);	
		//	Status Bar
		statusBar.setStatusLine(Msg.getMsg(Env.getCtx(), "Journal"));
		statusBar.setStatusDB("");
		
		journalLabel.setText(" Jornadas: ");			
		journalLabel.setPreferredSize(new Dimension(200,20));
		journalPanel.setPreferredSize(new Dimension(200,20));
		journalPanel.add(journalLabel);
		//	Get Journal Data
		KeyNamePair[] dataIG = getJournal();
		journalButton = new JButton[dataIG.length];
		colorLabel = new JLabel[dataIG.length];
		for(int i = 0; i < dataIG.length; i++) {
			//	Journal Button
			journalButton[i] = new JButton();
			journalButton[i].setText(dataIG[i].getName());
			journalButton[i].setName(String.valueOf(dataIG[i].getKey()));
			journalButton[i].setPreferredSize(new Dimension(170,20));
			journalButton[i].addActionListener(this);
			journalButton[i].addMouseListener(this);
			journalButton[i].setEnabled(false);
			//	Get Color for Label
			getColor(dataIG[i].getKey(),trxName);
			colorLabel[i] = new JLabel();
			colorLabel[i].setPreferredSize(new Dimension(20,18));
			colorLabel[i].setBackground(new Color(m_RColor, m_GColor, m_BColor));
			colorLabel[i].setOpaque(true);
			
			journalPanel.add(colorLabel[i]);
			journalPanel.add(journalButton[i]);			
		}
		//	Add Journal
		rightPanel.add(journalPanel);
	}
	public void statusJournal(boolean status){
		for(int i = 0; i < journalButton.length; i++) {
			//	Journal Button
			journalButton[i].setEnabled(status);
		}
	}
	/**
	 * Add Days of the Month From Calendar
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 21/10/2014, 16:54:22
	 * @param year
	 * @param month
	 * @return void
	 */
	public void dayMonth(int year, int month) {
	    int numberDays = getNumberDays(year, month);
	    cal.set(year, month-1,1);  
		startDay = cal.get(Calendar.DAY_OF_WEEK)-1;
		
	      dayNumPanel = new JPanel();
	      dayNumPanel.setPreferredSize(new Dimension(200,120));
	      dayNumPanel.setLayout(DayLayout);
	      //  Pad space before the first day of the month
	      for (int i = 0; i < startDay; i++){
	    	  JLabel dayMonthLabel = new JLabel();
	    	  dayMonthLabel.setText("   ");
	    	  dayNumPanel.add(dayMonthLabel);
	      }
	      //  Print days Button
	      for (int  i = 1; i <= numberDays; i++) {
	    	  dayButton[count] = new JToggleButton();
	    	  for(int j=0;j<m_Color.size(); j++){
	    		  if(dayYear[count].getKey() == day_ID.get(j)){
	    			  dayButton[count].setBackground(m_Color.get(j));
	    		  }  
	    	  }
	    	  dayButton[count].setText(String.valueOf(i));
	    	  dayButton[count].setName(String.valueOf(dayYear[count].getKey()));
	    	  dayButton[count].setBorder(BorderFactory.createEtchedBorder());
	    	  dayNumPanel.add(dayButton[count]);
	    	  count++;
	      } 
	      centerPanel.add(dayNumPanel,  new GridBagConstraints(cols, rows+2, 1, 1, 0.0, 0.0
					,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 15), 0, 0));
	      
	} //  Day Month
	
	/**
	 * Generate Days of Calendar 
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 21/10/2014, 14:02:10
	 * @return void
	 */
	public void generateDay(){
		statusJournal(true);
		 dayButton = new JToggleButton[dayYear.length];
			for(int x = 1; x < 13; x++){
				dayTitlePanel  = new JPanel();
				monthLabel	   = new JLabel();
		    	monthYearPanel = new JPanel();
		    	//	Set Date
				cal.set(m_Year, x-1, 1);
				getDate = cal.getTime();
		    	//	Print Month Name
				monthLabel.setText(mFormatter.format(getDate));
				monthYearPanel.add(monthLabel);
				dayTitlePanel.setLayout(new GridLayout(0, 7));
				dayTitlePanel.add(monthYearPanel);
				
				for(int i = 0; i < 7; i++){
					dayLabel = new JLabel(dFormatter.format(getDate));
					//	Set Date
					cal.set(2014, 8, i);
					getDate  = cal.getTime();
			       	//	Print Day Name 
					dayLabel.setText(dFormatter.format(getDate));
			       	dayTitlePanel.add(dayLabel);
				}
		        if(cols == 4){ 
		        	rows = x; 
		        	cols = 0;     
		        }
		        centerPanel.add(monthYearPanel,  new GridBagConstraints(cols, rows, 1, 1, 0.0, 0.0
     			   		,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			    centerPanel.add(dayTitlePanel,  new GridBagConstraints(cols, rows+1, 1, 1, 0.0, 0.0
						,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 5), 0, 0));
			    //	Add Day of the Month
			   dayMonth(m_Year,x);
			   cols++;	
			}
	} //  generateDay
	
	@Override
	public void mousePressed(MouseEvent e) {
	}
	  
	@Override
	public void stateChanged(ChangeEvent e) {
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		//	Asign journal in day button
		for(int i = 0; i < journalButton.length; i++){ 
			if(e.getActionCommand().equals(journalButton[i].getText())){
				//	Get Color
				getColor(Integer.parseInt(journalButton[i].getName()),trxName);
				if(dayButton!=null){
					for(int j = 0; j < dayButton.length; j++){
						if(dayButton[j].isSelected()){
							dayButton[j].setSelected(false);
							dayButton[j].setBackground(new Color(m_RColor, m_GColor, m_BColor));
						}
					}
				}
			}
		}
		if(e.getActionCommand().equals(saveButton.getText())){
			saveData();
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
			// Add Border from Day Button
			for(int i = 0; i < journalButton.length; i++){
				if(e.getSource().equals(journalButton[i])){
					if(dayButton != null){
						for(int j = 0; j < dayButton.length; j++){
							if(dayButton[j].getBackground().equals(colorLabel[i].getBackground())){
								dayButton[j].setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
							}
						}
					}
				}
			}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// Remove Border from Day Button
		for(int i = 0; i < journalButton.length; i++){
			if(e.getSource().equals(journalButton[i])){
				if(dayButton!=null){
					for(int j = 0; j < dayButton.length; j++){
						if(dayButton[j].getBackground().equals(colorLabel[i].getBackground())){
							dayButton[j].setBorder(BorderFactory.createEtchedBorder());
						}
					}
				}
			}
		}
	}
	
	@Override
	public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
		Object value = evt.getNewValue();
		if(evt.getSource().equals(calendarSearch)){
			//	Get Value Calendar Search
			m_HR_Calendar_ID = (Integer) calendarSearch.getValue();
		}
		//	Load Day of the Year
		if(evt.getSource().equals(yearSearch)){
			clearData();
			m_C_Year_ID = ((Integer)value).intValue();
			dayYear 	= getDayYear(m_C_Year_ID);
	    	getDayColor(m_HR_Calendar_ID,m_C_Year_ID, trxName);
			if(dayYear.length == 0){
				JOptionPane.showMessageDialog(null, "Generate Day");
			}
			else{
				m_Year = Integer.parseInt(dayYear[0].getName());
				generateDay();
			}
			centerPanel.revalidate();
		}
		
		if(evt.getSource().equals(calendarSearch)){
			clearData();
			if(m_C_Year_ID != 0){
				//	Generate Day of Month
				generateDay();
			}
			centerPanel.revalidate();
		} 
	}
	/**
	 * Clear Data
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 21/10/2014, 14:06:16
	 * @return void
	 */
	public void clearData(){
		startDay = 0;
		count	 = 0;
		cols	 = 0;
		rows	 = 0;
		centerPanel.removeAll();
		centerPanel.repaint();
		statusJournal(false);
	}
	/**
	 * Save Journal Day Data
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 02/10/2014, 14:21:57
	 * @return void
	 */
	public void saveData(){
		try	{
			Trx.run(new TrxRunnable() {
				public void run(String trxName)	{
					statusBar.setStatusLine(saveCalendar(m_HR_Calendar_ID, journalButton, dayButton, colorLabel, trxName));
					rightPanel.repaint();
					clearData();
				}
			});
		}
		catch (Exception e) {
			ADialog.error(m_WindowNo, mainPanel, "Error", e.getLocalizedMessage());
			return;
		}
	}
	
	/** 
	 * 	Get the number of days in a month	 
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 15/10/2014, 15:36:20
	 * @param year
	 * @param month
	 * @return
	 * @return int
	 */
	public int getNumberDays(int year, int month) {
		cal.set(year, month-1, 1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
		 
}