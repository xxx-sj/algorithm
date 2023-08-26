package date_2023_08_25.DP_11052;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] cards;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        cards = new int[N + 1];
        dp = new Integer[N + 1];

        for(int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        dp[1] = cards[1];

        bottom_up(N);
        System.out.println(dp[N]);

//        System.out.println(top_down(N));
    }

    static void bottom_up(int N) {
        for(int i = 2; i <= N; i++) {
            dp[i] = cards[i];
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + cards[i - j]);
            }
        }
    }

    static int top_down(int N) {

        if(dp[N] == null) {
            dp[N] = cards[N];
            for(int i = 1; i <= N; i++) {
                dp[N] = Math.max(dp[N], top_down(N - i) + cards[i]);
            }
        }

        return dp[N];
    }
}
