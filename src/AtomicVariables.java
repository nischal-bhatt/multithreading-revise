import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariables {

	//private static int counter = 0;

	private static AtomicInteger counter = new AtomicInteger(0);
	//under the hood, atomicInteger uses low level synchronization
	
	public static void main(String[] args) {
		AtomicVariables atomicVariables = new AtomicVariables();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				increment();

			}

		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				increment();

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
		
		
		System.out.println(counter);
	}

	public static void increment() {
		for (int i = 0; i < 10000; i++) {

			counter.getAndIncrement();
		}
	}
}
