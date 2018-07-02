package de.upb.soot.jimple.interpreter.values;

import de.upb.soot.jimple.interpreter.IValue;

import soot.SootClass;
import soot.SootField;

/**
 * @author Manuel Benz created on 02.07.18
 */
public class JObject implements IValue {

  private final SootClass implementingClazz;

  public JObject(SootClass implementingClazz) {
    this.implementingClazz = implementingClazz;
  }
}
