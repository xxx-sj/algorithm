package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> implements  StackInterface<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};

    private Object[] array;
    private int size;

    public Stack() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public Stack(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }
    
    private void resize() {
        //빈 배열인 경우
        if(Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        //현재 용적크기
        int arrayCapacity = array.length;

        //용적이 가득 찬 경우
        if (size == arrayCapacity) {
            int newSize = arrayCapacity * 2;

            //배열 복사
            array = Arrays.copyOf(array, newSize);
            return;
        }

        if (size < (arrayCapacity / 2)) {

            int newCapacity = arrayCapacity / 2;

            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity));
            return;
        }
    }


    public E push(E item) {

        if(size == array.length) {
            resize();
        }

        array[size] = item;
        size++;

        return item;
    }


    public E pop() {

        if (size == 0) {
            throw new EmptyStackException();
        }

        @SuppressWarnings("unchecked")
        E obj = (E)array[size - 1];

        array[size - 1] = null;
        size--;
        resize();

        return obj;
    }


    @SuppressWarnings("unchecked")
    public E peek() {
        if(size == 0) {
            throw new EmptyStackException();
        }

        return (E) array[size - 1];
    }

    public int search(Object value) {

        if(value == null) {
            //size -1 인 이유 index이기 때문에.
            for(int idx = size - 1; idx >= 0; idx--) {
                if(array[idx] == null) {
                    return size - idx;
                }
            }
        } else {
            for(int idx = size - 1; idx >= 0; idx --) {

                if(array[idx].equals(value)) {
                    return size - idx;
                }
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public void clear() {

        for(int i = 0; i < size; i++) {
            array[i] = null;
        }

        size = 0;
        resize();
    }

    public boolean empty() {
        return size == 0;
    }


}
