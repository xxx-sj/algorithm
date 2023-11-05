/**
 * https://programmers.co.kr/learn/courses/30/lessons/12954
 */
public class NumberOfN {
    public long[] solution(int x, int n) {
        long[] arr = new long[n];
        arr[0] = x;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + x;
        }
        return arr;
    }
}
