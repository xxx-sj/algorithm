package date_2023_08_16.DP_2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Long dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Long[N + 1][2];

        dp[1][0] = dp[1][1] = 1L;

        System.out.println(recur(N, 1));
    }

    static Long recur(int digit, int val) {

        if(digit == 1) {
            return dp[digit][val];
        }

        if(dp[digit][val] == null) {
            if(val == 1) {
                dp[digit][val] = recur(digit - 1, 0);
            } else {
                dp[digit][val] = recur(digit - 1, 0) + recur(digit - 1, 1);
            }
        }

        return dp[digit][val];
    }
}
