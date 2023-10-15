package project2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test Program");
        System.out.println();

        System.out.println("Testing the .Insert() method by inserting Strings 'one', 'two', 'three' into List 1:");
        SinglyLinkedList<String> list1 = new SinglyLinkedList<String>();
        list1.Insert("one");
        list1.Insert("two");
        list1.Insert("three");
        System.out.println("List 1: " + list1);
        System.out.println();

        System.out.println("Testing the copy constructor by copying List 1 to List 2:");
        SinglyLinkedList<String> list2 = new SinglyLinkedList<String>(list1);
        System.out.println("List 2: " + list2);
        System.out.println();

        System.out.println("Testing the .GetFront() method:");
        System.out.println("List 1 front data: " + list1.GetFront().Data);
        System.out.println("List 1 front and next data: " + list1.GetFront().Next.Data);
        System.out.println();

        System.out.println("Testing the .GetTail() method:");
        System.out.println("List 1 tail data: " + list1.GetTail().Data);
        System.out.println();

        System.out.println("Testing the .RemoveFront() method by removing the first method from List 1:");
        SinglyLinkedNode<String> front = list1.GetFront();
        System.out.println("List 1 front String: " + front.Data);
        list1.RemoveFront();
        System.out.println("List 1: " + list1);
        System.out.println();

        System.out.println("Testing the .RemoveBack() method by removing the last method from List 2:");
        SinglyLinkedNode<String> back = list2.GetTail();
        System.out.println("List 2 tail String: " + back.Data);
        list2.RemoveBack();
        System.out.println("List 2: " + list2);
        System.out.println();

        System.out.println("Testing the .Empty() method:");
        System.out.println("List 1 is empty: " + list1.Empty());
        SinglyLinkedList<String> list3 = new SinglyLinkedList<String>();
        System.out.println("List 3 is empty: " + list3.Empty());
        System.out.println();

        System.out.println("Testing the .Size() method:");
        System.out.println("The size of List 1 is: " + list1.Size());
        System.out.println("The size of List 2 is: " + list2.Size());
        System.out.println("The size of List 3 is: " + list3.Size());
        System.out.println();

        System.out.println("Testing the .Reverse() method:");
        list2.Insert("three");
        list2.Insert("four");
        list2.Insert("five");
        System.out.println("List 2: " + list2);
        System.out.println("Let's reverse it...");
        list2.Reverse();
        System.out.println("List 2: " + list2);
        System.out.println();

        System.out.println("Testing the .Merge() method:");
        SinglyLinkedList<Integer> list4 = new SinglyLinkedList<Integer>();
        list4.Insert(1);
        list4.Insert(5);
        list4.Insert(7);
        list4.Insert(10);
        list4.Insert(100);
        SinglyLinkedList<Integer> list5 = new SinglyLinkedList<Integer>();
        list5.Insert(0);
        list5.Insert(7);
        list5.Insert(11);
        list5.Insert(95);
        System.out.println("List 4: " + list4);
        System.out.println("List 5: " + list5);
        list4.Merge(list5);
        System.out.println("Merged List: " + list4);
    }
}
