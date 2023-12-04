package queue;


import java.util.NoSuchElementException;

public class LinkedListQueue<E> implements Queue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean offer(E value) {
        Node<E> newNode = new Node<E>(value);
        if(size == 0) {
            head = newNode;
        }
        else {
            tail.next = newNode;
        }

        tail = newNode;
        size++;

        return true;
    }

    public E poll() {

        if(size == 0) {
            return null;
        }

        E data = head.data;

        Node<E> next_node = head.next;
        head.data = null;
        head.next = null;

        head = next_node;
        size--;

        return data;
    }

    public E remove() {
        E element = poll();
        if(element == null) {
            throw new NoSuchElementException();
        }

        return element;
    }

    public E peek() {
        if (size == 0) {
            return null;
        }
        return  head.data;
    }

    public E element() {
        E element = peek();
        if(element == null)
            throw new NoSuchElementException();

        return element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size ==0;
    }

    public boolean contains(Object value) {

        for(Node<E> x = head; x != null; x = x.next){
            if (x.data.equals(value)) {
                return true;
            }
        }

        return false;
    }

    public void clear() {

        for(Node<E> x = head; x != null;) {
            Node<E> next = x.next;
            x.data =null;
            x.next = null;

            x = next;
        }

        size = 0;
        head = tail = null;
    }
}
