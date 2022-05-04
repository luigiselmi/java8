package hr.test12;

import java.util.Scanner;

public class Solution {
  // Return true if you can win the game; otherwise, return false.
  public static boolean canWin(int leap, int[] game) {
    boolean result = false;
    int n = game.length;
    int i = 0, next = 0;
    
    for (i = 0; i < n; i++) {
      next += leap;
      if (next < n) {
        if (game[next] == 0)
          i = next;
        else 
          next -= leap;
      }
      else
        break;
      
      next += 1;
      boolean back = false;
      if (next < n) {
        if(game[next] == 0)
          i = next ;
        else {
          next -= 1;
          back = true;
        }
      }
      else
        break;
      
      if (back) 
        if (next - 1 > 0 && game[next - 1] == 0)
          next -=1;
    }
    
    if (next >= n - 1)
      result = true;
    
    return result;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int q = scan.nextInt();
    while (q-- > 0) {
        int n = scan.nextInt();
        int leap = scan.nextInt();
        
        int[] game = new int[n];
        for (int i = 0; i < n; i++) {
            game[i] = scan.nextInt();
        }

        System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
    }
    scan.close();
  }

}
