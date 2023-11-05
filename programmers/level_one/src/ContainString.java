/**
 * https://programmers.co.kr/learn/courses/30/lessons/12918
 *
 *
 */
public class ContainString {


    public static void main(String[] args) {
        System.out.println(solution("1234"));
    }

    public static boolean solution(String s) {
        String[] arr = s.split("");

        if (!(s.length() == 4 || s.length() == 6)) return false;

        for (String s1 : arr) {
            if (s1.matches("[\\D]")) {
                return false;
            }
        }

        return true;
    }
}