import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Demonstration of running tasks with the
 * <code>ExecutorService</code> interface
 * @see java.util.concurrent.ExecutorService
 *
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class ExecutorServiceMain {
    /**
     * Main method
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Runnable task = new Task("T");
        java.util.concurrent.ExecutorService executor =
                Executors.newSingleThreadExecutor();
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
            System.out.println("Executor has been finished.");
        }
    }
}
