package hr.test7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(bufferedReader.readLine().trim());

    int p = Integer.parseInt(bufferedReader.readLine().trim());
    
    bufferedReader.close();

    int result = Result.pageCount(n, p);
    
    System.out.println("Minimum number of pages to turn: " + result);

  }

}
