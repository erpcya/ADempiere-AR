/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2007 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.spin.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for HR_AttendanceRecord
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS - $Id$ */
public class X_HR_AttendanceRecord extends PO implements I_HR_AttendanceRecord, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20141014L;

    /** Standard Constructor */
    public X_HR_AttendanceRecord (Properties ctx, int HR_AttendanceRecord_ID, String trxName)
    {
      super (ctx, HR_AttendanceRecord_ID, trxName);
      /** if (HR_AttendanceRecord_ID == 0)
        {
			setHR_Employee_ID (0);
			setT_DateTime (new Timestamp( System.currentTimeMillis() ));
        } */
    }

    /** Load Constructor */
    public X_HR_AttendanceRecord (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_HR_AttendanceRecord[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Attendance Record.
		@param HR_AttendanceRecord_ID Attendance Record	  */
	public void setHR_AttendanceRecord_ID (int HR_AttendanceRecord_ID)
	{
		if (HR_AttendanceRecord_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_AttendanceRecord_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_AttendanceRecord_ID, Integer.valueOf(HR_AttendanceRecord_ID));
	}

	/** Get Attendance Record.
		@return Attendance Record	  */
	public int getHR_AttendanceRecord_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_AttendanceRecord_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.eevolution.model.I_HR_Employee getHR_Employee() throws RuntimeException
    {
		return (org.eevolution.model.I_HR_Employee)MTable.get(getCtx(), org.eevolution.model.I_HR_Employee.Table_Name)
			.getPO(getHR_Employee_ID(), get_TrxName());	}

	/** Set Payroll Employee.
		@param HR_Employee_ID Payroll Employee	  */
	public void setHR_Employee_ID (int HR_Employee_ID)
	{
		if (HR_Employee_ID < 1) 
			set_Value (COLUMNNAME_HR_Employee_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Employee_ID, Integer.valueOf(HR_Employee_ID));
	}

	/** Get Payroll Employee.
		@return Payroll Employee	  */
	public int getHR_Employee_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Employee_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set DateTime.
		@param T_DateTime DateTime	  */
	public void setT_DateTime (Timestamp T_DateTime)
	{
		set_Value (COLUMNNAME_T_DateTime, T_DateTime);
	}

	/** Get DateTime.
		@return DateTime	  */
	public Timestamp getT_DateTime () 
	{
		return (Timestamp)get_Value(COLUMNNAME_T_DateTime);
	}
}