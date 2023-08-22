package date_2023_08_22.DP_1699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];

        dp[0] = 0;
        dp[1] = 1;

        System.out.println(bottom_up2(N));
    }

    private static int bottom_up(int N) {

        for(int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;

            for(int j = 1; j <= i / 2; j++) {

                if(j * j == i) {
                    min = 1;
                    break;
                } else {
                    min = Math.min(min, dp[i - j]  + dp[j]);
                }
            }

            dp[i] = min;
        }

        return dp[N];
    }

    private static int bottom_up2(int N) {

        for(int i = 2; i <= N; i++) {
            dp[i] = i;
            for(int j = 1; j * j<= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        return dp[N];
    }


}
