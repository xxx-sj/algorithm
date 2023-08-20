package date_2023_08_21.DP_1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Integer[] dp;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        dp = new Integer[N];
        numbers = new int[N];

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = numbers[0];


        recur(N - 1);



        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);


    }


    static int recur(int N) {

        if(dp[N] == null) {
            dp[N] = Math.max(recur(N - 1) + numbers[N], numbers[N]);
        }

        return dp[N];
    }
}
