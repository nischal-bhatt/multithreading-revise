import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
	private int id ;
	
	public Task(int id)
	{
		this.id = id;
	}
	
	public void run() {
		System.out.println("task with id " + id + "is in work- thread id " + Thread.currentThread().getName());
		long duration = (long)(Math.random() * 5);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class ExecutorServiceExample {

	public static void main(String[] args)
	{
		ExecutorService executor = Executors.newSingleThreadExecutor(); 
		
		for (int i =0; i<5 ; i++)
		{
			executor.execute(new Task(i));
		}
		
		
	}
}
