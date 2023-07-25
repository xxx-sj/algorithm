package date_2023_07_25.greedy_10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] split = str.split("");
        Integer[] number = new Integer[split.length];

        for(int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(number, Collections.reverseOrder());

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number.length; i++) {
            sum += number[i];
            sb.append(number[i]);
        }

        if (sum % 3 != 0 || number[number.length -1] != 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb.toString());
        }
    }
}
