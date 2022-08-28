import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriterArrayDemo {

	private List<Integer> list;
	
	public CopyOnWriterArrayDemo ()
	{
		this.list = new CopyOnWriteArrayList<>();
		this.list.addAll(Arrays.asList(0,0,0,0,0,0,0,0,0,0));
		
	}
	
	public void simulate() {
		Thread t1 = new Thread(new WriteTask(list));
		Thread t2 = new Thread(new WriteTask(list));
		Thread t3 = new Thread(new WriteTask(list));
		Thread t4 = new Thread (new ReadTask(list));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	
	public static void main(String[] args) {
		CopyOnWriterArrayDemo a = new CopyOnWriterArrayDemo();
		a.simulate();
	}
}
