package chapter1;

import java.util.List;

public class ApplePrinterContext {
	
	private AppleFormatter formatter;
	
	public void setFancyFormatter() {
		this.formatter = new AppleFancyFormatter();
	}
	
	public void setSimpleFormatter() {
		this.formatter = new AppleSimpleFormatter();
	}
	
	public void print(List<Apple> apples) {
		if(formatter != null) {
			for(Apple a: apples) {
				System.out.println(formatter.accept(a));
			}
		}
	}
}
