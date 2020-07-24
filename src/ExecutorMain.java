import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorMain {

	public static void main(String[] args) {
		Runnable task = new Task("T", 1);
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(task);
		
		executor.shutdown();
		try {
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("Tasks were interrupted.");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("Tasks will be interrupted.");
			}
			
			executor.shutdownNow();
			System.out.println("Executor was finished.");
		}
	}

}
