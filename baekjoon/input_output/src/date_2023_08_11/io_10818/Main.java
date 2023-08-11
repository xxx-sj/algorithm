package date_2023_08_11.io_10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

//        solutionWithSort();
        solutionWithMinMax();
    }

    private static void solutionWithSort() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        System.out.println(numbers[0] + " " + numbers[numbers.length - 1]);
    }

    private static void solutionWithMinMax() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int MAX = Integer.MIN_VALUE;
        int MIN = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if(number >= MAX) {
                MAX = number;
            }
            if(number <= MIN) {
                MIN = number;
            }
        }

        System.out.println(MIN + " " + MAX);
    }
}
