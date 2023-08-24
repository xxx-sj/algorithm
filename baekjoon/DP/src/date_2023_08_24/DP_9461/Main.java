package date_2023_08_24.DP_9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Long dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        //test case
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            // 1<= N <= 100
            int N = Integer.parseInt(br.readLine());

            dp = new Long[N + 1];
            dp[0] = 0L;
            dp[1] = 1L;
            if(N >= 2) {
                dp[2] = 1L;
            }
            if (N >= 3) {
                dp[3] = 1L;
            }
            if(N >= 4) {
                dp[4] = 2L;
            }

            if (N >= 5) {
                bottom_up(N);
            }

            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);

    }

    static void bottom_up(int N) {
        for(int i = 5; i <= N; i++) {
            dp[i] = dp[i -1] + dp[i - 5];
        }
    }

//    static int top_down() {
//
//    }
}
