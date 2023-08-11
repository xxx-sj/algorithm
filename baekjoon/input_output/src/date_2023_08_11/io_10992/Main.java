package date_2023_08_11.io_10992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            for(int j = N; j > i; j--) {
                sb.append(" ");
            }

            if (i == N) {
                for(int j = 0; j < 2 * i - 1; j++) {
                    sb.append("*");
                }
            } else {
                for(int j = 0; j < 2 * i - 1; j++) {
                    if(j == 0 || j == 2 * i - 1 - 1) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
