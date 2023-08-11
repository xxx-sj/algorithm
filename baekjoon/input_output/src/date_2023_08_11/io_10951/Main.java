package date_2023_08_11.io_10951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str;
//        while((str = br.readLine()) != null)
        while(true) {
            str = br.readLine();
            if(str == null) break;;
            st = new StringTokenizer(str, " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append((A + B));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
