package date_2023_08_06.greedy_2847;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        int prev_number = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] >= prev_number) {
                result += arr[i] - prev_number;
                prev_number -= 1;
                result++;
            } else {
                prev_number = arr[i];
            }
        }

        System.out.println(result);
    }
}
