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
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                stickers[0][j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                stickers[1][j] = Integer.parseInt(st.nextToken());
            }

            dp = new Integer[2][N + 1];

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];


        }
    }

    private static int recur(int row, int col) {

        if(col == 1) {
            return dp[row][col];
        }

        if (dp[row][col] == null) {
            if(row == 1) {
            } else if (row == 0) {

            }
        }


        return dp[row][col];
    }
}
