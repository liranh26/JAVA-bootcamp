package forkJoinPool;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	// making the task recursive

	static int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// use fork join pool
		// By defualt the number of threads is the max tas can (cores of computer)
		ForkJoinPool pool = new ForkJoinPool(2);

		// execute Method -
//		pool.execute(new RecursiveIncrementTask(0, arr.length)); // triggers the compute method

		// if we would like the recursive call to return a value
		Lock lock = new ReentrantLock();
		Future<Double> future = pool.submit(new Recursivevalue(0, arr.length, lock));

		Double sum = future.get();
		// Lets imagine we want to add 1 to the array values

		pool.shutdown();
		pool.awaitTermination(5, TimeUnit.SECONDS);

		System.out.println(Arrays.toString(arr));
		System.out.println("The sum is : " + sum);
	}

//	RecursiveTask can return back a value ..
	static class Recursivevalue extends RecursiveTask<Double> {

		private static final int NUM_ELEMENTS = 3;
		private final int left; // indexes of the array
		private final int right;
		private double sum = 0;
		private Lock lock;

		public Recursivevalue(int left, int right, Lock lock) {
			this.left = left;
			this.right = right;
			this.lock = lock;
		}

		@Override
		protected Double compute() {

			if (right - left <= NUM_ELEMENTS - 1) {
				// 2. solving the small problem
				for (int i = left; i < right; i++) {
					sum += arr[i];
				}
				return sum;

			} else {
				int mid = (left + right) / 2; // middle index

				Recursivevalue leftTask = new Recursivevalue(left, mid, lock);
				Recursivevalue rightTask = new Recursivevalue(mid, right, lock);

				// taking the thread for the next call -> create 2 threads "fork"
				leftTask.fork();
				rightTask.fork();

				// thread need to return a value we need to join them (return back the threads)
				return leftTask.join() + rightTask.join();
			}

		}

	}

	// RecursiveAction extends the ForkJoinPool
	static class RecursiveIncrementTask extends RecursiveAction {

		private static final int NUM_ELEMENTS = 3;
		private final int left; // indexes of the array
		private final int right;

		public RecursiveIncrementTask(int left, int right) { // no need for the array because its static
			this.left = left;
			this.right = right;
		}

		@Override
		protected void compute() {
			// 3 todos when implementing a recursive task

			// 1. stopping condition
			// our stop condition is when we reach to a single value element
			if (right - left <= NUM_ELEMENTS - 1) {
				// 2. solving the small problem
				for (int i = left; i < right; i++) {
					arr[i]++;
				}
			} else {
				// 3. decreasing the input size and recursive call
				int mid = (left + right) / 2; // middle index

				RecursiveIncrementTask leftTask = new RecursiveIncrementTask(left, mid);
				RecursiveIncrementTask rightTask = new RecursiveIncrementTask(mid, right);

				// taking the thread for the next call -> create 2 threads "fork"
				leftTask.fork();
				rightTask.fork();

				// option 2
//				invokeAll(leftTask, rightTask);

			}

		}
	}

	static void sleep(int time) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
