import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
public class NumberOfK {

    public static void main(String[] args) {
        int[] solution = solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    /**
     *
     *
     * @param array
     * @param commands
     * @return
     */
    private static int[] solution(int[] array, int[][] commands) {

        int startIndex = 0;
        int endIndex = 0;
        int point = 0;

        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            for(int j = 0; j < commands[i].length; j++) {
                if (j == 0) {
                    startIndex = commands[i][j] - 1;
                } else if (j == 1) {
                    endIndex = commands[i][j] - 1;
                } else {
                    point = commands[i][j] - 1;
                }
            }

            for (; startIndex <= endIndex; startIndex++) {
                list.add(array[startIndex]);
            }
            //sort
            list.sort(Comparator.naturalOrder());

            result.add(list.get(point));
            list.clear();
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }


        return answer;
    }
}
