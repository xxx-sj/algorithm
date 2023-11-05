/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/76501
 */
public class PlusMinus {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 7, 12}, new boolean[]{true, false, true}));
    }

    /**
     *
     *
     *
     *
     * @param absolutes
     * @param signs
     * @return
     */
    public static int solution(int[] absolutes, boolean[] signs) {
        int result = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                result += absolutes[i];
            } else {
                result -= absolutes[i];
            }
        }
        return result;
    }
}
