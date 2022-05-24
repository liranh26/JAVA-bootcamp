package threadPoolExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Executor_Service {

	static int num = 0;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		/*** creating a new ThreadPoolExecutor by using build in executors ***/
		// the creation is by the factory design
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		executorService.execute(()->System.out.println("JAVA"));

		Future<Integer> future = executorService.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				//...code
				return 5;
			}
			
		});
	
		int num1 = future.get();
		System.out.println(num1);
		
		
		
		
		/*** method of ExecutorService ***/
		
		//invokeAll - invoking a group of callables, and returns a List of Future
		List<Callable<Integer>> callables = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			callables.add(() -> num++);
		}
		
		List<Future<Integer>> futures = executorService.invokeAll(callables);
		
		int sum = 0;
		for (Future<Integer> myFuture : futures) {
			sum+=myFuture.get();
		}
		System.out.println(sum);
//		futures.forEach(x -> sum += x.get());
		
		
		//invokeAny - invokes randomly a future from the results
		//it will runs the list of the task and return one the tasks result that completed
		Integer anyFuture = executorService.invokeAny(callables);
		System.out.println(anyFuture);
	
		executorService.shutdown();
		executorService.awaitTermination(5, TimeUnit.SECONDS);
	
		/*
		 * ScheduledExecutorService is an interface
		 * this is created by factory 
		 */
		final int NUM_THREADS = 3;
		ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(NUM_THREADS);
		
		//in 5 seconds i want to return the value 21
		ScheduledFuture<Integer> scheduledFuture = scheduledService.schedule(()->21, 5, TimeUnit.SECONDS);
		
		System.out.println(scheduledFuture.get());
		
		/*
		 * scheduled fix rate - is executing a task in a fix time 
		 * it doesnt return a future 
		 */
		
		//10 is the start delay, 1 is fix rate
		scheduledService.scheduleAtFixedRate(()->System.out.println("Java"), 
				3, 1, TimeUnit.SECONDS);
		
		//waiting for the printing by the fix rate
		sleep(10000);
		
		scheduledService.shutdown();
		scheduledService.awaitTermination(5, TimeUnit.SECONDS);
		
		
		/*
		 * CachedThreadPool - uses SynchronousQueue
		 * - this pool fits for short limit of tasks because every task is immediately send to a thread
		 *   so for lot of tasks there will be lot of threads.
		 * - So i will choose this pool for small tasks that don't take long of time.
		 * - it is a yaeel ..
		 */
		
		
	}
	
	static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
