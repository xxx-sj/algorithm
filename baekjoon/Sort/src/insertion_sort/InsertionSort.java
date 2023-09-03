package insertion_sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,9,4,3,7,8,6};

        insertionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void insertionSort(int[] a, int N) {

        for(int i = 1; i < N; i++) {
            int target = a[i];

            int j = i - 1;
            while(j >= 0 && target < a[j]) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = target;

        }
    }

    static void insertionSort2(int[] a, int N) {

        //target idx
        for(int i = 1; i < N; i++) {
            int target = a[i];

            for(int j = i - 1; j >= 0; j--) {

                if(target < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    a[j + 1] = target;
                    break;
                }
            }
        }
    }
}
