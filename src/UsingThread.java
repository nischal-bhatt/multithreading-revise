
class Runner1Thread extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Runner 1 Thread: " + i);
		}
	}
}

class Runner2Thread extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Runner 2 Thread: " + i);
		}
	}
}

public class UsingThread {

	public static void main(String[] args)
	{
         Thread t1 = new Runner1Thread();	
	     Thread t2 = new Runner2Thread();
	     
	     t1.start();
	     t2.start();
	     
	     try {
			t1.join();
			//t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     
	     System.out.println("Threads finished");
	}
	
}
