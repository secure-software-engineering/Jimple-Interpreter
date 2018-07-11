package de.upb.soot.jimple.interpreter.emulation;

import de.upb.soot.jimple.interpreter.values.JObject;

/**
 * @author Manuel Benz created on 04.07.18
 */
public class JavaEmulator {
  public static Object toJavaObject(JObject jObject) {
    return null;
  }

  public static JObject toJimpleObject(Object javaObject) {
    if (javaObject == null) {
      return null;
    }
    return null;
  }
}
