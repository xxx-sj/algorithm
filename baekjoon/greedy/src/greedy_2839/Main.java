package greedy_2839;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

//        int result = Main.conditionSolution(N);
//        int result = Main.conditionSolution2(N);
        Main.ruleSolution(N);
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

    private static int conditionSolution2(int N) {
        if (N % 5 == 0) {
            return N / 5;
        } else {
            int amount = N / 5;
            for(int i = amount; i > 0; i--) {
               int temp = N - (i * 5);
               if (temp % 3 == 0) {
                   return i + (temp/3);
               }
            }
        }

        if (N % 3 == 0) {
            return N / 3;
        }

        return -1;
    }

    private static void ruleSolution(int N) {
        if (N == 4 || N == 7) {
            System.out.println(-1);
        }
        else if (N % 5 == 0) {
            System.out.println(N / 5);
        }
        else if (N % 5 == 1 || N % 5 == 3) {
            System.out.println((N / 5) + 1);
        }
        else if (N % 5 == 2 || N % 5 == 4) {
            System.out.println((N / 5) + 2);
        }
    }
}
