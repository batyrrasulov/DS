
import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<T> {
    private List<PriorityQueueNode<T>> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void insert(T item, int priority) {
        PriorityQueueNode<T> newNode = new PriorityQueueNode<>(item, priority);
        heap.add(newNode);
        heapifyUp(heap.size() - 1);
    }

    public T extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }

        T minItem = heap.get(0).getItem();
        int lastIndex = heap.size() - 1;

        // Move the last element to the root position
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);

        // Restore heap property
        heapifyDown(0);

        return minItem;
    }

    public T peekMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return heap.get(0).getItem();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).getPriority() < heap.get(parentIndex).getPriority()) {
                // Swap the current node with its parent if necessary
                swap(index, parentIndex);
                index = parentIndex; // Move up to the parent
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex;
        while ((leftChildIndex = 2 * index + 1) < heap.size()) {
            int minChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;
            if (rightChildIndex < heap.size() &&
                heap.get(rightChildIndex).getPriority() < heap.get(leftChildIndex).getPriority()) {
                minChildIndex = rightChildIndex;
            }

            if (heap.get(index).getPriority() > heap.get(minChildIndex).getPriority()) {
                // Swap the current node with its smallest child if necessary
                swap(index, minChildIndex);
                index = minChildIndex; // Move down to the child
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        PriorityQueueNode<T> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

class PriorityQueueNode<T> {
    private T item;
    private int priority;

    public PriorityQueueNode(T item, int priority) {
        this.item = item;
        this.priority = priority;
    }

    public T getItem() {
        return item;
    }

    public int getPriority() {
        return priority;
    }
}
