//+======================================================================
// $Source$
//
// Project:   Tango
//
// Description:  java source code for the TANGO client/server API.
//
// $Author: pascal_verdier $
//
// Copyright (C) :      2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,
//						European Synchrotron Radiation Facility
//                      BP 220, Grenoble 38043
//                      FRANCE
//
// This file is part of Tango.
//
// Tango is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
// 
// Tango is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public License
// along with Tango.  If not, see <http://www.gnu.org/licenses/>.
//
// $Revision: 25297 $
//
//-======================================================================


package fr.esrf.TangoDs;

import fr.esrf.Tango.DevFailed;
import org.omg.CORBA.Any;

 
public class SetTraceOutputCmd extends Command implements TangoConst
{
	
//+-------------------------------------------------------------------------
//
// method : 		SetTraceOutputCmd 
// 
// description : 	constructor for Command class SetTraceOutput
//
//--------------------------------------------------------------------------

 
	public SetTraceOutputCmd(String name,int in,int out,String desc)
	{
		super(name,in,out);
		set_in_type_desc(desc);
	}

//+-------------------------------------------------------------------------
//
// method : 		execute 
// 
// description : 	Change the trace output
//
//--------------------------------------------------------------------------
 
	public Any execute(DeviceImpl device,Any in_any) throws DevFailed
	{
		Util.out4.println("SetTraceOutputCmd.execute(): arrived");

    String desc = "SetTraceOutput is no more supported, please use SetLoggingTarget";
    Except.throw_exception("API_DeprecatedCommand", desc, "SetTraceOutputCmd::execute");

    //- make compiler happy
		return Util.return_empty_any("SetTraceOutput");
	}
}
