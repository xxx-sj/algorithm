/**
 * https://programmers.co.kr/learn/courses/30/lessons/12931
 */
public class SumOfNumbers {

    public static void main(String[] args) {

    }

    public static int solution(int n) {
        int sum = 0;

        String[] split = String.valueOf(n).split("");
        for (String s : split) {
            sum += Integer.valueOf(s);
        }
        return sum;
    }

    public static int solution2(int n) {
        int sum = 0;
        while(true) {
            sum += n%10;
            if(n < 10) {
                break;
            }

            n /= 10;
        }

        return sum;

    }
}
