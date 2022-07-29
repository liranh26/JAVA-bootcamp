package linkedList;

public class linkedListRunner {

	
	public static void main(String[] args) {

        /*
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(5);

        Node start = head;

        while(start.next != null) {
            System.out.println(start.data);
            start = start.next;
        }
        System.out.println(start.data);

         */

        Node<Integer> head = new Node<>(1);
        MyLinkedList<Integer> linkedList = new MyLinkedList<>(head);

        linkedList.head.appendToTail(2);
        linkedList.head.appendToTail(7);
        linkedList.head.appendToTail(1);
        linkedList.head.appendToTail(3);
        linkedList.head.appendToTail(2);

        linkedList.print(head);
        linkedList.removeDuplicates(head);
        linkedList.print(head);
	}
}
