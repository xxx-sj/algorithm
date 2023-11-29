package list;

import interface_form.List;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10; //기본 용적 크기 / 배열의 크기
    private static final Object[] EMPTY_ARRAY = {};//빈 배열

    private int size; //현재 요소의 개수이자 다음으로 넣을 배열의 위치
    
    Object[] array; //요소를 담을 배열

    public ArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public ArrayList(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }


    private void resize() {
        int array_capacity = array.length; //현재 용적의 크기 / 배열의 크기

        if(Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        //용량이 꽉 찰 경우
        if (size == array_capacity) {
            //용량을 2배로 늘린다.
            int new_capacity = array_capacity * 2;

            array = Arrays.copyOf(array, new_capacity);
            return;
        }

        //용적의 절반 미만으로 요소가 차지하고 있을 경우
        //줄여야 함
        if (size < (array_capacity / 2)) {
            int new_capacity = array_capacity / 2;

            //요소가 반보다 적다면 용적을 반으로 줄이고, 그 중에서 반으로 줄인 용적과 기본 용적을 비교하여 넣는다.
            array = Arrays.copyOf(array, Math.max(new_capacity, DEFAULT_CAPACITY));
            return;
        }
    }


    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void addLast(E value) {
        //꽉차있는 경우 용적을 늘린다.
        if(size == array.length) {
            resize();
        }

        array[size] = value;
        size++;
    }

    //중간에 요소 삽입
    public void add(int index, E value) {

        //중간에 넣으려는 인덱스가 사이즈보다 크거나, 0보다 작을 때
        if(index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        //만약 넣으려는 index가 size와 같다면 즉, 마지막에 넣으려는 것이라면
        if(index == size) {
            addLast(value);
        }
        else {

            //용적이 가득 찼다면
            if (size == array.length) {
                resize();
            }

            /**
             * i가 size인 이유는 다음으로 들어가야하는 위치가 size인데,
             * 한칸씩 밀리면서 해당 위치에 값을 넣기 위해서이다.
             *
             * 즉, 다음으로 add되는 위치가 size이기때문에 i가 size가 되고,
             * 해당 위치에는 그 전 index 에 해당하는 요소가 들어가게 되는 것이기 때문에
             * arr[i] = arr[i - 1] 이 되는 것이다.
             */
            for(int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }

            array[index] = value;
            size++;
        }
    }
}
