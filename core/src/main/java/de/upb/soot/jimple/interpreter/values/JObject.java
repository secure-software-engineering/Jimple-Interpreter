package de.upb.soot.jimple.interpreter.values;

import com.google.common.collect.Maps;

import java.util.Map;

import soot.BooleanType;
import soot.ByteType;
import soot.CharType;
import soot.DoubleType;
import soot.FastHierarchy;
import soot.FloatType;
import soot.IntType;
import soot.LongType;
import soot.PrimType;
import soot.RefType;
import soot.Scene;
import soot.ShortType;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.TypeSwitch;

/**
 * @author Manuel Benz created on 02.07.18
 */
public class JObject implements JValue {

  protected static final FastHierarchy HIERARCHY = Scene.v().getOrMakeFastHierarchy();
  protected final SootClass declaringClass;
  protected final Map<SootField, Object> fieldMap;

  public JObject(SootClass declaringClass) {
    this.declaringClass = declaringClass;
    fieldMap = Maps.newHashMapWithExpectedSize(declaringClass.getFieldCount());
    initPrimitiveFields();
  }

  public SootClass getDeclaringClass() {
    return declaringClass;
  }

  public Object getFieldValue(SootField field) {
    return fieldMap.get(field);
  }

  public void setFieldValue(SootField field, Object value) {
    fieldMap.put(field, value);
  }

  /**
   * Used to get the corresponding SootMethod for this object. e.g., if the original SootMethod references a supertype
   * implementation, we will have to return the correct subtype implementation here.
   *
   * Is also useful for build-in method delegates.
   * 
   * @param method
   * @param virtualCall
   *          indicates whether virtual call resolution should be used
   * @return The SootMethod which has to be executed on this object
   */
  public SootMethod getMethod(SootMethod method, boolean virtualCall) {
    if (virtualCall) {
      return HIERARCHY.resolveConcreteDispatch(declaringClass, method);
    } else {
      return method;
    }
  }

  public JObject castTo(Type toType) {
    // we really just have to check if the cast is legal. either up or down cast should work for this.
    final RefType thisType = declaringClass.getType();
    if (HIERARCHY.canStoreType(toType, thisType) || HIERARCHY.canStoreType(thisType, toType)) {
      return this;
    }
    throw new IllegalStateException(String.format("Illegal cast from {} to {}", thisType, toType));
  }

  public Boolean instanceOf(Type checkType) {
    return checkType.equals(getDeclaringClass().getType());
  }

  private void initPrimitiveFields() {
    // primitive types are by default initialized as 0 if not specified explicitly
    for (SootField sootField : this.getDeclaringClass().getFields()) {
      final Type fieldType = sootField.getType();
      if (fieldType instanceof PrimType && (!sootField.isStatic() == isInstanceObject())) {
        final TypeSwitch typeSwitch = new TypeSwitch() {
          @Override
          public void caseBooleanType(BooleanType t) {
            setFieldValue(sootField, Boolean.FALSE);
          }

          @Override
          public void caseByteType(ByteType t) {
            setFieldValue(sootField, Byte.valueOf((byte) 0));
          }

          @Override
          public void caseCharType(CharType t) {
            setFieldValue(sootField, Character.valueOf((char) 0));
          }

          @Override
          public void caseDoubleType(DoubleType t) {
            setFieldValue(sootField, Double.valueOf(0.0D));
          }

          @Override
          public void caseFloatType(FloatType t) {
            setFieldValue(sootField, Float.valueOf(0.0f));
          }

          @Override
          public void caseIntType(IntType t) {
            setFieldValue(sootField, Integer.valueOf(0));
          }

          @Override
          public void caseLongType(LongType t) {
            setFieldValue(sootField, Long.valueOf(0));
          }

          @Override
          public void caseShortType(ShortType t) {
            setFieldValue(sootField, Short.valueOf((short) 0));
          }
        };
        fieldType.apply(typeSwitch);
      }
    }
  }

  protected boolean isInstanceObject() {
    return true;
  }
}
