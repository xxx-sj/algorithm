package deque;

import queue.Queue;

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


}
