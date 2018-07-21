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

  private static JArray createMultDimensional(int[] dimSizes, int maxDims, int dimIndex) {
    final int curSize = dimSizes[dimIndex];
    JArray res = new JArray(curSize);

    if (dimIndex >= maxDims - 1) {
      return res;
    }

    for (int i = 0; i < curSize; i++) {
      final JArray inner = createMultDimensional(dimSizes, maxDims, dimIndex + 1);
      res.setValue(i, inner);
    }

    return res;
  }

  public static JArray createMultDimensional(int[] dimSizes) {
    return createMultDimensional(dimSizes, dimSizes.length, 0);
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
