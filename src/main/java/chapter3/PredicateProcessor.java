package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
/*
 * Tests some functional interfaces available in the package 
 * java.util.function
 */
public class PredicateProcessor {

  public static void main(String[] args) {
    // Predicate interface
    Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
    List<String> listOfStrings = Arrays.asList("Pippo", "Pluto", "", "Paperino");
        
    List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
    for(String s: nonEmpty) {
      System.out.println(s);
    }
    
    // Consumer interface
    forEach(
      Arrays.asList(1,2,3,4,5), (Integer i) -> System.out.print(i + " ")
    );
    System.out.println();
    
    // Function interface
    List<Integer> lengths = map(
      Arrays.asList("Pippo", "Pluto", "Paperino"), (String s) -> s.length()
    );
    forEach(lengths, (Integer i) -> System.out.print(i + " "));
     
  }

  public static <T> void forEach(List<T> list, Consumer<T> c) {
    for(T t: list) {
      c.accept(t);
    }
  }
  
  public static <T> List<T> filter(List<T> list, Predicate<T> p) {
    List<T> results = new ArrayList<>();
    for(T t: list) {
      if(p.test(t)) {
        results.add(t);
      }
    }
    return results;
  }
  
  public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
    List<R> result = new ArrayList<>();
    for(T t: list) {
      result.add(f.apply(t));
    }
    return result;
  }

}
