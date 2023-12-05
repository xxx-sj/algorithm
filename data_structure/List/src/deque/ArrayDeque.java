package deque;

import queue.Queue;

import java.util.NoSuchElementException;

public class ArrayDeque<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 64; //기본 용적 크기

    private Object[] array;
    private int size;

    private int front;
    private int rear;

    public ArrayDeque() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public ArrayDeque(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    private void resize(int capacity) {
        int arrayCapacity = array.length; //현재 용적크기

        Object[] newArray = new Object[arrayCapacity]; //새로운 배열

        /**
         * i = new array index 
         * 1부터 시작하는 이유는 front는 비어있어야 하기 때문에,
         * j = original array 
         * front + 1인 이유는 front는 비어있기 때문에 그 다음 위치인 front + 1을 하는 것
         */
        for(int i = 1, j = front + 1; i <= size; i++, j++) {
            newArray[i] = array[j % arrayCapacity];
        }
        this.array = null;
        this.array = newArray;

        front = 0;
        rear = size;
    }

    public boolean offer(E item) {
        return offerLast(item);
    }

    public boolean offerLast(E item) {

        //용적이 가득찬 경우
        //rear + 1 은 그 다음 넣을 위치
        if ((rear + 1) % array.length == front) {
            resize(array.length * 2);
        }

        rear = (rear + 1) % array.length;

        array[rear] = item;
        size++;

        return true;
    }

    public boolean offerFirst(E item) {

        if((front - 1 + array.length) % array.length == rear) {
            resize(array.length * 2);
        }

        //rear + 1 처럼 1을 더하지 않는 이유는 front는 비어있기 때문에
        array[front] = item;
        front = (front -1 + array.length) % array.length;
        size++;

        return true;
    }

    public E poll() {
        return pollFirst();
    }


    //앞(front)에서 값을 꺼내는 것
    public E pollFirst() {
        if(size == 0) {
            return null;
        }

        front = (front + 1) % array.length;

        @SuppressWarnings("unchecked")
        E item = (E) array[front];

        array[front] = null;
        size--;

        //현재 용적 크기가 기본보다 크고, 현재 요소가 용적크기의 /4 일 때
        if (array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

        return item;
    }

    public E remove() {
        return removeFirst();
    }

    public E removeFirst() {
        E item = pollFirst();

        if(item == null) {
            throw new NoSuchElementException();
        }

        return item;
    }

    public E pollLast() {
        if(size == 0) {
            return null;
        }

        @SuppressWarnings("unchecked")
        //rear를 그대로 넣은 이유는 rear의 위치에는 바로 요소가 있기 때문에
        E item = (E) array[rear];

        array[rear] = null;

        rear = (rear - 1 + array.length) % array.length;
        size--;

        if(array.length > DEFAULT_CAPACITY && size > (array.length / 4)) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

        return item;
    }

    public E removeLast() {
        E item = pollLast();
        if(item == null) {
            throw new NoSuchElementException();
        }

        return item;
    }

    public E peek() {
        return peekFirst();
    }

    public E peekFirst() {
        if(size == 0) {
            return null;
        }

        @SuppressWarnings("unchecked")
        //front - 1 햇을 때 배열을 벗어날 수 있기 때문에, + array.length 해주는 것
        E item = (E) array[(front - 1 + array.length) % array.length];

        return item;
    }

    public E peekLast() {
        if(size == 0) {
            return null;
        }
        //rear는 넘어가지 않기 때문에
        @SuppressWarnings("unchecked")
        E item = (E)array[rear];

        return item;
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

        if(item == null)
            throw new NoSuchElementException();

        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {
        int start = (front + 1) % array.length;

        /**
         * i : 요소의 갯수만큼 반복한다. 비교대상 [size]
         * idx : 원소 위치로, 매 회 (idx + 1) % array.length로 위치 조정. 실제 요소의 위치를 나타낸다.
         */
        for(int i = 0, idx = start; i < size; i++, idx = (idx + 1) % array.length) {
            if(array[idx].equals(value)) {
                return true;
            }
        }

        return false;
    }

    public void clear() {
        for(int i = 0; i < array.length; i++) {
            array[i] = null;
        }

        front = rear = size = 0;
    }




}
