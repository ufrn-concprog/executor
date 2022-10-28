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
	/** Delay in seconds prior starting a task */
	private static final int START_DELAY = 5;

	/** Time to periodically execute a task */
	private static final int CYCLE_TIME = 3;

	/**
	 * Main method
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		Runnable task1 = new Task("T1");
		Runnable task2 = new Task("T2");

		ScheduledExecutorService executor =
				Executors.newSingleThreadScheduledExecutor();

		// Execution of the task after 5 seconds
		executor.schedule(task1, START_DELAY, TimeUnit.SECONDS);

		// Execution of the task at each 3 seconds, starting immediately
		executor.scheduleAtFixedRate(task2, 0, CYCLE_TIME,
				TimeUnit.SECONDS);
	}
}
