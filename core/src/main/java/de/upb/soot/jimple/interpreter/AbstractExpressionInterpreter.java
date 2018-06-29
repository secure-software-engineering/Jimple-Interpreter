package de.upb.soot.jimple.interpreter;

import org.jboss.util.NotImplementedException;

import soot.jimple.AbstractExprSwitch;

/**
 * @author Manuel Benz created on 29.06.18
 */
public abstract class AbstractExpressionInterpreter extends AbstractExprSwitch {
  @Override
  public void defaultCase(Object obj) {
    throw new NotImplementedException(String.format("%s expression not supported"));
  }
}
