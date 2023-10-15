package project2;

public class SinglyLinkedList< T extends Comparable <T> > {
	// a node pointer to the front and the tail of the list
    private SinglyLinkedNode <T> front;
    private SinglyLinkedNode <T> tail;
    private int size;
    // default constructor to initialize an empty linked list
    public SinglyLinkedList() {
        front = null;
        tail = null;
        size = 0;
    }
    // copy constructor that creates a new linked list by copying the elements from another one
    public SinglyLinkedList(SinglyLinkedList <T> aList) {
        front = null;
        tail = null;
        size = 0;
        // copy elements from the old to the new list
        SinglyLinkedNode <T> current = aList.front;
        while (current != null) {
            Insert(current.Data);
            current = current.Next;
        }
    }
    // access to the first and last element
    public SinglyLinkedNode <T> GetFront() {
        return front;
    }
    public SinglyLinkedNode <T> GetTail() {
        return tail;
    }
    // insert a new element with a value into the linked list
    public void Insert(T val) {
        SinglyLinkedNode <T> newNode = new SinglyLinkedNode<>(val);
        if (front == null || val.compareTo(front.Data) < 0) {
            // put it in as the new front of the list
            newNode.Next = front;
            front = newNode;
            if (tail == null) {
                tail = front;
            }
        } else {
            // put the node in the sorted order
            SinglyLinkedNode <T> current = front;
            while (current.Next != null && val.compareTo(current.Next.Data) >= 0) {
                current = current.Next;
            }
            newNode.Next = current.Next;
            current.Next = newNode;
            if (newNode.Next == null) {
                tail = newNode;
            }
        }
        size++;
    }
    // remove the front element from the linked list
    public void RemoveFront() {
        if (front != null) {
            front = front.Next;
            size--;
            if (front == null) {
                tail = null;
            }
        }
    }
    // remove the tail element from the linked list
    public void RemoveBack() {
        if (front != null) {
            if (front.Next == null) {
                front = null;
                tail = null;
            } else {
                SinglyLinkedNode <T> current = front;
                while (current.Next.Next != null) {
                    current = current.Next;
                }
                current.Next = null;
                tail = current;
            }
            size--;
        }
    }
    // determine if the linked list is empty
    public boolean Empty() {
        return front == null;
    }
    // return the number of elements in the linked list
    public int Size() {
        return size;
    }
    // reverse the linked list and return a new linked list
    public SinglyLinkedList <String> Reverse() {
        SinglyLinkedNode <T> prev = null;
        SinglyLinkedNode <T> current = front;
        tail = front;
        while (current != null) {
            SinglyLinkedNode <T> next = current.Next;
            current.Next = prev;
            prev = current;
            current = next;
        }
        front = prev;
		return null;
    }
    // merge the elements of another linked list into the current one
    public void Merge(SinglyLinkedList <T> aList) {
        SinglyLinkedNode <T> current = aList.front;
        while (current != null) {
            Insert(current.Data);
            current = current.Next;
        }
    }
    // get the tail element of the linked list
	public SinglyLinkedNode <String> back() {
		return null;
	}
	@Override
    public String toString() {
        if (front == null) {
            return "Empty List";
        }
        // build a string representation of the linked list
        StringBuilder sb = new StringBuilder();
        SinglyLinkedNode <T> current = front;
        while (current != null) {
            sb.append(current.Data);
            if (current.Next != null) {
                sb.append(" -> ");
            }
            current = current.Next;
        }
        return sb.toString();
    }
}
