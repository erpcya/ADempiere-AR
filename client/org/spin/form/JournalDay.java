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
 * Contributor(s):Victor Perez www.e-evolution.com 				              *
 * Copyright (C) 2003-2007 e-Evolution,SC. All Rights Reserved.               *
 *****************************************************************************/
package org.spin.form;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.swing.JOptionPane;

import org.compiere.model.MOrgInfo;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;
import org.spin.model.MHRJournal;
import org.spin.model.MHRJournalLine;

/**
 * 
 * @author victor.perez@e-evolution.com, www.e-evolution.com
 *
 */
public class JournalDay 
{

	/**	Window No			*/
	public int         		m_WindowNo = 0;

	protected int 			m_HR_Journal_ID 		= 0;
	protected int			m_HR_IncidenceGroup_ID  = 0;
	/** Red Color			*/
	protected int 			m_RColor				= 0;
	/** Green Color			*/
	protected int 			m_GColor				= 0;
	/** Blue Color			*/
	protected int 			m_BColor				= 0;
	/** Start Time			*/
	protected Timestamp 	m_TimeSlotStart 			= null;
	/** End Time			*/
	protected Timestamp 	m_TimeSlotEnd 				= null;
//	protected Timestamp		m_StartHour				= null;
//	protected Timestamp		m_EndHour				= null;
	/**	Client				*/
	protected int 				m_AD_Client_ID = 0;
	/**	Organization		*/
	protected int 				m_AD_Org_ID = 0;
	protected ArrayList<Integer> 			m_HR_Concept_ID			= new ArrayList<Integer>();

	protected ArrayList<Timestamp> 			m_StartHour			= new ArrayList<Timestamp>();
	protected ArrayList<Timestamp> 			m_EndHour			= new ArrayList<Timestamp>();
	/**	Logger			*/
	public static CLogger log = CLogger.getCLogger(JournalDay.class);
	/**	Export Class for Bank Account	*/
	public String			m_PaymentExportClassHR = null;
	
	protected ArrayList<KeyNamePair> getJournalLineData(int p_HR_Journal_ID, int p_HR_Concept_ID, String trxName){
		ArrayList<KeyNamePair> data = new ArrayList<KeyNamePair>();
		StringBuffer sql =new StringBuffer("SELECT jl.AD_Org_ID, jl.HR_JournalLine_ID, jl.description FROM " +
				"HR_JournalLine as jl " +
				"INNER JOIN HR_Concept as c  on(jl.HR_Concept_ID = c.HR_Concept_ID) " +
				"INNER JOIN HR_Journal as j on(jl.HR_Journal_ID = j.HR_Journal_ID) " +
				"WHERE jl.HR_Journal_ID="+p_HR_Journal_ID+" and jl.HR_Concept_ID="+p_HR_Concept_ID);
		try	{
			
			PreparedStatement pstmt = DB.prepareStatement(sql.toString(), null);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				m_AD_Org_ID=rs.getInt("AD_Org_ID");
				
				data.add(new KeyNamePair(rs.getInt("HR_JournalLine_ID"), rs.getString("description")));
			}
			rs.close();
			pstmt.close();
		}	
		catch (SQLException e){
			log.log(Level.SEVERE, sql.toString(), e);
		}
			
		return data;
	}
	protected ArrayList<KeyNamePair> getGroupIncidenceData(int p_HR_Journal_ID, String trxName){
		String sql = "SELECT c.HR_Concept_ID, c.name FROM " +
				"HR_JournalLine as jl " +
				"INNER JOIN HR_Concept as c  on(jl.HR_Concept_ID = c.HR_Concept_ID) " +
				"INNER JOIN HR_Journal as j on(jl.HR_Journal_ID = j.HR_Journal_ID) " +
				"WHERE jl.HR_Journal_ID="+p_HR_Journal_ID+" GROUP BY c.HR_Concept_ID";
		return getData(sql, trxName);
	}
	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 01/10/2014, 14:37:48
	 * @param p_HR_Journal_ID
	 * @param trxName
	 * @return
	 * @return Timestamp
	 */
	protected Timestamp getStarHour(int p_HR_JournalLine_ID, String trxName){
		return DB.getSQLValueTS(trxName, "SELECT jl.StartTime FROM " +
		"HR_JournalLine as jl " +
		"INNER JOIN HR_Concept as c  on(jl.HR_Concept_ID = c.HR_Concept_ID) " +
		"INNER JOIN HR_Journal as j on(jl.HR_Journal_ID = j.HR_Journal_ID) " +
		"WHERE jl.HR_JournalLine_ID=?", p_HR_JournalLine_ID);
	}
	protected void setSE_Hour(int p_HR_JournalLine_ID, String trxName){
		m_StartHour.add(getStarHour(p_HR_JournalLine_ID, trxName));
		m_EndHour.add(getEndHour(p_HR_JournalLine_ID, trxName));
	}
	protected Timestamp getEndHour(int p_HR_JournalLine_ID, String trxName){
		return DB.getSQLValueTS(trxName, "SELECT jl.EndTime FROM " +
		"HR_JournalLine as jl " +
		"INNER JOIN HR_Concept as c  on(jl.HR_Concept_ID = c.HR_Concept_ID) " +
		"INNER JOIN HR_Journal as j on(jl.HR_Journal_ID = j.HR_Journal_ID) " +
		"WHERE jl.HR_journalLine_ID=?", p_HR_JournalLine_ID);
	}
	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 29/09/2014, 16:13:25
	 * @param trxName
	 * @return void
	 */
	protected void setTimeSlot(int p_HR_Journal, String trxName){
		MHRJournal journal = new MHRJournal(Env.getCtx(), 0, trxName);
		if(m_HR_Journal_ID != 0)
			journal.setHR_Journal_ID(m_HR_Journal_ID);
		if(m_HR_Journal_ID != 0){
			m_TimeSlotStart = getTimeSlotStart(p_HR_Journal,trxName);
			m_TimeSlotEnd = getTimeSlotEnd(p_HR_Journal,trxName);
		} 
	}	
	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 29/09/2014, 16:13:02
	 * @param p_HR_Journal
	 * @param trxName
	 * @return
	 * @return Timestamp
	 */
	protected Timestamp getTimeSlotEnd(int p_HR_Journal, String trxName){
		return DB.getSQLValueTS(trxName, "SELECT TimeSlotEnd FROM " +
				"HR_Journal " +
				"Where HR_Journal_ID = ?", p_HR_Journal);	
	}
	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 29/09/2014, 16:13:12
	 * @param p_HR_Journal
	 * @param trxName
	 * @return
	 * @return Timestamp
	 */
	protected Timestamp getTimeSlotStart(int p_HR_Journal, String trxName){
		return DB.getSQLValueTS(trxName, "SELECT TimeSlotStart FROM " +
				"HR_Journal " +
				"Where HR_Journal_ID = ?", p_HR_Journal);
	}
	protected void setRGB(int p_HR_Concept_ID, String trxName){
		m_RColor = getRColor(p_HR_Concept_ID,trxName);
		m_GColor = getGColor(p_HR_Concept_ID,trxName);
		m_BColor = getBColor(p_HR_Concept_ID,trxName);	
	}
	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 30/09/2014, 16:22:31
	 * @param p_HR_Concept_ID
	 * @param trxName
	 * @return
	 * @return int
	 */
	protected int getRColor(int p_HR_Concept_ID, String trxName){
		return DB.getSQLValue(trxName, "SELECT ig.red, igc.HR_Concept_ID " +
				"FROM HR_IGConcept as igc " +
				"INNER JOIN HR_IncidenceGroup as ig on(igc.HR_IncidenceGroup_ID = ig.HR_IncidenceGroup_ID) " +
				"WHERE igc.HR_Concept_ID=?", p_HR_Concept_ID);
	}
	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 30/09/2014, 16:22:31
	 * @param p_HR_Concept_ID
	 * @param trxName
	 * @return
	 * @return int
	 */
	protected int getGColor(int p_HR_Concept_ID, String trxName){
		return DB.getSQLValue(trxName, "SELECT ig.green, igc.HR_Concept_ID " +
				"FROM HR_IGConcept as igc " +
				"INNER JOIN HR_IncidenceGroup as ig on(igc.HR_IncidenceGroup_ID = ig.HR_IncidenceGroup_ID) " +
				"WHERE igc.HR_Concept_ID=?", p_HR_Concept_ID);
	}
	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 30/09/2014, 16:22:31
	 * @param p_HR_Concept_ID
	 * @param trxName
	 * @return
	 * @return int
	 */
	protected int getBColor(int p_HR_Concept_ID, String trxName){
		return DB.getSQLValue(trxName, "SELECT ig.blue, igc.HR_Concept_ID " +
				"FROM HR_IGConcept as igc " +
				"INNER JOIN HR_IncidenceGroup as ig on(igc.HR_IncidenceGroup_ID = ig.HR_IncidenceGroup_ID) " +
				"WHERE igc.HR_Concept_ID=?", p_HR_Concept_ID);
	}
	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 29/09/2014, 16:13:16
	 * @param sql
	 * @param trxName
	 * @return
	 * @return ArrayList<KeyNamePair>
	 */
	private ArrayList<KeyNamePair> getData(String sql, String trxName){
		ArrayList<KeyNamePair> data = new ArrayList<KeyNamePair>();
		
		log.config("getData");
		
		try	{
			PreparedStatement pstmt = DB.prepareStatement(sql, trxName);
			ResultSet rs = pstmt.executeQuery();
			//
			while (rs.next()) {
				data.add(new KeyNamePair(rs.getInt(1), rs.getString(2)));
			}
			rs.close();
			
			pstmt.close();
		} catch (SQLException e) {
			log.log(Level.SEVERE, sql, e);
		}
		return data;
	}
	
	protected String generateJournalDay(String trxName){
		 
		 //	Org Info
		 MOrgInfo orgInfo = null;
		 orgInfo = MOrgInfo.get(Env.getCtx(), m_AD_Org_ID, trxName);
			JOptionPane.showMessageDialog(null, m_AD_Org_ID+" clientr ");
			
		 MHRJournalLine journalLine = new MHRJournalLine(Env.getCtx(), 0, trxName);
		 journalLine.setAD_Org_ID(m_AD_Org_ID);
		
		 	journalLine.setHR_Journal_ID(m_HR_Journal_ID);
			for(int i = 0; i<m_HR_Concept_ID.size(); i++)
				journalLine.setHR_Concept_ID(m_HR_Concept_ID.get(i));
			for(int i = 0; i<m_StartHour.size(); i++){
				
				JOptionPane.showMessageDialog(null,m_StartHour.get(i));
				journalLine.setStartTime(m_StartHour.get(i));
				journalLine.setEndTime(m_EndHour.get(i));
			}
	
			if (!journalLine.save())
			{
				journalLine = null;
				
			}
		 return "Save";
	}
	
}
