
public class ProblemsWithMemoryManagement {

	public static int counter = 0;
	
	//this method should be called only by 1 thread at a time
	public static synchronized void increment() {
		counter++;
	}
	
	public static void process() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i =0; i<1000; i++)
				{
					counter++;
				    //increment();
				}
				
			}
			
			
		});
		
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i =0; i<1000; i++)
				{
					counter++;
				    //increment();
				}
				
				//toggle between counter++ and increment() to see the difference
			}
			
			
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("the counter is " + counter);
		
	}
	
	public static void main(String[] args)
	{
		//thread has its own stack memory
		//all threads share the heap memory
		//these willl lead to probs when resources are shared
		// among threads 
		
		process();
	
	}
}
