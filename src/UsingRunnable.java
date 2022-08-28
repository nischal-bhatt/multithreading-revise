
class Runner1Runnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Runner 1 Runnable: " + i);
		}

	}
}

class Runner2Runnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Runner 2 Runnable: " + i);
		}

	}
}

public class UsingRunnable {

	public static void main(String[] args) {

		//this is not parallel execution - this is time slicing
		Thread t1 = new Thread(new Runner1Runnable());
		Thread t2 = new Thread(new Runner2Runnable());
		
		t1.start();
		t2.start();
		
	}
}
