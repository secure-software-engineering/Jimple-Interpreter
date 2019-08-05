package de.upb.soot.jimple.interpreter;

import de.upb.soot.jimple.interpreter.values.JObject;

import java.util.HashMap;
import java.util.Map;

import soot.Local;
import soot.PatchingChain;
import soot.SootMethod;
import soot.Unit;

/**
 * Models the current scope, including local variables and parameters passed into the method modeled by this scope.
 *
 * @author Manuel Benz created on 29.06.18
 */
public class Environment {

  private final Map<Local, Object> localToValue = new HashMap<>();
  private final JObject thisInstance;
  private final Object[] arguments;
  private final Environment parent;
  private final PC pc;
  private final SootMethod method;

  private Environment(Environment parent, SootMethod method, PC pc, JObject thisInstance, Object... arguments) {
    this.thisInstance = thisInstance;
    this.arguments = arguments;
    this.parent = parent;
    this.method = method;
    this.pc = pc;
  }

  public static Environment createRoot(SootMethod method) {
    // TODO implement parameters to e.g. static void main
    return createRoot(method, null);
  }

  public static Environment createRoot(SootMethod method, Unit startingUnit) {
    // TODO implement parameters to e.g. static void main
    final PatchingChain<Unit> units = method.retrieveActiveBody().getUnits();

    if (startingUnit == null) {
      startingUnit = units.getFirst();
    }

    final PC pc = new PC(units, startingUnit);
    return new Environment(null, method, pc, null);
  }

  public Environment createChild(SootMethod method, Object... arguments) {
    return createChild(method, null, arguments);
  }

  public Environment createChild(SootMethod method, JObject thisInstance, Object... arguments) {
    final PC pc = new PC(method.retrieveActiveBody().getUnits());
    return new Environment(this, method, pc, thisInstance, arguments);
  }

  public Object getLocalValue(Local id) {
    final Object iValue = localToValue.get(id);

    if (iValue != null) {
      return iValue;
    } else {
      throw new InterpretException("Given local does not exist in scope: " + id);
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

  public Object getArgument(int index) {
    return arguments[index];
  }

  public Environment getParent() {
    return parent;
  }

  public PC getPc() {
    return pc;
  }

  public SootMethod getMethod() {
    return method;
  }
}
