package date_2023_08_01.greedy_1449;

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
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int tape = 1;
        double startTapePoint = arr[0] - 0.5;

        for(int i = 1; i < N; i++) {
            if(startTapePoint + L >= arr[i]) {
                continue;
            }
            startTapePoint = arr[i] - 0.5;
            tape++;
        }

        System.out.println(tape);

    }
}
