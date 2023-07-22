package greedy_2839;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int result = Main.conditionSolution(N);
        System.out.println(result);

    }

    private static int conditionSolution(int N) {
        int cnt = 0;
        while(true) {
            if(N % 5 == 0) {
                return (N / 5) + cnt;
            }

            if (N < 0) {
                return -1;
            }

            N -= 3;
            cnt++;
        }
    }
}
