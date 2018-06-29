package de.upb.soot.jimple.interpreter;

import org.jboss.util.NotImplementedException;

import soot.SootMethod;
import soot.jimple.AbstractJimpleValueSwitch;

/**
 * @author Manuel Benz created on 29.06.18
 */
public abstract class AbstractValueInterpreter extends AbstractJimpleValueSwitch<IValue> {
  private SootMethod curMethod;
  private Environment curEnvironment;

  @Override
  public void defaultCase(Object obj) {
    throw new NotImplementedException(String.format("%s expression not supported", obj));
  }

  public SootMethod getCurMethod() {
    return curMethod;
  }

  protected void setCurMethod(SootMethod curMethod) {
    this.curMethod = curMethod;
  }

  public Environment getCurEnvironment() {
    return curEnvironment;
  }

  protected void setCurEnvironment(Environment curEnvironment) {
    this.curEnvironment = curEnvironment;
  }
}
