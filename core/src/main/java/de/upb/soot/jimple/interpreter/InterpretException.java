package de.upb.soot.jimple.interpreter;

import soot.SootMethod;
import soot.Unit;
import soot.Value;

/**
 * @author Manuel Benz created on 21.07.18
 */
public class InterpretException extends RuntimeException {
  public InterpretException(String message) {
    super(message);
  }

  public InterpretException(String message, Throwable cause) {
    super(message, cause);
  }

  public InterpretException(Throwable cause) {
    super(cause);
  }

  public InterpretException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public InterpretException(SootMethod method, Unit unit, InterpretException e) {
    super(msg(method, unit), e);
  }

  public InterpretException(Value v, String msg) {
    super(msg(v, msg));
  }

  private static String msg(Value v, String msg) {
    return String.format("Value ‘%s‘: %s", v, msg);
  }

  private static String msg(SootMethod method, Unit unit) {
    return String.format("Method '%s', Stmt ‘%s‘", method, unit);
  }
}
