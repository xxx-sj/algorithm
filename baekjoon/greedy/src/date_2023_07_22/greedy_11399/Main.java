package date_2023_07_22.greedy_11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] time = new int[N];

        for(int i = 0; i < N; i++) {
            time[i] = sc.nextInt();
        }

        Arrays.sort(time);

        int prev = 0;
        int sum = 0;

        for(int i = 0; i < N; i++) {
            prev += time[i];

            sum += prev;
        }

        System.out.println(sum);


    }
}
