import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader {
	INSTANCE;

	private Semaphore semaphore = new Semaphore(6, true);

	public void download() {
		try {
			semaphore.acquire();
			downloadData();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaphore.release();
		}

	}

	private void downloadData() {
		try {
			
			System.out.println("downloading data from the web .... " + Thread.currentThread().getName());
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

public class Semaphores {

	 public static void main(String[] args)
	 {
		 ExecutorService service = Executors.newCachedThreadPool();
		 for (int i =0; i<12; i++)
		 {
			 service.execute(new Runnable() {

				@Override
				public void run() {
					Downloader.INSTANCE.download();
					
				}
				 
			 });
		 }
	 }
}
