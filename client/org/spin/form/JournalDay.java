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

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
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
	/**	Window No											*/
	public int         				m_WindowNo 				= 0;
	/**	Calendar											*/
	protected int 					m_HR_Calendar_ID 		= 0;
	/**	Incidence Group										*/
	protected int					m_HR_IncidenceGroup_ID  = 0;
	/**	Year ID												*/
	protected int 					m_C_Year_ID				= 0;
	/**	Client												*/
	protected int 					m_AD_Client_ID 			= 0;
	/**	Organization										*/
	protected int 					m_AD_Org_ID 			= 0;
	/**	Year												*/
	protected int					m_Year					= 0;
	/** Red Color											*/
	protected int 					m_RColor				= 0;
	/** Green Color											*/
	protected int 					m_GColor				= 0;
	/** Blue Color											*/
	protected int 					m_BColor				= 0;
	/**	Logger												*/
	public static CLogger			log 		= CLogger.getCLogger(JournalDay.class);
	protected ArrayList<Color>		m_Color = new ArrayList<Color>();
	protected ArrayList<Integer>	day_ID= new ArrayList<Integer>();
	/** 
	 * Get Day of Year
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 21/10/2014, 09:17:23
	 * @param p_HR_Year_ID
	 * @param trxName
	 * @return
	 * @return KeyNamePair[]
	 */
	protected KeyNamePair[] getDayYear(int p_HR_Year_ID) {
		return DB.getKeyNamePairs("SELECT HR_Day_ID, FiscalYear " +
								  "FROM HR_Day AS d " +
								  "INNER JOIN C_Year AS y ON(d.C_Year_ID = y.C_Year_ID) " +
								  "WHERE y.C_Year_ID = "+p_HR_Year_ID, false);
	}

	/**
	 *  Get Journal Data
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 09/10/2014, 16:58:12
	 * @param 
	 * @param trxName
	 * @return
	 * @return KeyNamePair[]
	 */
	protected KeyNamePair[] getJournal() {
		return DB.getKeyNamePairs("SELECT HR_Journal_ID, Name " +
								  "FROM HR_Journal", false);
	}
	
	/** 
	 * Get Color for Day
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 16/10/2014, 10:21:41
	 * @param p_HR_day_ID
	 * @param p_HR_Calendar_ID
	 * @param p_C_Year_ID
	 * @param trxName
	 * @return
	 * @return boolean
	 */
	protected ArrayList<Color> getDayColor(int p_HR_Calendar_ID, int p_C_Year_ID, String trxName) {
		ResultSet 		  rs 	 = null;
		PreparedStatement pstmt  = null;
		m_Color.clear();
		day_ID.clear();
		try	{
			pstmt = DB.prepareStatement("SELECT jd.HR_Day_ID, j.Red, j.Green, j.Blue " +
										"FROM HR_JournalDay AS jd " +
										"INNER JOIN HR_Calendar AS c ON(jd.HR_Calendar_ID = c.HR_Calendar_ID) " +
										"INNER JOIN HR_Journal AS j ON(j.HR_Journal_ID = jd.HR_Journal_ID) " +
										"INNER JOIN HR_Day AS d ON(d.HR_Day_ID = jd.HR_Day_ID) " +
										"INNER JOIN C_Year AS y ON(d.C_Year_ID = y.C_Year_ID) " +
										"WHERE c.HR_Calendar_ID = ? AND y.C_Year_ID = ?" +
										"GROUP BY jd.HR_Day_ID, j.Red, j.Green, j.Blue", trxName);
			
			//	Set HR_Calendar_ID
			pstmt.setInt(1, p_HR_Calendar_ID);
			//	Set C_Year_ID
			pstmt.setInt(2, p_C_Year_ID);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				m_Color.add(new Color(rs.getInt(2),rs.getInt(3),rs.getInt(4)));
				day_ID.add(rs.getInt(1));
		
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
			
		return m_Color;
	}
	
	/**
	 * Get Color From Journal Day
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 13/10/2014, 15:32:37
	 * @param p_HR_Journal_ID
	 * @param trxName
	 * @return
	 * @return int
	 */
	protected void getColor(int p_HR_Journal_ID, String trxName) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try	{
			pstmt = DB.prepareStatement("SELECT Red, Green, Blue, HR_Journal_ID " +
										"FROM HR_Journal " +
										"WHERE HR_Journal_ID = ?", trxName);
			//	Set Journal
			pstmt.setInt(1, p_HR_Journal_ID);
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
	 * Save Calendar Data 
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 20/10/2014, 17:24:37
	 * @param p_HR_Calendar_ID
	 * @param p_journalButton
	 * @param p_dayButton
	 * @param trxName
	 * @return
	 * @return String
	 */
	protected String saveCalendar(int p_HR_Calendar_ID, JButton[] p_journalButton, JToggleButton[] p_dayButton, JLabel[] p_ColorLabel, String trxName) {
		
		for(int j = 0; j < p_journalButton.length; j++) {
			for(int i = 0; i < p_dayButton.length; i++) { 
				if(p_dayButton[i].getBackground()
						.equals(p_ColorLabel[j].getBackground())) {
					MHRJournalDay journalDay = new MHRJournalDay(Env.getCtx(), 0, trxName);
					//	Set Calendar
					journalDay.setHR_Calendar_ID(p_HR_Calendar_ID);
					//	Set Day
					journalDay.setHR_Day_ID(Integer.parseInt(p_dayButton[i].getName()));
					//	Set Journal
					journalDay.setHR_Journal_ID(Integer.parseInt(p_journalButton[j].getName()));
					//	Save Data
					journalDay.saveEx();
				}
			}
		}
		 return "Save";
	}
}