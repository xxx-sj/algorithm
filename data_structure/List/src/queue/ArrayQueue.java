package queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 64; //기본 크기
    private Object[] array;
    private int size;

    private int front; //시작 인덱스
    private int rear; //마지막 요소의 인덱스


    public ArrayQueue() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public ArrayQueue(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    private void resize(int newCapacity) {
        int arrayCapacity = array.length;

        Object[] newArray = new Object[newCapacity];

        /**
         * i = new array Index
         * i가 1인 이유는 처음 front와 rear가 같은 공간에서 시작하게 되는데,
         * front가 비어있어야 하기 때문에, rear를 한칸 앞으로 옮긴 것
         * j = original array
         * front + 1인 이유는 현재 front에는 비어있기 때문에 +1 해주는 것
         * front + 1 부터 시작하는 이유는 마치 배열에 있는 값을 지운다고 생각하면 된다.
         */
        for(int i = 1, j = front + 1; i<= size; i++, j++) {
            newArray[i] = array[j % arrayCapacity];
        }

        this.array = null;
        this.array = newArray;

        front = 0;
        rear = size;
    }

    public boolean offer(E item) {

        //용적이 가득 찬 경우
        if((rear + 1) % array.length == front) {
            resize(array.length * 2);
        }
        
        //rear 7, array length 가 8이라면 rear + 1 이 8이 되면, 0으로 이동
        rear = (rear + 1) % array.length; //rear을 rear의 다음 위치로 갱신

        array[rear] = item;
        size++;
        return true;
        
    }

    public E poll() {

        if(size == 0) {
            return null;
        }

        front = (front + 1) & array.length; //front를 한칸 옮긴다.

        @SuppressWarnings("unchecked")
        E item = (E)array[front];

        array[front] = null;
        size--;
        
        //용적의 크기는 기본 용적 크기보다 크지만, 요소 갯수는 1/4보다 작은 경우
        if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {

            resize(Math.max(array.length / 4, DEFAULT_CAPACITY));
        }

        return item;
    }

    public E remove() {
        E item = poll();
        if(item == null) {
            throw new NoSuchElementException();
        }

        return item;
    }

    public E peek() {

        if(size == 0) {
            return null;
        }

        @SuppressWarnings("unchecked")
        E item = (E) array[(front + 1) % array.length];
        return item;
    }

    public E element() {
        E item = peek();
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
        int start = (front + 1) % array.length;

        for(int i = 0, idx = start; i <size; i++, idx = (idx + 1) % array.length) {
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
