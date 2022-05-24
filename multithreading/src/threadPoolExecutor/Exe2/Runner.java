package threadPoolExecutor.Exe2;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Runner {

	public static void main(String[] args) throws InterruptedException {

		int javaCounter = 0;

		URLConnection connection = connectToURL();
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		try (Scanner scanner = new Scanner(connection.getInputStream())) {

			while (scanner.hasNext()) {

				String line = scanner.nextLine();

				Future<Integer> future = executorService.submit(new CallTask(line));

				try {
					javaCounter += future.get();

				} catch (ExecutionException e) {
					e.printStackTrace();
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		executorService.shutdown();
		executorService.awaitTermination(5, TimeUnit.SECONDS);

		System.out.println("Num of time java appears: " + javaCounter);

	}

	static class CallTask implements Callable<Integer> {

		private String line;
		private int javaCounter = 0;

		public CallTask(String line) {
			this.line = line.toLowerCase();
		}

		@Override
		public Integer call() throws Exception {
			String[] words = line.split(" ");
			for (int i = 0; i < words.length; i++) {
				if (words[i].equals("java")) {
					javaCounter++;
				}
			}

			return javaCounter;
		}
	}

	static URLConnection connectToURL() {
		URLConnection connection = null;
		try {
			connection = new URL("https://en.wikipedia.org/wiki/Java_(programming_language)").openConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return connection;
	}

}
