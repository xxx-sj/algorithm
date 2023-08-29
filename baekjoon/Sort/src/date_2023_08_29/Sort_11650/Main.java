package date_2023_08_29.Sort_11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Point[] arr = new Point[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = new Point(x, y);
        }

        Arrays.sort(arr, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x == o2.x) {
                    return Integer.compare(o1.y, o2.y);
                }

                return Integer.compare(o1.x, o2.x);
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            sb.append(arr[i].x).append(" ").append(arr[i].y).append("\n");
        }

        System.out.println(sb);

    }
}
