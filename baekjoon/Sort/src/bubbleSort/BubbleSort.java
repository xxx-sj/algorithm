package bubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,9,4,3,7,8,6};

        bubbleSort2(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }
    static void bubbleSort(int[] a, int n) {
        //i가 나타내는 것은 정렬하려는 마지막 위치이다. 0 ~ n - 2;
        //예를들어 5이면 0,1,2,3 인덱스 위치의 값을 채우고 , 마지막은 자동으로 가장 큰 값이 들어가기에 정렬위치가아님.
        for(int i = 0; i < n -1; i++) {
            //j는 끝부터 시작하여 i보다 클 때까지 진행하며, 비교하여 i에 값을 채운다.
            /**
             * 예시로 i = 1 이라면 j의 값은
             * j = 4; 인덱스로 보자면 4/3 자리를.
             * j = 3 3/2 자리를
             * j = 2 2/1 자리를 비교한 후
             * j = 2 에서 idx 1의 자리르 채우게 되는 것.
             */
            for(int j = n - 1; j > i; j--) {
                if(a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                }
            }
        }
    }

    static void bubbleSort2(int[] a, int N) {
        for(int i = 0; i < N - 1; i ++) {
            for(int j = 1; j < N - i; j++) {
                if(a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                }
            }
        }
    }


    /**
     * swap 은 배열과 두 인덱스를 받아서 값을 변경한다.
     */
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }
}
