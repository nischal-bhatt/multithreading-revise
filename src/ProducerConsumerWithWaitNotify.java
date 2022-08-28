import java.util.ArrayList;
import java.util.List;

class Processor {
	
	private List<Integer> list = new ArrayList<>();
	private static final int UPPER_LIMIT = 5;
	private static final int LOWER_LIMIT = 0;
	private final Object lock = new Object();
	private int value = 0;
	
	public void producer() throws InterruptedException {

		 synchronized(lock) {
			 
			 while (true)
			 {
				 if (list.size() == UPPER_LIMIT)
				 {
					 System.out.println("waiting for removing item..");
				     lock.wait();
				 }else {
					 System.out.println("adding a new item ..." + value);
				     list.add(value);
				     value++;
				     lock.notify();
				 }
				 Thread.sleep(500);
			 }
			 
		 }
	}

	public void consumer() throws InterruptedException {

 synchronized(lock) {
			 
			 while (true)
			 {
				 if (list.size() == LOWER_LIMIT)
				 {
					 System.out.println("waiting for adding item..");
				     value = 0;
					 lock.wait();
				 }else {
					 System.out.println("removing a new item ..." + list.remove(list.size() - 1));
				    
				     lock.notify();
				 }
				 Thread.sleep(500);
			 }
			 
		 }
		
	}
}

public class ProducerConsumerWithWaitNotify {

	public static void main(String[] args) {

		Processor processor = new Processor();
		Thread t1 = new Thread(new Runnable() {
			 
			public void run()
			{
				try {
					processor.producer();
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
					processor.consumer();
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
