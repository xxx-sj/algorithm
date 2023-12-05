package deque;

import queue.Queue;

import java.util.NoSuchElementException;

public class LinkedListDeque<E> implements Queue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListDeque() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean offerFirst(E value) {
        Node<E> newNode = new Node<>(value);
        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;
        size++;

        if(head.next == null) {
            tail = head;
        }

        return true;
    }

    public boolean offer(E value) {
        return offerLast(value);
    }

    public boolean offerLast(E value) {

        if (size == 0) {
            return offerFirst(value);
        }

        Node<E> newNode = new Node<E>(value);

        //size > 0 이면 tail은 무조건 존재하기 때문에
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;

        return true;
    }

    public E poll() {
        return pollFirst();
    }

    public E pollFirst() {

        if (size == 0) {
            return null;
        }

        E element = head.data;

        Node<E> nextNode = head.next;
        head.data = null;
        head.next = null;
        //head prev는 null이다.

        //nextNode가 null이 아니라면 prev에 head가 있기 때문에.
        if (nextNode != null) {
            nextNode.prev = null;
        }

        head = null;
        head = nextNode;
        size--;

        if(size == 0) {
            tail = null;
        }

        return element;
    }

    public E remove() {
        return removeFirst();
    }

    public E removeFirst() {
        E element = poll();
        if(element == null) {
            throw new NoSuchElementException();
        }

        return element;
    }

    public E pollLast() {
        if (size == 0) {
            return null;
        }

        E element = tail.data;

        Node<E> prev_node = tail.prev;
        tail.data = null;
        tail.prev = null;

        //tail 이자 head일 수 있기 때문에
        if (prev_node != null) {
            prev_node.next = null;
        }

        tail = null;
        tail = prev_node;
        size--;

        if(size == 0) {
            head = null;
        }

        return element;
    }

    public E removeLast() {
        E element = pollLast();

        if(element == null) {
            throw new NoSuchElementException();
        }
        return element;
    }

    public E peek() {
        return peekFirst();
    }

    public E peekFirst() {
        if (size == 0) {
            return null;
        }

        return head.data;
    }

    public E peekLast() {
        if(size == 0) {
            return null;
        }

        return tail.data;
    }

    public E element() {
        return getFirst();
    }

    public E getFirst() {
        E item = peek();

        if(item == null) {
            throw new NoSuchElementException();
        }

        return item;
    }

    public E getLast() {
        E item = peekLast();

        if(item == null) {
            throw new NoSuchElementException();
        }

        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {
        for(Node<E> x = head; x != null; x = x.next) {
            if (value.equals(x.data)) {
                return true;
            }
        }

        return false;
    }

    public void clear() {
        for(Node<E> x = head; x != null) {
            Node<E> next_node = x.next;
            x.data = null;
            x.prev = null;
            x.next = null;

            x = next_node;
        }
        size = 0;
        head = tail = null;
    }


}
