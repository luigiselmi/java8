package chapter1;

import java.util.Arrays;
import java.util.List;

public class ApplePrinter {

	public static void main(String[] args) {
		
		List<Apple> apples = Arrays.asList(
				new Apple(80, "green"), 
				new Apple(160, "red"), 
				new Apple(155, "green"));
		
		ApplePrinterContext context = new ApplePrinterContext();
		
		context.setFancyFormatter();
		context.print(apples);
		
		context.setSimpleFormatter();
		context.print(apples);
	}

}
