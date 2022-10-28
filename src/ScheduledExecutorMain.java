import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Demonstration of running tasks with the
 * <code>ScheduledExecutorService</code> interface
 * @see java.util.concurrent.ScheduledExecutorService
 *
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class ScheduledExecutorMain {
	/**
	 * Main method
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		Runnable task = new Task("T");
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
