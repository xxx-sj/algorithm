package date_2023_08_24.DP_2133;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N % 2 == 1) {
            System.out.println(0);
            return;
        }

        dp = new Integer[N + 1];

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        bottom_up(N);
        System.out.println(dp[N]);

//        System.out.println(top_down(N));
    }

    static int top_down(int N) {

        if(dp[N] == null) {
            dp[N] = top_down(N - 2) * dp[2];

            for(int i = N - 4; i >= 0; i -=2) {
                dp[N] += top_down(i) * 2;
            }
        }

        return dp[N];
    }

    static void bottom_up(int N) {

        for(int i = 4; i <= N; i+=2) {
            dp[i] = dp[i - 2] * dp[2];

            for(int j = i - 4; j >= 0; j-=2) {
                dp[i] += dp[j] * 2;
            }
        }
    }
}
