package date_2023_08_18.DP_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    static Integer dp[];
    static int glass[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        glass = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            glass[i] = Integer.parseInt(br.readLine());
        }

        //초기값 세팅
        dp[0] = 0;
        dp[1] = glass[1];


    }

    private static int recur(int N) {

        if(N == 1) {
            return dp[N];
        }

        if(dp[N] == null) {
            dp[N] = Math.max(Math.max(recur(N - 2), recur(N - 3) + glass[N - 1]) + glass[N], recur(N - 1));
        }

        return dp[N];
    }
}
