package de.upb.soot.jimple.interpreter.values;

import com.google.common.collect.Maps;

import java.util.Map;

import soot.FastHierarchy;
import soot.Scene;
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
      FastHierarchy hierarchy = Scene.v().getOrMakeFastHierarchy();
      return hierarchy.resolveConcreteDispatch(declaringClass, method);
    } else {
      return method;
    }
  }
}
