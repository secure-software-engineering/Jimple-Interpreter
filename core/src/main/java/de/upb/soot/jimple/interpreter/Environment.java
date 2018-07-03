package de.upb.soot.jimple.interpreter;

import de.upb.soot.jimple.interpreter.values.JObject;

import java.util.HashMap;
import java.util.Map;

import soot.Local;

/**
 * @author Manuel Benz created on 29.06.18
 */
public class Environment {

  private final Map<Local, Object> idToValue = new HashMap<>();
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
    final Object iValue = idToValue.get(id);

    if (iValue != null) {
      return iValue;
    } else {
      throw new IllegalArgumentException("Given local does not exist in scope: " + id);
    }
  }

  public void setLocal(Local id, int paramIndex) {
    idToValue.put(id, arguments[paramIndex]);
  }

  public void setLocal(Local id, Object value) {
    idToValue.put(id, value);
  }

  public JObject getThisInstance() {
    return thisInstance;
  }

  public Object[] getMethodArguments() {
    return arguments;
  }
}
