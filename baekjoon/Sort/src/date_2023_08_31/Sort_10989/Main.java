package date_2023_08_31.Sort_10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] result_arr = new int[N];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (max < number) {
                max = number;
            }
            arr[i] = number;
        }

        int[] counting = new int[max + 1];

        for(int i = 0; i < arr.length; i++) {
            counting[arr[i]]++;
        }

        //counting 더하여 arr 위치 잡기
        for(int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        for(int i = arr.length - 1; i >= 0; i--) {
            int idx = --counting[arr[i]];

            result_arr[idx] = arr[i];
        }

        for(int i = 0; i < result_arr.length; i++) {
            sb.append(result_arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
