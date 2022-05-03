package hr.test8;

public class Result {
  /*
   * A valley starts and ends at sea level (level = 0).
   */
  public static int countingValleys(int steps, String path) {
    int num_valleys = 0;
    int level = 0;
    boolean enter_valley = false;
    
    for (int i = 0; i < steps; i++) {
      if (path.charAt(i) == 'D') {
        level--;
        if (level < 0) 
          enter_valley = true;
      }
      if (path.charAt(i) == 'U') {
        level++;
        if(level == 0 && enter_valley == true) {
          num_valleys++;
          enter_valley = false;
        }
      }
        
    }
    
    return num_valleys;
  }
}
