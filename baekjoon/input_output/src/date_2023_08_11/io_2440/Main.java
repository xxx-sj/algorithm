package date_2023_08_11.io_2440;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

//        int star = N;
//        for(int i = 0; i < N; i++) {
//            for(int j = 0; j < star; j++) {
//                sb.append("*");
//            }
//
//            star--;
//            sb.append("\n");
//        }

        for(int i = N; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
