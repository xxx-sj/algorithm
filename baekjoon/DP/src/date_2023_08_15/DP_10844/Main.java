package date_2023_08_15.DP_10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Long[][] dp;

    static long mod = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //배열 생성
        dp = new Long[N + 1][10];

        //초기값 설정
        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;
        bottom_up(N);

        for(int i = 1; i <= 9; i++) {
            result += dp[N][i];
        }

//        for(int i = 1; i <= 9; i++) {
//            result += recur(N, i);
//        }

        System.out.println(result % mod);

    }

    private static long recur(int digit, int val) {

        if(digit == 1) {
            return dp[digit][val];
        }

        if(dp[digit][val] == null) {

            if(val == 0) {
                dp[digit][val] = recur(digit - 1, 1) % mod;
            } else if (val == 9) {
                dp[digit][val] = recur(digit - 1, 8) % mod;
            } else {
                dp[digit][val] = (recur(digit - 1, val - 1) + recur(digit - 1, val + 1)) % mod;
            }
        }

        return dp[digit][val];
    }

    static void bottom_up(int N) {

        for(int i = 2; i <= N; i++) {

            for(int j = 0; j < 10; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i - 1][1] % mod;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j + 1] + dp[i -1][j - 1]) % mod;
                }
            }
        }
    }
}
