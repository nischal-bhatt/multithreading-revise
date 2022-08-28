import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TaskF implements Runnable {
	private int id ;
	
	public TaskF(int id)
	{
		this.id = id;
	}
	
	public void run() {
		System.out.println("task with id " + id + "is in work- thread id " + Thread.currentThread().getId());
		long duration = (long)(Math.random() * 5);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

public class ExecutorServiceExample2 {

	public static void main(String[] args)
	{
		ExecutorService executor = Executors.newFixedThreadPool(5); 
		
		for (int i =0; i<100 ; i++)
		{
			executor.execute(new TaskF(i+1));
		}
		
		//we prevent the executor to execute any further tasks 
		executor.shutdown();
		
		//terminate actual running tasks
		
		try {
			if (!executor.awaitTermination(1000, TimeUnit.MILLISECONDS))
			{
				//executor.shutdownNow();
			}
		}catch (InterruptedException e)
		{
			executor.shutdownNow();
		}
		
	}
}
