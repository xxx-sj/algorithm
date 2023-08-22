package date_2023_08_22.DP_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] stairs;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        stairs = new int[N + 1];
        dp = new Integer[N + 1];

        for(int i = 1;i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = stairs[1];
        //조건을 추가하지않으면 N = 1일 때, dp[2], stairs[2]에 접근하려다 오류 발생함.
        if (N >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        System.out.println(recur(N));
    }

    private static int recur(int N) {

        if(N == 1) {
            return dp[N];
        }

        if(dp[N] == null) {
            dp[N] = Math.max(recur(N - 2), recur(N - 3) + stairs[N - 1]) + stairs[N];
        }

        return dp[N];
    }
}
