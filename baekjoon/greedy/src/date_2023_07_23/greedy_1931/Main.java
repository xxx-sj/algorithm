package date_2023_07_23.greedy_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

//        Scanner sc = new Scanner(System.in);

//        int N = sc.nextInt();

        int[][] time = new int[N][2];

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
            //시작시간
//            time[i][0] = sc.nextInt();
            //종료시간
//            time[i][1] = sc.nextInt();
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int prev_end_time = 0;

        for(int i = 0; i < N; i++) {

            //직전 종료시간이 다음 회의시간 시작 시간보다 작거나 같을경우
            if(prev_end_time <= time[i][0]) {
                prev_end_time = time[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
