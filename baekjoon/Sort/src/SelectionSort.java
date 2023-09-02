import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,9,4,3,7,8,6};

        selectionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] a, int n) {
        for(int i = 0; i < n - 1; i++) {
            int min = i;
            for(int j = i; j < n; j++) {
                if(a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, i, min);
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
