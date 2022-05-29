package tcp.multi_threading_exe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class User {
	
	
	private static int idCounter =0;
	private final int id;
	private Map<ExpenseCategory, Double> expeneses;
	private List<Expense> expensesHistory;
	

	public User() {
		this.id = idCounter++;
		expeneses = new HashMap<>();
		expensesHistory = new ArrayList<>();
		initializeMapCategory();
	}

	public void runUser() {
		
	}
	
	public void addExpense(Expense expense) {
		expensesHistory.add(expense);
		double currExpense = expeneses.get(expense.getCategory());
		expeneses.put(expense.getCategory(), currExpense + expense.getExpenseAmount());
	}
	
	private void initializeMapCategory() {
		expeneses.put(ExpenseCategory.CLOTHING, 0d);
		expeneses.put(ExpenseCategory.FOOD, 0d);
		expeneses.put(ExpenseCategory.TRANSPORTATION, 0d);
		expeneses.put(ExpenseCategory.UTILITIES, 0d);
	}
	
	public int getId() {
		return id;
	}

	public Map<ExpenseCategory, Double> getTotalExpenses(){
		return expeneses;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", expensesHistory=" + expensesHistory + "]";
	}
	
	
	
}
