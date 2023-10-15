package project4;

import java.util.ArrayList;

public class MyQueue<T> {
	private ArrayList<T> queue;
	// constructor to initialize the queue
	public MyQueue(){
		queue = new ArrayList<T>();
	}
	// method to add an element to the back of the queue
	public void push(T v) {
		queue.add(queue.size(), v);
	}
	// method to get the number of the elements in the queue
	public int size() {
		return queue.size();
	}
	// method to check if the queue is empty
	public boolean empty() {
		return queue.isEmpty();
	}
	// method to get the element at the front of the queue
	public T front() {
		return queue.get(0);
	}
	// method to remove the element at the front of the queue
	public void pop() {
		queue.remove(0);
	}
}
