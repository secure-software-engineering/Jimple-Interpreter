package de.upb.soot.jimple.interpreter;

import org.apache.commons.lang3.ClassUtils;

import soot.PrimType;
import soot.Type;

/**
 * @author Manuel Benz created on 19.07.18
 */
public class Utils {

  public static Class<?> jimpleTypeToJavaClass(Type jimpleType) {
    try {
      // we only work with boxed types so we should make sure to use them here to no run into complications during casting of
      // Objects to prim types in castJavaObjectToType
      if (jimpleType instanceof PrimType) {
        return ClassUtils.getClass(((PrimType) jimpleType).boxedType().toString());
      } else {
        return ClassUtils.getClass(jimpleType.toString());
      }
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> T castJavaObject(Object val, Class<T> aClass) {
    if (val.getClass().equals(aClass)) {
      return (T) val;
    }

    try {
      // we cannot just cast number objects, we have to create new objects with the valueOf method
      if (Number.class.isAssignableFrom(aClass)) {
        return (T) aClass.getMethod("valueOf", String.class).invoke(null, val.toString());
      } else if (aClass.equals(Character.class)) {
        return (T) Character.valueOf((char) ((Number) val).intValue());
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    return aClass.cast(val);
  }

  public static Object castJavaObjectToType(Object val, Type type) {
    final Class<?> aClass = jimpleTypeToJavaClass(type);
    return castJavaObject(val, aClass);
  }
}
