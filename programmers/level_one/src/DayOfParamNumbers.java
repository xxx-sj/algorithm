/**
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12901
 */
public class DayOfParamNumbers {

    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }


    /**
     * 2016년 1월 1일 금요일
     * 2016년은 윤년이다.
     * 1. 배열의 시작을 금요일로 잡기
     * 2. 두수 입력 받는 [a, b]
     * ex) a=5, b=24 // 5월24일 => TUE
     *  1 < a < 13, 1 < b < 32
     * 3. 31일까지 있는 달
     * 3-1. 1, 3, 5, 7, 8, 10, 12
     * 4. 30일까지 있는 달
     * 4-1. 4, 6, 9, 11
     * 4-2. 2월은 예외 28일 또는 29일
     * 이전 달 까지의 일 수를 더하고
     * 이번 달 일수에 해당하는 값 더한 후
     * 7나머지 계산 끝
     *
     * ex) a = 5 , b = 24
     * => a 이전까지의 일 수 : 1월,2월,3월,4월 일수
     *    => 31 + 29 + 31 + 30 => 121
     *    121 + 24(b) => 145
     *    (145 - 1) % 7 => 4
     *     요일의 시작은 1일부터
     *
     * @param a 월
     * @param b 일
     * @return 해당 요일
     */
    public static String solution(int a, int b) {
        String[] days = new String[]{"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int totalDay = 0;

        for (int i = 1; i < a; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                totalDay += 31;

            /**
             * 윤년 계산 필요하면 넣기
             * 년 % 4 == 0 윤년 (4의 배수일 때)
             * 아니면 28일로 계산하기
             */
            } else if (i == 2) {
                totalDay += 29;
            } else {
                totalDay += 30;
            }
        }
        totalDay += b;

        return days[(totalDay - 1) % 7];
    }
}
