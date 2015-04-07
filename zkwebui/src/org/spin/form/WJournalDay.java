package org.spin.form;

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


import org.adempiere.webui.component.Button;
import org.adempiere.webui.component.Label;
import org.adempiere.webui.component.Grid;
import org.adempiere.webui.component.GridFactory;
import org.adempiere.webui.component.Panel;
import org.adempiere.webui.component.Row;
import org.adempiere.webui.component.Rows;
import org.adempiere.webui.panel.ADForm;
import org.adempiere.webui.panel.CustomForm;
import org.adempiere.webui.panel.IFormController;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.Trx;
import org.spin.form.JournalDay;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zkex.zul.Borderlayout;
import org.zkoss.zkex.zul.North;

/**
 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a>
 *
 */
public class WJournalDay extends JournalDay
			implements IFormController,EventListener {
	private CustomForm form = new CustomForm();

	public WJournalDay() {
		
		
		Env.setContext(Env.getCtx(), form.getWindowNo(), "IsSOTrx", "Y");   //  defaults to no
		Trx.get(trxName, true);
		try	{
//			dyInit();
			zkInit();
			
//			frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
//			frame.getContentPane().add(statusBar, BorderLayout.SOUTH);
		}
		catch(Exception e) {
		}
	}
	/**	Window No				*/
//	private int         	m_WindowNo = 0;
	private Borderlayout mainLayout = new Borderlayout();
	/** 	Panel				*/
//	private CPanel 			mainPanel    	  = new CPanel();
//	private CPanel 			northPanel   	  = new CPanel();
//	private JPanel 			centerPanel		  = new JPanel();
//	private JPanel			rightPanel		  = new JPanel();
//	private JPanel 			southPanel	  	  = new JPanel();
//	private JPanel 			journalPanel	  = new JPanel();
//	private JPanel 			dayTitlePanel     = new JPanel();
//	private JPanel 			monthYearPanel    = new JPanel();
//	private JPanel 	  		dayNumPanel 	  = new JPanel();
//	private GridLayout 		DayLayout 		  = new GridLayout(0,7);
//	private GridLayout 		JournalLayout 	  = new GridLayout(0,1);
//	private StatusBar		statusBar		  = new StatusBar(); 
	/** 						*/
	private String			trxName 		  = Trx.createTrxName("GM");
	/** Scroll */
//	private JScrollPane 	scrollPane;
	/** Calendar 				*/
	private Label 			calendarLabel     = new Label();
//	private VLookup 		calendarSearch    = null;
	/** Year 					*/
	private Label 			yearLabel		  = new Label();
//	private VLookup 		yearSearch	      = null;
	/** Save */
	private Button			saveButton		  = new Button();
	/** Day Calendar 			*/
//	private JToggleButton[] dayButton		  = null;
//	private KeyNamePair[]   dayYear	  	  	  = null;
//	/** Calendar				*/
//	private Calendar 		cal				  = Calendar.getInstance();
//	/**	First Day 				*/
//	private	int				startDay	 	  = 0;
//	/** Count Day 				*/
//	private	int				count	  	  	  = 0;
//	/** Columns calendar  		*/
//	private int 			cols			  = 0;
//	/** Rows calendar  			*/
//	private int 			rows			  = 0;
//	/** Formatter Month Title	*/
//	private SimpleDateFormat mFormatter 	  = new SimpleDateFormat("MMMM");
//	/** Formatter Day Title		*/
//	private SimpleDateFormat dFormatter 	  = new SimpleDateFormat("E");
//	/** Journal 				*/
//	private JButton[] 		journalButton	  = null;
//	/** Journal Color			*/
//	private JLabel[] 		colorLabel 	  	  = null;
//	/**  Month 					*/
//	private JLabel  	    monthLabel		  = null;
//	/** Day Week 				*/
//	private JLabel  	    dayLabel		  = null;
//	/** Get Date 				*/
//	private Date 		    getDate 		  = null;
//	/** Journal Label			*/
//	private JLabel		    journalLabel	  = new JLabel();
	private Panel parameterPanel = new Panel();
	private Grid parameterLayout = GridFactory.newGridLayout();
	/**
	 * Static Init
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 30/10/2014, 10:29:50
	 * @throws Exception
	 * @return void
	 */
	private void zkInit() throws Exception {
//		CompiereColor.setBackground(mainPanel);
		form.appendChild(mainLayout);
		mainLayout.setWidth("99%");
		mainLayout.setHeight("100%");
//		mainPanel.setLayout(mainLayout);
//		mainPanel.setMinimumSize(new Dimension(500, 500));
//		//	North Panel
//		northPanel.setLayout(new GridBagLayout());	
		calendarLabel.setText(Msg.translate(Env.getCtx(), "Calendar"));
//		yearLabel.setText(Msg.translate(Env.getCtx(), "Year"));
		saveButton.setLabel(Msg.translate(Env.getCtx(), "Save"));
		saveButton.addActionListener(this);
		
//		northPanel.add(calendarLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
//				,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0)); 
//		northPanel.add(calendarSearch, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
//				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
//		northPanel.add(yearLabel, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0
//				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
//		northPanel.add(yearSearch, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
//				,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 5), 0, 0));
//
//       	centerPanel.setLayout(new GridBagLayout());
//       	centerPanel.setPreferredSize(new Dimension(900, 800));
//       	centerPanel.setBorder(BorderFactory.createEtchedBorder());
//       	//	Scroll From Right Panel
//       	scrollPane = new JScrollPane(journalPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
//       								 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//       	rightPanel.setLayout(JournalLayout);
//       	rightPanel.add(scrollPane);
       	//  Add Button Save
//     	southPanel.add(saveButton);
       	//	Add North Panel
//       	mainPanel.add(northPanel, BorderLayout.NORTH);
//       	//	Add Center Panel
//		mainPanel.add(centerPanel, BorderLayout.CENTER);
//		//	Add Right Panel
//		mainPanel.add(rightPanel, BorderLayout.EAST);
//		//	Add South Panel
//		mainPanel.add(southPanel, BorderLayout.SOUTH);
		parameterPanel.appendChild(parameterLayout);
		
		North north = new North();
		north.setStyle("border: none");
		mainLayout.appendChild(north);
		north.appendChild(parameterPanel);
		Rows rows = null;
		Row row = null;
		parameterLayout.setWidth("800px");
		rows = parameterLayout.newRows();
		row = rows.newRow();
//		row.appendChild(saveButtonz.rightAlign());
		row.appendChild(saveButton);
		row.appendChild(calendarLabel.rightAlign());
//		row.appendChild(dateLabel.rightAlign());
//		row.appendChild(dateField.sgetComponent());
//		row.appendChild(organizationLabel.rightAlign());
//		row.appendChild(organizationPick.getComponent());
		
	}
	
	/**
	 * Dynamic Init (prepare dynamic fields)
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 30/10/2014, 10:29:40
	 * @throws Exception
	 * @return void
	 */
//	public void dyInit() throws Exception {
//		//	Get Calendar
//		int AD_Column_ID = 1000167;		//	HR_Calendar.HR_Calendar_ID
//		MLookup lookupCalendar = MLookupFactory.get(Env.getCtx(), m_WindowNo, 0, AD_Column_ID, DisplayType.TableDir);
//		calendarSearch = new VLookup("HR_Calendar_ID", true, false, true, lookupCalendar);
//		calendarSearch.addVetoableChangeListener(this);
//
//		//	Get Year
//		AD_Column_ID = 54927;		//	HR_Year.HR_Year_Id	
//		MLookup lookupYear = MLookupFactory.get(Env.getCtx(), m_WindowNo, 0, AD_Column_ID, DisplayType.TableDir);
//		yearSearch = new VLookup("C_Year_ID", true, false, true, lookupYear);
//		yearSearch.addVetoableChangeListener(this);	
//		//	Status Bar
//		statusBar.setStatusLine(Msg.getMsg(Env.getCtx(), "Journal"));
//		statusBar.setStatusDB("");
//		
//		journalLabel.setText(" Jornadas: ");			
//		journalLabel.setPreferredSize(new Dimension(200,20));
//		journalPanel.setPreferredSize(new Dimension(200,20));
//		journalPanel.add(journalLabel);
//		//	Get Journal Data
//		KeyNamePair[] dataIG = getJournal();
//		journalButton = new JButton[dataIG.length];
//		colorLabel = new JLabel[dataIG.length];
//		for(int i = 0; i < dataIG.length; i++) {
//			//	Journal Button
//			journalButton[i] = new JButton();
//			journalButton[i].setText(dataIG[i].getName());
//			journalButton[i].setName(String.valueOf(dataIG[i].getKey()));
//			journalButton[i].setPreferredSize(new Dimension(170,20));
//			journalButton[i].addActionListener(this);
//			journalButton[i].addMouseListener(this);
//			journalButton[i].setEnabled(false);
//			//	Get Color for Label
//			getColor(dataIG[i].getKey(),trxName);
//			colorLabel[i] = new JLabel();
//			colorLabel[i].setPreferredSize(new Dimension(20,18));
//			colorLabel[i].setBackground(new Color(m_RColor, m_GColor, m_BColor));
//			colorLabel[i].setOpaque(true);
//			
//			journalPanel.add(colorLabel[i]);
//			journalPanel.add(journalButton[i]);			
//		}
//		//	Add Journal
//		rightPanel.add(journalPanel);
//	}
//	
//	/**
//	 * Status Journal Button
//	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 30/10/2014, 10:30:06
//	 * @param status
//	 * @return void
//	 */
//	public void statusJournal(boolean status) {
//		for(int i = 0; i < journalButton.length; i++) {
//			//	Journal Button
//			journalButton[i].setEnabled(status);
//		}
//	}
	
	/**
	 * Generate Days of Calendar 
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 21/10/2014, 14:02:10
	 * @return void
	 */
//	public void generateDay() {
//		statusJournal(true);
//		dayButton = new JToggleButton[dayYear.length];
//		for(int x = 1; x < 13; x++) {
//			dayTitlePanel  = new JPanel();
//			monthLabel	   = new JLabel();
//		   	monthYearPanel = new JPanel();
//		   	//	Set Date
//			cal.set(m_Year, x-1, 1);
//			getDate = cal.getTime();
//		   	//	Print Month Name
//			monthLabel.setText(mFormatter.format(getDate));
//			monthYearPanel.add(monthLabel);
//			dayTitlePanel.setLayout(new GridLayout(0, 7));
//			dayTitlePanel.add(monthYearPanel);
//				
//			for(int i = 0; i < 7; i++) {
//				dayLabel = new JLabel(dFormatter.format(getDate));
//				//	Set Date
//				cal.set(2014, 8, i);
//				getDate  = cal.getTime();
//			    //	Print Day Name 
//				dayLabel.setText(dFormatter.format(getDate));
//			    dayTitlePanel.add(dayLabel);
//			}
//		    if(cols == 4) { 
//		       	rows = x; 
//		       	cols = 0;     
//		    }
//		    centerPanel.add(monthYearPanel,  new GridBagConstraints(cols, rows, 1, 1, 0.0, 0.0
//     			   		,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//			centerPanel.add(dayTitlePanel,  new GridBagConstraints(cols, rows+1, 1, 1, 0.0, 0.0
//						,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 0, 5), 0, 0));
//			//	Add Day of the Month
//			dayMonth(m_Year,x);
//			cols++;	
//			}
//		centerPanel.revalidate();
//	} //  generateDay
	
	/**
	 * Add Days of the Month From Calendar
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 21/10/2014, 16:54:22
	 * @param year
	 * @param month
	 * @return void
	 */
//	public void dayMonth(int year, int month) {
//	    cal.set(year, month-1,1); 
//	    int numberDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);;
//		startDay = cal.get(Calendar.DAY_OF_WEEK)-1;
//		
//	      dayNumPanel = new JPanel();
//	      dayNumPanel.setPreferredSize(new Dimension(200,120));
//	      dayNumPanel.setLayout(DayLayout);
//	      //  Pad space before the first day of the month
//	      for (int i = 0; i < startDay; i++) {
//	    	  JLabel dayMonthLabel = new JLabel();
//	    	  dayMonthLabel.setText("");
//	    	  dayNumPanel.add(dayMonthLabel);
//	      }
//	      //  Print days Button
//	      for (int  i = 1; i <= numberDays; i++) {
//	    	  dayButton[count] = new JToggleButton();
//	    	  int j=0;
//	    	  while(j<m_Color.size()) {
//	    		  if(dayYear[count].getKey() == m_Day_ID.get(j)) {
//	    			  dayButton[count].setBackground(m_Color.get(j));
//	    			  break;
//	    		  }  
//	    		  j++;
//	    	  }
//	    	  dayButton[count].setText(""+i);
//	    	  dayButton[count].setName(""+dayYear[count].getKey());
//	    	  dayButton[count].setBorder(BorderFactory.createEmptyBorder());
//	    	  dayNumPanel.add(dayButton[count]);
//	    	  count++;
//	      } 
//	      centerPanel.add(dayNumPanel,  new GridBagConstraints(cols, rows+2, 1, 1, 0.0, 0.0
//					,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 5, 15), 0, 0));
//	} //  Day Month
//	
//	@Override
//	public void mousePressed(MouseEvent e) {
//	}
//	  
//	@Override
//	public void stateChanged(ChangeEvent e) {
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		//	Asign journal in day button
//		for(int i = 0; i < journalButton.length; i++) { 
//			if(e.getActionCommand().equals(journalButton[i].getText())) {
//				//	Get Color
//				getColor(Integer.parseInt(journalButton[i].getName()),trxName);
//				if(dayButton!=null) {
//					for(int j = 0; j < dayButton.length; j++) {
//						if(dayButton[j].isSelected()) {
//							dayButton[j].setSelected(false);
//							dayButton[j].setBackground(new Color(m_RColor, m_GColor, m_BColor));
//						}
//					}
//				}
//			}
//		}
//		if(e.getActionCommand().equals(saveButton.getLabel())) {
//			saveData();
//		}
//	} 	//  actionPerformed
//	@Override
//	public void dispose() {
//	}
//	@Override
//	public void mouseClicked(MouseEvent e) {
//	}
//	@Override
//	public void mouseReleased(MouseEvent e) {
//	}
//	
//	@Override
//	public void mouseEntered(MouseEvent e) {
//			// Add Border from Day Button
//		for(int i = 0; i < journalButton.length; i++) {
//			if(e.getSource().equals(journalButton[i])) {
//				if(dayButton != null) {
//					for(int j = 0; j < dayButton.length; j++) {
//						if(dayButton[j].getBackground().equals(colorLabel[i].getBackground())) {
//							dayButton[j].setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
//						}
//					}
//				}
//			}
//		}
//	}
//	
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// Remove Border from Day Button
//		for(int i = 0; i < journalButton.length; i++) {
//			if(e.getSource().equals(journalButton[i])) {
//				if(dayButton!=null) {
//					for(int j = 0; j < dayButton.length; j++) {
//						if(dayButton[j].getBackground().equals(colorLabel[i].getBackground())) {
//							dayButton[j].setBorder(BorderFactory.createEmptyBorder());
//						}
//					}
//				}
//			}
//		}
//	}
	
//	@Override
//	public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
//		Object value = evt.getNewValue();
//		
//		//	Load Day of the Year
//		if(evt.getSource().equals(yearSearch)) {
//			clearData();
//			m_C_Year_ID = ((Integer)value).intValue();
//			//	Get Day of Year
//			dayYear 	= getDayYear(m_C_Year_ID);
//	    	getDayColor(m_HR_Calendar_ID,m_C_Year_ID, trxName);
//			if(dayYear.length == 0) {
//				JOptionPane.showMessageDialog(null, "Generate Day");
//			}
//			else{
//				m_Year = Integer.parseInt(dayYear[0].getName());
//				generateDay();
//			}
//		}
//		
//		if(evt.getSource().equals(calendarSearch)) {
//			//	Get Value Calendar Search
//			m_HR_Calendar_ID = (Integer) calendarSearch.getValue();
//			if(m_C_Year_ID != 0) {
//				clearData();
//				//	Get Day of Year
//				dayYear = getDayYear(m_C_Year_ID);
//		    	getDayColor(m_HR_Calendar_ID,m_C_Year_ID, trxName);
//				//	Generate Day of Month
//				generateDay();
//			}
//			
//		} 
//	}
	/**
	 * Clear Data
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 21/10/2014, 14:06:16
	 * @return void
	 */
//	public void clearData() {
//		startDay = 0;
//		count	 = 0;
//		cols	 = 0;
//		rows	 = 0;
//		centerPanel.removeAll();
//		centerPanel.repaint();
//		dayButton=null;
//		
//		statusJournal(false);
//	}
	/**
	 * Save Journal Day Data
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 02/10/2014, 14:21:57
	 * @return void
	 */
//	public void saveData() {
//		try	{
//			Trx.run(new TrxRunnable() {
//				public void run(String trxName)	{
//					statusBar.setStatusLine(saveCalendar(m_HR_Calendar_ID, journalButton, dayButton, colorLabel, trxName));
//					rightPanel.repaint();
//					clearData();
//				}
//			});
//		}
//		catch (Exception e) {
//			ADialog.error(m_WindowNo, mainPanel, "Error", e.getLocalizedMessage());
//			return;
//		}
//	}

	@Override
	public ADForm getForm() {
		return form;
	}

	@Override
	public void onEvent(Event event) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
		 
}