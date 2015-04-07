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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.spin.model.MHRJournal;
import org.spin.model.MHRJournalLine;
import org.zkoss.zul.Div;

/**
 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a>
 *
 */
public class JournalLine {
	/**	Window No											*/
	public int         				m_WindowNo 				= 0;
	/**	Journal												*/
	protected int 					m_HR_Journal_ID 		= 0;
	/**	Incidence Group										*/
	protected int					m_HR_IncidenceGroup_ID  = 0;
	/** Red Color											*/
	protected int 					m_RColor				= 0;
	/** Green Color											*/
	protected int 					m_GColor				= 0;
	/** Blue Color											*/
	protected int 					m_BColor				= 0;
	/** Start Time											*/
	protected Timestamp 			m_TimeSlotStart 		= null;
	/** End Time											*/
	protected Timestamp 			m_TimeSlotEnd 			= null;
	/**	Client												*/
	protected int 					m_AD_Client_ID 			= 0;
	/**	Organization										*/
	protected int 					m_AD_Org_ID 			= 0;
	/**	Concept												*/
	protected ArrayList<Integer> 	m_HR_Concept_ID			= new ArrayList<Integer>();
	/** StartHour											*/
	protected ArrayList<Timestamp> 	m_StartHour				= new ArrayList<Timestamp>();
	/** EndHour												*/
	protected ArrayList<Timestamp>	m_EndHour				= new ArrayList<Timestamp>();
	/**	Logger												*/
	public static CLogger 			log 					= CLogger.getCLogger(JournalDay.class);
	/**	Counter												*/
	protected int 					m_count					= 0;
	/** Start Slot Hour										*/
	protected Timestamp 			m_StartSlotHour			= null;
	/** End Slot Hour										*/
	protected Timestamp 			m_EndSlotHour			= null;
	/** Journal Line										*/
	protected ArrayList<Integer> 	m_HR_JournalLine		= new ArrayList<Integer>();
	
	/**
	 * Get Journal Line Data
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 21/10/2014, 10:14:44
	 * @param p_HR_Journal_ID
	 * @param p_HR_Concept_ID
	 * @param trxName
	 * @return
	 * @return KeyNamePair[]
	 */
	protected KeyNamePair[] getJournalLineData(int p_HR_Journal_ID, int p_HR_Concept_ID){
		return DB.getKeyNamePairs("SELECT jl.HR_JournalLine_ID, jl.AD_Org_ID " +
								  "FROM HR_JournalLine AS jl " +
								  "INNER JOIN HR_Concept AS c ON(jl.HR_Concept_ID = c.HR_Concept_ID) " +
								  "INNER JOIN HR_Journal AS j ON(jl.HR_Journal_ID = j.HR_Journal_ID) " +
								  "WHERE jl.HR_Journal_ID = "+p_HR_Journal_ID+" AND jl.HR_Concept_ID = "+p_HR_Concept_ID,false);
	}
	
	/**
	 * Get Group Incidence Data
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 21/10/2014, 10:15:14
	 * @param p_HR_Journal_ID
	 * @param trxName
	 * @return
	 * @return KeyNamePair[]
	 */
	protected  KeyNamePair[] getConceptData(int p_HR_Journal_ID){
		return DB.getKeyNamePairs("SELECT c.HR_Concept_ID, c.Name " +
								  "FROM HR_JournalLine AS jl " +
								  "INNER JOIN HR_Concept AS c ON(jl.HR_Concept_ID = c.HR_Concept_ID) " +
								  "INNER JOIN HR_Journal AS j ON(jl.HR_Journal_ID = j.HR_Journal_ID) " +
								  "WHERE jl.HR_Journal_ID = "+p_HR_Journal_ID+" GROUP BY c.HR_Concept_ID", false);
	}
	protected  KeyNamePair[] getGroupIncidenceData(){
		return DB.getKeyNamePairs("SELECT i.HR_IncidenceGroup_ID, i.name " +
								  "FROM HR_IncidenceGroup AS i", false);
	}
	
	/**
	 * Get Line Counter
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 21/10/2014, 10:15:48
	 * @param trxNameGardenWorld Admin
	 * @return
	 * @return int
	 */
	protected int getLineCount(String trxName){
		return DB.getSQLValue(trxName, "SELECT COUNT(*) FROM HR_JournalLine");
	}
	
	/**
	 * Set Start Hour and End Hour
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 21/10/2014, 10:17:47
	 * @param p_HR_JournalLine_ID
	 * @param trxName
	 * @return void
	 */
	protected void getSE_Hour(int p_HR_JournalLine_ID, String trxName){
		m_StartHour.add(getStarHour(p_HR_JournalLine_ID, trxName));
		m_EndHour.add(getEndHour(p_HR_JournalLine_ID, trxName));
	}
	
	/**
	 * Get Start Hour From Journal Line
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 01/10/2014, 14:37:48
	 * @param p_HR_Journal_ID
	 * @param trxName
	 * @return
	 * @return Timestamp
	 */
	protected Timestamp getStarHour(int p_HR_JournalLine_ID, String trxName){
		return DB.getSQLValueTS(trxName, "SELECT jl.StartTime " +
										 "FROM HR_JournalLine as jl " +
										 "INNER JOIN HR_Concept as c ON(jl.HR_Concept_ID = c.HR_Concept_ID) " +
										 "INNER JOIN HR_Journal as j ON(jl.HR_Journal_ID = j.HR_Journal_ID) " +
										 "WHERE jl.HR_JournalLine_ID = ? ", p_HR_JournalLine_ID);
	}
	
	/**
	 * Get End Hour From Journal Line
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 21/10/2014, 10:17:10
	 * @param p_HR_JournalLine_ID
	 * @param trxName
	 * @return
	 * @return Timestamp
	 */
	protected Timestamp getEndHour(int p_HR_JournalLine_ID, String trxName){
		return DB.getSQLValueTS(trxName, "SELECT jl.EndTime " +
										 "FROM HR_JournalLine as jl " +
										 "INNER JOIN HR_Concept as c ON(jl.HR_Concept_ID = c.HR_Concept_ID) " +
										 "INNER JOIN HR_Journal as j ON(jl.HR_Journal_ID = j.HR_Journal_ID) " +
										 "WHERE jl.HR_journalLine_ID = ?", p_HR_JournalLine_ID);
	}
	
	/**
	 * Set Time Slot
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 29/09/2014, 16:13:25
	 * @param trxName
	 * @return void
	 */
	protected void getTimeSlot(int p_HR_Journal, String trxName){
			m_TimeSlotStart = getTimeSlotStart(p_HR_Journal,trxName);
			m_TimeSlotEnd = getTimeSlotEnd(p_HR_Journal,trxName);
	}	
	
	/**
	 * Get Time Slot End
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 29/09/2014, 16:13:02
	 * @param p_HR_Journal
	 * @param trxName
	 * @return
	 * @return Timestamp
	 */
	protected Timestamp getTimeSlotEnd(int p_HR_Journal, String trxName){
		return DB.getSQLValueTS(trxName, "SELECT TimeSlotEnd " +
										 "FROM HR_Journal " +
										 "Where HR_Journal_ID = ?", p_HR_Journal);	
	}
	
	/**
	 * Get Time Slot Start
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 29/09/2014, 16:13:12
	 * @param p_HR_Journal
	 * @param trxName
	 * @return
	 * @return Timestamp
	 */
	protected Timestamp getTimeSlotStart(int p_HR_Journal, String trxName){
		return DB.getSQLValueTS(trxName, "SELECT TimeSlotStart " +
										 "FROM HR_Journal " +
										 "Where HR_Journal_ID = ?", p_HR_Journal);
	}
	
	/**
	 * Get color for Incididence Button
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 30/09/2014, 16:22:31
	 * @param p_HR_Concept_ID
	 * @param trxName
	 * @return
	 * @return int
	 */
	protected void getColor(int p_HR_Concept_ID, String trxName){
		ResultSet 		  rs 	 = null;
		PreparedStatement pstmt  = null;
		try	{
			pstmt = DB.prepareStatement("SELECT ig.Red, ig.Green, ig.Blue, igc.HR_Concept_ID " +
										"FROM HR_IGConcept AS igc " +
										"INNER JOIN HR_IncidenceGroup AS ig ON(igc.HR_IncidenceGroup_ID = ig.HR_IncidenceGroup_ID) " +
										"WHERE igc.HR_Concept_ID = ?", trxName);
			//	Set HR_Conept_ID
			pstmt.setInt(1, p_HR_Concept_ID);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				//	Red Color
				m_RColor = rs.getInt(1);
				//	Green Color
				m_GColor = rs.getInt(2);
				//	Blue Color
				m_BColor = rs.getInt(3);	
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			//	Close Connection
			DB.close(rs,pstmt);
			rs=null;
			pstmt=null;
		}
	}
	
	/**
	 * Save Journal Line Data
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 21/10/2014, 10:59:46
	 * @param slider
	 * @param hours
	 * @param trxName
	 * @return
	 * @return String
	 */
	protected String saveJournalLine( JPanel[] slider, JButton[] hours, String trxName){
		MHRJournalLine journalLine = null;
		MHRJournal journal = null;
		journal =new MHRJournal(Env.getCtx(), m_HR_Journal_ID, trxName);
		journal.setHR_Journal_ID(m_HR_Journal_ID);
		journal.setTimeSlotStart(m_StartSlotHour);
		journal.setTimeSlotEnd(m_EndSlotHour);
		journal.saveEx(trxName);
		for(int i = 0; i < m_HR_Concept_ID.size(); i++){			
			for(int j = 0; j < slider[i].getComponentCount(); j++){					
				for(int x = 0; x<hours.length; x++){
					if(slider[i].getComponent(j).getName().equals(hours[x].getName())){
					if(x >= m_HR_JournalLine.size()){
						journalLine = new MHRJournalLine(Env.getCtx(), 0, trxName);	
					}
					else {
						journalLine = new MHRJournalLine(Env.getCtx(), m_HR_JournalLine.get(x), trxName);
						journalLine.setHR_JournalLine_ID(m_HR_JournalLine.get(x));
					}
						//	Set Journal
					 	journalLine.setHR_Journal_ID(m_HR_Journal_ID);						
						//	Set Concept
						journalLine.setHR_Concept_ID(m_HR_Concept_ID.get(i));
						//	Set Start Hour 
						journalLine.setStartTime(m_StartHour.get(x));
						//	Set End Hour
						journalLine.setEndTime(m_EndHour.get(x));
						//	Save Data
						journalLine.saveEx(trxName);
					}
				}
			}
		}
		 return "Save";
	}
	/**
	 * Save Journal Line Data
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Mu�oz</a> 21/10/2014, 10:59:46
	 * @param slider
	 * @param hours
	 * @param trxName
	 * @return
	 * @return String
	 */
	protected String wSaveJournalLine( Div[] slider, Div[] hours, String trxName){
		MHRJournalLine journalLine = null;
		MHRJournal journal = null;
		journal =new MHRJournal(Env.getCtx(), m_HR_Journal_ID, trxName);
		journal.setHR_Journal_ID(m_HR_Journal_ID);
		journal.setTimeSlotStart(m_StartSlotHour);
		journal.setTimeSlotEnd(m_EndSlotHour);
		journal.saveEx(trxName);
		for(int i = 0; i < m_HR_Concept_ID.size(); i++){
			List listSlider = slider[i].getChildren();
			for(int j = 0; j < listSlider.size(); j++){					
				for(int x = 0; x<hours.length; x++){
					if(listSlider.get(j).equals(hours[x])){
					if(x >= m_HR_JournalLine.size()){
						journalLine = new MHRJournalLine(Env.getCtx(), 0, trxName);	
					}
					else {
						journalLine = new MHRJournalLine(Env.getCtx(), m_HR_JournalLine.get(x), trxName);
						journalLine.setHR_JournalLine_ID(m_HR_JournalLine.get(x));
					}
						//	Set Journal
					 	journalLine.setHR_Journal_ID(m_HR_Journal_ID);						
						//	Set Concept
						journalLine.setHR_Concept_ID(m_HR_Concept_ID.get(i));
						//	Set Start Hour 
						journalLine.setStartTime(m_StartHour.get(x));
						//	Set End Hour
						journalLine.setEndTime(m_EndHour.get(x));
						//	Save Data
						journalLine.saveEx(trxName);
					}
				}
			}
		}
		 return "Save";
	}
}