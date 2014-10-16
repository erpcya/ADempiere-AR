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
import java.util.Vector;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JToggleButton;

import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.spin.model.MHRJournalDay;

/**
 * 
 * @author victor.perez@e-evolution.com, www.e-evolution.com
 *
 */
public class JournalDay 
{
	/**	Window No			*/
	public int         		m_WindowNo = 0;
	/**	Calendar			*/
	protected int 			m_HR_Calendar_ID 		= 0;
	/**	IncidenceGroup		*/
	protected int			m_HR_IncidenceGroup_ID  = 0;
	/**	Year ID				*/
	protected int 			m_C_Year_ID				= 0;
	/**	Client				*/
	protected int 			m_AD_Client_ID 			= 0;
	/**	Organization		*/
	protected int 			m_AD_Org_ID 			= 0;
	/**	Year				*/
	protected int			m_Year					= 0;
	/** Red Color			*/
	protected int 			m_RColor				= 0;
	/** Green Color			*/
	protected int 			m_GColor				= 0;
	/** Blue Color			*/
	protected int 			m_BColor				= 0;
	/** Concept						*/
	protected ArrayList<Integer> 	m_HR_Concept_ID		= new ArrayList<Integer>();
	/** StartHour					*/
	protected ArrayList<Timestamp> 	m_StartHour			= new ArrayList<Timestamp>();
	/** EndHour						*/
	protected ArrayList<Timestamp> 	m_EndHour			= new ArrayList<Timestamp>();
	/**	Logger			*/
	public static CLogger log = CLogger.getCLogger(JournalDay.class);
	
	/** getDayYear
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 16/10/2014, 10:22:28
	 * @param p_HR_Year_ID
	 * @param trxName
	 * @return
	 * @return Vector<Integer>
	 */
	protected Vector<Integer> getDayYear(int p_HR_Year_ID, String trxName){
		Vector<Integer> columnNames = new Vector<Integer>();
		try	{
			PreparedStatement pstmt = DB.prepareStatement("SELECT fiscalYear, HR_Day_ID  FROM HR_Day as d " +
														  "INNER JOIN C_Year as y on(d.C_Year_ID=y.C_Year_ID) WHERE y.C_Year_ID=?", null);
			pstmt.setInt(1, p_HR_Year_ID);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				columnNames.add(rs.getInt(2));
				m_Year=rs.getInt(1);
			}
			DB.close(rs, pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columnNames;
	}

	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 09/10/2014, 16:58:12
	 * @param 
	 * @param trxName
	 * @return
	 * @return ArrayList<KeyNamePair>
	 */
	protected ArrayList<KeyNamePair> getJournal(String trxName){
		String sql = "SELECT HR_Journal_ID, name FROM " +
				"HR_Journal";
		return getData(sql, trxName);
	}
	/** getDayColor
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 16/10/2014, 10:21:41
	 * @param p_HR_day_ID
	 * @param p_HR_Calendar_ID
	 * @param p_C_Year_ID
	 * @param trxName
	 * @return
	 * @return boolean
	 */
	protected boolean getDayColor(int p_HR_day_ID, int p_HR_Calendar_ID, int p_C_Year_ID, String trxName){
		boolean result=false;
		try	{
			PreparedStatement pstmt = DB.prepareStatement("SELECT jd.HR_Day_ID, red, green, blue  FROM HR_JournalDay as jd " +
							"INNER JOIN HR_Calendar as c on(jd.HR_Calendar_ID = c.HR_Calendar_ID) " +
							"INNER JOIN HR_Journal as j on(j.HR_Journal_ID=jd.HR_Journal_ID) " +
							"INNER JOIN HR_Day as d on(d.HR_Day_ID=jd.HR_Day_ID) " +
							"INNER JOIN C_Year as y on(d.C_Year_ID=y.C_Year_ID) " +
							"WHERE jd.HR_Day_ID=? and c.HR_Calendar_ID=? and y.C_Year_ID=?", null);
			pstmt.setInt(1, p_HR_day_ID);
			pstmt.setInt(2, p_HR_Calendar_ID);
			pstmt.setInt(3, p_C_Year_ID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				m_RColor = rs.getInt(2);
				m_GColor = rs.getInt(3);
				m_BColor = rs.getInt(4);	
				result=true;
			}
			DB.close(rs, pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
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
	
	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 13/10/2014, 15:32:37
	 * @param p_HR_Journal_ID
	 * @param trxName
	 * @return
	 * @return int
	 */
	protected void getColor(int p_HR_Journal_ID, String trxName){
		try	{
			PreparedStatement pstmt = DB.prepareStatement("SELECT red, green, blue HR_Journal_ID " +
				"FROM HR_Journal " +
				"WHERE HR_Journal_ID=?", null);
		
		pstmt.setInt(1, p_HR_Journal_ID);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			m_RColor = rs.getInt(1);
			m_GColor = rs.getInt(2);
			m_BColor = rs.getInt(3);	
		}
		DB.close(rs, pstmt);
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	protected String saveCalendar(int p_HR_Calendar_ID, JButton[] p_journalButton, JToggleButton[] p_dayButton, String trxName){
	
		for(int j = 0; j < p_journalButton.length; j++){
			for(int i = 0; i < p_dayButton.length; i++){ 
				if(p_dayButton[i].getIconTextGap()==j){
					MHRJournalDay journalDay = new MHRJournalDay(Env.getCtx(), 0, trxName);
					journalDay.setAD_Org_ID(m_AD_Org_ID);
					journalDay.setHR_Calendar_ID(p_HR_Calendar_ID);
					journalDay.setHR_Day_ID(Integer.parseInt(p_dayButton[i].getName()));
					journalDay.setHR_Journal_ID(Integer.parseInt(p_journalButton[j].getName()));
					journalDay.saveEx();
				}
			}
		}
		 return "Save";
	}
}