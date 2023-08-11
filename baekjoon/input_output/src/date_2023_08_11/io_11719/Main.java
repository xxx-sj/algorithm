package date_2023_08_11.io_11719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        StringBuilder sb = new StringBuilder();

        while(true) {
            str = br.readLine();
            if(str == null) {
                break;
            }
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
