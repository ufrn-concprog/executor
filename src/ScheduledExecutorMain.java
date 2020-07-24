import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorMain {

	public static void main(String[] args) {
		Runnable task = new Task("T", 1);
		ScheduledExecutorService executor =
			Executors.newSingleThreadScheduledExecutor();
		
		ScheduledFuture<?> result = 
			executor.schedule(task, 5, TimeUnit.SECONDS);
		result = executor.scheduleAtFixedRate(task, 0, 3, TimeUnit.SECONDS);
		try {
			System.out.println(result.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
