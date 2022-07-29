package stack;

import java.util.EmptyStackException;

public class MyStack <T>{
	
	@SuppressWarnings("hiding")
	private class StackNode<T>{
		StackNode<T> next;
		T data;
		StackNode(T d){
			this.data = d;
		}
	}
	
	StackNode<T> top;

	MyStack(T d){
		StackNode<T> node = new StackNode<>(d);
		top = node;
	}
	
	T pop() {
		if(top == null)
			throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		return item;
	}
	
	void push(T item) {
		StackNode<T> node = new StackNode<>(item);
		node.next = top;
		top = node;
	}
	
	boolean isEmpty() {
		return top == null;
	}
	
	T peek() {
		return top.data;
	}
	
	
}
