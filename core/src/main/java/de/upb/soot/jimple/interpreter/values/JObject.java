package de.upb.soot.jimple.interpreter.values;

import com.google.common.collect.Maps;

import java.util.Map;

import soot.SootClass;
import soot.SootField;
import soot.SootMethod;

/**
 * @author Manuel Benz created on 02.07.18
 */
public class JObject implements JValue {

  protected final SootClass declaringClass;
  protected final Map<SootField, Object> fieldMap;

  public JObject(SootClass declaringClass) {
    this.declaringClass = declaringClass;
    fieldMap = Maps.newHashMapWithExpectedSize(declaringClass.getFieldCount());
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
   * Can be used to delegate to another method in build-ins
   * 
   * @param method
   * @return
   */
  public SootMethod getMethod(SootMethod method) {
    return method;
  }
}
