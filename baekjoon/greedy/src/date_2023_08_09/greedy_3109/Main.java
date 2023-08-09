package date_2023_08_09.greedy_3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 0, 1};
    static int[] dc = {1, 1, 1};
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //행 열을 입력받는다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        //파이프가 지나가는 자리에 대한 표시로 visited[][]을 초기화한다.
        visited = new boolean[R][C];
        //입력받은 행열 크기의 map을 초기화한다
        map = new char[R][C];

        //입력받은 행 열 만큼 배열을 만든다.
        for(int i = 0; i < R; i++) {
            String temp = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        int count = 0;
        //행[row] 수 만큼 반복하며 이동을 시작한다.
        //0으로 넘기는 이유는 시작부분이 가장 왼쪽 세로 부분이기때문에 열의 값은 항상 0이다.
        for(int i = 0; i < R; i++) {

            if(connectPipe(i, 0)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean connectPipe(int row, int col) {

        //재귀의 종료 시점을 설정한다.
        // 이때 종룔 시점은 왼쪽에서 시작해 오른쪽으로 모두 이동하였다면 true를 반환한다.
        //이 때 C - 1인 이유는 C는 열의 갯수이고, 우리가 알 수 있는건 index값이기 때문에
        //C -1 을 해준다.
        if (col == C - 1) {
            visited[row][col] = true;
            return true;
        }

        //3번 반복하는 이유는 이동방향이 [오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선] 3개 이기 때문이다.
        for (int i = 0; i < 3; i++) {
            //입력받은 row, col을 이용해 앞으로 이동할 방향을 결정한다.
            // 각각 위에서 선언한 오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선 순서대로 이동한다.
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            //isvalid함수를 통해 새로 이동하는 위치를 검증한다.
            //isValid검증은 행 열에 대한 검증인데, 행 열이 0보다 큰지, 그리고
            //입력받은 행렬 정보보다 커지지 않았는지에 대한 정보이다.
            //예를들어 5x5 배열인데, 증가하다가 row 또는 col의 인덱스가 5가 되어버리면 입력값을 벗어나기 때문이다.
            //두 번째로 체크하는 것은 이 전에 파이프에 해당 배열을 지나 갔는가 이다.
            //지나갔다면 해당 위치로는 이동할 수 없기 때문이다.
            //마지막으로 건물이 있는지 아닌지에 대한 판단이다. map 배열에 건물이 없다면 "." 있다면 'X'이다.
            if(isValid(newRow, newCol) && !visited[newRow][newCol] && map[newRow][newCol] == '.') {
                //모두 통과하면 해당 위치에 이동할 수 있다는 의미[파이프 설치]이므로 visited 배열에 true를 입력한다.
                visited[newRow][newCol] = true;

                //새로운 위치로 이동하였으니 그 다음으로 이동해야 하기 때문에 connectPipe를 재귀로 호출한다.
                //이때는 만약 처음 입력받은 값이 (0,0)이고, 이동한 위치가 오른쪽 이라면
                // 다음으로 newRow, newCol이 (0,1)로 connectPipe에 전달된다.
                //전달된 값은 위의 검증을 거쳐 만약에 세 곳 모두로 이동할 수 없다면 돌아와
                //오른쪽 아래 대각선 이동에 대해 검증을 진행하게 된다.
                if(connectPipe(newRow, newCol)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isValid(int row, int col) {

        return row >= 0 && row < R && col >= 0 && col < C;
    }
}
