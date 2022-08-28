
class WorkerVolatile implements Runnable {

	//it will be stored in main memory and not in the Thread's cache!
	private volatile boolean terminated;
	
	@Override
	public void run() {
		
		while (!terminated)
		{
			System.out.println("working class is running...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public boolean isTerminated() {
		return terminated;
	}
	
	public void setTerminated(boolean terminated)
	{
		this.terminated = terminated;
	}
	
}

public class VolatileKeyword {

	public static void main(String[] args)
	{
		
		WorkerVolatile wv = new WorkerVolatile();
		
		/*System.out.println("tttt");*/
		/*volatile - read from the RAM*/
		
		Thread t1 = new Thread(wv);
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wv.setTerminated(true);
		
		System.out.println("algo is terminated");
	}
}
