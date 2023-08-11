package date_2023_08_11.io_11721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();

        int count  = line.length() / 10;
        if(line.length() % 10 > 0)  {
            count++;
        }

        for(int i = 0 ; i < count; i++) {
            for(int j = i * 10; j < 10 * (i + 1); j++) {
                if (j == line.length()) break;
                sb.append(line.charAt(j));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
