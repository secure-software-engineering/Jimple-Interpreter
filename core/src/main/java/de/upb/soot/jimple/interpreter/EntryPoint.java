package de.upb.soot.jimple.interpreter;

import soot.Scene;
import soot.SootMethod;

/**
 * @author Manuel Benz created on 29.06.18
 */
public class EntryPoint {
  private int entryLine;
  private String entryMethod;

  public EntryPoint(String entryMethod) {
    this(entryMethod, 1);
  }

  public EntryPoint(String entryMethod, int entryLine) {
    this.entryMethod = entryMethod;
    this.entryLine = entryLine;
  }

  public SootMethod getMethod() {
    return Scene.v().getMethod(entryMethod);
  }

  public int getUnitIndex() {
    return entryLine - 1;
  }
}
