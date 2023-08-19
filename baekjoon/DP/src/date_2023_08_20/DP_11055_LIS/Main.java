package date_2023_08_20.DP_11055_LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] number;
    static Integer[] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        number = new int[N];
        dp = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = number[0];
        bottom_up_lis();

//        for(int i = 1; i < N; i++) {
//            recur_lis(i);
//        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {

            if(max < dp[i]) {
                max = dp[i];
            }
        }

        System.out.println(max);
    }

    private static int recur_lis(int N) {

        if(dp[N] == null) {
            dp[N] = number[N];

            for(int i = N - 1; i >= 0; i--) {

                if(number[N] > number[i]) {
                    dp[N] = Math.max(dp[N], number[N] + recur_lis(i));;
                }
            }
        }

        return dp[N];
    }


    private static void bottom_up_lis() {

        for(int i = 1; i < N; i++) {
            dp[i] = number[i];

            for(int j = 0; j < i; j++) {
                if(number[i] > number[j]) {
                    dp[i] = Math.max(dp[j] + number[i], dp[i]);
                }
            }
        }
    }
}
