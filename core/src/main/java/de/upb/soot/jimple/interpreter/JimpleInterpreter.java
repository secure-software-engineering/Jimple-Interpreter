package de.upb.soot.jimple.interpreter;

import de.upb.soot.jimple.interpreter.concrete.ConcreteValueInterpreter;

import java.util.Collections;
import java.util.Iterator;

import org.jboss.util.file.Files;

import soot.G;
import soot.PackManager;
import soot.Scene;
import soot.SootMethod;
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
    stmtInterpreter = new StmtInterpreter(new ConcreteValueInterpreter());

    if (!configuration.isReuseSoot()) {
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
    if (configuration.isDumpJimple()) {
      opt.set_output_format(Options.output_format_jimple);
      opt.set_no_writeout_body_releasing(true);
    } else {
      opt.set_output_format(Options.output_format_none);
    }

    Scene.v().loadNecessaryClasses();
    PackManager.v().getPack("wjpp").apply();

    if (configuration.isDumpJimple()) {
      Files.delete(opt.output_dir());
      PackManager.v().writeOutput();
    }
  }

  public IValue interpret(EntryPoint entryPoint) {
    final SootMethod entryMethod = entryPoint.getMethod();
    final Iterator<Unit> iterator = entryMethod.retrieveActiveBody().getUnits().iterator();
    for (int i = 0; i < entryPoint.getUnitIndex(); i++) {
      if (iterator.hasNext()) {
        iterator.next();
      } else {
        throw new IllegalArgumentException(
            String.format("Method %s does not contain in line %d", entryMethod.toString(), entryPoint.getUnitIndex()));
      }
    }
    return interpret(entryMethod, iterator, new Environment());
  }

  private IValue interpret(SootMethod method, Iterator<Unit> units, Environment environment) {
    IValue res = null;
    stmtInterpreter.setCurMethod(method);
    stmtInterpreter.setCurEnvironment(environment);
    while (units.hasNext()) {
      final Unit next = units.next();
      res = interpret((Stmt) next);
    }
    return res;
  }

  private IValue interpret(Stmt stmt) {
    stmt.apply(stmtInterpreter);
    return stmtInterpreter.getResult();
  }
}
