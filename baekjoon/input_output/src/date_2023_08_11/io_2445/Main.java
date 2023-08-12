package date_2023_08_11.io_2445;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            //1영역
            for(int j = 0; j < i; j++) {
                sb.append("*");
            }

            for(int j = N; j > i; j--) {
                sb.append(" ");
            }
            //1영역
            
            //2영역
            for(int j = N; j > i; j--) {
                sb.append(" ");
            }

            for(int j = 0; j < i; j++) {
                sb.append("*");
            }
            //2영역

            sb.append("\n");
        }

        for(int i = 1; i <= N - 1; i++) {
            //3영역
            for(int j = N; j > i; j--) {
                sb.append("*");
            }

            for(int j = 0; j < i; j++) {
                sb.append(" ");
            }
            //3영역
            
            //4영역
            for(int j = 0; j < i; j++) {
                sb.append(" ");
            }

            for(int j = N; j > i; j--) {
                sb.append("*");
            }
            //4영역
            sb.append("\n");
        }


        System.out.println(sb);
    }
}
