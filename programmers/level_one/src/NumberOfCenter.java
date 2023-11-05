/**
 *https://school.programmers.co.kr/learn/courses/30/lessons/12903
 */
public class NumberOfCenter {

    public static void main(String[] args) {
        System.out.println(solution("abcde"));
        System.out.println(solution("qwer"));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();

        int length = s.length();
        if (length % 2 == 1) {
            sb.append(String.valueOf(s.substring(length / 2, length / 2 + 1)));
        } else {
            sb.append(s.substring(length / 2 - 1, length / 2 + 1));
        }

        return sb.toString();
    }
}
