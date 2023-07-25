package date_2023_07_25.greedy_10162;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int A = 300;
        int B = 60;
        int C = 10;

        int resultA = T / A;
        T %= A;
        int resultB = T / B;
        T %= B;
        int resultC = T / C;
        T %= C;

        StringBuilder sb = new StringBuilder();
        if(T > 0) {
            System.out.println(-1);
        } else {
            sb.append(resultA);
            sb.append(" ");
            sb.append(resultB);
            sb.append(" ");
            sb.append(resultC);
            System.out.println(sb.toString());
        }

    }
}
