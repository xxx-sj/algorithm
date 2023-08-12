package date_2023_08_13.DP_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer DP[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        DP = new Integer[N + 1];
        DP[0] = DP[1] = 0;


        System.out.println(recur(N));
    }

    private static int recur(int N) {
        if (DP[N] == null) {
            if (N % 6 == 0) {
                DP[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
            } else if (N % 3 == 0) {
                DP[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            } else if (N % 2 == 0) {
                DP[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            } else {
                DP[N] = recur(N - 1) + 1;
            }
        }
        return DP[N];
    }
}
