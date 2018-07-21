package de.upb.soot.jimple.interpreter;

import de.upb.soot.jimple.interpreter.values.JArray;
import de.upb.soot.jimple.interpreter.values.JClassObject;
import de.upb.soot.jimple.interpreter.values.JObject;

import org.jboss.util.NotImplementedException;

import soot.Local;
import soot.SootField;
import soot.Value;
import soot.jimple.AbstractStmtSwitch;
import soot.jimple.ArrayRef;
import soot.jimple.AssignStmt;
import soot.jimple.BreakpointStmt;
import soot.jimple.EnterMonitorStmt;
import soot.jimple.ExitMonitorStmt;
import soot.jimple.GotoStmt;
import soot.jimple.IdentityStmt;
import soot.jimple.IfStmt;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InvokeStmt;
import soot.jimple.LookupSwitchStmt;
import soot.jimple.NopStmt;
import soot.jimple.RetStmt;
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.StaticFieldRef;
import soot.jimple.TableSwitchStmt;
import soot.jimple.ThrowStmt;

/**
 * @author Manuel Benz created on 29.06.18
 */
public class StmtInterpreter extends AbstractStmtSwitch {

  private final JimpleInterpreter jimpleInterpreter;
  private final ClassRegistry classRegistry;
  private final AbstractValueInterpreter valueInterpreter;

  private Environment curEnvironment;

  public StmtInterpreter(JimpleInterpreter jimpleInterpreter, AbstractValueInterpreter valueInterpreter) {
    this.jimpleInterpreter = jimpleInterpreter;
    this.valueInterpreter = valueInterpreter;
    this.classRegistry = jimpleInterpreter.getClassRegistry();
  }

  @Override
  public void caseBreakpointStmt(BreakpointStmt stmt) {
    super.caseBreakpointStmt(stmt);
  }

  @Override
  public void caseInvokeStmt(InvokeStmt stmt) {
    stmt.getInvokeExpr().apply(valueInterpreter);
    setResult(valueInterpreter.getResult());
  }

  @Override
  public void caseAssignStmt(AssignStmt stmt) {
    stmt.getRightOp().apply(valueInterpreter);
    Object val = valueInterpreter.getResult();

    final Value leftOp = stmt.getLeftOp();

    // if we have a prim (boxed) type, we might have to cast because the val side does oftentimes not uniquely identify the
    // type. e.g. byte and short constants are actually integer values
    if (val instanceof Number) {
      val = Utils.castJavaObjectToType(val, leftOp.getType());
    }

    if (leftOp instanceof Local) {
      curEnvironment.setLocal((Local) leftOp, val);
    } else if (leftOp instanceof StaticFieldRef) {
      final SootField field = ((StaticFieldRef) leftOp).getField();
      final JClassObject classObject = classRegistry.getClassObject(curEnvironment, field.getDeclaringClass());
      classObject.setFieldValue(field, val);
    } else if (leftOp instanceof InstanceFieldRef) {
      ((InstanceFieldRef) leftOp).getBase().apply(valueInterpreter);
      final JObject base = (JObject) valueInterpreter.getResult();
      base.setFieldValue(((InstanceFieldRef) leftOp).getField(), val);
    } else if (leftOp instanceof ArrayRef) {
      ((ArrayRef) leftOp).getBase().apply(valueInterpreter);
      final JArray jArray = (JArray) valueInterpreter.getResult();
      ((ArrayRef) leftOp).getIndex().apply(valueInterpreter);
      final Integer index = (Integer) valueInterpreter.getResult();
      jArray.setValue(index, val);
    } else {
      defaultCase(stmt);
    }

    // TODO do we really want to have the right side as evaluated value of an assignment?
    setResult(val);
  }

  @Override
  public void caseIdentityStmt(IdentityStmt stmt) {
    stmt.getRightOp().apply(valueInterpreter);
    final Object right = valueInterpreter.getResult();

    final Value leftOp = stmt.getLeftOp();
    if (leftOp instanceof Local) {
      curEnvironment.setLocal((Local) leftOp, right);
    } else {
      throw new InterpretException(
          String.format("Identity statements only allow for locals on leftOp side but got %s.", leftOp));
    }
  }

  @Override
  public void caseEnterMonitorStmt(EnterMonitorStmt stmt) {
    super.caseEnterMonitorStmt(stmt);
  }

  @Override
  public void caseExitMonitorStmt(ExitMonitorStmt stmt) {
    super.caseExitMonitorStmt(stmt);
  }

  @Override
  public void caseGotoStmt(GotoStmt stmt) {
    super.caseGotoStmt(stmt);
  }

  @Override
  public void caseIfStmt(IfStmt stmt) {
    stmt.getCondition().apply(valueInterpreter);
    final Object result = valueInterpreter.getResult();
    setResult(result);
  }

  @Override
  public void caseLookupSwitchStmt(LookupSwitchStmt stmt) {
    super.caseLookupSwitchStmt(stmt);
  }

  @Override
  public void caseNopStmt(NopStmt stmt) {
    // literally do nothing
    setResult(null);
  }

  @Override
  public void caseRetStmt(RetStmt stmt) {
    super.caseRetStmt(stmt);
  }

  @Override
  public void caseReturnStmt(ReturnStmt stmt) {
    stmt.getOp().apply(valueInterpreter);
    setResult(valueInterpreter.getResult());
  }

  @Override
  public void caseReturnVoidStmt(ReturnVoidStmt stmt) {
    setResult("");
  }

  @Override
  public void caseTableSwitchStmt(TableSwitchStmt stmt) {
    super.caseTableSwitchStmt(stmt);
  }

  @Override
  public void caseThrowStmt(ThrowStmt stmt) {
    super.caseThrowStmt(stmt);
  }

  @Override
  public void defaultCase(Object obj) {
    throw new NotImplementedException(String.format("%s statement not supported", obj));
  }

  public void reset() {
    curEnvironment = null;
    valueInterpreter.reset();
  }

  public void setCurEnvironment(Environment curEnvironment) {
    this.curEnvironment = curEnvironment;
    valueInterpreter.setCurEnvironment(curEnvironment);
  }

}
