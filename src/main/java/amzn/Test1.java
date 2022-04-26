/*
 * Run from the command line using the command
 * 
 * $ java -cp "target/classes" amzn.Test1 < src/main/resources/amzn/log1.txt
 * 
 */
package amzn;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Test1 {
  
  class Result {
    /*
     * Complete the 'processLogs' function below.
     * 
     * The function is expected to return a STRING_ARRAY.
     * The function accepts the following parameters:
     * 1) STRING_ARRAY logs
     * 2) Integer threshold
     */
    public List<String> processLogs(List<String> logs, int threshold) {
      
      return null;
    }
    
  }
  
  private int n;
  private int threshold;
  private InputStream is;
  
  public Test1(InputStream is) {
	  this.is = is;
  }
  
  public int getThreshold() {
	  return threshold;
  }
  /*
   * Reads and validates the input data. 
   */
  public List<String> readData() {
	List<String> logs = new ArrayList<String>();
  
    Scanner sc=new Scanner(is);
    n = sc.nextInt();
    if (n < 0 || n > Math.pow(10, 5)) {
      System.err.println("The number of transactions must be positive and not above 10^5.");
      System.exit(1);
    }
      
    int count = 1;
    
    while (count < n + 1) {
      String line = sc.nextLine(); 
      if (line.equals(""))
    	  continue;
      String [] values = line.trim().split(" ");
      for (String value: values) {
        if (!value.matches("^[1-9][0-9]*$")) {
          System.err.println("The values in the transactions must contain only characters in the range ascii['0'-'9'] starting with a non-zero digit.");
          System.exit(1);
        }
        if (value.length() == 0 || value.length() >= 9){
          System.err.println("0 < length of sender_user_id, recipient_user_id and amount_of_transaction <= 9");
          System.exit(1);
        }
      }
          
      logs.add(line);
      count++;
    }
    
    threshold = sc.nextInt();
    if (threshold < 0 || threshold > n) {
	      System.err.println("0 <= threshold <= " + n);
	      System.exit(1);
	}
    sc.close();
    
    return logs;
  }
  /*
   * Counts the number of transactions per user.
   */
  public TreeMap<String, Integer> getUserTransactions(List<String> logs) {
	  TreeMap<String, Integer> transactions = new TreeMap<String, Integer>();
	  for (String log: logs) {
		  String [] values = log.split(" ");
		  String senderId = values[0];
		  String recipientId = values[1];
		  if (transactions.containsKey(senderId)) {
			  int old_value = (int) transactions.get(senderId);
			  transactions.put(senderId, ++old_value);
		  }
		  else
			  transactions.put(senderId, 1);
		  
		  if ( ! recipientId.equals(senderId) ) {
			  if (transactions.containsKey(recipientId)) {
				  int old_value = (int) transactions.get(recipientId);
				  transactions.put(recipientId, ++old_value);
			  }
			  else
				  transactions.put(recipientId, 1);
		  }
			  
	  }
	  return transactions;
  }
  /*
   * Filters the users whose number of transactions are equal or above the threshold.
   */
  public List<String> filterUsers(TreeMap<String, Integer> usersTransact, int threshold) {
	  List<String> filteredUsers = new ArrayList<String>();
	  Set<String> users = usersTransact.keySet();
	  for (String user: users) {
		  int num_transactions = usersTransact.get(user);
		  if (num_transactions >= threshold)
			  filteredUsers.add(user);
	  }
	  // sort the filtered users by num of transactions
	  return filteredUsers;
  }
  
  public static void main(String[] args) {
	  Test1 test = new Test1(System.in);
	  // reads the data
	  List<String> logs = test.readData();
	  System.out.println("Number of entries: " + logs.size());
	  System.out.println("Threshold = " + test.getThreshold());
	  for (String s: logs) 
	      System.out.println(s);  
	  
	  // counts the number of transactions per user
	  TreeMap<String, Integer> transactions = test.getUserTransactions(logs);
	  Set<String> userIds = transactions.keySet();
	  for (String userId: userIds)
		  System.out.println(userId);
	  
	  // filters the users whose number of transactions are equal or above the threshold
	  System.out.println("Users abusing the service:");
	  List<String> users = test.filterUsers(transactions, test.getThreshold());
	  for (String user: users)
		  System.out.println(user);
	  
  }

}
