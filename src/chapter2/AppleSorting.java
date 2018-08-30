package chapter2;

import java.util.Arrays;
import java.util.List;

import chapter1.Apple;

public class AppleSorting {
	public static void main(String [] args) {
		
		List<Apple> apples = Arrays.asList(
				new Apple(80, "green"), 
				new Apple(160, "red"), 
				new Apple(155, "green"));
		
		// sort apples (by weight)
		apples.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		
		for(Apple a: apples) {
			System.out.println(a.getWeight() + " " + a.getColor());
		}
	}
}
