package project3;

public class DNode<T>
{
    DNode<T> next;
	DNode<T> prev;
    T data;

    public DNode(T val)
    {
        this.data = val;
        next = prev = this;
    }
    // getter method to retrieve the next node in the linked list
    public DNode<T> GetNext() {
        return next;
    }
    // setter method to update the reference to the next node
    public void SetNext(DNode<T> next) {
        this.next = next;
    }
    // getter method to retrieve the previous node in the linked list
    public DNode<T> GetPrev() {
        return prev;
    }
    // setter method to update the reference to the previous node
    public void SetPrev(DNode<T> prev) {
        this.prev = prev;
    }
    // getter method to retrieve the data stored in this node
    public T GetData() {
        return data;
    }
    // setter method to update the data stored in this node
    public void SetData(T data) {
        this.data = data;
    }
}
