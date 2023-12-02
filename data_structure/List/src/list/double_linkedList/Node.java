package list.double_linkedList;

public class Node<E> {

    E data;
    Node<E> next;
    Node<E> prev;

    public Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
