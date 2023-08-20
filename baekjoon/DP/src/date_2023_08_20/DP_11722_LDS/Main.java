package date_2023_08_20.DP_11722_LDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Integer[] dp;
    static int[] number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        number = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= N;i ++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

//        for(int i = N; i >= 0; i--) {
//            recur_lds(i);
//        }
        bottom_up(N);

        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= N; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }

    static int recur_lds(int N) {

        if(dp[N] == null) {

            dp[N] = 1;
            for(int i = N - 1; i >= 0; i--) {

                if(number[N] < number[i]) {
                    dp[N] = Math.max(dp[N], recur_lds(i) + 1);
                }
            }
        }


        return dp[N];
    }

    static void bottom_up(int N) {
        for(int i = 1; i <= N; i++) {
            dp[i] = 1;

            for(int j = 0; j < i; j++) {

                if(number[i] < number[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
    }
}
