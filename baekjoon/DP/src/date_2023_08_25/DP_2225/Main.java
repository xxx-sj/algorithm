package date_2023_08_25.DP_2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Integer[][] dp;

    static int mod = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1<= N <= 200
        int N = Integer.parseInt(st.nextToken());
        // 1<= K <= 200
        int K = Integer.parseInt(st.nextToken());

        dp = new Integer[K + 1][N + 1];

        // dp[K][0] = 1;
        for(int i = 1; i <= K; i++) {
            dp[i][0] = 1;
        }

        //dp[1][N] = 1;
//        for(int i = 1; i <= N; i++) {
        for(int i = 0; i <= N; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= K; i++) {
            for(int j = 1; j <= N; j++) {
                //dp[K - 1][N] + dp[K][N - 1]
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
            }
        }

        System.out.println(dp[K][N]);

    }
}
