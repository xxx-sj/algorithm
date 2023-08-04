package date_2023_08_04.greedy_1080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        int[][] B = new int[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                A[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                B[i][j] = str.charAt(j) - '0';
            }
        }

        int result = 0;
        for(int i = 0; i < N - 2; i++) {
            for(int j = 0; j < M -2; j++) {
                if(A[i][j] != B[i][j]) {
                    flip(A, i, j);
                    result++;
                }
            }
        }

        if (isSameMatrix(A, B)) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    private static void flip(int[][] matrix, int x, int y) {
        for(int i = x; i < x + 3; i++) {
            for(int j = y; j < y + 3; j++) {
                matrix[i][j] = 1 - matrix[i][j];
            }
        }
    }

    private static Boolean isSameMatrix(int[][] m1, int[][] m2) {
        for(int i = 0; i < m1.length; i++) {
            for(int j = 0; j < m1[i].length; j++) {
                if(m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
