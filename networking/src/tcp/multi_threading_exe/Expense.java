package tcp.multi_threading_exe;

import java.time.LocalDateTime;

public class Expense {

	public ExpenseCategory category;
	public String time;
	public double amount;
	
	public Expense(ExpenseCategory category, LocalDateTime time, double amount) {
		this.category = category;
		this.time = time.toString();
		this.amount = amount;
	}

	public ExpenseCategory getCategory() {
		return category;
	}
	
	public double getExpenseAmount() {
		return amount;
	}
	

	@Override
	public String toString() {
		return "Expense category=" + category + " , time=" + time + " , expense=" + amount ;
	}
	
}
