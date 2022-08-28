import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class MapFirstWorker implements Runnable {

	private ConcurrentMap<String, Integer> map;

	public MapFirstWorker(ConcurrentMap<String, Integer> map) {
		this.map = map;
	}

	@Override
	public void run() {
		
		try {
			map.put("B", 12);
			Thread.sleep(1000);
			map.put("Z", 5);
			map.put("A", 25);
			Thread.sleep(2000);
			map.put("D", 19);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class MapSecondWorker implements Runnable {

	private ConcurrentMap<String, Integer> map;

	public MapSecondWorker(ConcurrentMap<String, Integer> map) {
		this.map = map;
	}

	@Override
	public void run() {
		
		try {
			Thread.sleep(5000);
		System.out.println(map.get("A"));
		Thread.sleep(2000);
		System.out.println(map.get("Z"));
		System.out.println(map.get("B"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

public class ConcurrentMapsExample {

	public static void main(String[] args) {

		ConcurrentMap<String,Integer> map = new ConcurrentHashMap<String,Integer>();
	
		MapFirstWorker f = new MapFirstWorker(map);
		MapSecondWorker r = new MapSecondWorker(map);
		
		
		new Thread(f).start();
		new Thread(r).start();
		
		
		
		
		
	}
}
