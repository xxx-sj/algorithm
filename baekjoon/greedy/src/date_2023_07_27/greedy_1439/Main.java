package date_2023_07_27.greedy_1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String[] numbers = S.split("");

        String firstNumber = numbers[0];
        String prev_number = numbers[0];
        int cnt = 0;
        for(int i = 1; i < numbers.length; i++) {
//            if(firstNumber.equals(numbers[i])) {
//            }
//            if(!firstNumber.equals(numbers[i]) && prev_number.equals(numbers[i])) {
//            }
            if(!firstNumber.equals(numbers[i]) && !prev_number.equals(numbers[i])) {
                cnt++;
            }
            prev_number = numbers[i];
        }

        System.out.println(cnt);
    }
}
