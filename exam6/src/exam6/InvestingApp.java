package exam6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import exam6.Command.Operation;

public class InvestingApp {

	private double funds = 0;
	private ArrayList<Command> commands;
	private ExecutorService executorService;
	private final int NUM_OF_THREADS = 6;
	private List<Future<Double>> futures;
	private final static double STOCK_INCREASE_VALUE = 0.02;
	private final static double STOCK_DECREASE_VALUE = 0.01;

	public InvestingApp() {
		executorService = Executors.newFixedThreadPool(NUM_OF_THREADS);
		futures = new ArrayList<>();

		System.out.println("--------------------");
		createListCommands();
		System.out.println("Initial Stocks in the DB.");
		printStocks();
		printFunds();
		System.out.println("--------------------");
	}

	public void runApp() {

		Lock lock = new ReentrantLock();
		for (Command command : commands)
			futures.add(executorService.submit(new CallTask(command, lock)));

		updateFundAmount();

		closeExcutor();

		System.out.println("------ End of the tradding day ------");
		printFunds();
		printStocks();
	}

	private void closeExcutor() {
		try {
			executorService.shutdown();
			executorService.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("Something went wrong during termination!");
			e.printStackTrace();
		}
	}

	private void updateFundAmount() {
		futures.stream().forEach(f -> {
			try {
				
				funds += f.get();
				
			} catch (InterruptedException e) {
				System.err.println(e);
			} catch (ExecutionException e) {
				System.err.println(e);
			} catch (NullPointerException e) {
				System.err.println("Cant add value of unkown stock!");
			}
		});
	}

	static class CallTask implements Callable<Double> {
		private Command command;
		private Lock lock;
		Stock stock;

		public CallTask(Command command, Lock lock) {
			this.command = command;
			this.lock = lock;
		}

		@Override
		public Double call() {

			try {
				stock = StocksDB.getStockByName(command.stockName);
			} catch (IllegalArgumentException e) {
				System.err.println("This stock name doesnt exist!");
				return null;
			}

			double price;

			lock.lock();
			if (command.operation == Operation.BUY) {
				price = stock.getBuyPrice();
				stock.setBuyPrice(price + STOCK_INCREASE_VALUE);
			} else {
				price = stock.getSellPrice();
				stock.setSellPrice(price - STOCK_DECREASE_VALUE);
			}
			lock.unlock();

			return price;
		}
	}

	public void printStocks() {
		System.out.println(StocksDB.getStockByName("DOODLE"));
		System.out.println(StocksDB.getStockByName("BARVAZON"));
		System.out.println(StocksDB.getStockByName("HEADBOOK"));
	}

	public void printFunds() {
		System.out.println("The funds value is : " + funds);
	}

	private void createListCommands() {
		commands = new ArrayList<>();
		commands.add(new Command("DOODLE", Operation.BUY));
		commands.add(new Command("DOODLE", Operation.BUY));
		commands.add(new Command("DOODLE", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.SELL));
		commands.add(new Command("HEADBOOK", Operation.SELL));
		commands.add(new Command("HEADBOOK", Operation.SELL));
		commands.add(new Command("HEADBOOK", Operation.SELL));
		commands.add(new Command("BLABLA", Operation.BUY));
	}
}
