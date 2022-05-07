package hr.test15;

import java.util.HashMap;
import java.util.List;

public class Result {
  
  public static void checkMagazine(List<String> magazine, List<String> note) {
    HashMap<String, Integer> mag_words = new HashMap<String, Integer>();
    for (String word: magazine) {
      if ( ! mag_words.containsKey(word) )
        mag_words.put(word, 1);
      else {
        int num_words = mag_words.get(word);
        mag_words.put(word, ++num_words);
      }
    }
    HashMap<String, Integer> note_words = new HashMap<String, Integer>();
    for (String word: note) {
      if ( ! note_words.containsKey(word) )
        note_words.put(word, 1);
      else {
        int num_words = note_words.get(word);
        note_words.put(word, ++num_words);
      }
    }
    
    boolean all_words = true;
    for (String note_word: note_words.keySet()) { 
      if ( mag_words.containsKey(note_word) ) { 
          int num_mag_words = mag_words.get(note_word);
          int num_note_words = note_words.get(note_word);
          if (num_note_words > num_mag_words)
            all_words = false; // not enough repeated words
      }
      else
        all_words = false;
    }
    if (all_words)
      System.out.println("Yes");
    else
      System.out.println("No");
  }
  
    
}
