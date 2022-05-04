package hr.test11;

public class Result {
  public static String timeConversion(String s) {
    StringBuilder mil_time = new StringBuilder();
    int hour = Integer.parseInt(s.substring(0, 2));
    String period = s.substring(s.length() - 2, s.length());
    String invariant = s.substring(2, s.length() - 2);
    
    if (period.equals("AM")) {
      hour %= 12;
      if (hour < 10)
        mil_time.append("0");
      mil_time.append(hour);
    }
    else {
      hour += 12;
      if (hour == 24)
        hour = 12;
      if (hour < 10)
        mil_time.append("0");
      mil_time.append(hour);
    }
    
    mil_time.append(invariant);
    
    return mil_time.toString();
  }
}
