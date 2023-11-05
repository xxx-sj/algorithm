/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */
public class MinimalSize {

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{60,50}, {30, 70}, {60, 30}, {80, 40}}));

    }


    /**
     *
     * 모든 배열을 순회하면서 가장 큰 값을 구한다
     * 가로와 세로 중 큰것을 가로 / 작은 숫자를 세로
     *
     *
     *
     * @param sizes
     * @return
     */
    public static int solution(int[][] sizes) {

        int temp = 0;
        int maxWidth = 0;
        int maxHeight = 0;
        for(int i = 0; i < sizes.length; i++) {
            if (sizes[i][1] > sizes[i][0]) {
                temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }

            if (sizes[i][0] > maxWidth) {
                maxWidth = sizes[i][0];
            }
            if (sizes[i][1] > maxHeight) {
                maxHeight = sizes[i][1];
            }
        }

        return maxWidth * maxHeight;
    }

}
