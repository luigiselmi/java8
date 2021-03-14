package chapter1;

public class AppleSimpleFormatter implements AppleFormatter {

	@Override
	public String accept(Apple a) {
		return "Weight: " + a.getWeight() + " color: " + a.getColor();
	}

}
