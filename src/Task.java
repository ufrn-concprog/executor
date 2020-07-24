import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	
	private String id;
	private long time;
	
	public Task(String id, long time) {
		this.id = id;
		this.time = time;
	}

	@Override
	public void run() {
		System.out.println("Thread " + id + " executing");
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
