import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class StockMarketUpdater implements Runnable {
	public void run()
	{
		System.out.println("updating and downloading stock related data from the web ... ");
		
		
	}
}

public class ExecutorServiceExample3 {

	public static void main(String[] args)
	{
		ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
		
		exec.scheduleAtFixedRate(new StockMarketUpdater(), 1000, 2000, TimeUnit.MILLISECONDS);
		
		
		
	}
}
