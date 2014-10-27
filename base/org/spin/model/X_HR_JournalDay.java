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
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for HR_JournalDay
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS - $Id$ */
public class X_HR_JournalDay extends PO implements I_HR_JournalDay, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20141021L;

    /** Standard Constructor */
    public X_HR_JournalDay (Properties ctx, int HR_JournalDay_ID, String trxName)
    {
      super (ctx, HR_JournalDay_ID, trxName);
      /** if (HR_JournalDay_ID == 0)
        {
			setHR_Calendar_ID (0);
			setHR_Day_ID (0);
			setHR_Journal_ID (0);
        } */
    }

    /** Load Constructor */
    public X_HR_JournalDay (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_JournalDay[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.spin.model.I_HR_Calendar getHR_Calendar() throws RuntimeException
    {
		return (org.spin.model.I_HR_Calendar)MTable.get(getCtx(), org.spin.model.I_HR_Calendar.Table_Name)
			.getPO(getHR_Calendar_ID(), get_TrxName());	}

	/** Set Calendar.
		@param HR_Calendar_ID Calendar	  */
	public void setHR_Calendar_ID (int HR_Calendar_ID)
	{
		if (HR_Calendar_ID < 1) 
			set_Value (COLUMNNAME_HR_Calendar_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Calendar_ID, Integer.valueOf(HR_Calendar_ID));
	}

	/** Get Calendar.
		@return Calendar	  */
	public int getHR_Calendar_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Calendar_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.spin.model.I_HR_Day getHR_Day() throws RuntimeException
    {
		return (org.spin.model.I_HR_Day)MTable.get(getCtx(), org.spin.model.I_HR_Day.Table_Name)
			.getPO(getHR_Day_ID(), get_TrxName());	}

	/** Set Day.
		@param HR_Day_ID 
		Day
	  */
	public void setHR_Day_ID (int HR_Day_ID)
	{
		if (HR_Day_ID < 1) 
			set_Value (COLUMNNAME_HR_Day_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Day_ID, Integer.valueOf(HR_Day_ID));
	}

	/** Get Day.
		@return Day
	  */
	public int getHR_Day_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Day_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.spin.model.I_HR_Journal getHR_Journal() throws RuntimeException
    {
		return (org.spin.model.I_HR_Journal)MTable.get(getCtx(), org.spin.model.I_HR_Journal.Table_Name)
			.getPO(getHR_Journal_ID(), get_TrxName());	}

	/** Set Journal.
		@param HR_Journal_ID Journal	  */
	public void setHR_Journal_ID (int HR_Journal_ID)
	{
		if (HR_Journal_ID < 1) 
			set_Value (COLUMNNAME_HR_Journal_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Journal_ID, Integer.valueOf(HR_Journal_ID));
	}

	/** Get Journal.
		@return Journal	  */
	public int getHR_Journal_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Journal_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}