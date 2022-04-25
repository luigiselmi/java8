/*
 * Run from the command line using the command
 * 
 * $ java -cp "target/classes" amzn.Test1 < src/main/resources/amzn/log1.txt
 * 
 */
package amzn;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
  
  static class Result {
    /*
     * Complete the 'processLogs' function below.
     * 
     * The function is expected to return a STRING_ARRAY.
     * The function accepts the following parameters:
     * 1) STRING_ARRAY logs
     * 2) Integer threshold
     */
    public static List<String> processLogs(List<String> logs, int threshold) {
      
      return null;
    }
    
  }

  public static void main(String[] args) {
  
    List<String> logs = new ArrayList<String>();
    int n = 0, threshold = 0;
  
    Scanner sc=new Scanner(System.in);
    n = sc.nextInt();
    int count = 0;
    
    while (count < n + 1) {
      String line = sc.nextLine(); 
      logs.add(line);
      count++;
    }
    
    threshold = sc.nextInt();
    sc.close();
    
    System.out.println("Number of entries: " + n);
    System.out.println("Threshold = " + threshold);
    for (String s: logs) 
      System.out.println(s);
    
  }

}
