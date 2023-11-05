import java.util.HashMap;
import java.util.Map;

/**
 *https://school.programmers.co.kr/learn/courses/30/lessons/81301
 */
public class NumbersAndStrings {

    public static void main(String[] args) {
        String test = "one4seveneight";
        String test2 = "23four5six7";
        String test3 = "2three45sixseven";
        String test4 = "123";

        System.out.println(solution(test));
        System.out.println(solution(test2));
        System.out.println(solution(test3));
        System.out.println(solution(test4));
    }

    /**
     *
     *
     *
     * @param s
     * @return
     */
    public static int solution(String s) {
        Map<String, String> map = new HashMap();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        for (String s1 : map.keySet()) {
            s = s.replaceAll(s1, map.get(s1));
        }

        return Integer.valueOf(s);
    }
}
