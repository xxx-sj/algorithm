public class RangeOfArray {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,2,3,1,22,1}));
    }

    /**
     * 모든 배열을 순회하면 너무 느리지 않을까...
     * @param arr
     * @return
     */
    public static double solution(int[] arr) {
        double sum = 0;
        for (char i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum / arr.length;
    }
}
