package de.upb.soot.jimple.interpreter.values;

import soot.SootClass;
import soot.Value;

/**
 * @author Manuel Benz created on 02.07.18
 */
public class JObject {

  private final SootClass implementingClazz;

  public JObject(SootClass implementingClazz) {
    this.implementingClazz = implementingClazz;
  }
}
