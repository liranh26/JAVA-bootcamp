package linkedList;

import java.util.HashMap;

public class MyLinkedList<T> {

	Node<T> head;

	MyLinkedList(Node<T> head) {
		this.head = head;
	}

	public Node<T> removeDuplicates(Node<T> head) {
		HashMap<T, Boolean> map = new HashMap<>();
		Node<T> curr = head;

		while (curr.next != null) {
			if (!map.containsKey(curr.data))
				map.put(curr.data, false);
			curr = curr.next;
		}

		curr = head;
		Node<T> prev = null;
		while (curr != null) {
			if (!map.get(curr.data)) {
				map.put(curr.data, true);
				prev = curr;
				curr = curr.next;
			} else {
				prev.next = curr.next;
				curr = prev.next;
			}
		}
		return head;
	}

	public void print(Node<T> start) {
		while (start.next != null) {
			System.out.print(start.data);
			start = start.next;
		}
		System.out.print(start.data);
		System.out.println();
	}

}
