/**
 * https://programmers.co.kr/learn/courses/30/lessons/12922
 */
public class  Watermelon{

    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                sb.append("박");
            } else {
                sb.append("수");
            }
        }


        return sb.toString();

    }

    /**
     * 참고 자료
     * @param n
     * @return
     */
    public String watermelon(int n){

        return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
    }
}
