/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package thrift.cmd;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallResult implements org.apache.thrift.TBase<CallResult, CallResult._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CallResult");

  private static final org.apache.thrift.protocol.TField RETURN_INFO_FIELD_DESC = new org.apache.thrift.protocol.TField("returnInfo", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField RETURN_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("returnCode", org.apache.thrift.protocol.TType.I32, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CallResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CallResultTupleSchemeFactory());
  }

  public String returnInfo; // required
  public int returnCode; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RETURN_INFO((short)1, "returnInfo"),
    RETURN_CODE((short)2, "returnCode");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // RETURN_INFO
          return RETURN_INFO;
        case 2: // RETURN_CODE
          return RETURN_CODE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __RETURNCODE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RETURN_INFO, new org.apache.thrift.meta_data.FieldMetaData("returnInfo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.RETURN_CODE, new org.apache.thrift.meta_data.FieldMetaData("returnCode", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CallResult.class, metaDataMap);
  }

  public CallResult() {
  }

  public CallResult(
    String returnInfo,
    int returnCode)
  {
    this();
    this.returnInfo = returnInfo;
    this.returnCode = returnCode;
    setReturnCodeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CallResult(CallResult other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetReturnInfo()) {
      this.returnInfo = other.returnInfo;
    }
    this.returnCode = other.returnCode;
  }

  public CallResult deepCopy() {
    return new CallResult(this);
  }

  @Override
  public void clear() {
    this.returnInfo = null;
    setReturnCodeIsSet(false);
    this.returnCode = 0;
  }

  public String getReturnInfo() {
    return this.returnInfo;
  }

  public CallResult setReturnInfo(String returnInfo) {
    this.returnInfo = returnInfo;
    return this;
  }

  public void unsetReturnInfo() {
    this.returnInfo = null;
  }

  /** Returns true if field returnInfo is set (has been assigned a value) and false otherwise */
  public boolean isSetReturnInfo() {
    return this.returnInfo != null;
  }

  public void setReturnInfoIsSet(boolean value) {
    if (!value) {
      this.returnInfo = null;
    }
  }

  public int getReturnCode() {
    return this.returnCode;
  }

  public CallResult setReturnCode(int returnCode) {
    this.returnCode = returnCode;
    setReturnCodeIsSet(true);
    return this;
  }

  public void unsetReturnCode() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __RETURNCODE_ISSET_ID);
  }

  /** Returns true if field returnCode is set (has been assigned a value) and false otherwise */
  public boolean isSetReturnCode() {
    return EncodingUtils.testBit(__isset_bitfield, __RETURNCODE_ISSET_ID);
  }

  public void setReturnCodeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __RETURNCODE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RETURN_INFO:
      if (value == null) {
        unsetReturnInfo();
      } else {
        setReturnInfo((String)value);
      }
      break;

    case RETURN_CODE:
      if (value == null) {
        unsetReturnCode();
      } else {
        setReturnCode((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RETURN_INFO:
      return getReturnInfo();

    case RETURN_CODE:
      return Integer.valueOf(getReturnCode());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RETURN_INFO:
      return isSetReturnInfo();
    case RETURN_CODE:
      return isSetReturnCode();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CallResult)
      return this.equals((CallResult)that);
    return false;
  }

  public boolean equals(CallResult that) {
    if (that == null)
      return false;

    boolean this_present_returnInfo = true && this.isSetReturnInfo();
    boolean that_present_returnInfo = true && that.isSetReturnInfo();
    if (this_present_returnInfo || that_present_returnInfo) {
      if (!(this_present_returnInfo && that_present_returnInfo))
        return false;
      if (!this.returnInfo.equals(that.returnInfo))
        return false;
    }

    boolean this_present_returnCode = true;
    boolean that_present_returnCode = true;
    if (this_present_returnCode || that_present_returnCode) {
      if (!(this_present_returnCode && that_present_returnCode))
        return false;
      if (this.returnCode != that.returnCode)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(CallResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    CallResult typedOther = (CallResult)other;

    lastComparison = Boolean.valueOf(isSetReturnInfo()).compareTo(typedOther.isSetReturnInfo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReturnInfo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.returnInfo, typedOther.returnInfo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetReturnCode()).compareTo(typedOther.isSetReturnCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReturnCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.returnCode, typedOther.returnCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("CallResult(");
    boolean first = true;

    sb.append("returnInfo:");
    if (this.returnInfo == null) {
      sb.append("null");
    } else {
      sb.append(this.returnInfo);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("returnCode:");
    sb.append(this.returnCode);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class CallResultStandardSchemeFactory implements SchemeFactory {
    public CallResultStandardScheme getScheme() {
      return new CallResultStandardScheme();
    }
  }

  private static class CallResultStandardScheme extends StandardScheme<CallResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CallResult struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RETURN_INFO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.returnInfo = iprot.readString();
              struct.setReturnInfoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // RETURN_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.returnCode = iprot.readI32();
              struct.setReturnCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, CallResult struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.returnInfo != null) {
        oprot.writeFieldBegin(RETURN_INFO_FIELD_DESC);
        oprot.writeString(struct.returnInfo);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(RETURN_CODE_FIELD_DESC);
      oprot.writeI32(struct.returnCode);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CallResultTupleSchemeFactory implements SchemeFactory {
    public CallResultTupleScheme getScheme() {
      return new CallResultTupleScheme();
    }
  }

  private static class CallResultTupleScheme extends TupleScheme<CallResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CallResult struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetReturnInfo()) {
        optionals.set(0);
      }
      if (struct.isSetReturnCode()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetReturnInfo()) {
        oprot.writeString(struct.returnInfo);
      }
      if (struct.isSetReturnCode()) {
        oprot.writeI32(struct.returnCode);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CallResult struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.returnInfo = iprot.readString();
        struct.setReturnInfoIsSet(true);
      }
      if (incoming.get(1)) {
        struct.returnCode = iprot.readI32();
        struct.setReturnCodeIsSet(true);
      }
    }
  }

}
