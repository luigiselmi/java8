/*
 * Run from the command line using the command
 * 
 * $ java -cp "target/classes" amzn.Test1 < src/main/resources/amzn/log1.txt
 * 
 */
package utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class IOUtils {

  public static void main(String[] args) {
    
    int n = 0;
    int threshold = 0;
    
    List<String> logs = new ArrayList<String>();
    
    try {
      
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(bufferedReader.readLine().trim());
      int count = 1;
      
      while (count < n + 1) {
        String line = bufferedReader.readLine().trim();
        String [] values = line.trim().split(" ");
        for (String value: values) {
          System.out.println(value);
          if (!value.matches("^[1-9][0-9]*$")) {
            System.err.println("The values in the transactions must contain only characters in the range ascii['0'-'9'] starting with a non-zero digit.");
            System.exit(1);
          }
        }
        logs.add(line);
        count++;
      }
      
      threshold = Integer.parseInt(bufferedReader.readLine().trim());
      bufferedReader.close();
       
    }
    catch (IOException ioe) {
      System.out.println(ioe.getMessage());
    }
    
    System.out.println("Number of entries: " + n);
    System.out.println("Threshold = " + threshold);
    for (String s: logs) 
      System.out.println(s);


  }

}
