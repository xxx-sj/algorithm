package date_2023_08_11.io_2439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

//        for(int i = 0; i < N; i++) {
//            for(int j = N; j > i + 1; j--) {
//                System.out.print(" ");
//            }
//            for(int j = 0; j <= i; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }

        int star = 1;
        for(int i = N - 1; i >= 0; i--) {

            for(int j = 0; j < i; j++) {
                sb.append(" ");
            }

            for(int j = 0; j < star; j++) {
                sb.append("*");
            }

            sb.append("\n");
            star++;
        }

        System.out.println(sb);
    }
}
