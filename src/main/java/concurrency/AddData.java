package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AddData {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService service = null;
		
		try {	
			service = Executors.newSingleThreadExecutor();
			Future<Long> result = service.submit(() -> {
				long sum = 0;
		        for (int i = 1; i < 101; i++) {
		            sum += i;
		        }
		        return sum;
			});
			
			System.out.println(result.get());
			
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}
