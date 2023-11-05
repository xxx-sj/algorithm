/**
 * https://programmers.co.kr/learn/courses/30/lessons/12928
 */
public class Divisor {

    public static void main(String[] args) {
        System.out.println(solution(12));
    }


    /**
     * 약수의 합 구하기
     * 인자로 전달받은 값의 약수의 합을 구하기 위해서
     * 먼저 제곱근으로 나눈다. (반만 돌기 위해서)
     * 인자로 전달받은 n의 값을 i로 나누었을 때 나머지가 0이라면 (최소 약수)
     * 이때의 몫이 곧 (최대 약수) 가 된다
     * ex) (12 % 2) => 0;
     *     (12 / 2) => 6;
     *     0 + 6 => 6;
     *
     * @param n
     * @return 약수의 합
     */
    public static int solution(int n) {
        double sqrt = Math.sqrt(n);
        int sum = 0;
        for(int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                sum += i;
                if (n / i != i) {
                    sum += (n / i);
                }
            }
        }

        return sum;
    }
}
