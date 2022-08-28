
public class MainClass {

	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("hi");
		
		System.out.println(""
				+ "what is multithreading?\n"
				+ "programming languages are sequential - execute commands on a line by line basis\n"
				+ "initializeArrays()\n"
				+ "downloadStocks()\n"
				+ "initializeTimeSeriesModels()\n"
				+ "makePredictions()\n"
				+ "in SINGLE THREADED APPS - these above will be called 1 by 1 - BLOCKNIG\n"
				+ "another reason for multithreading\n"
				+ "do not freeze an application while data is being downloaded"
				+ "multithreading- ability of cpu to execute multiple processes or threads concurrently\n"
				+ "PROCESS - registers, program counter, stack memory , heap memory\n"
				+ "each thread in a process shares the memory and resources of the process - PROBLEM CREATED!\n"
				+ "time slicing algorithm stuff\n"
				+ "lets say we have a single processor - and k threads\n"
				+ "single processor has to deal with k threads \n"
				+ "processing time for a single core is shared among threads - time slicing\n"
				+ "multithreaded execution is TIME SLICING!\n"
				+ "there is a big difference between multithreading and parallel computing\n"
				+ "Advantages of multithreading\n"
				+ "1.more responsive applications - no need to block\n"
				+ "2.\n"
				+ "3.\n"
				+ "DISADVANTAGES of multithreading"
				+ "1.synchronization issues!\n"
				+ "2.expensive operations\n"
				+ "\n"
				+ "JAVA THREAD LIFE CYCLE!\n"
				+ "NEW - havent  start()\n"
				+ "RUNNABLE - start()\n"
				+ "WAITING - wait() method - thread is waiting for another thread to finish its task - when other thread signals, then this thread goes back to runnable state\n"
				+ "DEAD - after thread finishes its task"
				+ ""
				+ ""
				+ "");
		
		//Thread.sleep(10000);
		System.out.println("done");
	}
}
