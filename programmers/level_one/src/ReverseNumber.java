import java.util.Arrays;
import java.util.Comparator;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12932
 */
public class ReverseNumber {

    public static void main(String[] args) {
        long n = 12345L;
        String[] str = String.valueOf(n).split("");
        int[] answer = new int[str.length];

        for(int idx = 0; idx < str.length; idx++) {
            answer[idx] = Integer.valueOf(str[str.length - idx]);
        }
    }

    public static int[] solution(long n) {
        String[] str = String.valueOf(n).split("");
        int[] answer = new int[str.length];

        Object[] objects = Arrays.stream(str).sorted(Comparator.reverseOrder()).toArray();
        for(int idx = 0; idx < str.length; idx++) {
            answer[idx] = Integer.valueOf(objects[idx].toString());
        }

        return answer;
    }
}
