
public class ProblemsWithMemoryManagementSynchronizedBlock2 {

	public static int counter = 0;
	
	//this method should be called only by 1 thread at a time
	/*
	 * what happens when you use the synchronized keyword?
	 * 1. every java object (this is entire object level locking) has a monitor lock
	 * 2. a thread that needs exclusive access to an object's fields has to acquire the object's monitor lock
	 * 3. so because of this monitor lock, only 1 thread can execute the increment method at any one time
	 * 4.
	 * 5.
	 * 6.
	 */
	public static  void increment() {
		//always synchronize a block rather than the whole method
		synchronized(ProblemsWithMemoryManagementSynchronizedBlock2.class)
		{
		counter++;
		}
	}
	
	public static void process() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i =0; i<1000; i++)
				{
					counter++;
				   // increment();
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

/*
 * every object has a single monitor lock
 * so even if you have 2 independent synchronized methods,
 * this will cause performance problems! coz slow
 * this is because synchronized causes the entire object to be locked
 */ 
