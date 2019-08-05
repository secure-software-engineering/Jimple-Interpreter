package de.upb.soot.jimple.interpreter;

import java.util.Iterator;

import soot.PatchingChain;
import soot.Unit;

/**
 * @author Manuel Benz created on 21.07.18
 */
public class PC implements Iterator<Unit> {
  private final PatchingChain<Unit> units;

  private Unit next;

  public PC(PatchingChain<Unit> units) {
    this(units, units.getFirst());
  }

  public PC(PatchingChain<Unit> units, Unit startUnit) {
    this.units = units;
    this.next = startUnit;
  }

  @Override
  public boolean hasNext() {
    return next != null;
  }

  @Override
  public Unit next() {
    Unit res = next;
    next = units.getSuccOf(next);
    return res;
  }

  public void goTo(Unit target) {
    if (!units.contains(target)) {
      throw new InterpretException("Target not in current method: " + target);
    }

    next = target;
  }
}
