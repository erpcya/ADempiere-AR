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

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.util.CCache;

/**
 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a>
 *
 */
public class MHRJournalDay extends X_HR_JournalDay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 607784731165038969L;
	private static CCache<String, MHRJournalDay> s_cache = new CCache<String, MHRJournalDay>(Table_Name, 10);
	/**
	 * *** Constructor ***
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 07/10/2014, 10:02:02
	 * @param ctx
	 * @param HR_JournalDay_ID
	 * @param trxName
	 */
	
	
	public MHRJournalDay(Properties ctx, int HR_JournalDay_ID, String trxName) {
		super(ctx, HR_JournalDay_ID, trxName);
		
	}
	/**
	 * Get JournalDay by ID
	 * @param ctx
	 * @param p_HR_Calendar_ID
	 * @return p_HR_Journal_ID
	 */
	public static MHRJournalDay get(Properties ctx, int p_HR_Calendar_ID, int p_HR_Journal_ID) {
		String key = p_HR_Calendar_ID+"_"+p_HR_Journal_ID;
		
		MHRJournalDay journalDay = s_cache.get(key);
		if (journalDay != null)
			return journalDay;
		
		journalDay = new MHRJournalDay(ctx, p_HR_Calendar_ID, null);
		if (journalDay.getHR_Calendar_ID() == p_HR_Calendar_ID) {
			s_cache.put(key, journalDay);
		}
		else {
			journalDay = null;
		}
		return journalDay;
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
