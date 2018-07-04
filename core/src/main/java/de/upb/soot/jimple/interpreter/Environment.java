package de.upb.soot.jimple.interpreter;

import de.upb.soot.jimple.interpreter.values.JObject;

import java.util.HashMap;
import java.util.Map;

import soot.Local;

/**
 * Models the current scope, including local variables and parameters passed into the method modeled by this scope.
 *
 * @author Manuel Benz created on 29.06.18
 */
public class Environment {

  private final Map<Local, Object> localToValue = new HashMap<>();
  private final JObject thisInstance;
  private final Object[] arguments;

  public Environment(Object... arguments) {
    this(null, arguments);
  }

  public Environment(JObject thisInstance, Object... arguments) {
    this.thisInstance = thisInstance;
    this.arguments = arguments;
  }

  public Object getLocalValue(Local id) {
    final Object iValue = localToValue.get(id);

    if (iValue != null) {
      return iValue;
    } else {
      throw new IllegalArgumentException("Given local does not exist in scope: " + id);
    }
  }

  /**
   * Assigns the value of the parameter with the given index to the given local.
   * 
   * @param id
   * @param paramIndex
   */
  public void setLocal(Local id, int paramIndex) {
    localToValue.put(id, arguments[paramIndex]);
  }

  /**
   * Assigns the given value (JObject or primitive) to the given local.
   * 
   * @param id
   * @param value
   */
  public void setLocal(Local id, Object value) {
    localToValue.put(id, value);
  }

  public JObject getThisInstance() {
    return thisInstance;
  }

  public Object[] getMethodArguments() {
    return arguments;
  }
}
