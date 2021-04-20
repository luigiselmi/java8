package chapter6;

import static java.util.Comparator.comparingInt;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;
import chapter4.Dish;
import chapter4.Restaurant;

public class CollectorExamples {

	public enum CaloricLevel {DIET, NORMAL, FAT};
	
	public static void main(String[] args) {
		CollectorExamples examples = new CollectorExamples();
		examples.mostCaloricDish();
		examples.totalCalories();
		examples.averageCalories();
		examples.summaryStatistics();
		examples.groupDishesByType();
		examples.groupDishesByCaloricLevel();
		examples.groupDishesByTypeAndCaloricLevel();
		examples.partitionVegetarianDishes();
	}

	// reducing elements from a stream
	// finding maximum in a stream 
	public void mostCaloricDish() {
		Comparator<Dish> dishCaloriesComparator = comparingInt(Dish::getCalories);
		Optional<Dish> mostCaloricDish = Restaurant.menu.stream()
				.collect(maxBy(dishCaloriesComparator));
		
		System.out.println("Most caloric dish: " + mostCaloricDish.get().getCalories());
	}
	
	// summarization 
	public void totalCalories() {
		int totalCalories = Restaurant.menu.stream().
				collect(summingInt(Dish::getCalories));
		
		System.out.println("Total calories: " + totalCalories);
	}
	
	// averaging
	public void averageCalories() {
		double averageCalories = Restaurant.menu.stream()
				.collect(averagingInt(Dish::getCalories));
		
		System.out.println("Average calories: " + averageCalories);
	}
	
	public void summaryStatistics() {
		IntSummaryStatistics menuStats = Restaurant.menu.stream()
				.collect(summarizingInt(Dish::getCalories));
		
		System.out.println("Statistics: " + menuStats);
	}
	// grouping elements from a stream
	public void groupDishesByType() {
		Map<Dish.Type, List<Dish>> dishesByType = Restaurant.menu.stream()
				.collect(groupingBy(Dish::getType));
		
		for(Dish.Type key: dishesByType.keySet()) {
			System.out.println("Type: " + key);
			for(Dish dish: dishesByType.get(key)) {
				System.out.println("  Dish: " + dish.getName());
			}
		}
	}
	
	public void groupDishesByCaloricLevel() {
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Restaurant.menu.stream()
				.collect(
				    groupingBy(dish -> {
				      if (dish.getCalories() <= 400) return CaloricLevel.DIET;
		          else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
		          else return CaloricLevel.FAT;
		        } 
				));
		
		for(CaloricLevel key: dishesByCaloricLevel.keySet()) {
			System.out.println("Caloric level: " + key);
			for(Dish dish: dishesByCaloricLevel.get(key)) {
				System.out.println("  Dish: " + dish.getName());
			}
		}
	}
	// multilevel grouping
	public void groupDishesByTypeAndCaloricLevel() {
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeAndCaloricLevel = Restaurant.menu.stream()
				.collect(
				    groupingBy(Dish::getType, 
				        groupingBy(dish -> {
				          if (((Dish) dish).getCalories() <= 400) return CaloricLevel.DIET;
		              else if (((Dish) dish).getCalories() <= 700) return CaloricLevel.NORMAL;
		              else return CaloricLevel.FAT;
		            })
		        )
		    );
		
		for(Dish.Type type: dishesByTypeAndCaloricLevel.keySet()) {
			System.out.println("Type: " + type);
			for(CaloricLevel level: dishesByTypeAndCaloricLevel.get(type).keySet()) {
				System.out.println("  Caloric level: " + level);
				for(Dish dish: dishesByTypeAndCaloricLevel.get(type).get(level)) {
					System.out.println("    Dish: " + dish.getName());
				}
			}
		}
	}
	
	// partitioning (i.e splitting elements in two groups)
	public void partitionVegetarianDishes() {
	  Map<Boolean, List<Dish>> partitionedMenu = Restaurant.menu.stream()
	    .collect(partitioningBy(Dish::isVegetarian));
	  System.out.println(partitionedMenu);
	}
}
