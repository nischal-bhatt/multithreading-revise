import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample2 {

	 private Lock lock1 = new ReentrantLock(true);
	 private Lock lock2 = new ReentrantLock(true);
	 public static void main(String[] args)
	 {
		 DeadLockExample2 de = new DeadLockExample2();
		 new Thread(de::worker1,"worker1").start();
		 new Thread(de::worker2,"worker2").start();
		 
	 }
	 
	 public void worker1() 
	 {
		 lock1.lock();
		 System.out.println("worker1 acquires the lock 1");
		 try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 lock2.lock();
		 System.out.println("worker 1 acauired lock 2");
		 
		 lock1.unlock();
		 lock2.unlock();
	 }
	 
	 public void worker2() 
	 {
		 lock1.lock();
		 System.out.println("worker2 acquires the lock 1");
		 try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 lock2.lock();
		 System.out.println("worker 2 acauired lock 2");
		 
		 lock1.unlock();
		 lock2.unlock();
	 }
}
