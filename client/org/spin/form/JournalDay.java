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
	protected int 			m_C_Year_ID				=0;
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
	
	
	protected Vector<Timestamp> getDayYear(int p_HR_Year_ID, String trxName){
		Vector<Timestamp> columnNames = new Vector<Timestamp>();
		
		
		try	{
			PreparedStatement pstmt = DB.prepareStatement("SELECT HR_Day_ID, Date1  FROM HR_Day " +
														  "WHERE C_Year_ID=?", null);
			pstmt.setInt(1, p_HR_Year_ID);
			ResultSet rs = pstmt.executeQuery();
			//
			while (rs.next()) {
				columnNames.add(rs.getTimestamp(2));
				
			}
			DB.close(rs, pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return columnNames;
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
	
	protected String generateJournalDay(JPanel[] slider, JButton[] hours, String trxName){
		 
		 //	Org Info
		 MOrgInfo orgInfo = null;
		 orgInfo = MOrgInfo.get(Env.getCtx(), m_AD_Org_ID, trxName);
			
		 MHRJournalLine journalLine = new MHRJournalLine(Env.getCtx(), 0, trxName);
		 journalLine.setAD_Org_ID(m_AD_Org_ID);
		
		 	journalLine.setHR_Journal_ID(m_HR_Calendar_ID);
			for(int i = 0; i<m_HR_Concept_ID.size(); i++){
				journalLine.setHR_Concept_ID(m_HR_Concept_ID.get(i));
				for(int j = 0; j<slider[i].getComponentCount(); j++){
					for(int x = 0; x<hours.length; x++){
						if(slider[i].getComponent(j).getName().equals(hours[x].getName())){
							journalLine.setStartTime(m_StartHour.get(x));
							journalLine.setEndTime(m_EndHour.get(x));
							journalLine.saveEx();
						}
					}
				}
			}
			
		 return "Save";
	}
	
}
