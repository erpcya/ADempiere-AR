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

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for HR_IncidenceGroup
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS - $Id$ */
public class X_HR_IncidenceGroup extends PO implements I_HR_IncidenceGroup, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140901L;

    /** Standard Constructor */
    public X_HR_IncidenceGroup (Properties ctx, int HR_IncidenceGroup_ID, String trxName)
    {
      super (ctx, HR_IncidenceGroup_ID, trxName);
      /** if (HR_IncidenceGroup_ID == 0)
        {
			setBlue (0);
			setColorType (null);
			setGreen (0);
			setLineDistance (0);
			setLineWidth (0);
			setName (null);
			setRed (0);
			setRepeatDistance (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_IncidenceGroup (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_IncidenceGroup[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Color getAD_Color() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Color)MTable.get(getCtx(), org.compiere.model.I_AD_Color.Table_Name)
			.getPO(getAD_Color_ID(), get_TrxName());	}

	/** Set System Color.
		@param AD_Color_ID 
		Color for backgrounds or indicators
	  */
	public void setAD_Color_ID (int AD_Color_ID)
	{
		if (AD_Color_ID < 1) 
			set_Value (COLUMNNAME_AD_Color_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Color_ID, Integer.valueOf(AD_Color_ID));
	}

	/** Get System Color.
		@return Color for backgrounds or indicators
	  */
	public int getAD_Color_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Color_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Blue.
		@param Blue 
		Color RGB blue value
	  */
	public void setBlue (int Blue)
	{
		set_Value (COLUMNNAME_Blue, Integer.valueOf(Blue));
	}

	/** Get Blue.
		@return Color RGB blue value
	  */
	public int getBlue () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Blue);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set 2nd Blue.
		@param Blue_1 
		RGB value for second color
	  */
	public void setBlue_1 (int Blue_1)
	{
		set_Value (COLUMNNAME_Blue_1, Integer.valueOf(Blue_1));
	}

	/** Get 2nd Blue.
		@return RGB value for second color
	  */
	public int getBlue_1 () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Blue_1);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** ColorType AD_Reference_ID=243 */
	public static final int COLORTYPE_AD_Reference_ID=243;
	/** Normal (Flat) = F */
	public static final String COLORTYPE_NormalFlat = "F";
	/** Gradient = G */
	public static final String COLORTYPE_Gradient = "G";
	/** Line = L */
	public static final String COLORTYPE_Line = "L";
	/** Texture (Picture) = T */
	public static final String COLORTYPE_TexturePicture = "T";
	/** Set Color Type.
		@param ColorType 
		Color presentation for this color
	  */
	public void setColorType (String ColorType)
	{

		set_Value (COLUMNNAME_ColorType, ColorType);
	}

	/** Get Color Type.
		@return Color presentation for this color
	  */
	public String getColorType () 
	{
		return (String)get_Value(COLUMNNAME_ColorType);
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

	/** Set Green.
		@param Green 
		RGB value 
	  */
	public void setGreen (int Green)
	{
		set_Value (COLUMNNAME_Green, Integer.valueOf(Green));
	}

	/** Get Green.
		@return RGB value 
	  */
	public int getGreen () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Green);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set 2nd Green.
		@param Green_1 
		RGB value for second color
	  */
	public void setGreen_1 (int Green_1)
	{
		set_Value (COLUMNNAME_Green_1, Integer.valueOf(Green_1));
	}

	/** Get 2nd Green.
		@return RGB value for second color
	  */
	public int getGreen_1 () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Green_1);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Incidence Group.
		@param HR_IncidenceGroup_ID Incidence Group	  */
	public void setHR_IncidenceGroup_ID (int HR_IncidenceGroup_ID)
	{
		if (HR_IncidenceGroup_ID < 1) 
			set_Value (COLUMNNAME_HR_IncidenceGroup_ID, null);
		else 
			set_Value (COLUMNNAME_HR_IncidenceGroup_ID, Integer.valueOf(HR_IncidenceGroup_ID));
	}

	/** Get Incidence Group.
		@return Incidence Group	  */
	public int getHR_IncidenceGroup_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_IncidenceGroup_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Image Alpha .
		@param ImageAlpha 
		Image Texture Composite Alpha
	  */
	public void setImageAlpha (BigDecimal ImageAlpha)
	{
		set_Value (COLUMNNAME_ImageAlpha, ImageAlpha);
	}

	/** Get Image Alpha .
		@return Image Texture Composite Alpha
	  */
	public BigDecimal getImageAlpha () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ImageAlpha);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Line Distance.
		@param LineDistance 
		Distance between lines
	  */
	public void setLineDistance (int LineDistance)
	{
		set_Value (COLUMNNAME_LineDistance, Integer.valueOf(LineDistance));
	}

	/** Get Line Distance.
		@return Distance between lines
	  */
	public int getLineDistance () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LineDistance);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Line Width.
		@param LineWidth 
		Width of the lines
	  */
	public void setLineWidth (int LineWidth)
	{
		set_Value (COLUMNNAME_LineWidth, Integer.valueOf(LineWidth));
	}

	/** Get Line Width.
		@return Width of the lines
	  */
	public int getLineWidth () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LineWidth);
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

	/** Set Red.
		@param Red 
		RGB value
	  */
	public void setRed (int Red)
	{
		set_Value (COLUMNNAME_Red, Integer.valueOf(Red));
	}

	/** Get Red.
		@return RGB value
	  */
	public int getRed () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Red);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set 2nd Red.
		@param Red_1 
		RGB value for second color
	  */
	public void setRed_1 (int Red_1)
	{
		set_Value (COLUMNNAME_Red_1, Integer.valueOf(Red_1));
	}

	/** Get 2nd Red.
		@return RGB value for second color
	  */
	public int getRed_1 () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Red_1);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Repeat Distance.
		@param RepeatDistance 
		Distance in points to repeat gradient color - or zero
	  */
	public void setRepeatDistance (int RepeatDistance)
	{
		set_Value (COLUMNNAME_RepeatDistance, Integer.valueOf(RepeatDistance));
	}

	/** Get Repeat Distance.
		@return Distance in points to repeat gradient color - or zero
	  */
	public int getRepeatDistance () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_RepeatDistance);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** StartPoint AD_Reference_ID=248 */
	public static final int STARTPOINT_AD_Reference_ID=248;
	/** North = 1 */
	public static final String STARTPOINT_North = "1";
	/** North East = 2 */
	public static final String STARTPOINT_NorthEast = "2";
	/** East = 3 */
	public static final String STARTPOINT_East = "3";
	/** South East = 4 */
	public static final String STARTPOINT_SouthEast = "4";
	/** South = 5 */
	public static final String STARTPOINT_South = "5";
	/** South West = 6 */
	public static final String STARTPOINT_SouthWest = "6";
	/** West = 7 */
	public static final String STARTPOINT_West = "7";
	/** North West = 8 */
	public static final String STARTPOINT_NorthWest = "8";
	/** Set Start Point.
		@param StartPoint 
		Start point of the gradient colors
	  */
	public void setStartPoint (String StartPoint)
	{

		set_Value (COLUMNNAME_StartPoint, StartPoint);
	}

	/** Get Start Point.
		@return Start point of the gradient colors
	  */
	public String getStartPoint () 
	{
		return (String)get_Value(COLUMNNAME_StartPoint);
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