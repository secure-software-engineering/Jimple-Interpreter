package de.upb.soot.jimple.interpreter.values;

import soot.SootClass;

/**
 * @author Manuel Benz created on 02.07.18
 */
public class JClassObject extends JObject {
  public JClassObject(SootClass declaringClass) {
    super(declaringClass);
  }

  public JObject newInstance() {
    return new JObject(declaringClass);
  }
}
