import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12982
 */
public class Budget {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2, 5,4}, 9));
        System.out.println(solution(new int[]{2,2,3,3}, 10));
    }

    /**
     * 배열을 순회하면서 예산에서 해당 금액신청금을 뱄을 때 0보다 크거나 같다면
     * cnt++(지급 가능한 부서 추가하기(1)) 하고, 예산(budget)에서 지급한 가격(d[i])을 빼준다 (budget = budget - d[i])
     * 계속해서 배열을 순회하다가 지급금이 남은 예산을 넘어갈 경우 밸열순회 중지 후 cnt 반환
     *
     * 고려해야할 점
     * break을 해버리면 다음 부서에 지급할 수 있는 예산이 남았음에도 그것을 계산하지 못함
     * @param d 해당부서들의 금액신청금
     * @param budget 예산
     * @return
     */
    public static int solution(int[] d, int budget) {
        int cnt = 0;
        int[] ints = Arrays.stream(d).sorted().toArray();
        for(int i = 0; i < ints.length; i++) {
            budget -= ints[i];
            if (budget >= 0) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }
}
