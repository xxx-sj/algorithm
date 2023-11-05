/**
 * https://programmers.co.kr/learn/courses/30/lessons/12930
 */
public class WeirdNumber {

    public static void main(String[] args) {
        String test = "try hello world";
        System.out.println(solution(test));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder(s);

        int outerIndex = 0;

        for(int idx = 0; idx < s.length(); idx++) {
            if(sb.charAt(idx) == ' ') {
                outerIndex = 0;
                continue;
            }
            System.out.println("outerIndex = " + outerIndex);
            if(outerIndex % 2 == 1) {
                sb.replace(idx, idx + 1, String.valueOf(sb.charAt(idx)).toLowerCase());
            } else if (outerIndex % 2 == 0){
                sb.replace(idx, idx + 1, String.valueOf(sb.charAt(idx)).toUpperCase());
            }
            outerIndex++;
        }
        return sb.toString();
    }
}
