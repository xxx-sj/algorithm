import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12921
 * 에라토스테네스의 체
 *
 */
public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(solution(5));
    }


    public static int solution(int n) {
        //n + 1 -> index는 0부터 시작 // 숫자는 1부터 시작
        List<Boolean> primeNumbers = new ArrayList(n + 1);

        //  2<= n <= 1000000...;
//        if (n <= 1) return 0;

        //0과 1은 제외
        primeNumbers.add(false);
        primeNumbers.add(false);

        for(int i = 2; i <= n; i++) {
            //(index, element)
            primeNumbers.add(i, true);
        }
        //제곱만큼만 돌아도 됨
        for(int i = 2; (i * i) <= n; i++) {
            //기본적으로 모든 배열의 값을 true로 설정
            if(primeNumbers.get(i)) {
                //
                for (int j = i * i; j <= n; j += i) {
                    primeNumbers.set(j, false);
                }
            }
        }

        int cnt = 0;

        for(int i = 0; i <= n; i++) {
            if(primeNumbers.get(i)) {
                cnt++;
            }
        }

        return cnt;
    }
}


