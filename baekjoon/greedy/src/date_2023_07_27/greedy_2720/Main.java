package date_2023_07_27.greedy_2720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] change = new int[]{25, 10, 5, 1};

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());

            for (int j = 0; j < change.length; j++) {
                sb.append(C / change[j]);
                C = C % change[j];
                if(j < change.length - 1) {
                    sb.append(" ");
                }
            }
            if (i < T - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
