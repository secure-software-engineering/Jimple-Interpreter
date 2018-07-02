package de.upb.soot.jimple.interpreter;

import de.upb.soot.jimple.interpreter.values.JObject;
import soot.Local;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Manuel Benz created on 29.06.18
 */
public class Environment {

  private final Map<Local, Object> idToValue = new HashMap<>();
  private final JObject thisInstance;

  public Environment() {
    this(null);
  }

  public Environment(JObject thisInstance) {
    this.thisInstance = thisInstance;
  }

  public Object getLocalValue(Local id) {
    final Object iValue = idToValue.get(id);

    if (iValue != null) {
      return iValue;
    } else {
      throw new IllegalArgumentException("Given local does not exist in scope: " + id);
    }
  }

  public void setLocal(Local id, Object value) {
    idToValue.put(id, value);
  }

  public JObject getThisInstance() {
    return thisInstance;
  }
}
