package test;

import org.junit.jupiter.api.Test;
import project2.SinglyLinkedList;
import static org.junit.jupiter.api.Assertions.*;

class Project2Tests
{
	@Test
	void testInsert()
	{
		var myList = new SinglyLinkedList<Integer>();
		myList.Insert(11);
		myList.Insert(2);
		myList.Insert(31);
		var node = myList.GetFront();
		assertEquals(2, node.Data);
		node = node.Next;
		assertEquals(11, node.Data);
		node = node.Next;
		assertEquals(31, node.Data);
		assertEquals(2, myList.GetFront().Data);
		assertEquals(31, myList.GetTail().Data);
	}
	@Test
	void testRemoves()
	{
		var myList = new SinglyLinkedList<Integer>();
		myList.Insert(11);
		myList.Insert(2);
		myList.Insert(31);
		
		myList.RemoveFront();
		var node = myList.GetFront();
		assertEquals(11, node.Data);
		node = node.Next;
		assertEquals(31, node.Data);
		assertEquals(11, myList.GetFront().Data);
		assertEquals(31, myList.GetTail().Data);

		myList.RemoveBack();
		node = myList.GetFront();
		assertEquals(11, node.Data);
		assertEquals(11, myList.GetFront().Data);
		assertEquals(11, myList.GetTail().Data);
	}
	@Test
	void testEmpty()
	{
		var myList = new SinglyLinkedList<Integer>();
		assertTrue(myList.Empty());

		myList.Insert(11);
		myList.Insert(2);
		myList.Insert(31);
		assertFalse(myList.Empty());
		
		myList.RemoveFront();
		myList.RemoveFront();
		myList.RemoveFront();
		assertTrue(myList.Empty());
	}
	@Test
	void testSize()
	{
		var myList = new SinglyLinkedList<Integer>();
		assertEquals(0, myList.Size());

		myList.Insert(11);
		myList.Insert(2);
		myList.Insert(31);
		assertEquals(3, myList.Size());
		
		myList.RemoveFront();
		assertEquals(2, myList.Size());
	}
	@Test
	void testReverse()
	{
		var myList = new SinglyLinkedList<Integer>();
		myList.Insert(11);
		myList.Insert(2);
		myList.Insert(31);
		myList.Reverse();
		
		var node = myList.GetFront();
		assertEquals(31, node.Data);
		node = node.Next;
		assertEquals(11, node.Data);
		node = node.Next;
		assertEquals(2, node.Data);
		assertEquals(31, myList.GetFront().Data);
		assertEquals(2, myList.GetTail().Data);
	}
	@Test
	void testMerge()
	{
		var myList1 = new SinglyLinkedList<Integer>();
		myList1.Insert(11);
		myList1.Insert(2);
		myList1.Insert(31);

		var myList2 = new SinglyLinkedList<Integer>();
		myList2.Insert(66);
		myList2.Insert(51);
		myList2.Insert(80);
		
		myList1.Merge(myList2);
		var node = myList1.GetFront();
		assertEquals(2, node.Data);
		node = node.Next;
		assertEquals(11, node.Data);
		node = node.Next;
		assertEquals(31, node.Data);
		node = node.Next;
		assertEquals(51, node.Data);
		node = node.Next;
		assertEquals(66, node.Data);
		node = node.Next;
		assertEquals(80, node.Data);
		assertEquals(2, myList1.GetFront().Data);
		assertEquals(80, myList1.GetTail().Data);
	}
}
