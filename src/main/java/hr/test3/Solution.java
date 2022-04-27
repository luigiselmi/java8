package amzn.test3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    
    int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
    List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
        try {
          return bufferedReader.readLine().replaceAll("\\s+$", "");
        }
        catch (IOException ioe) {
          throw new RuntimeException(ioe);
        }
    })
    .map(String::trim)
    .map(Integer::parseInt)
    .collect(Collectors.toList());
    
    List<Integer> result = Result.minimalHeaviestSetA(arr);
    for (int item: result)
      System.out.println(item);
    /*
    bufferedWriter.write(
        result.stream()
        .map(Object::toString)
        .collect(Collectors.joining("\n"))
     + "\n"
    );
    */
    bufferedReader.close();
    //bufferedWriter.close();

  }

}
