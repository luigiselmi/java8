package hr.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    int logsCount = Integer.parseInt(bufferedReader.readLine().trim());
    
    List<String> logs = IntStream.range(0, logsCount).mapToObj(i -> {
        try {
          return bufferedReader.readLine().replaceAll("\\s+$", "");
        }
        catch (IOException ioe) {
          throw new RuntimeException(ioe);
        }
    })
    .collect(Collectors.toList());
    
    int threshold = Integer.parseInt(bufferedReader.readLine().trim());
    
    List<String> result = Result.processLogs(logs, threshold);
    
    for (String log: result)
      System.out.println(log);
  }

}
