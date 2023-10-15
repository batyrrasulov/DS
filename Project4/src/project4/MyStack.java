package project4;

import java.util.ArrayList;

public class MyStack<T> {
	private ArrayList<T> stack;
	// constructor to initialize the stack
	public MyStack(){
		stack = new ArrayList<T>();
	}
	// push a new element onto the stack
	public void push(T v) {
		stack.add(0, v);
	}
	// get the size of the stack
	public int size() {
		// returns the number of elements in the stack
		return stack.size();
	}
	// check if the stack is empty
	public boolean empty() {
		// returns true if the stack is empty
		return stack.isEmpty();
	}
	// get the top element of the stack
	public T top() {
		// returns the element at the top of the stack
		return stack.get(0);
	}
	// remove the top element from the stack
	public void pop() {
		// removes the element at the top of the stack
		stack.remove(0);
	}
}
