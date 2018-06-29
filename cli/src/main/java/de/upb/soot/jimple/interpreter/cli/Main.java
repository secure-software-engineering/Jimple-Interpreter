package de.upb.soot.jimple.interpreter.cli;

import de.upb.soot.jimple.interpreter.JimpleInterpreter;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

/**
 * @author Manuel Benz created on 29.06.18
 */
public class Main {
  public static void main(String[] args) {
    Options options = new Options();
    CmdLineParser parser = new CmdLineParser(options);

    try {
      parser.parseArgument(args);
      JimpleInterpreter interpreter = new JimpleInterpreter(options.toConfig());
      final Object res = interpreter.interpret(options.getEntryPoint());
      System.out.println(res);
    } catch (CmdLineException e) {
      System.err.println(e.getMessage());
      parser.printUsage(System.err);
    }
  }
}
