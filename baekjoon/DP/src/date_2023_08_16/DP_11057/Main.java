package date_2023_08_16.DP_11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Long dp[][];
    static int mod = 10_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Long[N + 1][10];


        //초기값 설정
        for(int i = 0; i <= 9; i++) {
            dp[1][i] = 1L;
        }


        long result = 0;

        for(int i = 0; i <= 9; i++) {
            result += recur(N, i);

        }
            System.out.println(result % mod);

    }

    static long recur(int digit, int val) {

        if (digit == 1) {
            return dp[digit][val];
        }

        if(dp[digit][val] == null) {
//            if (val == 9) {
//                dp[digit][val] = recur(digit - 1, 9) % mod;
//            } else {
//                long result = 0;
//                for(int i = val; i <= 9; i++) {
//                    result += recur(digit - 1, i);
//                }
//                dp[digit][val] = result  % mod;
//            }
            long result = 0;
            for(int i = val; i <= 9; i++) {
                result += recur(digit - 1, i);
            }

            dp[digit][val] = result % mod;
        }

        return dp[digit][val];
    }
}
