package hr.test7;

public class Result {
  public static int pageCount(int n, int p) {
    int odd_page = 0, even_page = 0;
    
    int page_count_front = 0;
    for (; page_count_front < p;) {
      odd_page = 2 * page_count_front + 1;
      even_page = 2 * page_count_front;
      if (odd_page == p || even_page == p)
        break;
      page_count_front++;
    }
    
    int page_count_back = 0;
    for (; page_count_back < p;) {
      if (n % 2 == 0) {
        odd_page = n - 2 * page_count_back - 1;
        even_page = n - 2 * page_count_back;
      }
      else {
        odd_page = n - 2 * page_count_back;
        even_page = n - 2 * page_count_back - 1;
      }
      if (odd_page == p || even_page == p)
        break;
      page_count_back++;
    }
    
    int page_count = Math.min(page_count_front, page_count_back);
    
    return page_count;
  }
}
