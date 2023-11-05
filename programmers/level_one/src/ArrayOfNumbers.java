import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12910
 */
public class ArrayOfNumbers {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 9 , 7, 10}, 5));
        System.out.println(solution(new int[]{2, 36, 1, 3}, 1));
    }

    /**
     * divisor 로 나누어 지는 값을 배열로 반환하는 함수
     * 반환할 값이 없다면 -1 배열 반환 => new int[]{ -1 }
     * 배열 순회하면서 divisor 로 나누기
     *      arr[i] % divisor == 0 나누어 떨어진다
     *      배열에 추가하기
     *
     *
     *
     * @param arr
     * @param divisor
     * @return
     */
    public static int[] solution(int[] arr, int divisor) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            if (i % divisor == 0) {
                sb.append(i);
                sb.append("/");
            }
        }
        if(sb.length() == 0) return new int[]{ -1 };

        String[] s = sb.toString().split("/");
        int[] temp = new int[s.length];
        Object[] objects = Arrays.stream(s).toArray();


        for(int i = 0; i < objects.length; i++) {
            temp[i] = Integer.valueOf(objects[i].toString());
        }


        return Arrays.stream(temp).sorted().toArray();

    }
}
