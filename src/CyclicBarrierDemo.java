import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CyclicBarrierWorker implements Runnable{

	private int id;
	private Random random;
	private CyclicBarrier barrier;
	
	public CyclicBarrierWorker(int id, CyclicBarrier barrier)
	{
		this.id = id;
		this.random = new Random();
		this.barrier= barrier;
	}
	
	@Override
	public void run() {
		doWork();
		
	}

	private void doWork() {
		System.out.println("Thread with id " + this.id + "starts the work ...");
		try {
			Thread.sleep(random.nextInt(3000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("after the await");
	}
	
}

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		
		ExecutorService executors
		= Executors.newFixedThreadPool(5);
		
		CyclicBarrier b = new CyclicBarrier(5, new Runnable() {

			@Override
			public void run() {
				System.out.println("all tasks have been completed....");
				
			}
			
			
		});
		
		for (int i =0; i< 5; i++)
		{
			executors.execute(new CyclicBarrierWorker(i+1, b));
		}
		
		executors.shutdown();
		
	}
}
