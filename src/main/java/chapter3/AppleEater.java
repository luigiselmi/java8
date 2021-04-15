package chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import chapter1.Apple;

public class AppleEater {

  public static void main(String[] args) {
    List<Apple> apples = Arrays.asList(
        new Apple(80, "green"), 
        new Apple(160, "red"), 
        new Apple(155, "green"));
    
    // sorts apples by weight using an implementation of comparator
    apples.sort(new AppleComparator());
    
    //print(apples);
    
    // sorts apples using an anonymous class
    apples.sort(new Comparator<Apple>() {
      public int compare(Apple a1, Apple a2) {
        return a1.getWeight().compareTo(a2.getWeight());
      }
    });
    
    //print(apples);
    
    // sorts apples using lambda expressions
    apples.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
    //print(apples);
    
    // sorts apples in reverse order using method references
    apples.sort(Comparator.comparing(Apple::getWeight).reversed());
    print(apples);
  }
  
  private static void print(List<Apple> apples) {
    for(Apple a: apples) {
      System.out.println(a.getWeight());
    }
  }

}
