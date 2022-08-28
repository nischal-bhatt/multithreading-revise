import java.util.concurrent.Exchanger;

class FirstThreadEx implements Runnable {

	private int counter;
	private Exchanger<Integer> exchanger;

	public FirstThreadEx(Exchanger<Integer> ex) {
		this.exchanger = ex;
	}

	@Override
	public void run() {
		while (true) {
			counter++;
			System.out.println("first thread incremented the counter " + counter);
			try {
				counter = exchanger.exchange(counter);
				System.out.println("First thread get the counter " + counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}


class SecondThreadEx implements Runnable {

	private int counter;
	private Exchanger<Integer> exchanger;

	public SecondThreadEx(Exchanger<Integer> ex) {
		this.exchanger = ex;
	}

	@Override
	public void run() {
		while (true) {
			counter--;
			System.out.println("second thread decremented the counter " + counter);
			try {
				counter = exchanger.exchange(counter);
				System.out.println("Second thread get the counter " + counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

public class ExchangerDemo {

	public static void main(String[] args) {

		Exchanger<Integer> exchanger = new Exchanger<>();
		
		FirstThreadEx t1 = new FirstThreadEx(exchanger);
		SecondThreadEx t2 = new SecondThreadEx(exchanger);
		
		new Thread(t1).start();
		new Thread(t2).start();
		
	}
}
