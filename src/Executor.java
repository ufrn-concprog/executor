import java.util.concurrent.Executors;

/**
 * Demonstration of running tasks with the
 * <code>Executor</code> interface
 * @see java.util.concurrent.Executor
 *
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class Executor {
	/**
	 * Main method
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		Runnable task = new Task("T");
		java.util.concurrent.Executor executor =
				Executors.newSingleThreadExecutor();
		executor.execute(task);
	}
}
