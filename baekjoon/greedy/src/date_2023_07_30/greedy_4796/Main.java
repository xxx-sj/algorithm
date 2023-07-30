package date_2023_07_30.greedy_4796;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int idx = 1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            //P일중 L 일동안 사용가능 부여받은 휴가 V
            if(L == 0 && P == 0 && V == 0) {
                break;
            }

            sb.append("Case ");
            sb.append(idx++);
            sb.append(": ");
            sb.append((V / P) * L + Math.min(V % P, L));
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
