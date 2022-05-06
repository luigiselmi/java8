package hr.test14;

import java.util.Scanner;

public class Solution {

  // Returns the minimum number of swaps to sort the integer array.
  static int minimumSwaps(int[] arr) {
    int n = arr.length;
    int swaps = 0;
    for (int i = 0; i < n; i++) {
      int index_min = min_index(arr, i, n);
      if (index_min > i) {
        int temp = arr[i];
        arr[i] = arr[index_min];
        arr[index_min] = temp;
        swaps++;
      }
    }
    
    return swaps;
  }
  // Returns the index of the minimum value in the input array
  static int min_index(int [] a, int start, int max_value) {
    int min_value = max_value;
    int min_index = start;
    for (int i = start; i < a.length; i++) {
      if (a[i] < min_value) {
        min_value = a[i];
        min_index = i;
      }
    }
    return min_index; 
  }
  
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];
    String[] arrItems = scanner.nextLine().split(" ");
    
    scanner.close();

    for (int i = 0; i < n; i++) {
        int arrItem = Integer.parseInt(arrItems[i]);
        arr[i] = arrItem;
    }
    
    // Test for mean execution time
    int num_test = 10;
    // array of num_test copies of arr
    // to be used to compute the mean execution time
    int [][] test_arr = new int [num_test][n];
    for (int i = 0; i < num_test; i++)
      for (int j = 0; j < n; j++)
        test_arr[i][j] = arr[j];
    double execTime = 0.0;
    int res = 0;
    double startTime = System.currentTimeMillis();
    for (int i = 0; i < num_test; i++) {
      int swaps = minimumSwaps(test_arr[i]); 
      res += swaps;
    }
    double endtTime = System.currentTimeMillis();
    execTime = (endtTime - startTime) / 1000;
    System.out.println(res / num_test);
    System.out.println("Mean execution time (s): " + execTime / num_test);
    
  }

}
