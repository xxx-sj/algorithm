package date_2023_07_26.greedy_1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스
        int T = Integer.parseInt(br.readLine());


        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[][] rates = new int[N][2];

            for(int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                rates[j][0] = Integer.parseInt(st.nextToken());
                rates[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(rates, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int cnt = 1;
            int comp = rates[0][1];
            for(int k = 1; k < N; k++) {
                if(comp > rates[k][1]) {
                    comp = rates[k][1];
                    cnt++;
                }
            }
            System.out.println(cnt);

        }
    }
}
