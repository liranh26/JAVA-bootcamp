package threadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;

public class Runner {

	private static final int KEEP_ALIVE_TIME = 3;
	private static final int CORE_THREADS = 2;
	private static final int MAX_POOL_SIZE = 4;
	private static final int CAPACITY = 2;

	private static final BlockingQueue<Runnable> tasks = new ArrayBlockingQueue<>(CAPACITY);

	public static void main(String[] args) {

		/******* Thread Pools Executor *******/
		// 1. core pool size -> how much threads shall work together
		// 2. max pool size -> if the core pool size is not suficient its possible to
		// add threads until max size
		// 3. keep alive time (timeout) -> the amount of time to wait before terminate
		// if all jobs done and no new jobs entered
		// 4. the unit of the time
		// 5. BlockingQueue -> is an interface which has a lock that checks either the
		// queue is full, queue of runnable objects.
		ThreadPoolExecutor pool = new ThreadPoolExecutor(CORE_THREADS, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
				tasks);

//		//excute method - gets a runnable command
//		pool.execute(()->System.out.println("JAVA THREAD"));
//		// check how much threads are "awake"
//		System.out.println(pool.getPoolSize());
//		
//		//adding more tasks - remember 2 threads are will run if needed and max 4
//		pool.execute(()->System.out.println("JAVA THREAD"));
//		System.out.println(pool.getPoolSize());
//		
//		pool.execute(()->System.out.println("JAVA THREAD"));
//		pool.execute(()->System.out.println("JAVA THREAD"));
//		System.out.println(pool.getPoolSize());

		// lets trigger all 4 threads (max)
		// why 7 has exception and 6 not ?
		// the blocking queue size is 2, and the default threads are 2 and the
		// additional threads(max) is 2
		// so first it runs by the default threads, and then fills the queue -> so 2+2+2
		// = 6
		// more then 6 it rejects the incoming task!
		/*
		 * summary steps: 1. wake core threads -> 2. fill the queue -> 3. wkae up extra
		 * threads -> 4. reject extra execution
		 */
		for (int i = 0; i < 7; i++) {
			try {
				pool.execute(() -> {

					sleep(1000); // at the end of the class, local method to clean the code
					System.out.println("JAVA THREAD , " + Thread.currentThread().getName());

					System.out.println(pool.getPoolSize());
				});
			} catch (RejectedExecutionException e) {
				System.out.println("Task is rejected!");
			}
		}

		// gracefully shutdown method - only after finishing tasks that are in the queue
		// the pool will shutdown
		pool.shutdown();

		
		// Await 
		try {
			pool.awaitTermination(30,  TimeUnit.SECONDS);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		/******* option 2 use constructor to handle rejected exception *******/
		ThreadPoolExecutor pool2 = new ThreadPoolExecutor(CORE_THREADS, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
				TimeUnit.SECONDS, tasks, (Runnable runnable, ThreadPoolExecutor executor) -> { // exception handler
//					runnable.run(); //the main thread will work -> not recommended! 
//					executor.execute(runnable); //force execution until thread will be available
					System.out.println("Rejected task!");
				});

		for (int i = 0; i < 7; i++) {
				pool2.execute(() -> {
					sleep(1000);
					System.out.println("JAVA THREAD , " + Thread.currentThread().getName());
					System.out.println(pool2.getPoolSize());
				});
		}

		// gracefully shutdown method - only after finishing tasks that are in the queue
		// the pool will shutdown
		pool2.shutdown();

		
		
		
		/******* option 3 use constructor with policy to handle rejected exception *******/
		ThreadPoolExecutor pool3 = new ThreadPoolExecutor(CORE_THREADS, 
				MAX_POOL_SIZE, 
				KEEP_ALIVE_TIME,
				TimeUnit.SECONDS, 
				tasks, 
//				new ThreadPoolExecutor.AbortPolicy() // 
//				new ThreadPoolExecutor.DiscardPolicy() //ignore the task rejected
//				new ThreadPoolExecutor.DiscardOldestPolicy() //remove the "oldest" task in the queue and insert the new task
				new ThreadPoolExecutor.CallerRunsPolicy() // keep running until all tasks done
				);
		
		
		
		/***** Callable <V-VALUE> V is the value that is returned *****/
		/* using anynmous function  */
		Callable<Integer> myCallable = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// ...code block
				sleep(1000); //*my method..
				return 4;
			}
		
		};
		
		/****** Submit method - can recieve a callable ******/
		// submit returns a Future - a class that obtains the result of the call
		// Submit is a asynchrony method - it means we move forward in the code BEFORE it finish execution
		Future<Integer> future = pool2.submit(myCallable);
		System.out.println(future); // !-> here we will have not complete becuase we sleep in the call
		try {
			System.out.println(future.get()); // !-> here we wait for the submit task to finish and complete the future.
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		// check if future completed
		future.isDone();
		
		// Cancel - aborts the task and throws an exception of cancellation 
		if(!future.isDone()) {
			future.cancel(false);
		}
		
		Future<?> result = pool.submit(()->{}); //using runnable
		
		/******* Linked Blocking Queue *******/
		//LinkedBlockingQueue is unbounded - no limit for tasks can that be added
		
		BlockingQueue<Runnable> tasks2 = new LinkedBlockingQueue<>();
		
		/******* Synchronous Queue *******/
		//SynchronousQueue doesn't have a capacity, no use in queue, if there is a thread available it executes
		//the tasks will not wait for thread to finish-> if all threads occupied the additional task will throw exception!
		
		BlockingQueue<Runnable> tasks3 = new SynchronousQueue<>();
		
	}

	static void sleep(int time) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
