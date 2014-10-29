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
package org.spin.model;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

import org.compiere.model.Query;
import org.compiere.util.CCache;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Util;
import org.eevolution.model.MHRPayroll;

/**
 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a>
 *
 */
public class MHRJournalDay extends X_HR_JournalDay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 607784731165038969L;

	/**
	 * *** Constructor ***
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 07/10/2014, 10:02:02
	 * @param ctx
	 * @param HR_JournalDay_ID
	 * @param trxName
	 */
	
	private static CCache<String, MHRJournalDay> s_cacheValue = new CCache<String, MHRJournalDay>(Table_Name+"_Value", 10);
	private static CCache<String, MHRJournalDay> s_cache = new CCache<String, MHRJournalDay>(Table_Name, 10);
	public MHRJournalDay(Properties ctx, int HR_JournalDay_ID, String trxName) {
		super(ctx, HR_JournalDay_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public static MHRJournalDay get(Properties ctx, int p_HR_Calendar_ID,int p_HR_Year_ID)
	{
		CLogger s_log=null;
		  // check cache
		String key = "" + p_HR_Calendar_ID + "_" + p_HR_Year_ID;
	    MHRJournalDay retValue = s_cache.get(key);
	    if (retValue != null)
	       return retValue;
	    
	    String sql = "SELECT jd.HR_Day_ID, j.Red, j.Green, j.Blue " +
					 "FROM HR_JournalDay AS jd " +
					 "INNER JOIN HR_Calendar AS c ON(jd.HR_Calendar_ID = c.HR_Calendar_ID) " +
					 "INNER JOIN HR_Journal AS j ON(j.HR_Journal_ID = jd.HR_Journal_ID) " +
					 "INNER JOIN HR_Day AS d ON(d.HR_Day_ID = jd.HR_Day_ID) " +
					 "INNER JOIN C_Year AS y ON(d.C_Year_ID = y.C_Year_ID) " +
					 "WHERE c.HR_Calendar_ID = ? AND y.C_Year_ID = ?";
	    PreparedStatement pstmt = null;
	       try {
	            // Create the prepared statement
	            // Note: when you are querying objects that will be cached it is recommended 
	            //       to query "outside transaction" (trxName=null), 
	            //       That's why this kind of static getters does not have trxName parameter
	            pstmt = DB.prepareStatement (sql, null);
	            // Fill the parameters
	            pstmt.setInt(1, p_HR_Calendar_ID);
	            pstmt.setInt(2, p_HR_Year_ID);
	            // Execute the query
	            final ResultSet rs = pstmt.executeQuery ();
	            // Get the first result if exist
	            if (rs.next()){
	               retValue = new MHRJournalDay(ctx, rs, null);
	            }
	            // To protect the integrity of your cache check if you get more than one result for your query.
	            // This situation should be avoided !
	            // Another quick way to avoid this is using database unique constraints.
	            if (rs.next()) {
	               // TODO: do something here: log a warning, throw an exception, set retValue = null etc
	            }
	            // Don't forget to close the ResultSet and the PreparedStatement
	            rs.close ();
	            pstmt.close ();
	            pstmt = null;
	       } catch (SQLException e) {
	            
				// handle the SQLException
	            s_log.log(Level.SEVERE, sql, e);
	       }
	       // Don't forget to close the PreparedStatement (again!)
	       // This situation happens when an exception was thrown in the previous try/catch block
	       try {
	            if (pstmt != null){
	               pstmt.close ();
	            }
	            pstmt = null;
	       } catch (SQLException e)	{
	            pstmt = null;
	       }
	       
	       // Add the result (if any) to cache
	       if (retValue != null)
	            s_cache.put(key, retValue);
	       
	       // Finally we are returning the resulting MMaterial object
	       return retValue;
	}
	
	/**
	 * *** Constructor ***
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 07/10/2014, 10:02:02
	 * @param ctx
	 * @param rs
	 * @param trxName
	 */
	public MHRJournalDay(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
