import java.util.Arrays;

public class SortOfNumber {

    public static void main(String[] args) {
        System.out.println(solution(118372));
    }


    public static long solution(long n) {
        String[] split = String.valueOf(n).split("");
//        Object[] objects = Arrays.stream(split).sorted(Comparator.reverseOrder()).toArray();
        Object[] objects = Arrays.stream(split).sorted().toArray();
        StringBuilder sb = new StringBuilder();

        for (Object object : objects) {
            sb.append((String.valueOf(object)));
        }
//        return Long.parseLong(sb.toString())
        return Long.parseLong(sb.reverse().toString());

    }
}
