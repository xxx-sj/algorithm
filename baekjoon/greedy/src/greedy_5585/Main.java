package greedy_5585;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] coin = new int[]{500, 100, 50, 10 ,5, 1};

        int change = 1000 - Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 0; i < coin.length; i++) {

            if(change >= coin[i]) {
                cnt += change / coin[i];
                change = change % coin[i];
            }
        }

        System.out.println(cnt);
    }
}
