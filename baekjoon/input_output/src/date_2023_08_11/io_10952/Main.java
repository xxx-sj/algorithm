package date_2023_08_11.io_10952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String line;

        while(true) {
            line = br.readLine();
            st = new StringTokenizer(line, " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(A == 0 && B == 0) {
                break;
            }

            sb.append(A + B).append("\n");
        }

        System.out.println(sb);

    }
}
