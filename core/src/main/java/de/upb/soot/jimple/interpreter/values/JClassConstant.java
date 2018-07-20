package de.upb.soot.jimple.interpreter.values;

import soot.Type;
import soot.jimple.ClassConstant;

/**
 * @author Manuel Benz created on 20.07.18
 */
public class JClassConstant {
  private final Type type;

  public JClassConstant(ClassConstant v) {
    this.type = v.toSootType();
  }

  @Override
  public String toString() {
    return "class " + type.toString();
  }

  public Type getType() {
    return type;
  }
}
