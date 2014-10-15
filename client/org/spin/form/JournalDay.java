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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import org.compiere.model.MOrgInfo;
import org.compiere.swing.CComboBox;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;
import org.spin.model.MHRDay;
import org.spin.model.MHRJournal;
import org.spin.model.MHRJournalDay;
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

	protected int 			m_HR_Calendar_ID 		= 0;
	protected int			m_HR_IncidenceGroup_ID  = 0;
	protected int 			m_C_Year_ID				= 0;
	/**	Client				*/
	protected int 			m_AD_Client_ID 			= 0;
	/**	Organization		*/
	protected int 			m_AD_Org_ID 			= 0;
	protected int			m_Year					= 0;
	/** Red Color			*/
	protected int 			m_RColor				= 0;
	/** Green Color			*/
	protected int 			m_GColor				= 0;
	/** Blue Color			*/
	protected int 			m_BColor				= 0;


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
	
	protected Vector<Integer> getDayYear(int p_HR_Year_ID, String trxName){
		Vector<Integer> columnNames = new Vector<Integer>();
		
		
		try	{
			PreparedStatement pstmt = DB.prepareStatement("SELECT fiscalYear, HR_Day_ID  FROM HR_Day, C_Year " +
														  "WHERE HR_Day.C_Year_ID=? and C_Year.C_Year_ID=HR_Day.C_Year_ID", null);
			pstmt.setInt(1, p_HR_Year_ID);
			ResultSet rs = pstmt.executeQuery();
			//
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
	protected boolean getDayColor(int p_HR_day_ID, String trxName){
		boolean result=false;
		try	{
			PreparedStatement pstmt = DB.prepareStatement("SELECT  jd.HR_Day_ID, red, green, blue  FROM HR_JournalDay as jd "+
					"INNER JOIN HR_Calendar as c on(jd.HR_Calendar_ID = c.HR_Calendar_ID) " +
					"INNER JOIN HR_Journal as j on(j.HR_Journal_ID=jd.HR_Journal_ID) " +
					"INNER JOIN HR_Day as d on(d.HR_Day_ID=jd.HR_Day_ID) Where jd.HR_Day_ID=?", null);
			pstmt.setInt(1, p_HR_day_ID);
			ResultSet rs = pstmt.executeQuery();
			//
			
			
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
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 13/10/2014, 15:32:43
	 * @param p_HR_Concept_ID
	 * @param trxName
	 * @return void
	 */
	protected void setRGB(int p_HR_Journal_ID, String trxName){
		m_RColor = getRColor(p_HR_Journal_ID,trxName);
		m_GColor = getGColor(p_HR_Journal_ID,trxName);
		m_BColor = getBColor(p_HR_Journal_ID,trxName);	
	}
	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 13/10/2014, 15:32:37
	 * @param p_HR_Journal_ID
	 * @param trxName
	 * @return
	 * @return int
	 */
	protected int getRColor(int p_HR_Journal_ID, String trxName){
		return DB.getSQLValue(trxName, "SELECT red, HR_Journal_ID " +
				"FROM HR_Journal " +
				"WHERE HR_Journal_ID=?", p_HR_Journal_ID);
	}
	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 13/10/2014, 15:32:32
	 * @param p_HR_Concept_ID
	 * @param trxName
	 * @return
	 * @return int
	 */
	protected int getGColor(int p_HR_Journal_ID, String trxName){
		return DB.getSQLValue(trxName, "SELECT green, HR_Journal_ID " +
				"FROM HR_Journal " +
				"WHERE HR_Journal_ID=?", p_HR_Journal_ID);
	}
	/**
	 * 
	 *@author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 13/10/2014, 15:32:25
	 * @param p_HR_Concept_ID
	 * @param trxName
	 * @return
	 * @return int
	 */
	protected int getBColor(int p_HR_Journal_ID, String trxName){
		return DB.getSQLValue(trxName, "SELECT blue, HR_Journal_ID " +
				"FROM HR_Journal " +
				"WHERE HR_Journal_ID=?", p_HR_Journal_ID);
	}
	protected String saveCalendar(int p_HR_Calendar_ID, JButton[] p_journalButton, JToggleButton[] p_dayButton, String trxName){
		 
		 //	Org Info
		 MOrgInfo orgInfo = null;
		 orgInfo = MOrgInfo.get(Env.getCtx(), m_AD_Org_ID, trxName);
			
		
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
