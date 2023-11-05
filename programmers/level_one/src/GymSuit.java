import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 */
public class GymSuit {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3}));
        System.out.println(solution(3, new int[]{3}, new int[]{1}));
    }

    /**
     *
     * 학생 수(n) - 잃어버린 학생 수 (lost.lenght) = 기본 값
     * 기본 값 + 여분의 학생  = 결과값
     *
     * 체육복을 잃어버린 학생 수 만큼 loop를 돌면서
     * 해당 번호에서 앞과 뒤에 여분의 체육복을 갖고 있는 학생이 있다면(앞번호 먼저 계산)
     * 결과(result)에 1개를 더하고 여분의 체육복을 갖고있는 학생(revese)의 값을 0으로 변경한다.
     *
     *
     * @param n 학생 수
     * @param lost 잃어버린 학생의 번호
     * @param reserve 여분을 갖고 있는 학생의 번호
     * @return
     */
    public static int solution(int n, int[] lost, int[] reserve) {
        int result = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    result++;
                    reserve[j] = -1;
                    lost[i] = -1;
                    break;
                }
            }
        }


        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) {
                    result++;
                    reserve[j] = -1;
                    break;
                }
            }
        }


        return result;
    }


    private static int solution2(int n, int[] lost, int[] reserve) {
        //인원 수
        int[] people = new int[n];
        //인원 수 
        int answer = n;

        for (int i : lost) {
            //인덱스 값 // 배열에는 값이 저장되어 있기때문에(1~ )인덱스로 저장하기 위해 -1;
            people[i - 1]--;
            //없는 인원의 번호에 값(인덱스)이 -1 로 설정
        }
        for (int i : reserve) {
            //인덱스 값
            people[i - 1]++;
            //여분의 값을 갖고 있다면 ++;
        }


        //여분의 체육복을 갖고있던 학생이 잃어버린 경우 또한 계산되어 있음(값 0);
        //여분의 체육복을 갖고있는 학생의 값(index + 1) 은 +1;
        //잃어버린 학생의 값 (index -1) 은 -1;



        for (int i = 0; i < people.length; i++) {
            if (people[i] == -1) {
                //만약에 해당 인덱스의 값이 -1 이라면 (잃어버린 학생)
                //i는 인덱스의 값이므로 +1를 통해 해당 학생의 번호를 갖는다.
                
                // i -1 >= 0 // 인덱스값0일 때 0 - 1은 인덱스 밖 영역이기에 계산에서 제외필요
                // people[i -1] 이전 인덱스 번호의 값이 1 일경우 (여분의 체육복을 갖고 있음 == 1)
                if (i - 1 >= 0 && people[i -1] == 1) {
                    //해당 인덱스 값 ++; => -1 -> 0;
                    people[i]++;
                    //이전 인덱스 값 --; => 1 -> 0;
                    people[i - 1]--;

                    //i + 1 < peole.length ;; check outOfBounds
                    //해당 인덱스(i) 이후의 값이 1일경우
                } else if (i + 1 < people.length && people[i+1] == 1) {
                    //해당 인덱스 값++;
                    people[i]++;
                    //이후 인덱스 값 --;
                    people[i+1]--;
                } else {
                    //answer--; 총인원에서 제외시키기 --;
                    answer--;
                }
            }
        }
        return answer;
    }
}
