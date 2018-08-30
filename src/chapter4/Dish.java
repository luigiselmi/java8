package chapter4;

import java.util.Arrays;
import java.util.List;

public class Dish {

	private final String name;
	private final boolean vegetarian;
    private final int calories;
    private final String type;
    
    public Dish(String name,
    		boolean vegetarian,
    		int calories,
    		String type) {
    	
    	this.name = name;
    	this.vegetarian = vegetarian;
    	this.calories = calories;
    	this.type = type;
    }
    
    public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public String getType() {
		return type;
	}
	
	public static final List<Dish> menu =
            Arrays.asList( new Dish("pork", false, 800, "MEAT"),
                           new Dish("beef", false, 700, "MEAT"),
                           new Dish("chicken", false, 400, "MEAT"),
                           new Dish("french fries", true, 530, "OTHER"),
                           new Dish("rice", true, 350, "OTHER"),
                           new Dish("season fruit", true, 120, "OTHER"),
                           new Dish("pizza", true, 550, "OTHER"),
                           new Dish("prawns", false, 400, "FISH"),
                           new Dish("salmon", false, 450, "FISH"));
    
}
