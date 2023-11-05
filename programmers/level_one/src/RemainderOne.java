/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/87389
 */
public class RemainderOne {

    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    /**
     * 나누어 1로 떨어지는 수 중 가장 작은 수
     * 1 ~ (n -1) 까지 순회하며 나머지가 1이 되는 순간의 값을 구하고 break;
     * @param n
     * @return
     */
    public static int solution(int n) {

        int answer = 0;
        for(int i = 1; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
