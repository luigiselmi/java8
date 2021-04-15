package chapter3;

import java.util.Comparator;
import chapter1.Apple;

public class AppleComparator implements Comparator<Apple> {
  public int compare(Apple a1, Apple a2){
    return a1.getWeight().compareTo(a2.getWeight());
  }
}
