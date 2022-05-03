package hr.test9;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
  
  private static final Scanner scanner = new Scanner(System.in);
  
  /*
   * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
   */
  static int getMoneySpent(int[] keyboards, int[] drives, int b) {
    int n = keyboards.length;
    int m = drives.length;
    int cost = 0;
    
    for (int i = 0; i < n; i++) {
      if (keyboards[i] < b) {
        for (int j = 0; j < m; j++) {
          int price = keyboards[i] + drives[j];
          if (price <= b && price > cost) 
            cost = price;
        }
      }
    }
    if (cost > 0)
      return cost;
    else
      return -1;
  }
  
  static int [] reverse(int [] a) {
    for (int i = 0; i < a.length / 2; i++) {
      int temp = a[a.length - 1 -i];
      a[a.length - 1 -i] = a[i];
      a[i] = temp;
    }
    return a;
  }

  public static void main(String[] args) {
    String[] bnm = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

    int b = Integer.parseInt(bnm[0]);

    int n = Integer.parseInt(bnm[1]);

    int m = Integer.parseInt(bnm[2]);

    int[] keyboards = new int[n];

    String[] keyboardsItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

    for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
        int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
        keyboards[keyboardsItr] = keyboardsItem;
    }

    int[] drives = new int[m];

    String[] drivesItems = scanner.nextLine().split(" ");
    //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

    for (int drivesItr = 0; drivesItr < m; drivesItr++) {
        int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
        drives[drivesItr] = drivesItem;
    }
    
    scanner.close();

    int moneySpent = getMoneySpent(keyboards, drives, b);

    System.out.println("Cost to buy electronics: " + moneySpent);
    


  }

}
