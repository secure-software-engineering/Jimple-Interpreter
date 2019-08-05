package de.upb.soot.jimple.interpreter;

import de.upb.soot.jimple.interpreter.buildins.MethodDelegate;
import de.upb.soot.jimple.interpreter.concrete.ConcreteValueInterpreter;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Consumer;

import org.apache.commons.io.FileUtils;

import soot.G;
import soot.PackManager;
import soot.PatchingChain;
import soot.Scene;
import soot.SootMethod;
import soot.SourceLocator;
import soot.Unit;
import soot.options.Options;

/**
 * @author Manuel Benz created on 29.06.18
 */
public class JimpleInterpreter {

  private final Configuration configuration;
  private final StmtInterpreter stmtInterpreter;
  private final ClassRegistry classRegistry;

  public JimpleInterpreter(Configuration configuration) {
    this.configuration = configuration;

    if (!configuration.isReuseSoot()) {
      initSoot();
    }

    // this has to run after Soot was initialized
    classRegistry = new ClassRegistry(this, configuration.getBuildIns());
    stmtInterpreter = new StmtInterpreter(this, new ConcreteValueInterpreter(this));
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
      opt.set_output_dir("./jimpleOut");
    } else {
      opt.set_output_format(Options.output_format_none);
    }

    // set custom options for new Soot instance
    final Consumer<Options> additionalSootOptions = configuration.getAdditionalSootOptions();
    if (additionalSootOptions != null) {
      additionalSootOptions.accept(opt);
    }

    Scene.v().loadNecessaryClasses();
    PackManager.v().getPack("wjpp").apply();

    if (configuration.isDumpJimple()) {
      if (configuration.isClearJimpleOutDir()) {
        try {
          FileUtils.deleteDirectory(new File(opt.output_dir()));
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      PackManager.v().writeOutput();
    }
  }

  public String interpretMethod(EntryPoint entryPoint) {
    final SootMethod entryMethod = entryPoint.getMethod();
    final PatchingChain<Unit> units = entryMethod.retrieveActiveBody().getUnits();
    final Iterator<Unit> iterator = units.iterator();

    Unit startUnit = null;

    final int entryLine = entryPoint.getLineNumber();
    if (entryLine > 0) {
      while (iterator.hasNext()) {
        startUnit = iterator.next();
        if (startUnit.getJavaSourceStartLineNumber() == entryLine - 1) {
          break;
        }
      }

      // throw exception if we didn't find the given line number
      if (!iterator.hasNext()) {
        throw new IllegalArgumentException(String.format(
            "Method %s does not contain a statement in line %d or line number tags are not set for this method.",
            entryMethod.toString(), entryLine));
      }
    }

    // TODO implement toString in JObject to interpretMethod real toString of the object
    return interpretMethod(Environment.createRoot(entryMethod, startUnit)).toString();
  }

  protected Object interpretMethod(Environment environment) {
    final SootMethod method = environment.getMethod();
    if (method instanceof MethodDelegate) {
      return ((MethodDelegate) method).delegate(environment);
    } else {
      return interpretMethodInternal(environment);
    }
  }

  /**
   *
   * 
   * @param environment
   *          Is prepared outside and contains parameters and instance object already
   * @return
   */
  private Object interpretMethodInternal(Environment environment) {
    stmtInterpreter.setCurEnvironment(environment);
    final PC pc = environment.getPc();

    while (pc.hasNext()) {
      final Unit next = pc.next();
      try {
        next.apply(stmtInterpreter);
      } catch (InterpretException e) {
        throw new InterpretException(environment.getMethod(), next, e);
      }
    }

    // epilog
    // reset the environment to the calling context
    stmtInterpreter.setCurEnvironment(environment.getParent());
    return stmtInterpreter.getResult();
  }

  public ClassRegistry getClassRegistry() {
    return classRegistry;
  }

  public void reset() {
    classRegistry.reset(configuration.getBuildIns());
    stmtInterpreter.reset();
  }
}
