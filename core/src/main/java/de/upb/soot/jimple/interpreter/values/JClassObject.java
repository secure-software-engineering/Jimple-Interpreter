package de.upb.soot.jimple.interpreter.values;

import soot.SootClass;
import soot.Type;

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

  @Override
  public JObject castTo(Type toType) {
    throw new IllegalStateException("Class object cannot be cast");
  }

  @Override
  public Boolean instanceOf(Type checkType) {
    // FIXME we should change the class hierarchy to get this right!
    throw new IllegalStateException("Class object is no instance in Java");
  }
}
