package date_2023_08_26.DP_2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;
    static int mod = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String password = br.readLine();

        if(password.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        dp = new int[password.length() + 1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= password.length(); i++) {
            if(password.charAt(i - 1) == '0') {
                int prev_number = Integer.parseInt(password.substring(i - 2, i - 1));
                if(!(prev_number == 1 || prev_number == 2)) {
                    //int[] 의 기본값은 0 이기때문에 따로 값을 초기화하지 않는다.
//                    dp[i] = 0;
                    break;
                } else {
                    dp[i] = dp[i - 2] % mod;
                }
            } else if (password.charAt(i - 2) == '0') {
                dp[i] = dp[i - 1] % mod;
            } else {
                int two_number = Integer.parseInt(password.substring(i - 2, i));

                if (two_number > 9 && two_number < 27) {
                    dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
                } else {
                    dp[i] = dp[i - 1] % mod;
                }
            }
        }

        System.out.println(dp[password.length()] % mod);

    }
}
