package hr.test16;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Pattern p = Pattern.compile(new MyRegex().pattern);
    while(in.hasNext()){
        String IP = in.next();
        Matcher m = p.matcher(IP);
        boolean match = m.find();
        if (match) { // in case the regex pattern does not check for elements of the IP address to be <= 255
          String [] values = IP.split("\\.");
          for (String value: values) {
            int v = Integer.parseInt(value);
            if (v > 255)
              match = false;
          }
        }
        
        System.out.println(match);
    }
  }

}
