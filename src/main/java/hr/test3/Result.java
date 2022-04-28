package hr.test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {
  public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
    int start_arr_weight = weight(arr);
    int n = arr.size(); // num of elements
    List<Integer> setA = new ArrayList<Integer>();
    List<Integer> setB = new ArrayList<Integer>();
    Collections.sort(arr, Collections.reverseOrder()); // order by weight
    int weight_a = 0; // total weight of items in A 
    int weight_b = 0; // total weight of items in B
    int arr_max_weight = 0; // heaviest weight in arr
    do { 
      arr_max_weight = arr.remove(0); // removes the heaviest item from arr
      if (weight(arr) > weight_a) {
        setA.add(arr_max_weight);
        weight_a = weight(setA);
      }
      else {
        setB.add(arr_max_weight);
        weight_b = weight(setB);
      }
    } while (! arr.isEmpty() );
    
    return setA;
  }
  public static int weight(List<Integer> items) {
    return items.stream().mapToInt(a -> a).sum();
  }
}
