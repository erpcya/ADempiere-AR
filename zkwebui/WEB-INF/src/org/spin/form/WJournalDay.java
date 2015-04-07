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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.adempiere.webui.component.Button;
import org.adempiere.webui.component.Grid;
import org.adempiere.webui.component.GridFactory;
import org.adempiere.webui.component.Label;
import org.adempiere.webui.component.Panel;
import org.adempiere.webui.component.Row;
import org.adempiere.webui.component.Rows;
import org.adempiere.webui.component.WTableColumn;
import org.adempiere.webui.editor.WTableDirEditor;
import org.adempiere.webui.event.ValueChangeEvent;
import org.adempiere.webui.event.ValueChangeListener;
import org.adempiere.webui.panel.ADForm;
import org.adempiere.webui.panel.CustomForm;
import org.adempiere.webui.panel.IFormController;
import org.adempiere.webui.window.FDialog;
import org.compiere.model.MLookup;
import org.compiere.model.MLookupFactory;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;
import org.compiere.util.Trx;
import org.compiere.util.TrxRunnable;
import org.zkoss.zk.ui.HtmlNativeComponent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zkex.zul.Borderlayout;
import org.zkoss.zkex.zul.Center;
import org.zkoss.zkex.zul.East;
import org.zkoss.zkex.zul.North;
import org.zkoss.zkex.zul.South;
/**
 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a>
 *
 */
public class WJournalDay extends JournalDay
			implements IFormController,EventListener, ValueChangeListener {
	private CustomForm form = new CustomForm();

	public WJournalDay() {
		
		
		Env.setContext(Env.getCtx(), form.getWindowNo(), "IsSOTrx", "Y");   //  defaults to no
		Trx.get(trxName, true);
		try	{
			
			dyInit();
			zkInit();
		}
		catch(Exception e) {
		}
	}
	/**	Window No				*/
	private Borderlayout mainLayout = new Borderlayout();
	/** 	Panel				*/
	private Panel 			dayTitlePanel   = new Panel();
	private Panel 	  		dayNumPanel		= new Panel();
	private Panel 			parameterPanel	= new Panel();
	private Grid 			northLayout		= GridFactory.newGridLayout();
	private Grid 			rightLayout 	= GridFactory.newGridLayout();
	private Grid 			centerLayout 	= GridFactory.newGridLayout();
	private Grid 			southLayout 	= GridFactory.newGridLayout();
	private East 			east 			= new East();
	private Center 			center 			= new Center();
	private South			south 			= new South();
	/** 						*/
	private String			trxName 		= Trx.createTrxName("GM");
	/** Calendar 				*/
	private Label 			calendarLabel   = new Label();
	private WTableDirEditor calendarSearch  = null;
	/** Year 					*/
	private Label 			yearLabel		= new Label();
	private WTableDirEditor	yearSearch	    = null;
	/** Save */
	private Button			saveButton		= new Button();
	/** Day Calendar 			*/
	private Button[] 		dayButton		= null;
	private KeyNamePair[]   dayYear	  	  	  = null;
	/** Calendar				*/
	private Calendar 		cal				= Calendar.getInstance();
	/**	First Day 				*/
	private	int				startDay	 	= 0;
	/** Count Day 				*/
	private	int				count	  	  	= 0;
	/** Columns calendar  		*/
	private int 			cols			= 1;
	/** Formatter Month Title	*/
	private SimpleDateFormat mFormatter 	= new SimpleDateFormat("MMMM");
	/** Formatter Day Title		*/
	private SimpleDateFormat dFormatter 	= new SimpleDateFormat("E");
	SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
	/** Journal 				*/
	private Button[] 		journalButton	= null;
	/** Journal Color			*/
	private Label[] 		colorLabel 	  	= null;
	/**  Month 					*/
	private Label  		    monthLabel		= null;
	/** Day Week 				*/
	private Label  		    dayLabel		= null;
	/** Get Date 				*/
	private Date 		    getDate 		= null;
	/** Journal Label			*/
	private Label		    journalLabel	= new Label();
	/** Calendar 				*/
	private Rows			calendarRows 	= null;
	private Row 			calendarRow 	= null;
	private ArrayList<WTableColumn>		m_tableColumns = new ArrayList<WTableColumn>();

	/**
	 * Static Init
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 30/10/2014, 10:29:50
	 * @throws Exception
	 * @return void
	 */
	private void zkInit() throws Exception {
		
		form.appendChild(mainLayout);

		calendarRows = centerLayout.newRows();
		
		mainLayout.setWidth("99%");
		mainLayout.setHeight("100%");
		//	North Panel
		calendarLabel.setText(Msg.translate(Env.getCtx(), "Calendar"));
		yearLabel.setText(Msg.translate(Env.getCtx(), "Year"));
		saveButton.setLabel(Msg.translate(Env.getCtx(), "Save"));
		saveButton.addActionListener(this);
	
		parameterPanel.appendChild(northLayout);
		
		North north = new North();
		north.setStyle("border-style: solid; border-width: 1px; border-color: rgb(0,0,255)");
		mainLayout.appendChild(north);
		north.appendChild(parameterPanel);
		Rows rows = null;
		Row row = null;
		northLayout.setWidth("65%");
		rows = northLayout.newRows();
		row = rows.newRow();
		
		row.appendChild(calendarLabel);
		row.appendChild(calendarSearch.getComponent());
		row.appendChild(yearLabel);
		row.appendChild(yearSearch.getComponent());
		east.appendChild(rightLayout);
		mainLayout.appendChild(east);
		center.setAutoscroll(true);
		center.appendChild(centerLayout);
		mainLayout.appendChild(center);
		rows = southLayout.newRows();
		row = rows.newRow();
		south.appendChild(southLayout);
		
		row.setAlign("center");
		row.appendChild(saveButton);
		mainLayout.appendChild(south);
		
	}
	
	/**
	 * Dynamic Init (prepare dynamic fields)
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 30/10/2014, 10:29:40
	 * @throws Exception
	 * @return void
	 */
	public void dyInit() throws Exception {
		//	Get Calendar
		int AD_Column_ID = 1000167;		//	HR_Calendar.HR_Calendar_ID
		MLookup lookupCalendar = MLookupFactory.get(Env.getCtx(), m_WindowNo, 0, AD_Column_ID, DisplayType.TableDir);
		calendarSearch = new WTableDirEditor("HR_Calendar_ID", true, false, true, lookupCalendar);
		calendarSearch.addValueChangeListener(this);
		//	Get Year
		AD_Column_ID = 54927;		//	HR_Year.HR_Year_Id	
		MLookup lookupYear = MLookupFactory.get(Env.getCtx(), m_WindowNo, 0, AD_Column_ID, DisplayType.TableDir);
		yearSearch = new WTableDirEditor("C_Year_ID", true, false, true, lookupYear);
		yearSearch.addValueChangeListener(this);
		//		
		Rows rows = null;
		Row row = null;
		rightLayout.setWidth("200px");
		rows = rightLayout.newRows();
		row = rows.newRow();
		journalLabel.setText(" Jornadas: ");			
		journalLabel.setWidth("200px");
		row.appendChild(journalLabel);
		//	Get Journal Data
		KeyNamePair[] dataIG = getJournal();
		journalButton = new Button[dataIG.length];
		colorLabel = new Label[dataIG.length];

		for(int i = 0; i < dataIG.length; i++) {
			//	Journal Button
			row = rows.newRow();
			journalButton[i] = new Button();
			colorLabel[i] = new Label(); 
			journalButton[i].setLabel(dataIG[i].getName());
			journalButton[i].setWidth("170px");
			journalButton[i].addActionListener(this);
			journalButton[i].setName(String.valueOf(dataIG[i].getKey()));

			//	Get Color for Label
			getColor(dataIG[i].getKey(),trxName);
			journalButton[i].setStyle("border-style: solid; border-width: 1px; border-color: rgb("+m_RColor+", "+m_GColor+", "+m_BColor+")");
			colorLabel[i].setStyle("border-style: solid; border-width: 1px; border-color: rgb("+m_RColor+", "+m_GColor+", "+m_BColor+")");
			
			row.appendChild(journalButton[i]);			
		}
	}
	
	/**
	 * Generate Days of Calendar 
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 21/10/2014, 14:02:10
	 * @return void
	 * @throws ParseException 
	 */
	public void generateDay() {
		calendarRows.getChildren().clear();
		int month=0;
		int aux=0;
		count=0;
		dayButton = new Button[dayYear.length];
		WTableColumn tableColumn= new WTableColumn();
		tableColumn.setHeaderValue("aa");
		m_tableColumns.add(tableColumn);
		centerLayout.setWidth("100%");

		calendarRow = calendarRows.newRow();
		
		for(int x = 1; x < 13; x++) {
			
			monthLabel	   = new Label();
		   	//	Set Date
			cal.set(2011, x-1, 1);
			getDate =  cal.getTime();;
		
		   	//	Print Month Name
			monthLabel.setText(mFormatter.format(getDate));
			monthLabel.setStyle("font-size:12px; font-weight: bold;");
			calendarRow.setAlign("center");
			calendarRow.appendChild(monthLabel);
		
		    if(cols == 3) { 
		    	calendarRow = calendarRows.newRow();
		    	cols = 0; 
		    	 
		    	 while(cols<3){
		    		 HtmlNativeComponent titleTable =
				    		  new HtmlNativeComponent("table", "<tr><td>", "</td></tr>");
				    
				      titleTable.setDynamicProperty("border", "0");
			  	      titleTable.setDynamicProperty("width", "215px");
			  	      
		    		 dayTitlePanel  = new Panel();
		 		    for(int i = 0; i < 7; i++) {
		 				dayLabel = new Label(dFormatter.format(getDate));
		 				//	Set Date
		 				cal.set(2014, 8, i);
		 				getDate  = cal.getTime();
		 			    //	Print Day Name 
		 				dayLabel.setText(" "+dFormatter.format(getDate)+".");
		 				dayLabel.setStyle("font-size:13px");
		 				dayTitlePanel.setStyle("float: left; border:solid 0px; width: 215px;");
		 				titleTable.appendChild(dayLabel);
		 			}
		 		    calendarRow.appendChild(titleTable);
		 		    cols++;
		 		 }
		    	 calendarRow = calendarRows.newRow();
		    	 cols = 0; 
		    	  while(cols<3){

			    	  cal.set(m_Year, month,1);
			    	  int numberDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);;
			    	  startDay = cal.get(Calendar.DAY_OF_WEEK)-1;
			    	  HtmlNativeComponent monthTable =
			    			  new HtmlNativeComponent("table", "<tr><td>", "</td></tr>");
		    
			    	  monthTable.setDynamicProperty("border", "0");
			    	  monthTable.setDynamicProperty("width", "225px");
	  		
			    	  dayNumPanel = new Panel();
			    	  dayNumPanel.setWidth("170px");
			    	  if(aux>1){
			    		  aux=aux-startDay;
			    	  }
			    	  //  Pad space before the first day of the month
			    	  for (int i = 1; i <= startDay; i++) {
			    		  Button dayMonthLabel = new Button();
			    		  dayMonthLabel.setLabel(""+(aux+i));
			    		  dayMonthLabel.setDisabled(true);
			    		  dayMonthLabel.setStyle("width:30px; border-style: solid; border-width: 1px; border-color: #ccc;");
			    		  monthTable.appendChild(dayMonthLabel);
			    	  }
			    	  for (int  i = 1; i <= numberDays; i++) {
			    		  aux=i;
			    		  dayButton[count] = new Button();
			    		  dayButton[count].setLabel(""+i);
			    		  dayButton[count].setName(""+dayYear[count].getKey());
			    		  int j=0;
			    		  dayButton[count].setStyle("width:30px; border-style: solid; border-width: 1px; border-color: #ccc;");
			    		  while(j<m_Color.size()) {
				    		  if(dayYear[count].getKey() == m_Day_ID.get(j)) {
				    			  dayButton[count].setStyle("width:30px; border-style: solid; border-width: 1px; border-color: rgb("+m_Color.get(j).getRed()+", "+m_Color.get(j).getGreen()+", "+m_Color.get(j).getBlue()+")");
				    			  break;
				    		  }  
				    		  j++;
				    	  }
			    		 
			    		  dayButton[count].addActionListener(this);
			    		  monthTable.appendChild(dayButton[count]);
			    		  count++;
			    	  }
			    	  month++;
			    	  calendarRow.appendChild(monthTable);
			    	  cols++;
		    	  }
  		  	     calendarRow.appendChild(dayNumPanel);
		    	 cols = 0;
		    	 calendarRow = calendarRows.newRow();
		    }
			cols++;	
			}
	} //  generateDay
	
	/**
	 * Clear Data
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 21/10/2014, 14:06:16
	 * @return void
	 */
	public void clearData() {
		startDay = 0;
		count	 = 0;
		cols	 = 0;
		calendarRows.getChildren().clear();
		count=0;
		dayButton=null;
	}
	
	/**
	 * Save Journal Day Data
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 02/10/2014, 14:21:57
	 * @return void
	 */
	public void saveData() {
							try	{
								Trx.run(new TrxRunnable() {
									public void run(String trxName)	{
										String[] journalName = null;
										String[] journalStyle = null;
										String[] dayName = null;
										String[] dayStyle = null;
										journalName = new String[journalButton.length];
										dayName = new String[dayButton.length];
										journalStyle = new String[journalButton.length];
										dayStyle = new String[dayButton.length];
										
										for(int x = 0; x < journalButton.length; x++){
											journalName[x]=journalButton[x].getName();
											journalStyle[x]=colorLabel[x].getStyle();
										}
										for(int x = 0; x < dayButton.length; x++){
											dayName[x]=dayButton[x].getName();
											dayStyle[x]=dayButton[x].getStyle();
										}
									
										wSaveCalendar(journalName, journalStyle, dayName, dayStyle, trxName);
										FDialog.info(0, mainLayout, "Save", "");
										
									}
								});
							}
							catch (Exception e) {
								FDialog.error(m_WindowNo, mainLayout, "Error", e.getLocalizedMessage());
								return;
							}
	}

	@Override
	public ADForm getForm() {
		return form;
	}

	@Override
	public void onEvent(Event event) throws Exception {
		if(event.getTarget().equals(saveButton)) {
			saveData();
		}
		if(dayButton!=null && journalButton!=null) {
			for(int i = 0; i < dayButton.length; i++){
				if(event.getTarget()==dayButton[i]){
					if(dayButton[i].getStyle().equals("border-style: solid; border-width: 1px; border-color: #000; width:28px;") ){
						dayButton[i].setStyle("border-style: solid; border-width: 0px; width:28px;");
					}
					else {
						dayButton[i].setStyle("border-style: solid; border-width: 1px; border-color: #000; width:28px;");
					}
				} 
			}
			for(int i = 0; i < journalButton.length; i++){
				if(event.getTarget()==journalButton[i]){
					for(int j = 0; j < dayButton.length; j++){
						if(dayButton[j].getStyle().equals("border-style: solid; border-width: 1px; border-color: #000; width:28px;") ){
							dayButton[j].setStyle(journalButton[i].getStyle());
						}	
					}	
				}
			}
		}
		
	}

	@Override
	public void valueChange(ValueChangeEvent evt) {
		String name = evt.getPropertyName();
		Object value = evt.getNewValue();
		
		if(name.equals("C_Year_ID")){
			m_C_Year_ID = ((Integer)value).intValue();
			//	Get Day of Year
			dayYear 	= getDayYear(m_C_Year_ID);
			if(dayYear.length>0){
			getDayColor(m_HR_Calendar_ID,m_C_Year_ID, trxName);
			m_Year = Integer.parseInt(dayYear[0].getName());
			generateDay();
			}
			else {
				FDialog.error(0, "Error", "Generate Day");
			}
		}
		if(name.equals("HR_Calendar_ID")) {
			//	Get Value Calendar Search
			m_HR_Calendar_ID = ((Integer) value).intValue();
		
			if(m_C_Year_ID != 0) {
				//	Get Day of Year
				dayYear = getDayYear(m_C_Year_ID);
		    	getDayColor(m_HR_Calendar_ID,m_C_Year_ID, trxName);
				//	Generate Day of Month
				generateDay();
			}
		}
	}
	
}