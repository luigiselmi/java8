package hr.test6;

import java.util.LinkedList;
import java.util.List;

public class Result {
  /*
   * Complete the 'jumpingOnClouds' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY c as parameter.
   */

  public static int jumpingOnClouds(List<Integer> c) {
    int min_num_jumps = 0;
    List<Integer> jumps = new LinkedList<Integer>();
    for (int i = 0; i < c.size() - 1;) {
      if (i < c.size() - 2 && c.get(i + 2) != 1) {
        jumps.add(i + 2);
        i += 2;
        min_num_jumps++;
        continue; // see whether there's another 2 steps jump
      }
      if (i < c.size() - 1 && c.get(i + 1) != 1) {
        jumps.add(i + 1);
        i += 1;
        min_num_jumps++;
      }
      
    }
    print(jumps);
    return min_num_jumps;
  }
  public static void print(List<Integer> jumps) {
    for (int jump: jumps)
      System.out.print(jump + " ");
    System.out.println();
  }
}
