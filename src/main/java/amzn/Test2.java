package amzn;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Result {
  /*
   * Returns an array with the number of items in each compartments in the string s.
   */
	public List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
		return null;
	}
}

public class Test2 {
  
  private InputStream is;
  private String s = null;
  private List<Integer> startIndices = null; 
  private List<Integer> endIndices = null;
  
  public Test2(InputStream is) {
    this.is = is;
  }

	public static void main(String[] args) {
		Test2 test = new Test2(System.in);
		test.readData();
		test.printData();
		String s = test.getString();
		List<Integer> startIndices = test.getStartIndices();
		List<Integer> endIndices = test.getEndIndices();
		List<Integer> numItems = test.numberOfItems(s, startIndices, endIndices);
		System.out.println("Number of items per compartments:");
		for (int ni: numItems)
		  System.out.println(ni);
	}
	
	public String getString() {
	  return s;
	}
	
	public List<Integer> getStartIndices() {
	  return startIndices;
	}
	
	public List<Integer> getEndIndices() {
	  return endIndices;
	}
	
	/*
	 * Reads and validates the data from standard input.
	 */
	public void readData() {
	  Scanner sc=new Scanner(is);
    s = sc.nextLine(); // string containing the items in compartments 
    
    int n = sc.nextInt(); // number of start indices
    startIndices = new ArrayList<Integer>();
    for (int i = 0; i < n; i++)
      startIndices.add(sc.nextInt());
    
    int m = sc.nextInt(); // number of end indices
    endIndices = new ArrayList<Integer>();
    for (int i = 0; i < m; i++)
      endIndices.add(sc.nextInt());
	}
	/*
   * Returns an array with the number of items in each compartments in the string s.
   */
	public List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
	  List<Integer> numItems = new ArrayList<Integer>();
	  for (int i = 0; i < startIndices.size(); i++) {
	    int start = startIndices.get(i);
	    int end = endIndices.get(i);
	    String t = s.substring(start, end);
	    int numItemsSubstring = numItemsSubstring(t, start, end);
	    numItems.add(numItemsSubstring);
	  }
	  
	  return numItems;
	}
	/*
	 * Finds the number of items in  a compartment.
	 */
	public int numItemsSubstring(String t, int start, int end) {
	  int numItemsSubstring = 0;
	  int numItemsCompart = 0;
    boolean startCompartment = false;
    for (int i = 0; i < t.length(); i++) {
      if (t.charAt(i) == '|' && !startCompartment)
        startCompartment = true;
      for (int j = i + 1; j < t.length(); j++) {
        if(t.charAt(j) == '*' && startCompartment)
          numItemsCompart++;
        else {
          numItemsSubstring += numItemsCompart; 
          numItemsCompart = 0;
          startCompartment = false;
        }
      }
      
    }
	  return numItemsSubstring;
	}
	
	public void printData() {
	  System.out.println("String s = " + s);
	  
	  System.out.println("Start indices:");
	  for (int i: startIndices)
	    System.out.println(i);
	  
	  System.out.println("End indices:");
    for (int i: endIndices)
      System.out.println(i);
	}

}
