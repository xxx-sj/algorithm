package date_2023_08_06.greedy_1343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int countX = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'X') {
                countX++;
            } else {
                if(countX % 2 != 0) {
                    System.out.println(-1);
                    return;
                }

                Main.appendAAndB(sb, countX);

                countX = 0;
                sb.append(".");
            }
        }

        if(countX % 2 != 0) {
            System.out.println(-1);
            return;
        }

        Main.appendAAndB(sb, countX);

        System.out.println(sb.toString());
    }
    private static void appendAAndB(StringBuilder sb, int countX) {
        int numberA = 0;
        int numberB = 0;

        if (countX >= 4) {
            numberA = countX / 4;
            countX = countX % 4;
        }
        numberB = countX / 2;

        for(int j = 0; j < numberA; j++) {
            sb.append("AAAA");
        }

        for(int j = 0; j < numberB; j++) {
            sb.append("BB");
        }
    }
}
