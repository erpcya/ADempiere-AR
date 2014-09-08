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
import java.util.ArrayList;
import java.util.logging.Level;

import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.KeyNamePair;

/**
 * 
 * @author victor.perez@e-evolution.com, www.e-evolution.com
 *
 */
public class JournalDay 
{

	/**	Window No			*/
	public int         		m_WindowNo = 0;

	/**	Logger			*/
	public static CLogger log = CLogger.getCLogger(JournalDay.class);
	/**	Export Class for Bank Account	*/
	public String			m_PaymentExportClassHR = null;
	
	protected ArrayList<KeyNamePair> getIncidenceData(String trxName){
		String sql = "SELECT HR_IncidenceGroup_ID, Name from HR_IncidenceGroup";
		return getData(sql, trxName);
	}
	 
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
