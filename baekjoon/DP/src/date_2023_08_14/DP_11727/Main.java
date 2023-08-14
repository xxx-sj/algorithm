package date_2023_08_14.DP_11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];

        dp[0] = dp[1] = 1;

        System.out.println(recur(N));
    }

    private static int recur(int N) {
        if (N == 2) {
            dp[N] = 3;
        }
        if(dp[N] == null) {
            dp[N] = ((recur(N - 2) * 2) + recur(N - 1)) % 10007;
        }
        return dp[N];
    }
}
