/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/68935
 */
public class ReverseTernary {

    public static void main(String[] args) {
        System.out.println(solution(45));
    }

    /**
     *
     * @param n
     * @return
     */
    public static int solution(int n) {
        if (n == 1) return 1;
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            if (n % 3 < 10) {
                sb.append(n % 3);
            }

            n /= 3;
        }

        int sum = 0;
        int upper = 0;
        for(int i = sb.length() - 1; 0 <= i; i--) {
            int number = Integer.valueOf(String.valueOf(sb.charAt(i)));
            sum += (number * (Math.pow(3, upper)));
            upper++;
        }

        return sum;
    }
}
