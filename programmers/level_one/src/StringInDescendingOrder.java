import java.util.Arrays;
import java.util.Comparator;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12917
 */
public class StringInDescendingOrder {

    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }

    public static String solution(String s) {
        String[] split = s.split("");
        Object[] objects = Arrays.stream(split).sorted(Comparator.reverseOrder()).toArray();
        StringBuilder sb = new StringBuilder();

        for (Object object : objects) {
            sb.append(object + "");
        }


        return sb.toString();
    }
}
