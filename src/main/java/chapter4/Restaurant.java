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
		restaurant.threeHighCaloricDishes();
	}
	
	public void processMenu() {
		
		List<String> dishNames = menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());

		System.out.println(dishNames);
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
		
		System.out.println(uniqueChars);
	    
	}
	
	public void checkVegetarianDishes() {
		if(menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("There are vegetarian dishes in the menu.");
		}	
	}
	
	public void filterDishes() {
	  List<String> lowCaloricDishesNames = menu.parallelStream()
                                      	  .filter(d -> d.getCalories() > 400)
                                      	  .sorted(comparing(Dish::getCalories))
                                      	  .map(Dish::getName)
                                      	  .collect(toList());
	  
    System.out.println(lowCaloricDishesNames);
	}
	// use of Optional
	public void findVegetarianDish() {
		Optional<Dish> vegDishes = menu.stream()
				.filter(Dish::isVegetarian)
				.findAny();
		
		if(vegDishes.isPresent()) // the stream contains a dish
			System.out.println(vegDishes.get().getName());
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
	
	public void threeHighCaloricDishes() {
	  List<String> threeHighCaloricDishNames =
	    menu.stream()
	    .filter(dish -> dish.getCalories() > 300)
	    .map(Dish::getName)
	    .limit(3)
	    .collect(toList());
	  System.out.println(threeHighCaloricDishNames);
	}

}
