package de.upb.soot.jimple.interpreter;

import de.upb.soot.jimple.interpreter.concrete.ConcreteExpressionInterpreter;

import java.util.Collections;
import java.util.Iterator;

import soot.Body;
import soot.G;
import soot.PackManager;
import soot.Scene;
import soot.SourceLocator;
import soot.Unit;
import soot.jimple.Stmt;
import soot.options.Options;

/**
 * @author Manuel Benz created on 29.06.18
 */
public class JimpleInterpreter {

  private final Configuration configuration;

  private final StmtInterpreter stmtInterpreter;

  public JimpleInterpreter(Configuration configuration) {
    this.configuration = configuration;
    stmtInterpreter = new StmtInterpreter(new ConcreteExpressionInterpreter());

    if (!configuration.getUseExistingSootInstance()) {
      initSoot();
    }
  }

  private void initSoot() {
    G.reset();
    final Options opt = Options.v();
    opt.set_process_dir(SourceLocator.explodeClassPath(configuration.getClassPath()));
    opt.set_prepend_classpath(true);
    opt.set_allow_phantom_refs(true);
    opt.set_no_bodies_for_excluded(false);
    opt.set_exclude(Collections.emptyList());
    opt.set_whole_program(true);
    opt.set_src_prec(Options.src_prec_class);
    opt.set_output_format(Options.output_format_none);

    Scene.v().loadNecessaryClasses();
    PackManager.v().getPack("wjpp").apply();
  }

  public Object interpret(EntryPoint entryPoint) {
    final Body body = entryPoint.getMethod().retrieveActiveBody();
    final Iterator<Unit> iterator = body.getUnits().iterator();
    for (int i = 0; i < entryPoint.getUnitIndex(); i++) {
      if (iterator.hasNext()) {
        iterator.next();
      } else {
        throw new IllegalArgumentException(String.format("Method %s does not contain in line %d",
            entryPoint.getMethod().toString(), entryPoint.getUnitIndex()));
      }
    }
    return interpret(body, iterator);
  }

  private Object interpret(Body body, Iterator<Unit> startUnit) {
    Object res = null;
    while (startUnit.hasNext()) {
      final Unit next = startUnit.next();
      res = interpret((Stmt) next);
    }
    return res;
  }

  private Object interpret(Stmt stmt) {
    stmt.apply(stmtInterpreter);
    return stmtInterpreter.getResult();
  }
}
