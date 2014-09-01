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

/** Generated Model for HR_IGConcept
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS - $Id$ */
public class X_HR_IGConcept extends PO implements I_HR_IGConcept, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140901L;

    /** Standard Constructor */
    public X_HR_IGConcept (Properties ctx, int HR_IGConcept_ID, String trxName)
    {
      super (ctx, HR_IGConcept_ID, trxName);
      /** if (HR_IGConcept_ID == 0)
        {
			setHR_Concept_ID (0);
        } */
    }

    /** Load Constructor */
    public X_HR_IGConcept (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_HR_IGConcept[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.eevolution.model.I_HR_Concept getHR_Concept() throws RuntimeException
    {
		return (org.eevolution.model.I_HR_Concept)MTable.get(getCtx(), org.eevolution.model.I_HR_Concept.Table_Name)
			.getPO(getHR_Concept_ID(), get_TrxName());	}

	/** Set Payroll Concept.
		@param HR_Concept_ID Payroll Concept	  */
	public void setHR_Concept_ID (int HR_Concept_ID)
	{
		if (HR_Concept_ID < 1) 
			set_Value (COLUMNNAME_HR_Concept_ID, null);
		else 
			set_Value (COLUMNNAME_HR_Concept_ID, Integer.valueOf(HR_Concept_ID));
	}

	/** Get Payroll Concept.
		@return Payroll Concept	  */
	public int getHR_Concept_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Concept_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.spin.model.I_HR_IncidenceGroup getHR_IncidenceGroup() throws RuntimeException
    {
		return (org.spin.model.I_HR_IncidenceGroup)MTable.get(getCtx(), org.spin.model.I_HR_IncidenceGroup.Table_Name)
			.getPO(getHR_IncidenceGroup_ID(), get_TrxName());	}

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
}