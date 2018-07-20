package de.upb.soot.jimple.interpreter.values;

import java.util.Arrays;

/**
 * @author Manuel Benz created on 20.07.18
 */
public class JArray implements JValue {
  private final Object[] values;

  public JArray(int size) {
    this.values = new Object[size];
  }

  public void setValue(int index, Object value) {
    values[index] = value;
  }

  public Object getValue(int index) {
    return values[index];
  }

  @Override
  public String toString() {
    return Arrays.toString(values);
  }

  public Integer getLength() {
    return values.length;
  }
}
