package date_2023_08_14.DP_9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 1<= N < 11
//        dp = new Integer[N + 1];
        dp = new Integer[11];

        dp[0] = dp[1] = 1;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            sb.append(recur(number)).append("\n");
        }

        System.out.println(sb);
    }

    private static int recur(int N) {

        if(N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 4;
        }

        if(dp[N] == null) {
            dp[N] = recur(N - 1) + recur(N - 2) + recur(N - 3);
        }
        return dp[N];
    }
}
