package chapter4;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class Restaurant {
  
  public static final List<Dish> menu =
      Arrays.asList( new Dish("pork", false, 800, Dish.Type.MEAT),
                     new Dish("beef", false, 700, Dish.Type.MEAT),
                     new Dish("chicken", false, 400, Dish.Type.MEAT),
                     new Dish("french fries", true, 530, Dish.Type.OTHER),
                     new Dish("rice", true, 350, Dish.Type.OTHER),
                     new Dish("season fruit", true, 120, Dish.Type.OTHER),
                     new Dish("pizza", true, 550, Dish.Type.OTHER),
                     new Dish("prawns", false, 400, Dish.Type.FISH),
                     new Dish("salmon", false, 450, Dish.Type.FISH));

	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant();
		restaurant.processMenu();
		restaurant.printMenu();
		restaurant.extractUniqueChars();
		restaurant.checkVegetarianDishes();
		restaurant.findVegetarianDish();
		restaurant.filterDishes();
		restaurant.groupByType();
	}
	
	public void processMenu() {
		
		List<String> resulStream = menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());

		for(String name: resulStream) {
			System.out.println(name);
		}
	}
	
	public void printMenu() {	
		menu.stream()
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
		if(menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("There are vegetarian dishes in the menu.");
		}	
	}
	
	public void filterDishes() {
	  List<String> lowCaloricDishesName = menu.parallelStream()
                                      	  .filter(d -> d.getCalories() > 400)
                                      	  .sorted(comparing(Dish::getCalories))
                                      	  .map(Dish::getName)
                                      	  .collect(toList());
	  
	  for(String dishName: lowCaloricDishesName) {
      System.out.println(dishName);
    }
	}
	
	public void findVegetarianDish() {
		Optional<Dish> dish = menu.stream()
				.filter(Dish::isVegetarian)
				.findAny();
		
		if(dish.isPresent()) {
			Dish vegetarianDish = dish.get();
			System.out.println(vegetarianDish.getName());
		}
		else 
			System.out.println("There are no vegetarian dishes.");
	}
	
	public void groupByType() {
	  Map<Dish.Type, List<Dish>> dishesByType =
	      menu.stream().collect(Collectors.groupingBy(Dish::getType));
	  
	  for(Dish.Type type: dishesByType.keySet())
	    for(Dish dish:  dishesByType.get(type))
	      System.out.println(type + ": " + dish.getName());
	}

}
