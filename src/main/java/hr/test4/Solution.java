package hr.test4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    int relatedCount = Integer.parseInt(bufferedReader.readLine().trim());
    
    List<String> related = IntStream.range(0, relatedCount).mapToObj(i -> {
      try {
        return bufferedReader.readLine().replaceAll("\\s+$", "");
      }
      catch (IOException ioe) {
        throw new RuntimeException(ioe);
      }
    })
    .collect(Collectors.toList());
    
    bufferedReader.close();
    
    int result = Result.countGroups(related);
    
    System.out.println("Related = " + result);
  

  }

}
