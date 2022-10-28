import java.util.concurrent.TimeUnit;

/**
 * Implementation of the task to be executed by a thread
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class Task implements Runnable {
	/** Task ID */
	private final String id;

	/**
	 * Parameterized constructor
	 * @param id Task ID
	 */
	public Task(String id) {
		this.id = id;
	}

	/** Task statements */
	@Override
	public void run() {
		System.out.println("Task " + id + " executing");
	}
}
