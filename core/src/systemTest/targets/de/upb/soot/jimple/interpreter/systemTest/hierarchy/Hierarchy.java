package de.upb.soot.jimple.interpreter.systemTest.hierarchy;

public class Hierarchy extends A {
    public static void hierarchy(String [] args) {
        Hierarchy h = new Hierarchy();
        h.methodB();
        System.out.println(h.methodA());
    }
}
