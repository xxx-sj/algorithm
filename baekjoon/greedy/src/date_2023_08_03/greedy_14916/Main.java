package date_2023_08_03.greedy_14916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        while(true) {
            if (N > 10) {
                N -= 5;
                result++;
                continue;
            }

            if(N % 5 == 0) {
                result += N / 5;
                break;
            } else if (N % 2 == 0) {
                result += N / 2;
                break;
            }

            N -= 2;
            result++;

            if(N <= 1) {
                result = -1;
                break;
            }

        }

        System.out.println(result);

    }
}
