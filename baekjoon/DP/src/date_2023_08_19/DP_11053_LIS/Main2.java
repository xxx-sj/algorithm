package date_2023_08_19.DP_11053_LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    static Integer dp[];
    static int[] number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N];
        number = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;

        for(int i = 1; i < N; i++) {

            dp[i] = 1;

            for(int j = 0; j < i; j++) {

                if(number[i] > number[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            if(max < dp[i]) {
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}
