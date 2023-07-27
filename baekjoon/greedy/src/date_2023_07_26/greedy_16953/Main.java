package date_2023_07_26.greedy_16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int cnt = 1;
        while(B != A) {
            if (B < A) {
                cnt = -1;
                break;
            }

            if (B % 10 == 1) {
                B = B / 10;
            } else if (B % 2 == 0){
                B = B / 2;
            } else {
                cnt = -1;
                break;
            }
            cnt++;

        }

        System.out.println(cnt);
    }
}
