package list;

import interface_form.List;

import java.util.NoSuchElementException;

public class SLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * search
     * 찾을 때는 head부터 하나씩 찾아야 함  O(N)
     * @param index
     * @return
     */
    private Node<E> search(int index) {

        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node<E> x = head;

        for(int i = 0; i < index; i++) {
            x = x.next;
        }

        return x;
    }

    /**
     * head 에 값넣기
     * @param value
     */
    public void addFirst(E value) {
        Node<E> node = new Node<E>(value);
        node.next = head;
        head = node;
        size++;


        if (head.next == null) {
            tail = head;
        }
    }

    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void addLast(E value) {
        Node<E> newNode = new Node<E>(value);

        if(size == 0) {
            addFirst(value);
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void add(int index, E value) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if(index == 0) {
            addFirst(value);
            return;
        }

        if (index == size) {
            addLast(value);
            return;
        }

        Node<E> newNode = new Node<E>(value);

        Node<E> prev_node = search(index - 1);
        Node<E> next_node = prev_node.next;

        prev_node.next = null;
        prev_node.next = newNode;
        newNode.next = next_node;
        size++;
    }

    /**
     * 가장 앞 요소 삭제
     * @return
     */
    public E remove() {
        Node<E> remove_node = head;

        if(remove_node == null) {
            throw new NoSuchElementException();
        }

        E data = remove_node.data;
        Node<E> next_node = remove_node.next;

        remove_node.data = null;
        remove_node.next = null;

        head = next_node;
        size--;

        if(size == 0) {
            tail = null;
        }

        return data;
    }


    public E remove(int index) {

        if(index == 0) {
            return remove();
        }

        if(index >= size || index < 0) {
            throw new NoSuchElementException();
        }

        Node<E> prev_node = search(index - 1);
        Node<E> remove_node = prev_node.next;
        Node<E> next_node = remove_node.next;

        E data = remove_node.data;

        remove_node.data = null;
        remove_node.next = null;
        size--;

        prev_node.next = next_node;

        //삭제한 노드가 마지막 노드였다면
        if(prev_node.next == null) {
            tail = prev_node;
        }

        return data;
    }

    public boolean remove(Object value) {

        Node<E> prevNode = head;
        boolean hasValue = false;
        Node<E> x= head; //removeNode;

        /**
         * x != null 조건의 의미는 tail.next 값이 null 이기 때문에
         * 마지막까지 돌겠다는 의미
         */
        for(; x != null; x = x.next) {
            if (value.equals(x.data)) {
                hasValue = true;
                break;
            }

            prevNode = x;
        }

        if(x == null) {
            return false;
        }


        if (x.equals(head)) {
            remove();
            return true;
        }

        else {
            //x를 삭제한다.
            prevNode.next = x.next;

            //삭제했던 노드가 마지막 노드였다면
            if (prevNode.next == null) {
                tail = prevNode;
            }
            x.data = null;
            x.next = null;
            size--;

            return true;
        }
    }

    public E get(int index) {
        Node<E> node = search(index);

        return node.data;
    }

    public void set(int index, E value) {

        Node<E> replaceNode = search(index);
        replaceNode.data = null;
        replaceNode.data = value;
    }

    public int indexOf(Object value) {
        int index = 0;

        for(Node<E> x = head; x != null; x = x.next) {
            if(value.equals(x.data)) {
                return index;
            }

            index++;
        }

        return -1;
    }

    public boolean contains(Object item) {
        return indexOf(item) >= 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for(Node<E> x= head; x != null;) {
            Node<E> next_node = x.next;
            x.data = null;
            x.next = null;
            x = next_node;
        }

        head = tail = null;
        size = 0;
    }
}
