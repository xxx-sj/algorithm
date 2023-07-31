package date_2023_07_31.greedy_1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> negativeList = new ArrayList<>();
        List<Integer> positveList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number > 0) {
                positveList.add(number);
            } else {
                negativeList.add(number);
            }
        }

        Collections.sort(negativeList);
        Collections.sort(positveList, Collections.reverseOrder());

        int sum = 0;

        int idx = 0;
        while(true) {
            if (idx + 1 >= positveList.size()) {
                break;
            }

            if(positveList.get(idx + 1) == 1) {
                sum += positveList.get(idx) + positveList.get(idx + 1);
            } else {
                sum += positveList.get(idx) * positveList.get(idx + 1);
            }

            idx += 2;
        }

        for(int i = 0; i < positveList.size() - idx; i++) {
            sum += positveList.get(idx + i);
        }

        idx = 0;
        while(true) {
            if (idx + 1 >= negativeList.size()) {
                break;
            }

            sum += negativeList.get(idx) * negativeList.get(idx + 1);
            idx += 2;
        }

        for(int i = 0; i < negativeList.size() - idx; i++) {
            sum += negativeList.get(idx + i);
        }

        System.out.println(sum);

    }
}
