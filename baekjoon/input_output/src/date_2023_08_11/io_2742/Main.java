package date_2023_08_11.io_2742;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N > 0) {
            sb.append(N).append("\n");
            N--;
        }

        System.out.println(sb);
    }
}
