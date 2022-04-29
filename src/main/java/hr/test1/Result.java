package hr.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Result {
  public static List<String> processLogs(List<String> logs, int threshold) {
    TreeMap<String, Integer> transactions = getUserTransactions(logs);
    List<String> users = filterUsers(transactions, threshold);
    return users;
  }
  /*
   * Counts the number of transactions per user.
   */
  private static TreeMap<String, Integer> getUserTransactions(List<String> logs) {
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
  private static List<String> filterUsers(TreeMap<String, Integer> usersTransact, int threshold) {
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
}
