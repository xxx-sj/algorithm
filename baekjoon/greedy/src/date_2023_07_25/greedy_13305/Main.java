package date_2023_07_25.greedy_13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //N 입력을 받는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] price = new long[N];
        long[] distance = new long[N -1];

        //N-1 만큼의 거리를 입력받는다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }
        //N만큼의 주유비용을 받는다.
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }
        //최소 비용은 price[0] 부터 시작한다.

        long sum = 0;
        long minPrice = price[0];

        for(int i = 0; i < N - 1; i++) {

            if (price[i] < minPrice) {
                minPrice = price[i];
            }

            sum += minPrice * distance[i];
        }

        System.out.println(sum);


        //0부터 돌면서
        //현재 가격이 더 작다면 min price를 변경하고
        //거리값을 꺼내어 곱한다.

    }
}
