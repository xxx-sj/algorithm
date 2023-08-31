package date_2023_09_01.Sort_11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> numbers = new HashMap<>();

        int max = Integer.MIN_VALUE;
        long result = Long.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            long number = Long.parseLong(br.readLine());

            Integer count = numbers.get(number);

            if(count != null) {
                numbers.put(number, count + 1);
            } else {
                numbers.put(number, 1);
            }


            int compare_count = numbers.get(number);
            if (max < compare_count) {
                max = compare_count;
                result = number;
            }


            if(max == compare_count) {
                if(result > number) {
                    result = number;
                }
            }
        }

        System.out.println(result);

    }
}
