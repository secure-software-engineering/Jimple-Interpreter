package de.upb.soot.jimple.interpreter.systemTest.arrays;

public class Arrays {

  public void primitiveArray() {
    int[] arr = new int[] { 1, 2 };
    System.out.println(arr);
    System.out.println(arr[0]);
    System.out.println(arr[1]);
  }

  public void objectArray() {
    String[] arr = new String[] { "1", "2" };
    System.out.println(arr);
    System.out.println(arr[0]);
    System.out.println(arr[1]);
  }

  public void manualAssignment() {
    int[] arr = new int[1];
    arr[0] = 1;
    System.out.println(arr);
    System.out.println(arr[0]);
  }

  public void twoDimensions() {
    int[][] arr = new int[1][1];
    arr[0][0] = 1;
    System.out.println(arr);
    System.out.println(arr[0]);
    System.out.println(arr[0][0]);
  }

}
