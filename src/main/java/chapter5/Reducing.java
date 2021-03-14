package chapter5;

import java.util.Arrays;
import java.util.List;

public class Reducing {

	public static void main(String[] args) {
		Reducing redux = new Reducing();
		System.out.println("sum = " + redux.sumIntegers());
		System.out.println("max = " + redux.maxNumber());

	}
	
	public int sumIntegers() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int sum = numbers.stream()
				.reduce(0, (accumulator, next) -> accumulator + next);
		return sum;
	}
	
	public int maxNumber() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int max = numbers.stream()
				.reduce(1, (a, b) -> a > b ? a : b); 
		return max;
	}

}
