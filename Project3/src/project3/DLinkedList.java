package project3;

public class DLinkedList<T extends Comparable<T>> {
	private DNode <T> header;
	public DLinkedList() {
        header = new DNode<T>(null);
        }
	// getter method for retrieving the header node
    public DNode<T> GetHeader() {
        return header;
    }
    public DNode<T> add(T item) {
    	//make a new node
    	DNode<T> newNode = new DNode<T>(item);
    	//update newNode
        newNode.prev = header;
        newNode.next = header.next;
        // update surrounding nodes
        header.next.prev = newNode;
        header.next = newNode;
        return newNode;
    }
    public String toString() {
        String str = "[";
        DNode<T> curr = header.next;
        while (curr != header) {
            str += curr.data + " ";
            curr = curr.next;
        }
        str = str.substring(0, str.length() - 1);
        return str + "]";
    }
    /**
     * ASSIGNED
     * remove val from the list
     * @param val
     * @return true if successful, false otherwise
     */
    // method to remove the first occurence of a node
    public boolean remove(T val) {
    	DNode<T> search = header;
    	while(search.data != null) {
    		if (search.data == val) {
        		// adjust the links to remove search from the list
    			search.prev.next = search.next;
        		search.next.prev = search.prev;
        		return true;
        		} else {
        			search = search.next;
        			}
        	}
        // return true to indicate the value was not found
        return true;
        }
    /**
     * ASSIGNED
     * 
     * @param item
     */
    // method to insert an item into the linked list in ascending order
    public void insertOrder(T item) {
        if(header.next.data == null) {
        	// if the list is empty, add an item as the first element
        	add(item);
        	} else {
        		DNode<T> node = new DNode<T>(item);
        		DNode<T> curr = header.next;
        		while(curr.data != null) {
        			if(curr.data.compareTo(item) >= 0) {
        				// insert the node before the current
        				curr.prev.next = node;
        				node.next = curr;
        				node.prev = curr.prev;
        				curr.prev = node;
        				} else {
        					curr = curr.next;
        					}
        			}
        		// insert the node at the end of the list
        		curr.prev.next = node;
        		node.prev = curr.prev;
        		node.next = curr;
        		curr.prev = node;
        		}
        }
    /**
     * ASSIGNED
     * 
     * @param item
     */
    public boolean insertOrderUnique(T item) {
    	if(header.next.data == null) {
    	    add(item);
    	    return true;
    	    } else {
    	    	DNode<T> node = new DNode<T>(item);
    	    	DNode<T> curr = header.next;
    	    	while(curr.data != null) {
    	    		if(curr.data.compareTo(item) == 0) {
    	    			// value already exists => return falst to indicate failure
    	    			return false;
    	    			} else if(curr.data.compareTo(item) > 0) {
    	    				curr.prev.next = node;
    	    				node.next = curr;
    	    				node.prev = curr.prev;
    	    				curr.prev = node;
    	    				return true;
    	    				} else {
    	    					curr = curr.next;
    	    					}
    	    		}
    	    	curr.prev.next = node;
    	    	node.prev = curr.prev;
    	    	node.next = curr;
    	    	curr.prev = node;
    	    	return true;
    	    	}
    	}
    /**
     * ASSIGNED
     * PRE: this and rhs are sorted lists
     * @param rhs
     * @return list that contains this and rhs merged into a sorted list
     * POST: return list will not contain duplicates
     */
    // method to merge this and rhs into a new list
    public DLinkedList <T> merge(DLinkedList<T> rhs) {
    	DLinkedList<T> result = new DLinkedList<T>();
        DNode<T> currLeft = this.header.next;
        DNode<T> currRight = rhs.header.next;
        DNode<T> currResult = result.header;
        while(currLeft.data != null && currRight.data != null) {
        	if(currLeft.data.equals(currRight.data)) {
        		// remove duplicates
        		DNode<T> removed = currRight;
        		currRight = currRight.next;
        		removed.prev.next = removed.next;
        		removed.next.prev = removed.prev;
        		} else if(currLeft.data.compareTo(currRight.data) > 0) {
        			// add the current right to the result
        			DNode<T> removed = currRight;
        			DNode<T> node = new DNode<T>(currRight.data);
        			currResult.prev.next = node;
        			node.next = currResult;
        			node.prev = currResult.prev;
        			currResult.prev = node;
        			currRight = currRight.next;
        			removed.prev.next = removed.next;
        			removed.next.prev = removed.prev;
        			} else {
        				// add the current left to the result
        				DNode<T> removed = currLeft;
        				DNode<T> node = new DNode<T>(currLeft.data);
        				currResult.prev.next = node;
    			        node.next = currResult;
    			        node.prev = currResult.prev;
    			        currResult.prev = node;
        		        currLeft = currLeft.next;       		
        		        removed.prev.next = removed.next;
        		        removed.next.prev = removed.prev;
        		        }
        	}
        // add the remaining itesm from rhs to the result
        while(currRight.data != null) {
        	DNode<T> removed = currRight;
        	DNode<T> node = new DNode<T>(currRight.data);
        	currResult.prev.next = node;
			node.next = currResult;
			node.prev = currResult.prev;
			currResult.prev = node;
        	currRight = currRight.next;        	
        	removed.prev.next = removed.next;
    		removed.next.prev = removed.prev;
    		}
        while(currLeft.data != null) {
        	// add the remaining itmes from this to the result
        	DNode<T> removed = currLeft;
        	DNode<T> node = new DNode<T>(currLeft.data);
        	currResult.prev.next = node;
			node.next = currResult;
			node.prev = currResult.prev;
			currResult.prev = node;			
        	currLeft = currLeft.next;       	
        	removed.prev.next = removed.next;
    		removed.next.prev = removed.prev;
        }
        return result;
    }
}
