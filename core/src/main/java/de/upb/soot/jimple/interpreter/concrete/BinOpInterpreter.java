package de.upb.soot.jimple.interpreter.concrete;

/**
 * @author Manuel Benz created on 19.07.18
 */
abstract class BinOpInterpreter {
  public Object apply(Number a, Number b) {
    if (a instanceof Double || b instanceof Double) {
      return applyDouble((Double) a, (Double) b);
    } else if (a instanceof Float || b instanceof Float) {
      return applyFloat((Float) a, (Float) b);
    } else if (a instanceof Long || b instanceof Long) {
      return applyLong((Long) a, (Long) b);
    } else if (a instanceof Integer || b instanceof Integer) {
      return applyInteger((Integer) a, (Integer) b);
    } else {
      throw new IllegalArgumentException("Unhandled type of a. N1: " + a.getClass() + ", N2: " + b.getClass());
    }
  }

  protected abstract Object applyLong(Long a, Long b);

  protected abstract Object applyInteger(Integer a, Integer b);

  protected Object applyFloat(Float a, Float b) {
    throw new IllegalArgumentException("Operation is not supported for Float");
  }

  protected Object applyDouble(Double a, Double b) {
    throw new IllegalArgumentException("Operation is not supported for Double");
  }
}
