package date_2023_07_26.greedy_1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pr = new PriorityQueue();
        for(int i = 0; i < N; i++) {
            pr.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while(pr.size() > 1) {
            Integer var1 = pr.poll();
            Integer var2 = pr.poll();

            int sum = var1 + var2;
            result += sum;
            pr.add(sum);
        }

        System.out.println(result);

//        int[] cards = new int[N];
//
//        for(int i = 0; i < cards.length; i++) {
//            cards[i] = Integer.parseInt(br.readLine());
//        }
//
//        Arrays.sort(cards);
//
//        int result = 0;
//        for(int i = 1; i < N; i++) {
//            int sum = cards[i - 1] + cards[i];
//            cards[i] = sum;
//            result += sum;
//        }
//        System.out.println(result);
    }
}
