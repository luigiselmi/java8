package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import chapter1.Apple;

public class AppleFiltering {

	public static void main(String[] args) {
		List<Apple> apples = Arrays.asList(
				new Apple(80, "green"), 
				new Apple(160, "red"), 
				new Apple(155, "green"));
		
		// Filter red apples
		List<Apple> redApples = filter(apples, 
				(Apple apple) -> "red".equals(apple.getColor()));
		for(Apple a: redApples) {
			System.out.println(a.getColor() + " " + a.getWeight());
		}
		
		// Filter heavy apples
		List<Apple> heavyApples = filter(apples, 
				(Apple apple) -> apple.getWeight() > 150);
		for(Apple a: heavyApples) {
			System.out.println(a.getWeight() + " " + a.getColor());
		}

	}
	
	public static List<Apple> filter(List<Apple> apples, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple: apples) {
			if(p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}
