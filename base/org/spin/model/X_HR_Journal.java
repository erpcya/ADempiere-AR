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
import org.compiere.util.KeyNamePair;

/** Generated Model for HR_Journal
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS - $Id$ */
public class X_HR_Journal extends PO implements I_HR_Journal, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140929L;

    /** Standard Constructor */
    public X_HR_Journal (Properties ctx, int HR_Journal_ID, String trxName)
    {
      super (ctx, HR_Journal_ID, trxName);
      /** if (HR_Journal_ID == 0)
        {
			setEndTime (new Timestamp( System.currentTimeMillis() ));
			setName (null);
			setStartTime (new Timestamp( System.currentTimeMillis() ));
			setTimeSlotEnd (new Timestamp( System.currentTimeMillis() ));
			setTimeSlotStart (new Timestamp( System.currentTimeMillis() ));
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_Journal (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_Journal[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set End Time.
		@param EndTime 
		End of the time span
	  */
	public void setEndTime (Timestamp EndTime)
	{
		set_Value (COLUMNNAME_EndTime, EndTime);
	}

	/** Get End Time.
		@return End of the time span
	  */
	public Timestamp getEndTime () 
	{
		return (Timestamp)get_Value(COLUMNNAME_EndTime);
	}

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

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set Start Time.
		@param StartTime 
		Time started
	  */
	public void setStartTime (Timestamp StartTime)
	{
		set_Value (COLUMNNAME_StartTime, StartTime);
	}

	/** Get Start Time.
		@return Time started
	  */
	public Timestamp getStartTime () 
	{
		return (Timestamp)get_Value(COLUMNNAME_StartTime);
	}

	/** Set Slot End.
		@param TimeSlotEnd 
		Time when timeslot ends
	  */
	public void setTimeSlotEnd (Timestamp TimeSlotEnd)
	{
		set_Value (COLUMNNAME_TimeSlotEnd, TimeSlotEnd);
	}

	/** Get Slot End.
		@return Time when timeslot ends
	  */
	public Timestamp getTimeSlotEnd () 
	{
		return (Timestamp)get_Value(COLUMNNAME_TimeSlotEnd);
	}

	/** Set Slot Start.
		@param TimeSlotStart 
		Time when timeslot starts
	  */
	public void setTimeSlotStart (Timestamp TimeSlotStart)
	{
		set_Value (COLUMNNAME_TimeSlotStart, TimeSlotStart);
	}

	/** Get Slot Start.
		@return Time when timeslot starts
	  */
	public Timestamp getTimeSlotStart () 
	{
		return (Timestamp)get_Value(COLUMNNAME_TimeSlotStart);
	}

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getValue());
    }
}