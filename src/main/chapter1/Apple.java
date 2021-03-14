package chapter1;

import java.util.Comparator;

public class Apple implements Comparable<Apple> {
	
	private String color;
	private Integer weight;
	
	public Apple(int weight, String color) {
		this.weight = weight;
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Apple a) {
		
		return weight.compareTo(a.weight);
	}
}
