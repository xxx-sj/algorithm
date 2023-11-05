import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12915
 */
public class StringOfSorted {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"sun", "bed", "car"}, 1)[0]);
    }

    /**
     * 전달받은 스트링 배열에서 n 번째 문자를 가장 앞으로 붙여서 sort 후
     *  substring을 통해 앞글자를 제외시키고 문자열에 다시 넣기
     * @param strings
     * @param n
     * @return
     */
    public static String[] solution(String[] strings, int n) {
        for (int i = 0; i < strings.length; i++) {
            char c = strings[i].charAt(n);
            strings[i] = c + strings[i];
        }

        Object[] objects = Arrays.stream(strings).sorted().toArray();

        for(int i = 0; i < objects.length; i++) {
            strings[i] = String.valueOf(objects[i]).substring(1);
        }

        return strings;
    }
}
