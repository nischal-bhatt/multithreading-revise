
class DaemonWorkerExample implements Runnable {

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("daemon thread is running...");
		}
	}
}

class NormalWorkerExample implements Runnable {

	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
				break;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("normal thread finishes execution...");
	    //when normal thread finishes execution, daemon also dies
	}
}

public class DaemonWorker {

	public static void main(String[] args) {
		Thread t1 = new Thread(new DaemonWorkerExample());
		Thread t2 = new Thread(new NormalWorkerExample());
		t1.setDaemon(true);
		t1.start();
		t2.start();

		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main thread exiting");
	}
}
