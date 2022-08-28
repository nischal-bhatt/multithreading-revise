import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ProcessorCall implements Callable<String> {

	private int id;
	
	public ProcessorCall(int id)
	{
		this.id = id;
	}
	
	@Override
	public String call() throws Exception {
		Thread.sleep(2000);
		return "ID: " + id;
	}

	
	
}

public class App {

	public static void main(String[] args)
	{
		 ExecutorService exec = Executors.newFixedThreadPool(2);
		 List<Future<String>> list = new ArrayList<> ();
		 
		 for (int i =0; i<10 ; i++)
		 {
			Future<String>  future =  exec.submit(new ProcessorCall(i+1) );
		    list.add(future);
		 }
		 
		 for (Future<String> f : list)
		 {
			 try {
				 System.out.println("nish printing");
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}
}
