package de.upb.soot.jimple.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Manuel Benz created on 29.06.18
 */
public class Environment {

  private final Map<IValue, IValue> idToValue = new HashMap<>();
  private Environment parent;

  public Environment() {
    this(null);
  }

  public Environment(Environment parent) {
    this.parent = parent;
  }

  public IValue getValue(IValue id) {
    final IValue iValue = idToValue.get(id);

    if (iValue == null) {
      if (parent != null) {
        return parent.getValue(id);
      } else {
        throw new IllegalArgumentException("Given local does not exist in scope: " + id);
      }
    }

    return iValue;
  }

  public void putLocal(IValue id, IValue value) {
    idToValue.put(id, value);
  }
}
