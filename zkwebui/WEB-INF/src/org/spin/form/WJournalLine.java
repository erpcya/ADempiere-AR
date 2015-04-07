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


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.adempiere.webui.component.Checkbox;
import org.adempiere.webui.component.Grid;
import org.adempiere.webui.component.GridFactory;
import org.adempiere.webui.component.Panel;
import org.adempiere.webui.component.Row;
import org.adempiere.webui.component.Rows;
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
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zkex.zul.Borderlayout;
import org.zkoss.zkex.zul.Center;
import org.zkoss.zkex.zul.North;
import org.zkoss.zkex.zul.South;
import org.zkoss.zkex.zul.West;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Timebox;
import org.zkoss.zul.Window;

/**
 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a>
 *
 */
public class WJournalLine extends JournalLine
			implements IFormController, EventListener, ValueChangeListener  {
	private CustomForm form = new CustomForm();

	public WJournalLine() {
		Env.setContext(Env.getCtx(), m_WindowNo, "IsSOTrx", "Y");   //  defaults to no
		Trx.get(trxName, true);
		Env.setContext(Env.getCtx(), form.getWindowNo(), "IsSOTrx", "Y");   //  defaults to no
		Trx.get(trxName, true);
		try	{
			dyInit();
			zkInit();	
		}
		catch(Exception e) {
		}
	}
	/**	 FormFrame									*/
	private Borderlayout mainLayout = new Borderlayout();
	/**  Arrays for Line Journal 					*/
	private Checkbox[] 			conceptBox;
	/**  Buttons for Incidences						*/
	private Div[] 				IncidenceDiv;
	/**  Add Incidence Button    					*/
	private Button[] 			a_IncidenceButton;
	
	/**  Panel										*/
	private Div[] 				sliderPanel;
	private Panel[] 			hPanel;
	private Panel 				mainPanel    	 = new Panel();
	private Panel 				parameterPanel	 = new Panel();
	private West 				west 			 = new West();
	private Center				center 			 = new Center();
	private Grid 				leftLayout 		 = GridFactory.newGridLayout();
	private Grid 				northLayout 	 = GridFactory.newGridLayout();
	private Grid 				centerLayout 	 = GridFactory.newGridLayout();
	private Panel				centerPanel	 	 = new Panel();
	private Grid 				southLayout		 = GridFactory.newGridLayout();
	private South				south			 = new South();
	/** trxName										*/
	private String				trxName 		 = Trx.createTrxName("GM");
	/**  Journal 									*/
	private Label 				journalLabel 	 = new Label();
	private WTableDirEditor		journalSearch    = null;
	/**  Start Hours Slot 							*/
	private Label				s_SlotLabel	     = new Label();
	private Timebox				s_SlotText 		 = new Timebox();
	/**  End Hours Slot 								*/
	private Label				e_SlotLabel	     = new Label();
	private Timebox				e_SlotText 	 	 = new Timebox();
	/**	 Group Incidence								*/
	private Label 				groupLabel  	 = new Label();
	/**  Save 										*/
	private Button				saveButton 		 = new Button();
	/**  Start Slot Hour Label						*/    
    private Label 				s_HourLabel 	 = new Label();	
    /**	 Start Slot Hour							*/
    private Timebox				s_HourText 		 = new Timebox();
    /**  End Slot Hour Label						*/
	private Label 				e_HourLabel		 = new Label();
    /**	 Start Slot Hour							*/
	private Timebox 			e_HourText 		 = new Timebox();
	/**  Save Slot Button 							*/
    private Button 				s_HourButton	 = new Button();
	/**  Total Button 								*/
	private int 				t_Button  		 = 0;
	/**  Quantity of Hour 							*/
	static final int 			N_HOUR 			 = 24;
	/**  Quantity of Minute 						*/
	static final int 			N_MIN  			 = 60;
	/**  Size Hour 									*/ 
	private int 				s_Hour      	 = 34;
	/**  Start Hour 								*/
	private int 				start_Hour  	 = 1;
	/**  End Hour 									*/
	private int 				end_Hour 		 = 1;
	/**  Float Start Minute							*/
	private float 				fstart_Min		 = 0;
	/**	 Float End Minute							*/
	private float 				fend_Min		 = 0;
	/**	 aux Position								*/
	private int 				aux 			 = 0;
	
	/**	 Top Position								*/
	private int 				top				 = 0;
	/**  Window Dialog 								*/
	private Window 				hourWindow		 = new Window();
	private Grid 				windowLayout	 = GridFactory.newGridLayout();
	private Rows 				hourRows		 = null;
	private Row 				hourRow			 = null;
	/** 											*/
	private Rows				incidenceRows  	 = null;
	private Row 				incidenceRow 	 = null;
	private Rows 				centerRows		 = null;
	private Row  				centerRow		 = null;
	private Rows 				timerRows		 = null;
	private Row 				timerRow		 = null;
	private int 				s_IncideceButton = 0;
	private int 				pos				 = 0;
	private DateFormat 			dateFormat 		 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * Static Init
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 30/10/2014, 10:28:35
	 * @return void
	 */
	private void zkInit() {
		form.appendChild(mainLayout);
		mainLayout.setWidth("99%");
		mainLayout.setHeight("100%");
		//	North Panel
		parameterPanel.appendChild(northLayout);
		
		North north = new North();
		north.setStyle("position:absolute; left:150px; border-style: solid; border-width: 1px; border-color: rgb(0,0,255)");
		mainLayout.appendChild(north);
		north.appendChild(parameterPanel);
		Rows rows = null;
		Row row = null;
		
		northLayout.setWidth("65%");
		rows = northLayout.newRows();
		row = rows.newRow();
		row.setAlign("center");
		Div jDiv = new Div();
		mainLayout.setStyle("collapsible:true");
		journalLabel.setValue("Jornadas: ");
		s_SlotLabel.setValue("Inicio Hora Descanso: ");
		e_SlotLabel.setValue(" Fin Hora Descanso: ");
		s_SlotText.setReadonly(true);
		e_SlotText.setReadonly(true);
		saveButton.setLabel(Msg.translate(Env.getCtx(), "Save"));
		saveButton.addEventListener("onClick", this);
		row.setSpans("2");
		jDiv.appendChild(journalLabel); 
	
		jDiv.appendChild(journalSearch.getComponent());
		row.appendChild(jDiv);
		row = rows.newRow();
		row.setAlign("center");
		row.setSpans("3");
		Div div = new Div();
		div.appendChild(s_SlotLabel);
		div.appendChild(s_SlotText);
		
		div.appendChild(e_SlotLabel);
		div.appendChild(e_SlotText);
		row.appendChild(div);
		//	Hour Edit Hours Dialog
		hourWindow.setTitle("Ajustar Hora");
		hourWindow.setClosable(true);
		hourWindow.setWidth("155px");
		hourWindow.setHeight("120px");
		hourWindow.appendChild(windowLayout);
		windowLayout.setWidth("130px");
		hourRows= windowLayout.newRows();
		windowLayout.setStyle("margin-left: 10px;");
		s_HourLabel.setValue("Hora Inicio");
		e_HourLabel.setValue("Hora Final");
		
		s_HourButton.setLabel("Save");
		s_HourText.setText("0:0");
		e_HourText.setText("1:00");
		hourRow = hourRows.newRow();
		hourRow.setAlign("right");
		hourRow.setWidth("30px");
		hourRow.appendChild(s_HourLabel);
		hourRow.appendChild(s_HourText);
		hourRow = hourRows.newRow();
		hourRow.setAlign("right");
		hourRow.appendChild(e_HourLabel);
		hourRow.appendChild(e_HourText);
		hourRow = hourRows.newRow();
		hourRow.setAlign("center");
		hourRow.setSpans("2");
		hourRow.appendChild(s_HourButton);
		s_HourButton.addEventListener("onClick", this);
		
		//	Split Panel
		 west.appendChild(leftLayout);
		 west.setWidth("150px");
		 center.appendChild(centerLayout);
 		 mainLayout.appendChild(west);
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
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 30/10/2014, 10:22:17
	 * @throws Exception
	 * @return void
	 */
	public void dyInit() throws Exception{
		//	GET Journal
		int AD_Column_ID = 1000177;		//	HR_Journal.HR_Journal_ID
		MLookup lookupJournal = MLookupFactory.get(Env.getCtx(), m_WindowNo, 0, AD_Column_ID, DisplayType.TableDir);
		journalSearch = new WTableDirEditor("HR_Journal_ID", true, false, true, lookupJournal);
		journalSearch.addValueChangeListener(this);
		
		incidenceRows = leftLayout.newRows();
		incidenceRow = incidenceRows.newRow();
		groupLabel.setValue("Grupos de Incidencias:");
		incidenceRow.appendChild(groupLabel);
	
		west.setCollapsible(true);
		west.setSplittable(true);
	
		centerRows = centerLayout.newRows();
		timerRows =  centerRows;
		
	}
	/**
	 * Remove Items
	 * @author <a href="mailto:Raulmunozn@gmail.com">Raul Muñoz</a> 10/12/2014, 10:03:37
	 * @return void
	 */
	public void removeItems() {
		incidenceRows.getChildren().clear();
		centerRows.getChildren().clear();
		top=0;
	}
	/**
	 * Add Items From Journal Line
	 * @author <a href="mailto:Raulmunozn@gmail.com">Raul Muñoz</a> 16/12/2014, 16:31:05
	 * @return void
	 */
	public void addItemsCenter() {
		centerRow = centerRows.newRow();
		centerRow.setStyle("background-color:#ccc; Width:150px;");
		
		for(int i = 0; i < 24; i++) {
			Label hoursLabel = new Label();
			//	Hours Label Line
			if(i < 10)
				hoursLabel.setValue("0"+ i +":30");
			else 
				hoursLabel.setValue(i +":30");
			centerRow.appendChild(hoursLabel);
		}
	}
	
	/**
	 * Add Items From Journal Line
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 27/10/2014, 14:16:24
	 * @param p_HR_Journal_ID
	 * @return void
	 */
	public void addItemsLeft(int p_HR_Journal_ID) {
		removeItems();
		addItemsCenter();
		int cont=0;	
		incidenceRow = incidenceRows.newRow();
		incidenceRow.appendChild(groupLabel);
		incidenceRow = incidenceRows.newRow();

		// Get Concept Data 
		KeyNamePair[] dataC = getConceptData(p_HR_Journal_ID);
		conceptBox 		  = new Checkbox[dataC.length];
		IncidenceDiv   = new Div[getLineCount(trxName)];
		
		a_IncidenceButton = new Button[dataC.length];
		sliderPanel 	  = new Div[dataC.length];
		hPanel 			  = new Panel[dataC.length];
		
		for(int i = 0; i < IncidenceDiv.length; i++) {
			IncidenceDiv[i] = new Div();
		}
		for(int i = 0; i < dataC.length; i++) {
			sliderPanel[i] = new Panel();	
			conceptBox[i]  = new Checkbox();
			conceptBox[i].setLabel(dataC[i].getName());
			conceptBox[i].setChecked(true);
	    	m_HR_Concept_ID.add(i, dataC[i].getKey());
			KeyNamePair[] dataJL = getJournalLineData(p_HR_Journal_ID,m_HR_Concept_ID.get(i));

			a_IncidenceButton[i]  = new Button();
		    hPanel[i] = new Panel();

		    //	Name of Incidence
		    conceptBox[i].setName(String.valueOf(i));
		    conceptBox[i].addEventListener("onCheck", this);
		    //	Button From Add Incidence 
		    a_IncidenceButton[i].setLabel("+");
		    a_IncidenceButton[i].setId(String.valueOf(i));
		    a_IncidenceButton[i].addEventListener("onClick", this);
		    
  		    //	Add Slider Hours in rightPanel
	    	centerPanel.appendChild(sliderPanel[i]);
	    	incidenceRow.appendChild(conceptBox[i]);
	    	incidenceRow.appendChild(a_IncidenceButton[i]);
	    	incidenceRow = incidenceRows.newRow();
	    	timerRow = timerRows.newRow();
	    	
	    	sliderPanel[i].setParent(timerRow);
	    	top+=23;
	    	for(int j = 0; j < dataJL.length; j++) {
	    		//	Get Start Hour and End Hour
		    	getSE_Hour(Integer.parseInt(dataJL[j].getID()),trxName);
		    	m_HR_JournalLine.add(Integer.parseInt(dataJL[j].getID()));
		    	//  Calculate Time size
	    		start_Hour = (((int) m_StartHour.get(cont).getTime() / 3600000) - 4) * s_Hour;
	    		end_Hour   = (((int) m_EndHour.get(cont).getTime() / 3600000) - 4) * s_Hour;
	    		fstart_Min = ((((float) m_StartHour.get(cont).getTime() / 3600000) - 4) * s_Hour) - start_Hour;
	    		fend_Min   = ((((float) m_EndHour.get(cont).getTime()   / 3600000) - 4) * s_Hour) - end_Hour;
	    		// Add button from Incidence
	    		addButtonHour(i,cont);
//	    		timerRow.appendChild(sliderPanel[i]);
	    		cont++;
	    	}
		}
	}
	/**
	 * Add Button for Incidence Hour
	 * d@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 27/10/2014, 14:16:08
	 * @param iSlider
	 * @param iButton
	 * @return void
	 */
	public void addButtonHour(int iSlider, int iButton) {
		IncidenceDiv[iButton] = new Div();
		int width=(end_Hour+ (int) fend_Min)-(start_Hour+(int) fstart_Min);
		int left=start_Hour+(int) fstart_Min;

		//	Get HR_Concept_ID for Get RGBColor
		getColor(m_HR_Concept_ID.get(iSlider),trxName);
		IncidenceDiv[iButton].setStyle("name:"+iButton+"; position:absolute; left:"+left+"px; top:"+top+"px; width:"+width+"px;  background-color: rgb("+m_RColor+", "+m_GColor+", "+m_BColor+")");
		IncidenceDiv[iButton].setHeight("15px");
		IncidenceDiv[iButton].addEventListener("onClick", this);
		IncidenceDiv[iButton].setZindex(iSlider);
		IncidenceDiv[iButton].setParent(sliderPanel[iSlider]);
		sliderPanel[iSlider].setStyle("left:"+left+"px");
		System.out.println(iSlider+"-"+iButton);
		t_Button++;
		pos = 0;
		
	} //  addButtonHour

	/** 
	 * 	Calculate Size and Position From Incidence 
	 *	@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 24/10/2014, 11:45:16
	 *  @return void
	 */
	public void calculate() {
			int left=0;
			int width=0;
			
			String hourString = dateFormat.format(s_HourText.getValue());
			Timestamp hourTime = Timestamp.valueOf(hourString);
			
			m_StartHour.add(aux,hourTime);
			//	Convert Timestamp to Hour Start
			start_Hour = (((int) hourTime.getTime() / 3600000) - 4) * s_Hour;
			//	Convert Timestamp to Minute Start
			fstart_Min = ((((float) hourTime.getTime() / 3600000) - 4) * s_Hour) - start_Hour;
			
			hourString = dateFormat.format(e_HourText.getValue());
			hourTime =Timestamp.valueOf(hourString);
			m_EndHour.add(aux,hourTime);
			//	Convert Timestamp to Hour End
			end_Hour   = (((int) hourTime.getTime() / 3600000) - 4) * s_Hour;
			//	Convert Timestamp to Minute End
			fend_Min   = ((((float) hourTime.getTime() / 3600000) - 4) * s_Hour) - end_Hour;
			
			if(start_Hour <= end_Hour) {
				s_IncideceButton = (end_Hour+ (int) fend_Min)-(start_Hour+ (int) fstart_Min);
				//	Set Position
				left=start_Hour + (int) fstart_Min;
				width =s_IncideceButton;
				IncidenceDiv[aux].setStyle("name:"+aux+"; position:absolute; left:"+left+"px; top:"+top+"px; width:"+width+"px;  background-color: rgb("+m_RColor+", "+m_GColor+", "+m_BColor+")");
			}
			else {
				//	Set Position
				left=end_Hour + (int) fend_Min;
				//	Size
				s_IncideceButton = (start_Hour+ (int) fstart_Min)-(end_Hour+ (int) fend_Min);
				width =s_IncideceButton;
				IncidenceDiv[aux].setStyle("name:"+aux+"; position:absolute; left:"+left+"px; top:"+top+"px; width:"+width+"px;  background-color: rgb("+m_RColor+", "+m_GColor+", "+m_BColor+")");
			}
						
	}

	/**
	 * Clear Data
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 21/10/2014, 14:07:38
	 * @return void
	 */
	public void clearData() {
		pos 			  = 0;
		aux				  = 0;
		s_IncideceButton  = 0;
		t_Button  		  = 0;
		start_Hour  	  = 1;
		end_Hour 		  = 1;
		IncidenceDiv   	  = null;
 		fstart_Min		  = 0;
		fend_Min		  = 0;
		a_IncidenceButton = null;
		sliderPanel 	  = null;
		hPanel 			  = null;
		m_HR_Concept_ID.clear();
		m_StartHour.clear();
		m_EndHour.clear();
		s_SlotText.setReadonly(true);
		e_SlotText.setReadonly(true);
		m_HR_JournalLine.clear();
	}
	
	/**
	 * Save Data
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 02/10/2014, 14:21:57
	 * @return void
	 */
	public void saveData() {
		m_StartSlotHour=Timestamp.valueOf("1800-01-01 "+s_SlotText.getText()+":00");
		m_EndSlotHour=Timestamp.valueOf("1800-01-01 "+e_SlotText.getText()+":00");
		try	{
			Trx.run(new TrxRunnable() {
				public void run(String trxName)	{	
					wSaveJournalLine(sliderPanel,IncidenceDiv,trxName);
					
				}
			});
		}
		catch (Exception e) {
			FDialog.error(m_WindowNo, mainPanel, "Error", e.getLocalizedMessage());
			return;
		}
	}

	@Override
	public void valueChange(ValueChangeEvent evt) {
		String name = evt.getPropertyName();
		Object value = evt.getNewValue();
		clearData();
		if(name.equals("HR_Journal_ID")) {
			m_HR_Journal_ID=((Integer)value).intValue();
			//	Get Time Slot Journal Line
			getTimeSlot(m_HR_Journal_ID,trxName);
			//	Add Items
			addItemsLeft(m_HR_Journal_ID);
			Date time= new Date(m_TimeSlotStart.getTime());
			
			s_SlotText.setValue(time);
			time = new Date(m_TimeSlotEnd.getTime());
			e_SlotText.setValue(time);
			s_SlotText.setReadonly(false);
			e_SlotText.setReadonly(false);
		}
	}

	@Override
	public void onEvent(Event arg0) throws Exception {
		String name =arg0.getName();
	
		Component target =arg0.getTarget();
		int count=conceptBox.length;
		if(target.equals(saveButton)) {
			saveData();
		}
		for(int i = 0;  i < count; i++) {
			if(target.equals(a_IncidenceButton[i])) {
				//	Add Hour Incidence 
				hourWindow.setMode("modal");
				hourWindow.setParent(form);
				pos = i; 
			}
		}
		for(int i=0; i< t_Button; i++) {
			if(IncidenceDiv[i].equals(arg0.getTarget())) {
				//	Edit Hour Incidence
				hourWindow.setMode("modal");
				hourWindow.setParent(form);
				aux = i;
				pos = t_Button;
			}
		}
		for(int i = 0;  i< count; i++) {
			if(conceptBox[i].isSelected()) {
				for(int x = 0; x < t_Button; x++) {
					//	Show Incidence Line
					a_IncidenceButton[i].setVisible(true);
					if(IncidenceDiv[x].getZindex() == i)
						IncidenceDiv[x].setVisible(true);
				}
				arg0.stopPropagation();
			}
			else { 
				for(int x = 0; x < t_Button; x++) {
					//	Hide Incidence Line
					a_IncidenceButton[i].setVisible(false);
					if(IncidenceDiv[x].getZindex() == i)
						IncidenceDiv[x].setVisible(false);
				}
				arg0.stopPropagation();
			}
		}
		
		if(target.equals(s_HourButton)) {
			if(name.equals("onClick")) {
				hourWindow.setVisible(false);
				if(pos == t_Button)
					calculate();
				else{
					if(pos==0)
						top=(23*2)-23;
					else
						top=(23*(pos+2))-23;
					addButtonHour(pos,t_Button);
					aux = t_Button-1;
					calculate();
				}
			}
		}
	}

	@Override
	public ADForm getForm() {
		return form;
	}
}