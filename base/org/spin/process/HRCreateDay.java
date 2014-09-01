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
package org.spin.process;

import java.sql.Timestamp;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MYear;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.TimeUtil;
import org.spin.model.I_HR_Day;
import org.spin.model.MHRDay;
/**
 * @author <a href="mailto:raulmunozn@gmail.com">Raul Muñoz</a>
 *
 */
public class HRCreateDay extends SvrProcess {

	/**		Year 					*/
	private int		p_C_Year_ID = 0; 
	

	@Override
	protected void prepare() {
		for (ProcessInfoParameter para : getParameter()) {
			String name = para.getParameterName();
			if (para.getParameter() == null)
				;			
			else if(name.equals("C_Year_ID"))
				p_C_Year_ID = para.getParameterAsInt();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
	}
	@Override
	protected String doIt() throws Exception {
		int count=0;
		// Validate Year
		if(p_C_Year_ID == 0)
			throw new AdempiereException("@C_Year_ID@ @NotFound@");
		//	Get Year
		MYear m_Year = new MYear(getCtx(), p_C_Year_ID, get_TrxName()); 
		//	Process Year
		int year = m_Year.getYearAsInt();
		Timestamp m_StartDate = TimeUtil.getDay(year, 1, 1);
		Timestamp m_EndDate = TimeUtil.getDay(year + 1, 1, 1);
		//	Delete old Inserted
		int deleted = DB.executeUpdateEx("DELETE FROM " + I_HR_Day.Table_Name + 
				" WHERE " + I_HR_Day.COLUMNNAME_C_Year_ID + 
				" = " + p_C_Year_ID, get_TrxName());
		//	Create new day
		do {
			// 	Get Day
			MHRDay Day = new MHRDay(getCtx(), 0, get_TrxName());
			Day.setC_Year_ID(p_C_Year_ID);
			Day.setDate1(m_StartDate);
			Day.saveEx();
			m_StartDate = TimeUtil.addDays(m_StartDate, 1);
			count++;
		}while(m_StartDate.before(m_EndDate));
		//	Return
		return "@Deleted@ = " + deleted + " @Created@ = "+count;
	}

}
