package bubble_sort;

import java.util.Arrays;

public class BubbleSort2 {
    public static void main(String[] args) {
        BubbleSort2 bs = new BubbleSort2();
        int [] arr = {7, 2, 3, 9, 28, 1};
        bs.sort(arr);
        System.out.println(Arrays.toString(arr));
        //length = 6;
        //length - 1 까지 loop
//        for(int i = 1; i <= arr.length - 1; i++) {
//            bs.sortARound(arr, arr.length - i);
//        }
//        bs.sortARound(arr, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
//        bs.sortARound(arr, arr.length - 2);
//        System.out.println(Arrays.toString(arr));
//        bs.sortARound(arr, arr.length - 3);
//        System.out.println(Arrays.toString(arr));
//        bs.sortARound(arr, arr.length - 4);
//        System.out.println(Arrays.toString(arr));
//        bs.sortARound(arr, arr.length - 5);
//        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        for(int i = 1; i <=arr.length - 1; i++) {
            sortARound(arr, arr.length - 1);
        }
    }

    private void sortARound(int[] arr, int until) {
        for(int i = 0; i < until; i++) {
            if(arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
