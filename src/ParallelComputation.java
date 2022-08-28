
public class ParallelComputation {

	public static void main(String[] args)
	{
		//sequential
		System.out.println("hi 1");
		System.out.println("hi 2");
		System.out.println("hi 3");
		System.out.println("hi 4");
		//some tasks cannot at all be done in parallel!
		//parallelization speeds things up
		//can we speed up an application with multithreading - NO!
	    //if the steps are depending on each other - we cannot use parallelization
	}
}

/*
 *  problems with parallelization
 *  1. communication between threads 
 *  2. load balance between processors
 *  3.
 *  4.
 *  5.
 */
