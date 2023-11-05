/**
 *  https://programmers.co.kr/learn/courses/30/lessons/12925
 *  예를들어 str이 "1234"이면 1234를 반환하고, "-1234"이면 -1234를 반환하면 됩니다.
 *  str은 부호(+,-)와 숫자로만 구성되어 있고, 잘못된 값이 입력되는 경우는 없습니다.
 *
 *   s의 길이는 1 이상 5이하입니다.
 *   s의 맨앞에는 부호(+, -)가 올 수 있습니다.
 *   s는 부호와 숫자로만 이루어져있습니다.
 *   s는 "0"으로 시작하지 않습니다.
 *
 *  1. 부호가 있는지 판단한다.
 *  1-1  -라면 음수로 표시한다
 *  1-2  +라면 양수이다.
 *  1-2-1 +라면 부호이기때문에 계산이 되면 안된다.
 *  2. 아스키코드(0 ~ 9)(48 ~ 57)
 *  2-1 value(반환값)
 *  2-1-1 value 매번 x10 을 통해 자릿수 올림 및 1일의 자리 비우기
 *  2-1-2 value = value * 10 + 일의 자리
 *
 */
public class ConvertStringToNumber {

    public static void main(String[] args) {
        System.out.println(solution("-12345"));

    }


    public static int solution(String s) {
        //부호 : 양수인지 음수인지
        boolean isNegative = false;
        //반환값
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                isNegative = true;
            } else if (s.charAt(i) != '+') {
                result = result * 10 + (s.charAt(i) - 48);
            }
        }

        return (isNegative ? -1 : 1) * result;

    }
}

