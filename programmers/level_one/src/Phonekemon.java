import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */
public class Phonekemon {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3,1,2,3}));
        System.out.println(solution(new int[] {3,3,3,2,2,4}));
        System.out.println(solution(new int[] {3,3,3,2,2,2}));
    }

    /**
     * set에 add 하면서 값들의 중복을 제거
     * 만약에 nums / 2 의 값이 set.size()보다 크다면 return set.size()
     * 아니라면 기본적으로 가질 수 있는 num / 2 반환
     *
     * @param nums
     * @return
     */
    private static int solution(int[] nums) {
        Set set = new HashSet();

        for (int num : nums) {
            set.add(num);
        }

        if (nums.length / 2 >= set.size()) {
            return set.size();
        }

       return nums.length / 2;
    }
}
