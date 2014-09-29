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

import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.spin.model.MHRJournal;

/**
 * 
 * @author victor.perez@e-evolution.com, www.e-evolution.com
 *
 */
public class JournalDay 
{

	/**	Window No			*/
	public int         		m_WindowNo = 0;

	protected int 			m_HR_Journal_ID = 0;
	protected Timestamp m_startTime = null;
	protected Timestamp m_endTime = null;
	/**	Logger			*/
	public static CLogger log = CLogger.getCLogger(JournalDay.class);
	/**	Export Class for Bank Account	*/
	public String			m_PaymentExportClassHR = null;
	
	protected ArrayList<KeyNamePair> getGroupIncidenceData(String trxName){
		String sql = "SELECT igc.HR_IncidenceGroup_ID, c.Name FROM " +
				"HR_IGConcept as igc " +
				"INNER Join HR_IncidenceGroup as ig on(ig.HR_IncidenceGroup_ID = igc.HR_IncidenceGroup_ID) " +
				"INNER JOIN HR_Concept as c  on(c.HR_Concept_ID = igc.HR_Concept_ID)";
		return getData(sql, trxName);
	}
	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 29/09/2014, 16:13:25
	 * @param trxName
	 * @return void
	 */
	protected void setTime(int p_HR_Journal, String trxName){
		MHRJournal journal = new MHRJournal(Env.getCtx(), 0, trxName);
		if(m_HR_Journal_ID != 0)
			journal.setHR_Journal_ID(m_HR_Journal_ID);
		if(m_HR_Journal_ID != 0){
			m_startTime = getStartTime(p_HR_Journal,trxName);
			m_endTime = getEndTime(p_HR_Journal,trxName);
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
	protected Timestamp getEndTime(int p_HR_Journal, String trxName){
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
	protected Timestamp getStartTime(int p_HR_Journal, String trxName){
		return DB.getSQLValueTS(trxName, "SELECT TimeSlotStart FROM " +
				"HR_Journal " +
				"Where HR_Journal_ID = ?", p_HR_Journal);
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
	
}
