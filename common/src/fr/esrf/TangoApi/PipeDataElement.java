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
// $Revision: 25296 $
//
//-======================================================================
package fr.esrf.TangoApi;

import fr.esrf.Tango.*;
import fr.esrf.TangoDs.Except;
import fr.esrf.TangoDs.TangoConst;

/**
 * This class defined an elementary element of a pipe blob.
 */

public class  PipeDataElement{
    private DevPipeDataElt element;
    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param element  data element IDL object
     */
    // ===================================================================
    public PipeDataElement(DevPipeDataElt element) {
        this.element = element;
    }
    // ===================================================================
    /**
     * Create the PipeDataElement 
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, boolean value) {
        this(name, new boolean[]{value});
    }
    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, boolean[] value) {
        AttrValUnion    attrValUnion = new AttrValUnion();
        attrValUnion.bool_att_value(value);
        this.element = new DevPipeDataElt(name, attrValUnion, new DevPipeDataElt[0], "");
    }

    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, short value) {
        this(name, new short[]{value}, false);
    }
    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, short[] value) {
        this(name, value, false);
    }
    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     * @param asUChar  insert data as unsigned char if true as short if false
     */
    // ===================================================================
    public PipeDataElement(String name, short[] value, boolean asUChar) {
        AttrValUnion    attrValUnion = new AttrValUnion();
        if (asUChar) {
            final byte[] unsigned = new byte[value.length];
            for (int i = 0; i < value.length; i++) {
                unsigned[i] = (byte) (value[i] & 0xFF);
            }
            attrValUnion.uchar_att_value(unsigned); //  as unsigned char
        }
        else
            attrValUnion.short_att_value(value); // as short
        this.element = new DevPipeDataElt(name, attrValUnion, new DevPipeDataElt[0], "");
    }

    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, int value) {
        this(name, new int[]{value}, false);
    }
    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, int[] value) {
        this(name, value, false);
    }
    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     * @param asUShort  insert data as unsigned short if true as int (DevLong) if false
     */
    // ===================================================================
    public PipeDataElement(String name, int[] value, boolean asUShort) {
        AttrValUnion    attrValUnion = new AttrValUnion();
        if (asUShort) {
            final short[] unsigned = new short[value.length];
            for (int i = 0; i < value.length; i++) {
                unsigned[i] = (short) (value[i] & 0xFFFF);
            }
            attrValUnion.ushort_att_value(unsigned); //  as unsigned char
        }
        else
            attrValUnion.long_att_value(value); // as short
        this.element = new DevPipeDataElt(name, attrValUnion, new DevPipeDataElt[0], "");
    }

    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, long value) {
        this(name, new long[]{value}, false);
    }
    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, long[] value) {
        this(name, value, false);
    }
    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     * @param asULong  insert data as unsigned int if true as long (DevLong64) if false
     */
    // ===================================================================
    public PipeDataElement(String name, long[]value, boolean asULong) {
        AttrValUnion    attrValUnion = new AttrValUnion();
        if (asULong) {
            final int[] unsigned = new int[value.length];
            for (int i = 0; i < value.length; i++) {
                unsigned[i] = (int) value[i];
            }
            attrValUnion.ulong_att_value(unsigned); //  as unsigned char
        }
        else
            attrValUnion.long64_att_value(value); // as short
        this.element = new DevPipeDataElt(name, attrValUnion, new DevPipeDataElt[0], "");
    }

    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, float value) {
        this(name, new float[]{value});
    }
    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, float[] value) {
        AttrValUnion    attrValUnion = new AttrValUnion();
        attrValUnion.float_att_value(value);
        this.element = new DevPipeDataElt(name, attrValUnion, new DevPipeDataElt[0], "");
    }

    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, double value) {
        this(name, new double[]{value});
    }
    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, double [] value) {
        AttrValUnion    attrValUnion = new AttrValUnion();
        attrValUnion.double_att_value(value);
        this.element = new DevPipeDataElt(name, attrValUnion, new DevPipeDataElt[0], "");
    }

    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, String value) {
        this(name, new String[]{value});
    }
    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, String[] value) {
        AttrValUnion    attrValUnion = new AttrValUnion();
        attrValUnion.string_att_value(value);
        this.element = new DevPipeDataElt(name, attrValUnion, new DevPipeDataElt[0], "");
    }
    // ===================================================================
    // ===================================================================

    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, DevState value) {
        this(name, new DevState[]{value});
    }
    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, DevState[] value) {
        AttrValUnion    attrValUnion = new AttrValUnion();
        attrValUnion.state_att_value(value);
        this.element = new DevPipeDataElt(name, attrValUnion, new DevPipeDataElt[0], "");
    }

    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, DevEncoded value) {
        this(name, new DevEncoded[]{value});
    }
    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param value    data element value
     */
    // ===================================================================
    public PipeDataElement(String name, DevEncoded[] value) {
        AttrValUnion    attrValUnion = new AttrValUnion();
        attrValUnion.encoded_att_value(value);
        this.element = new DevPipeDataElt(name, attrValUnion, new DevPipeDataElt[0], "");
    }
    // ===================================================================
    // ===================================================================

    // ===================================================================
    /**
     * Create the PipeDataElement
     * @param name     data element name
     * @param pipeBlob data element value
     */
    // ===================================================================
    public PipeDataElement(String name, PipeBlob pipeBlob) {

        AttrValUnion    attrValUnion = new AttrValUnion();
        attrValUnion.union_no_data(true);
        this.element = new DevPipeDataElt(name,
                attrValUnion,
                pipeBlob.getDevPipeBlobObject().blob_data,
                pipeBlob.getDevPipeBlobObject().name);
    }
    // ===================================================================
    // ===================================================================



    // ===================================================================
    /*
     *  Miscellaneous getters
     */
    // ===================================================================

    // ===================================================================
    /**
     * @return the name of data element at index
     */
    // ===================================================================
    public String getName(){
        return element.name;
    }
    // ===================================================================
    /**
     * @return type of data element at specified index.
     */
    // ===================================================================
    public int getType() throws DevFailed {
        return getType(element);
    }
    // ===================================================================
    // ===================================================================
    DevPipeDataElt getDevPipeDataEltObject() {
        return element;
    }
    // ===================================================================
    // ===================================================================





    
    // ===================================================================
    /*
     *  Extract methods
     */
    // ===================================================================

    // ===========================================
    /**
     * extract method for a boolean Array.
     *
     * @return the extracted value.
     */
    // ===========================================
    public boolean[] extractBooleanArray() {
        return element.value.bool_att_value();
    }
    // ===========================================
    /**
     * extract method for an unsigned char Array.
     *
     * @return the extracted value.
     */
    // ===========================================
    public short[] extractUCharArray() {
        final byte[] argOut = element.value.uchar_att_value();
        final short[] val = new short[argOut.length];
        final short mask = 0xFF;
        for (int i = 0; i < argOut.length; i++) {
            val[i] = (short) (mask & argOut[i]);
        }
        return val;
    }
    // ===========================================
    /**
     * extract method for an unsigned char Array as a char array.
     *
     * @return the extracted value.
     */
    // ===========================================
    public byte[] extractCharArray() {
        return element.value.uchar_att_value();
    }
    // ===========================================
    /**
     * extract method for a short Array.
     *
     * @return the extracted value.
     */
    // ===========================================
    public short[] extractShortArray() {
        return element.value.short_att_value();
    }
    // ===========================================
    /**
     * extract method for an unsigned short Array.
     *
     * @return the extracted value.
     */
    // ===========================================
    public int[] extractUShortArray() {
        final short[] argOut = element.value.ushort_att_value();
        final int[] val = new int[argOut.length];
        for (int i = 0; i < argOut.length; i++) {
            val[i] = 0xFFFF & argOut[i];
        }
        return val;
    }
    // ===========================================
    /**
     * extract method for a long Array.
     *
     * @return the extracted value.
     */
    // ===========================================
    public int[] extractLongArray() {
        return element.value.long_att_value();
    }
    // ===========================================
    /**
     * extract method for a unsigned long.array
     *
     * @return the extracted value.
     */
    // ===========================================
    public long[] extractULongArray() {
        final int[] array = element.value.ulong_att_value();
        long mask = 0x7fffffff;
        mask += (long) 1 << 31;
        final long[] result = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = mask & array[i];
        }
        return result;
    }
    // ===========================================
    /**
     * extract method for a long Array.
     *
     * @return the extracted value.
     */
    // ===========================================
    public long[] extractLong64Array() {
        return element.value.long64_att_value();
    }
    // ===========================================
    /**
     * extract method for a long Array.
     *
     * @return the extracted value.
     */
    // ===========================================
    public long[] extractULong64Array() {
        return element.value.ulong64_att_value();
    }
    // ===========================================
    /**
     * extract method for a float Array.
     *
     * @return the extracted value.
     */
    // ===========================================
    public float[] extractFloatArray() {
        return element.value.float_att_value();
    }
    // ===========================================
    /**
     * extract method for a double Array.
     *
     * @return the extracted value.
     */
    // ===========================================
    public double[] extractDoubleArray() {
        return element.value.double_att_value();
    }
    // ===========================================
    /**
     * extract method for a double Array.
     *
     * @return the extracted value.
     */
    // ===========================================
    public String[] extractStringArray() {
        return element.value.string_att_value();
    }
    // ===========================================
    /**
     * extract method for an DevState Array.
     *
     * @return the extracted value.
     */
    // ===========================================
    public DevState[] extractDevStateArray() throws DevFailed {
        return element.value.state_att_value();
    }
    // ===========================================
    /**
     * extract method for a DevEncoded[]
     *
     * @return the extracted value.
     */
    // ===========================================
    public DevEncoded[] extractDevEncodedArray() {
        return element.value.encoded_att_value();
    }
    // ===================================================================
    // ===================================================================
    public PipeBlob extractPipeBlob() {
        return new PipeBlob(element.inner_blob_name, element.inner_blob);
    }
    // ===================================================================
    // ===================================================================





    // ===================================================================
    // ===================================================================
    private static int getType(DevPipeDataElt element) throws DevFailed {
        int type = -1;
        try {
            //  Check if contains a inner blob
            if (element.inner_blob!=null && element.inner_blob.length>0) {
                return TangoConst.Tango_DEV_PIPE_BLOB;
            }

            //  Else check type from union
            int unionType = element.value.discriminator().value();
            switch (unionType) {
                case AttributeDataType._ATT_BOOL:
                    type = TangoConst.Tango_DEV_BOOLEAN;
                    break;
                case AttributeDataType._ATT_SHORT:
                    type = TangoConst.Tango_DEV_SHORT;
                    break;
                case AttributeDataType._ATT_LONG:
                    type = TangoConst.Tango_DEV_LONG;
                    break;
                case AttributeDataType._ATT_LONG64:
                    type = TangoConst.Tango_DEV_LONG64;
                    break;
                case AttributeDataType._ATT_FLOAT:
                    type = TangoConst.Tango_DEV_FLOAT;
                    break;
                case AttributeDataType._ATT_DOUBLE:
                    type = TangoConst.Tango_DEV_DOUBLE;
                    break;
                case AttributeDataType._ATT_UCHAR:
                    type = TangoConst.Tango_DEV_UCHAR;
                    break;
                case AttributeDataType._ATT_USHORT:
                    type = TangoConst.Tango_DEV_USHORT;
                    break;
                case AttributeDataType._ATT_ULONG:
                    type = TangoConst.Tango_DEV_ULONG;
                    break;
                case AttributeDataType._ATT_ULONG64:
                    type = TangoConst.Tango_DEV_ULONG64;
                    break;
                case AttributeDataType._ATT_STRING:
                    type = TangoConst.Tango_DEV_STRING;
                    break;
                case AttributeDataType._DEVICE_STATE:
                case AttributeDataType._ATT_STATE:
                    type = TangoConst.Tango_DEV_STATE;
                    break;
                case AttributeDataType._ATT_ENCODED:
                    type = TangoConst.Tango_DEV_ENCODED;
                    break;
                case AttributeDataType._ATT_NO_DATA:
                    type = TangoConst.Tango_DEV_VOID;
                    break;

                default:
                    Except.throw_exception("AttributeTypeNotSupported",
                            "Attribute Type (" + unionType + ") Not Supported");
            }
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            Except.throw_exception("Api_TypeCodePackage.BadKind", "Bad or unknown type ");
        }
        return type;
    }
    // ===================================================================
    // ===================================================================
}