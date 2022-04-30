package hr.test5;

import java.util.List;
import java.util.TreeMap;

public class Result {
  /*
   * Complete the 'sockMerchant' function below.
   * Returns the pairs of socks with matching color.
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER_ARRAY ar
   */

  public static int sockMerchant(int n, List<Integer> ar) {
    int pairs = 0;
    // counts socks of same color
    TreeMap<Integer, Integer> socks_by_color = new TreeMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      int color = ar.get(i);
      if (socks_by_color.containsKey(color)) {
        int num_socks = socks_by_color.get(color);
        socks_by_color.put(color, ++num_socks);
      }
      else
        socks_by_color.put(color, 1);
    }
    
    // count pairs of matching color
    for(int color: socks_by_color.keySet()) {
      int pair_per_color = socks_by_color.get(color) / 2;
      pairs += pair_per_color;
    }
    return pairs;
  }
}
