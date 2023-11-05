/**
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17681
 */
public class SecretMap {

    public static void main(String[] args) {
        String[] solution = solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        for (String s : solution) {
            System.out.println("s = " + s);
        }

    }


    /**
     *
     *
     *
     * @param n
     * @param arr1
     * @param arr2
     * @return
     */
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        int[][] result = new int[n][n];
        String[] map1 = new String[arr1.length];
        String[] map2 = new String[arr2.length];
        String[] answer = new String[n];

        for(int i = 0; i < arr1.length; i++) {
            map1[i] = convertToBinary(arr1[i], n);
            map2[i] = convertToBinary(arr2[i], n);
        }

        String map1Row = null;
        String map2Row = null;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < result.length; i++) {
            map1Row = map1[i];
            map2Row = map2[i];
            for (int j = 0; j < result[i].length; j++) {
                int add = map1Row.charAt(j) | map2Row.charAt(j);
                sb.append((add - 48) > 0 ? "#" : " ");
            }
            answer[i] = sb.toString();
            sb.delete(0, sb.length());
        }

        return answer;
    }

    /**
     * 십진수로 넘어온 값을 이진수로 변환하는 함수
     * 인수를 2로 나누었을 대 몫이 0이되면 종료
     * 그 전까지 append (decimal % 2)
     *
     *
     * 변환된 길이가 n보다 작다면 append 0
     * @param decimal
     * @return
     */
    private static String convertToBinary(int decimal, int n) {
        StringBuilder sb = new StringBuilder();

        while(true) {
            sb.append(decimal % 2);
            if (decimal / 2 == 0) break;
            decimal /= 2;
        }
        if (sb.length() < n) {
            while(sb.length() < n) {
                sb.append(0);
            }
        }
        sb.reverse();

        return sb.toString();
    }
}
