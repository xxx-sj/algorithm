/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12916
 */
public class NumberOfPAndY {

    public static void main(String[] args) {

    }

    /**
     * 전달받은 스트링을 하나씩 순회하며, sum을 통해 p가 있으면 증가 y면 감소 시킴
     * 0이면 같거나 하나도 없음
     * sum > 0 or sum < -1 이면 한쪽이 더 많음
     * @param s
     * @return
     */
    public static boolean solution(String s) {
        int sum = 0;
        String upperCaseString = s.toUpperCase();

        for(int i = 0; i < upperCaseString.length(); i++) {
            char c = upperCaseString.charAt(i);
            if (c == 'P') {
                sum++;
            } else if (c == 'Y') {
                sum--;
            }
        }

        return sum == 0 ? true : false;

    }
}
