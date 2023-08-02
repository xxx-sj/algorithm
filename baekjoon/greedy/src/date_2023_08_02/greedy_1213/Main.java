package date_2023_08_02.greedy_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();

        String name = br.readLine();
        int[] alpha = new int[26];

        for(int i = 0; i < name.length(); i++) {
            alpha[name.charAt(i) - 'A']++;
        }

        int oddNumber = 0;
        Integer oddIdx = null;
        for(int i = 0; i < alpha.length; i++) {
            if(alpha[i] % 2 == 1) {
                oddIdx = i;
                oddNumber++;
            }
        }

        if(oddNumber > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        for(int i = 0; i < alpha.length; i++) {
            for(int j = 0; j < alpha[i] / 2; j++) {
                front.append((char)('A' + i));
                back.insert(0, (char)('A' + i));
            }
        }

        if(oddIdx != null) {
            System.out.println(front.toString() + (char)('A' + oddIdx) + back.toString());
        } else {
            System.out.println(front.toString() + back.toString());
        }

    }
}
