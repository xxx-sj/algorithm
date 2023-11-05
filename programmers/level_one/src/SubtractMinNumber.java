import java.util.Arrays;

public class SubtractMinNumber {

    public static void main(String[] args) {

    }

    public static int[] solution(int[] arr) {
        if (arr.length <= 1) return new int[]{-1};

        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min >= arr[i]) {
                min = arr[i];
            }
        }

        int idx = 0;
        int[] answer = new int[arr.length -1];
        for (int j = 0; j < arr.length; j++) {
            if (min == arr[j]) continue;;
            answer[idx++] = arr[j];
        }

        return answer;
    }
    /**
     * stream
     */

    public static int[] solution2(int[] arr) {
        if (arr.length <= 1) return new int[]{-1};
        int min = Arrays.stream(arr).min().getAsInt();

        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }
}
