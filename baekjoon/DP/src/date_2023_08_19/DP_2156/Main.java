package date_2023_08_19.DP_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Integer dp [];
    static int wines[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        wines = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = wines[1];

        if(N >= 2) {
            dp[2] = wines[1] + wines[2];
        }

        System.out.println(recur(N));
    }

    private static int recur(int N) {

        if(dp[N] == null) {
//            dp[N] = Math.max(Math.max(recur(N - 2) + wines[N], recur(N - 3) + wines[N -1] + wines[N]), recur(N - 1));
//            dp[N] = Math.max(Math.max(recur(N - 1), recur(N - 2) + wines[N]), recur(N - 3) + wines[N - 1] + wines[N]);
            dp[N] = Math.max(Math.max(recur(N -2), recur(N - 3) + wines[N - 1]) + wines[N], recur(N - 1));
        }


        return dp[N];
    }
}
