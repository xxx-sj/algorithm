package date_2023_08_21.DP_11054;

import java.awt.im.InputContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] numbers;

    static Integer[] lis_dp;
    static Integer[] lds_dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        numbers = new int[N];

        lis_dp = new Integer[N];
        lds_dp = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            recur_lis(i);
        }

        for(int i = N - 1; i >= 0; i--) {
            recur_lds(i);
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {

            max = Math.max(max, recur_lds(i) + recur_lis(i) - 1);
        }

        System.out.println(max);
    }


    static int recur_lis(int N) {

        if(lis_dp[N] == null) {
            lis_dp[N] = 1;

            for(int i = N - 1; i >= 0; i--) {

                if (numbers[N] > numbers[i]) {
                    lis_dp[N] = Math.max(lis_dp[N], recur_lis(i) + 1);
                }
            }
        }


        return lis_dp[N];
    }


    static int recur_lds(int N) {

        if(lds_dp[N] == null) {
            lds_dp[N] = 1;

            for(int i = N + 1; i < lds_dp.length; i++) {
                if(numbers[N] > numbers[i])  {
                    lds_dp[N] = Math.max(lds_dp[N], recur_lds(i) + 1);
                }
            }
        }

        return lds_dp[N];
    }
}
