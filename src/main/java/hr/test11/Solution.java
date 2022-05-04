package hr.test11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    String s = bufferedReader.readLine();
    
    bufferedReader.close();

    String result = Result.timeConversion(s);
    
    System.out.println("Time 24-hours clock: " + result);
  }

}
