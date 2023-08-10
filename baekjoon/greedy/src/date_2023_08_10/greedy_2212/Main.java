package date_2023_08_10.greedy_2212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] location = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            location[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(location);

        int[] diff = new int[N - 1];

        for(int i = 0; i < N - 1; i++) {
            diff[i] = location[i + 1] - location[i];
        }

        Arrays.sort(diff);

        int result = 0;
        for(int i = 0; i < diff.length - (K - 1); i++) {
            result += diff[i];
        }

        System.out.println(result);
    }
}
