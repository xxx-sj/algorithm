/**
 * 최대 공약수: 두 수를 나누었을 때 나머지가 더 이상 나누어 지지않을 때 까지 나누었을 때의 몫의 곱
 * ex)  6 | 72 30
 *        |------
 *        | 12 5
 *        -------
 *        -> 6
 *
 * 최소 공배수: 두 수를 나누었을 때 나머지가 더 이상 나누어 지지 않을 때 까지 나누었을 땡의 몫과 나머지의 곱
 * ex) 위와 동일 _> 6 x 12 x 5 => 360
 *      => [72 x 30 / 최대공약수] 와 같다
 *      => 2160 / 6 => 360
 *
 */
public class CommonMultiple {

    public static void main(String[] args) {
        System.out.println(solution(3, 12)[1]);
    }

    /**
     * 유클리드 호제법
     * @param n
     * @param m
     * @return
     */
    public static int[] solution(int n, int m) {
        int[] answer = new int[2];
        int temp = 0;
        //greatest common divisor
        int gcd = 0;
        // least common multiple
        int lcm = 0;
        if (n > m) {
            temp = m;
            m = n;
            n = temp;
        }


         gcd = gcd(n, m);
         lcm = (n * m) / gcd;

        System.out.println("lcm = " + lcm);
        System.out.println("gcd = " + gcd);

        answer[0] = gcd;
        answer[1] = lcm;

        return answer;
    }

    /**
     * 재귀는 끝날 때와 다음 계산식을 넘긴다.
     * 유클리드 호제법
     * 2개의 자연수 [a, b]에 대하여(단, a > b)  a를 b로 나눈 나머지 r이라 하면
     * a와 b의 최대공약수는 b와 r의 최대공약수와 같다.(재귀)
     * 이 성질에 따라 b를 r로 나눈 나머지 r알파를 구하고 다시 r을 r알파로 나눈 나머지를 구하는 과정을
     * 반복하여 나머지가 0이 되었을 때 나누는 수가 a와 b의 최대공약수이다.
     * @param p
     * @param q
     * @return
     */
    private static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}
