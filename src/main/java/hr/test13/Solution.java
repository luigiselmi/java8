package hr.test13;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
  
  public static void main(String[] args) {
    TreeMap<Character, Character> parenthesis = new TreeMap<Character, Character>();
    parenthesis.put('(', ')');
    parenthesis.put('[', ']');
    parenthesis.put('{', '}');
    
    Scanner sc = new Scanner(System.in);
    
    while (sc.hasNext()) {
      String s = sc.nextLine();
      if (s.length() % 2 != 0)
        System.out.println("false");
      else {
        String balanced = Solution.checkBalance(s, parenthesis);
        System.out.println(balanced);
      }
    }
    
    sc.close();

  }
  /*
   *  If input string is even we have to check if it is balanced.
   *  The input is a string of open parenthesis '(', '[', '{'
   *  and closed parenthesis ')', ']', '}'. 
   *  Returns "true" if all open parenthesis have a corresponding 
   *  closed one and vice versa, "false" otherwise.
   */
  public static String checkBalance(String s, TreeMap<Character, Character> parenthesis) {
    boolean match = false; 
    Deque<Character> stack = new ArrayDeque<Character>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{')
        stack.push(c);
      else {
        if ( ! stack.isEmpty() ) {
          char b = (char) stack.pop();
          char close_b = parenthesis.get(b); 
          if (c == close_b)
            match = true;
          else
            match = false;
        }
        else
          return "false"; // a close parenthesis without an open one
      }
    }
    
    if (match)
      return "true";
    else
      return "false";
  }

}
