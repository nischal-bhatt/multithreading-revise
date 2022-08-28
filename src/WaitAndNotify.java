class Process {
	public void produce() throws InterruptedException 
	{
		synchronized(this) {
			System.out.println("running the produce method..");
			wait();
			System.out.println("again in the produce method..");
		}
	}
	
	public void consume() throws InterruptedException 
	{
		Thread.sleep(1000);
		
		synchronized(this) {
			System.out.println("consume method is executed");
			notify();
			//it is not going to notify immediately, we can make further operations
			Thread.sleep(5000);
		}
	}
	
	
}
public class WaitAndNotify {
  //wait() --> will release the lock
	
	
	
	public static void main(String[] args)
	{
		Process process = new Process();
		Thread t1 = new Thread(new Runnable() {
			 public void run()
			 {
				 try {
					process.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		});
		
		Thread t2 = new Thread(new Runnable() {
			 public void run()
			 {
				 try {
					process.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		});
		
		
		t1.start();
		t2.start();
	}
}
