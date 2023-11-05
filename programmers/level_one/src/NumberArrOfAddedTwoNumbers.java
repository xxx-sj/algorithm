import java.util.Set;
import java.util.TreeSet;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/68644
 */
public class NumberArrOfAddedTwoNumbers {

    public static void main(String[] args) {

    }


    /**
     * 배열의 길이를 구한다 lastIndexOfArray
     *      배열의 길이를 넘어가는 수를 더하면 안되서
     * 2중for문 돌면서 계산하기
     * set에 넣을까..? 중복값 들어가면 체크 할 필요없이 덮어씌우니까..?
     * set을 int[]로 바꾸면 되지않을까..?
     *
     * @param numbers
     * @return
     */
    public static int[] solution(int[] numbers) {
//        Set set = new HashSet();
        Set<Integer> set = new TreeSet();
        //TODO treeSet을 사용하면 add 하면서 정렬도 해준다..

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }

        Object[] objects = set.stream().toArray();
        int[] answer = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {
            answer[i] = Integer.valueOf(objects[i].toString());
        }

        return answer;

//        int[] ints = set.stream().sorted().mapToInt(Integer::intValue).toArray();
//        return ints;
    }
}
