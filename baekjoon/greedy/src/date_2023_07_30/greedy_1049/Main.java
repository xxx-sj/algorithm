package date_2023_07_30.greedy_1049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] packages = new int[M];
        int[] single = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            packages[i] = Integer.parseInt(st.nextToken());
            single[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(packages);
        Arrays.sort(single);

        int packagePrice = packages[0] * (N / 6);
        packagePrice += N % 6 > 0 ? packages[0] : 0;

        if (packagePrice < single[0] * N) {
            System.out.println(packagePrice);
            return;
        }

        if (packages[0] > single[0] * 6) {
            System.out.println(single[0] * N);
            return;
        }

        int singlePrice = single[0] * (N % 6);
        System.out.println((packagePrice - packages[0]) + singlePrice);
    }
}


