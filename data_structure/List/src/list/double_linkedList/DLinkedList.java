package list.double_linkedList;

import interface_form.List;

import java.util.NoSuchElementException;

public class DLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * 꼬리에 가까운지, 머리에 가까운지에 따라
     * 시작지점을 나눈다.
     * @param index
     * @return
     */
    private Node<E> search(int index) {

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if(index + 1 > size / 2) {
            Node<E> x= tail;

            /**
             * size - 1 = index 마지막
             */
            for(int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        } else {
            Node<E> x = head;

            for(int i  = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        }
    }

    public void addFirst(E value) {
        Node<E> newNode = new Node<E>(value);
        newNode.next = head;


        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;
        size++;


        if(head.next == null) {
            tail = head;
        }
    }

    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void addLast(E value) {
        Node<E> newNode = new Node<>(value);

        if (size == 0) {
            addFirst(value);
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;

        size++;

    }

    public void add(int index, E value) {

        /**
         * size보다 같거나 큰게 아닌
         * size보다 큰 이유는 다음과 같다
         * size는 다음으로 들어가는 value의 위치를 나타내기 때문에
         * size까지 입력받는 것에 대해서는 문제가 없다.
         */
        if(index < 0 || index > size) {
            throw  new IndexOutOfBoundsException();
        }

        if(index == 0) {
            addFirst(value);
            return;
        }

        if(index == size) {
            addLast(value);
            return;
        }

        Node<E> prev_node = search(index - 1);
        Node<E> next_node = prev_node.next;

        Node<E> newNode = new Node<>(value);

        prev_node.next = null;
        next_node.prev = null;

        prev_node.next = newNode;

        newNode.prev = prev_node;
        newNode.next = next_node;

        next_node.prev = newNode;

        size++;
    }

    public E remove() {
        Node<E> headNode = head;

        if(headNode == null) {
            throw new NoSuchElementException();
        }

        E element = headNode.data;

        //다음으로 head가 될 값
        Node<E> next_node = headNode.next;

        head.data = null;
        head.next = null;

        if(next_node != null) {
            next_node.prev = null;
        }

        head = next_node;
        size--;

        if(size == 0) {
            tail = null;
        }

        return element;
    }

    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            E data = head.data;
            remove();
            return data;
        }

        Node<E> prev_node = search(index - 1);
        Node<E> remove_node = prev_node.next;
        Node<E> next_node = remove_node.next;

        E element = remove_node.data;

        prev_node.next = null;

        remove_node.data = null;
        remove_node.prev = null;
        remove_node.next = null;


        if(next_node != null) {
            next_node.prev = null;

            prev_node.next = next_node;
            next_node.prev = prev_node;
        }
         else {
             tail = prev_node;
        }

         size--;

         return element;
    }

    public boolean remove(Object value) {

        Node<E> prev_node = head;
        Node<E> x = head;

        for(; x != null; x = x.next) {
            if(value.equals(x.data)) {
                break;
            }
            prev_node = x;
        }

        //value가 없다면
        if(x == null) {
            return false;
        }

        if (x.equals(head)) {
            remove();
            return true;
        }

        else {
            //삭제될 노드는 x이다.
            Node<E> next_node = x.next;

            prev_node.next = null;
            x.data = null;
            x.next = null;
            x.prev = null;

            if (next_node != null) {
                next_node.prev = null;

                next_node.prev = prev_node;
                prev_node.next = next_node;
            }
            else {
                tail = prev_node;
            }

            size--;

            return true;
        }
    }

    public E get(int index) {
        return search(index).data;
    }

    public void set(int index, E value) {
        Node<E> replaceNode = search(index);
        replaceNode.data = null;
        replaceNode.data = value;
    }


    public int indexOf(Object o) {
        int index = 0;

        for(Node<E> x = head; x!= null; x = x.next) {
            if(o.equals(x.data)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        int index = size;

        for(Node<E> x = tail; x != null; x = x.prev) {
            //index--가 먼저오는 이유는size는 그 다음으로 들어가는 위치를 나타내기 때문에
            //index를 찾기위해서는 -1을 먼저 해줘야 한다.
            index--;
            if(o.equals(x.data)) {
                return index;
            }
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
        for(Node<E> x = head; x != null; ) {
            Node<E> nextNode = x.next;
            x.data = null;
            x.next = null;
            x.prev = null;
            x = nextNode;
        }
        head = tail = null;
        size = 0;
    }
}
