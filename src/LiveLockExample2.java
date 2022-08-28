import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLockExample2 {

	private Lock lock1 = new ReentrantLock(true);
	private Lock lock2 = new ReentrantLock(true);

	public static void main(String[] args) {
		LiveLockExample2 de = new LiveLockExample2();
		new Thread(de::worker1, "worker1").start();
		new Thread(de::worker2, "worker2").start();

	}

	public void worker1() {
		while (true) {
			try {
				lock1.tryLock(50, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("worker 1 acquires lock 1...");

			System.out.println("worker 1 tries to get lock 2 ....");

			if (lock2.tryLock()) {
				System.out.println("Worker 1 acquires lock 2");
                lock2.unlock();
			} else {
				System.out.println("worker 1 can not acquire lock 2");
			    
			    continue;
			}
			break;
		}

		lock1.unlock();
		lock2.unlock();
	}

	public void worker2() {
		while (true) {
			try {
				lock2.tryLock(50, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("worker 2 acquires lock 2...");

			System.out.println("worker 2 tries to get lock 1 ....");

			if (lock1.tryLock()) {
				System.out.println("Worker 2 acquires lock 1");
				lock1.unlock();

			} else {
				System.out.println("worker 2 can not acquire lock 1");
			   
			    continue;
			}
			break;
		}

		//solution - avoid cyclic dependency!

		lock1.unlock();
		lock2.unlock();
	}
}
