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
public class MHRJournal extends X_HR_Journal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3794324445051833477L;
	private static CCache<String, MHRJournal> s_cache = new CCache<String, MHRJournal>(Table_Name, 10);
	
	/**
	 * *** Constructor ***
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 29/09/2014, 15:19:29
	 * @param ctx
	 * @param HR_Journal_ID
	 * @param trxName
	 */
	public MHRJournal(Properties ctx, int HR_Journal_ID, String trxName) {
		super(ctx, HR_Journal_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Get Journal by ID
	 * @param ctx
	 * @param HR_Payroll_ID
	 * @return payroll
	 */
	public static MHRJournal get(Properties ctx, int p_HR_Journal_ID) {
		String key =""+p_HR_Journal_ID;
		
		MHRJournal journal = s_cache.get(key);
		if (journal != null)
			return journal;
		//
		journal = new MHRJournal(ctx, p_HR_Journal_ID, null);
		if (journal.get_ID() == p_HR_Journal_ID) {
			s_cache.put(key, journal);
		}
		else {
			journal = null;
		}
		return journal;
	}
	/**
	 * *** Constructor ***
	 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a> 29/09/2014, 15:19:29
	 * @param ctx
	 * @param rs
	 * @param trxName
	 */
	public MHRJournal(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
