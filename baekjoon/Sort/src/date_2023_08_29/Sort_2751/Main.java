package date_2023_08_29.Sort_2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 1 <= N <= 1,000,000
        // X = 이 수는 절대값이 1_000_000 보다 작거나 같은 정수이다.
        // -1_000_000 <= X <= 1_000_000
        boolean[] arr = new boolean[2_000_001];

        //1_000_000 을 더하는 이유는 정수 x가 -1_000_000도 나올 수 있기 때문에 
        // 더하여 0을 만들기 위해서
        for(int i = 0; i < N; i++) {
            int idx = Integer.parseInt(br.readLine()) + 1_000_000;
            arr[idx] = true;
        }

        //1_000_000 를 더했기 때문에 출력할 때 -1_000_000 한다.
        for(int i = 0; i < arr.length; i++) {
            if(arr[i]) {
                sb.append(i - 1_000_000).append("\n");
            }
        }

        System.out.println(sb);
    }
}
