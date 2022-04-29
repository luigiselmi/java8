package hr.test4;

import java.util.Arrays;
import java.util.List;

public class Result {
  /*
   * The function is expected to return an integer.
   * The function accepts string array.
   */
  public static int countGroups(List<String> related) {
    int num_groups = 0; 
    
    int [] users_per_group = new int [related.size()]; // an empty group is not a group
    Arrays.fill(users_per_group, 1); // initialize each group with one user
    
    int count = 0;
    for (String line: related) {
      for (int i = 0; i < line.length(); i++) {
        if (line.charAt(i) == '1' && i != count) {
          users_per_group[i]--;
          if (users_per_group[count] > 0)
            users_per_group[count]++;
        }
      }
      count++;
    }
    
    for (int i = 0; i < related.size(); i++)
      if (users_per_group[i] > 0)
        num_groups++;
      
    return num_groups;
  }
  
}
