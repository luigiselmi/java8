package hr.test10;

import java.util.ArrayList;
import java.util.List;

public class Result {
  public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    List<Integer> comparisons = new ArrayList<Integer>();
    int score_a = 0;
    int score_b = 0;
    
    for (int i = 0; i < a.size(); i++) {
      int point_a = a.get(i);
      int point_b = b.get(i);
      
      if (point_a > point_b)
        score_a++;
      if (point_a < point_b)
        score_b++;
    }
    
    comparisons.add(score_a);
    comparisons.add(score_b);
    
    return comparisons;
  }
}
