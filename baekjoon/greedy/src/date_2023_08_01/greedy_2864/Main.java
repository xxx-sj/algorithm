package date_2023_08_01.greedy_2864;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken();
        String B = st.nextToken();

        String replacedA = A.replaceAll("6", "5");
        String replacedB = B.replaceAll("6", "5");

        int min = Integer.parseInt(replacedA) + Integer.parseInt(replacedB);

        replacedA = A.replaceAll("5", "6");
        replacedB = B.replaceAll("5", "6");

        int max = Integer.parseInt(replacedA) + Integer.parseInt(replacedB);

        System.out.println(min + " " + max);

    }
}
