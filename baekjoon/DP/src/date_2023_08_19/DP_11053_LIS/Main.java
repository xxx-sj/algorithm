package date_2023_08_19.DP_11053_LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Integer dp [];
    static int number [];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        dp = new Integer[N];
        number = new int[N];

        for(int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        //초기값
        dp[0] = 1;

        for(int i = 0; i < N; i++) {
            recur(i);
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        System.out.println(max);

    }

    private static int recur(int N) {

        if(dp[N] == null) {

            dp[N] = 1;

            for(int i = N - 1; i >= 0; i--) {

                if(number[N] > number[i]) {
                    dp[N] = Math.max(dp[N], recur(i) + 1);
                }
            }
        }

        return dp[N];
    }
}
