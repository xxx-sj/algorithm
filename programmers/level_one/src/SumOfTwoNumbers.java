/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12912
 */
public class SumOfTwoNumbers {

    public static void main(String[] args) {
        System.out.println(solution(-10, 5));
        System.out.println(solution(3, 5));
        System.out.println(solution(3, 3));
        System.out.println(solution(5, -10));
        System.out.println(solution(-10000000, 10000000));
    }

    /**
     * 전달받은 값을 기준으로 최소 최대로 나누고
     * 해당 숫자 포함 몇개를 더해야 하는지 계산하기
     * ex) 2 ~ 10 => 10 - 2 + 1 => 9개
     * 9 * (2 + 10) => 108
     * 108 / 2 => 54
     * @param a
     * @param b
     * @return
     */
    public static long solution(int a, int b) {

        // 두수가 같으면 아무 수 리턴
        if (a == b) return a;

        int temp = 0;

        if (a > b) {
            temp = b;
            b = a;
            a = temp;
        }

        return sumAtoB(Math.min(a, b), Math.max(b, a));
//        return (b - a + 1) * (a + b) / 2;
    }
    private static long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }
}
