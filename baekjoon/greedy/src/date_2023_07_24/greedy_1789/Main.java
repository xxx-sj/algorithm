package date_2023_07_24.greedy_1789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());
        if(S == 1 || S == 2) {
            System.out.println(1);
            return;
        }

        long sum = 0;
        for(int i = 1; i < S; i++) {
            sum += i;
            if (sum > S) {
                System.out.println(i - 1);
                break;
            } else if (sum == S) {
                System.out.println(i);
                break;
            }
        }
    }
}
