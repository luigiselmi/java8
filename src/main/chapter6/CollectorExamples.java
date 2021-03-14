package chapter6;

import static java.util.Comparator.comparingInt;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static java.util.stream.Collectors.*;
import chapter4.Dish;

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
	}

	public void mostCaloricDish() {
		Comparator<Dish> dishCaloriesComparator = comparingInt(Dish::getCalories);
		Optional<Dish> mostCaloricDish = Dish.menu.stream()
				.collect(maxBy(dishCaloriesComparator));
		
		System.out.println("Most calories: " + mostCaloricDish.get().getCalories());
	}
	
	public void totalCalories() {
		int totalCalories = Dish.menu.stream().
				collect(summingInt(Dish::getCalories));
		
		System.out.println("Total calories: " + totalCalories);
	}
	
	public void averageCalories() {
		double averageCalories = Dish.menu.stream()
				.collect(averagingInt(Dish::getCalories));
		
		System.out.println("Average calories: " + averageCalories);
	}
	
	public void summaryStatistics() {
		IntSummaryStatistics menuStats = Dish.menu.stream()
				.collect(summarizingInt(Dish::getCalories));
		
		System.out.println("Statistics: " + menuStats);
	}
	
	public void groupDishesByType() {
		Map<String, List<Dish>> dishesByType = Dish.menu.stream()
				.collect(groupingBy(Dish::getType));
		
		for(String key: dishesByType.keySet()) {
			System.out.println("Type: " + key);
			for(Dish dish: dishesByType.get(key)) {
				System.out.println("Dish: " + dish.getName());
			}
		}
	}
	
	public void groupDishesByCaloricLevel() {
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Dish.menu.stream()
				.collect(
		                groupingBy(dish -> {
		                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
		                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
		                    else return CaloricLevel.FAT;
		                } ));
		
		for(CaloricLevel key: dishesByCaloricLevel.keySet()) {
			System.out.println("Caloric level: " + key);
			for(Dish dish: dishesByCaloricLevel.get(key)) {
				System.out.println("Dish: " + dish.getName());
			}
		}
	}
	
	public void groupDishesByTypeAndCaloricLevel() {
		Map<String, Map<CaloricLevel, List<Dish>>> dishesByTypeAndCaloricLevel = Dish.menu.stream()
				.collect(
		                groupingBy(Dish::getType, 
		                		groupingBy(dish -> {
		                			if (dish.getCalories() <= 400) return CaloricLevel.DIET;
		                			else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
		                			else return CaloricLevel.FAT;
		                		})
		                )
		         );
		
		for(String type: dishesByTypeAndCaloricLevel.keySet()) {
			System.out.println("Type: " + type);
			for(CaloricLevel level: dishesByTypeAndCaloricLevel.get(type).keySet()) {
				System.out.println("Caloric level: " + level);
				for(Dish dish: dishesByTypeAndCaloricLevel.get(type).get(level)) {
					System.out.println("Dish: " + dish.getName());
				}
			}
		}
	}
}
