package project2;

public class SinglyLinkedNode <T> {
    // instance variable to store the data of the node
    public T Data;
    // instance variable to reference the next node in the linked list
    public SinglyLinkedNode <T> Next;
    // constructor for creating an instance
    public SinglyLinkedNode(T data) {
        Data = data;
        Next = null;
    }
    // getter for the data stored in node
	public String getData() {
		return null;
	}
    // getter for the next node in the linked list
	public SinglyLinkedNode <String> getLinkNext() {
		return null;
	}
	@Override
    public String toString() {
        return Data.toString();
    }
}
