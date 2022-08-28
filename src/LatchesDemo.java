import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerLatch implements Runnable {

	private int id;
	private CountDownLatch latch;
	
	public WorkerLatch(int id,CountDownLatch latch)
	{
		this.id  = id;
		this.latch = latch;
	}
	
	
	@Override
	public void run() {
		doWork();
		latch.countDown();
		
	}


	private void doWork() {
		try {
			System.out.println("Thread with id " + this.id + " starts working");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

public class LatchesDemo {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(5);
		//if the above number is more than 5, app will freeze
		ExecutorService service 
		       = Executors.newSingleThreadExecutor();
		
		for (int i =0; i<5; i++)
		{
			service.execute(new WorkerLatch(i,latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All tasks have been finished..");
		service.shutdown();
	}
}
