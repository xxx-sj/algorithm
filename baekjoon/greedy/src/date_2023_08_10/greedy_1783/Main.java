package date_2023_08_10.greedy_1783;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //가로
        int N = Integer.parseInt(st.nextToken());
        //세로
        int M = Integer.parseInt(st.nextToken());

        int count = 0;
        if(N == 1) {
            count = 1;
        } else if (N == 2) {
            count = Math.min(4, (M + 1) / 2);
        } else if (N >= 3) {
            if(M >= 7) {
                count = M - 2;
            } else {
                count = Math.min(4, M);
            }
        }
        System.out.println(count);
    }
}
