package date_2023_08_18.DP_9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] stickers;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            stickers = new int[2][N + 1];

            for(int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int k = 1; k <= N; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp = new Integer[2][N + 1];

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            System.out.println(Math.max(recur(0, N), recur(1, N)));
        }
    }

    private static int recur(int row, int col) {

        if (col == 1) {
            return stickers[row][col];
        }

        if (dp[row][col] == null) {
            if (col == 2) {
                dp[row][col] = recur(1 - row, col - 1) + stickers[row][col];
            } else {
                dp[row][col] = Math.max(recur(1 - row, col - 1), recur(1 - row, col - 2)) + stickers[row][col];
            }
        }

        return dp[row][col];
    }
}
