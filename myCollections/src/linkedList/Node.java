package linkedList;

public class Node <T>{

    Node<T> next = null;
    T data;

    public Node(T d) {
        data = d;
    }

    void appendToTail(T d) {
        Node<T> end = new Node<>(d);
        Node<T> n = this;

        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

}
