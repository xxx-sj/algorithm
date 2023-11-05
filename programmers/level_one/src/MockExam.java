import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840?language=java
 */
public class MockExam {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,5}));
    }

    /**
     * 1번 수포자 [1, 2, 3, 4, 5 ..] =>  [1,2,3,4,5]  // length => 5
     * 2번 수포자 [21, 23, 24, 25 ..] => [2,1,2,3,2,4,2,5] // length => 8
     * 3번 수포자 [33, 11, 22, 44, 55] => [3,3,1,1,2,2,4,4,5,5] // length => 10
     *
     *
     * answer 가 넘어오면 해당 anser를 순회하면서 해당 수포자들의 값과 비교하여 가장 많이 맞춘 수포자의 번호를 배열에 담아 리턴한다.
     *      같은 숫자를 맞췄을 경우 오름차순으로 정렬한다.
     *
     *
     *
     * @param answer
     * @return
     */
    public static int[] solution(int[] answer) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int oneCnt = 0, twoCnt = 0, threeCnt = 0;

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == arr[i % arr.length]) {
                oneCnt++;
            }
            if (answer[i] == arr2[i % arr2.length]) {
                twoCnt++;
            }
            if (answer[i] == arr3[i % arr3.length]) {
                threeCnt++;
            }
        }

        int max = oneCnt;

        if (max <= twoCnt) {
            max = twoCnt;
        }
        if (max <= threeCnt) {
            max = threeCnt;
        }

        List<Integer> list = new ArrayList();

        if (max == oneCnt) list.add(1);
        if (max == twoCnt) list.add(2);
        if (max == threeCnt) list.add(3);

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
