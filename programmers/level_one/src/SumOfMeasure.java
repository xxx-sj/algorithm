/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/77884
 */
public class SumOfMeasure {

    public static void main(String[] args) {
        System.out.println(solution(13, 17));
        System.out.println(solution(24, 27));

    }

    /**
     * 제약사항 left는 right보다 작거나 같다 (1 <= left <= right <= 1000)
     *
     * left 부터 right 까지 순회하면서 (for문)
     * 해당 값 (순회 값 = i)이 제곱근 이 자연수 인 수 (홀수) 나머지는 짝수
     * 약수... 두 수의 곱시 해당 값이 되는 것
     * 기준이 되는 값 17
     * 17의 약수 1, 17
     * 25의 약수
     * 1, 5, 25
     * 계산하여 뎃셈, 뺄셈 하기
     * 
     * math의 sqrt(제곱근) 계산하여 해당 값의 소수점 2번째 자리가 존재하지 않는다면(자연수의 제곱근 존재)
     * ex) Math.sqrt(25) => 5.0(실수반환) =>
     * @param left
     * @param right
     * @return
     */
    public static int solution(int left, int right) {
        int sum = 0;

        //FIXME 해당 값(i) 이 제곱근 값으로 나누어 떨어지면 (i % Math.sqrt(i) // 나머지의 값이 0) 홀수
        
        for (int i = left; i <= right; i++) {
            Double sqrt = Math.sqrt(i);
            String[] split = sqrt.toString().split("[.]");
            if (split[1].length() <= 1) {
                sum -= i;
            } else {
                sum += i;
            }

        }

        return sum;
    }
}
