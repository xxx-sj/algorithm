import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86051
 */
public class AddMissingNumbers {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,6,7,8,0}));
    }


    /**
     * 0~9까지의 합 45
     * 배열 순회하면서 빼기
     * @param numbers
     * @return
     */
    public static int solution(int[] numbers) {
        int[] ints = Arrays.stream(numbers).sorted().toArray();
        int sum = 45;

        for (int anInt : ints) {
            sum -= anInt;
        }

        return sum;
    }
}
