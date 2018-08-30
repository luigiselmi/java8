package chapter4;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class StreamDishes {

	public static void main(String[] args) {
		
		StreamDishes dishes = new StreamDishes();
		dishes.processMenu();
		dishes.printMenu();
		dishes.extractUniqueChars();
		dishes.checkVegetarianDishes();
		dishes.findVegetarianDish();
	}
	
	public void processMenu() {
		
		List<String> resulStream = Dish.menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());

		for(String name: resulStream) {
			System.out.println(name);
		}
	}
	
	public void printMenu() {	
		Dish.menu.stream()
			.map(Dish::getName)
			.forEach(System.out::println);
	}
	
	public void extractUniqueChars() {
		List<String> words =
	            Arrays.asList("Qui", "Quo", "Qua");
		
		List<String> uniqueChars = words.stream()
				.map(word -> word.split("")) // creates arrays of chars
				.flatMap(Arrays::stream) // transforms the arrays in streams, then flatten them in one single stream
				.distinct()
				.collect(toList());
		
		for(String uniqueChar: uniqueChars) {
			System.out.println(uniqueChar);
		}
	    
	}
	
	public void checkVegetarianDishes() {
		if(Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("There are vegetarian dishes in the menu.");
		}	
	}
	
	public void findVegetarianDish() {
		Optional<Dish> dish = Dish.menu.stream()
				.filter(Dish::isVegetarian)
				.findAny();
		
		if(dish.isPresent()) {
			Dish vegetarianDish = dish.get();
			System.out.println(vegetarianDish.getName());
		}
		else 
			System.out.println("There are no vegetarian dishes.");
	}

}
