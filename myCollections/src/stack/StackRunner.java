package stack;

public class StackRunner {

	public static void main(String[] args) {
		
		// -------------------------------------------------------------------//
		// new Stack - basic operation. 
		// stack uses LIFO (last-in first-out) ordering.
		// -------------------------------------------------------------------//
		MyStack<Integer> stack = new MyStack<Integer>(9);
		
		stack.push(2);
		stack.push(7);
		stack.push(5);
		stack.push(1);
		
		System.out.println("First item is: " + stack.peek());
		Integer item = stack.pop();
		System.out.println("After poping item: "+item+" the first item is: " + stack.peek());
		
		System.out.println("Is stack empty? " + stack.isEmpty());
		
		int i=0;
		while(stack.top != null) {
			System.out.println("Item "+i+" in stack is: " + stack.pop());
			i++;
		}
	}

}
