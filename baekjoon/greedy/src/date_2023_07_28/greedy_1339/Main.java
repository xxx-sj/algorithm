package date_2023_07_28.greedy_1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] alpha_arr = new int[26];

        for(int i = 0; i < N; i++) {
            String alpha = br.readLine();
            int base = 10;
            for(int j = 1; j <= alpha.length(); j++) {
                char c = alpha.charAt(j - 1);
                alpha_arr[c - 'A'] += Math.pow(10, (alpha.length() - j));
            }
        }

        Arrays.sort(alpha_arr);



        int result = 0;
        int number = 9;
        for(int i = alpha_arr.length - 1; i >= 0; i--) {
            if (alpha_arr[i] == 0) {
                break;
            }

            result += alpha_arr[i] * number;
            number--;
        }

        System.out.println(result);

    }
}
