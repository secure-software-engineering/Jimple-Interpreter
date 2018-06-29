package de.upb.soot.jimple.interpreter;

import org.jboss.util.NotImplementedException;

import soot.SootMethod;
import soot.jimple.AbstractStmtSwitch;
import soot.jimple.AssignStmt;
import soot.jimple.BreakpointStmt;
import soot.jimple.EnterMonitorStmt;
import soot.jimple.ExitMonitorStmt;
import soot.jimple.GotoStmt;
import soot.jimple.IdentityStmt;
import soot.jimple.IfStmt;
import soot.jimple.InvokeStmt;
import soot.jimple.LookupSwitchStmt;
import soot.jimple.NopStmt;
import soot.jimple.RetStmt;
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.TableSwitchStmt;
import soot.jimple.ThrowStmt;

/**
 * @author Manuel Benz created on 29.06.18
 */
public class StmtInterpreter extends AbstractStmtSwitch<IValue> {

  private AbstractValueInterpreter valueInterpreter;
  private SootMethod curMethod;
  private Environment curEnvironment;

  public StmtInterpreter(AbstractValueInterpreter valueInterpreter) {
    this.valueInterpreter = valueInterpreter;
  }

  @Override
  public void caseBreakpointStmt(BreakpointStmt stmt) {
    super.caseBreakpointStmt(stmt);
  }

  @Override
  public void caseInvokeStmt(InvokeStmt stmt) {
    super.caseInvokeStmt(stmt);
  }

  @Override
  public void caseAssignStmt(AssignStmt stmt) {
    stmt.getRightOp().apply(valueInterpreter);
    final IValue right = valueInterpreter.getResult();
    stmt.getLeftOp().apply(valueInterpreter);
    curEnvironment.putLocal(valueInterpreter.getResult(), right);
  }

  @Override
  public void caseIdentityStmt(IdentityStmt stmt) {
    stmt.getRightOp().apply(valueInterpreter);
    final IValue right = valueInterpreter.getResult();
    stmt.getLeftOp().apply(valueInterpreter);
    curEnvironment.putLocal(valueInterpreter.getResult(), right);
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
    super.caseIfStmt(stmt);
  }

  @Override
  public void caseLookupSwitchStmt(LookupSwitchStmt stmt) {
    super.caseLookupSwitchStmt(stmt);
  }

  @Override
  public void caseNopStmt(NopStmt stmt) {
    super.caseNopStmt(stmt);
  }

  @Override
  public void caseRetStmt(RetStmt stmt) {
    super.caseRetStmt(stmt);
  }

  @Override
  public void caseReturnStmt(ReturnStmt stmt) {
    super.caseReturnStmt(stmt);
  }

  @Override
  public void caseReturnVoidStmt(ReturnVoidStmt stmt) {
    super.caseReturnVoidStmt(stmt);
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

  public void setCurMethod(SootMethod curMethod) {
    this.curMethod = curMethod;
    valueInterpreter.setCurMethod(curMethod);
  }

  public void setCurEnvironment(Environment curEnvironment) {
    this.curEnvironment = curEnvironment;
    valueInterpreter.setCurEnvironment(curEnvironment);
  }
}
