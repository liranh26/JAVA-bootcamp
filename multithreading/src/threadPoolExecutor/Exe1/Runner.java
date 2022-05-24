package threadPoolExecutor.Exe1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class Runner {

	private static final int KEEP_ALIVE_TIME = 2;
	private static final int CORE_THREADS = 4;
	private static final int MAX_POOL_SIZE = 6;

	/******* Linked Blocking Queue *******/
	// LinkedBlockingQueue is unbounded - no limit for tasks can that be added
	private static BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();

	public static void main(String[] args) {

		HashMap<String, Integer> wordsAppearance = new HashMap<>();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(CORE_THREADS, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
				tasks,
				new ThreadPoolExecutor.CallerRunsPolicy()
				);

		Lock lock = new ReentrantLock();
		File file = new File("myFiles/alice.txt");

		try (Scanner sc = new Scanner(file)) {

			while (sc.hasNext()) {
				String sentence = sc.nextLine().replaceAll("[.,-,',`,\",:,=]", "");
				String[] words = sentence.split(" ");
				pool.submit(new ThreadTask(words, lock, wordsAppearance));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		pool.shutdown();

		try {
			pool.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println(wordsAppearance);

	}

	static class ThreadTask implements Runnable {

		private String[] words;
		private Lock lock;
		private HashMap<String, Integer> wordsAppearance;

		public ThreadTask(String[] words, Lock lock, HashMap<String, Integer> wordsAppearance) {
			this.words = words;
			this.lock = lock;
			this.wordsAppearance = wordsAppearance;
		}
		
		@Override
		public void run() {
			lock.lock();
			for (String word : words) {
				
				if (wordsAppearance.containsKey(word))
					wordsAppearance.put(word, wordsAppearance.get(word).intValue() + 1);
				else
					wordsAppearance.put(word, 1);
			}
			lock.unlock();
		}
	}
	
//	private static boolean containOnlyChars(String word) {
//		return word.chars().allMatch(Character::isLetter);
//	}

	
}

