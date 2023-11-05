import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42889
 */
public class FailureRate {

    static class Point {
        int stage;
        int players;
        double rate;

        public int getStage() {
            return stage;
        }

        public void setStage(int stage) {
            this.stage = stage;
        }

        public int getPlayers() {
            return players;
        }

        public void setPlayers(int players) {
            this.players = players;
        }

        public double getRate() {
            return rate;
        }

        public void setRate(double rate) {
            this.rate = rate;
        }
    }

    public static void main(String[] args) {
        int[] solution = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        for (int i : solution) {
            System.out.println("i = " + i);
        }

    }

    /**
     *
     * n은 스테이지 수 1부터 시작 int i = 1 ~;
     * n만큼 돌면서 해당 스테이지에 머물있는 플레이어 수 count
     * map에 담기 key = stage / value = player
     * stage player / players
     * players - player;
     *
     * 정렬.....
     *
     * @param N
     * @param stages
     * @return
     */
    public static int[] solution(int N, int[] stages) {
        Point point = null;
        LinkedList<Point> list = new LinkedList<>();

        for (int i = 1; i <= N + 1; i++) {
            point = new Point();
            point.setStage(i);
            for (int stage : stages) {
                if (i == stage) {
                    point.setPlayers(point.getPlayers() + 1);
                }
            }
            list.add(point);
        }

        int players = stages.length;

        for (Point point1 : list) {
            if (point1.getPlayers() != 0) {
                point1.setRate((double)point1.getPlayers() / players);
            } else {
               point1.setRate(0);
            }

            players -= point1.getPlayers();
        }

        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double point1 = o1.getRate();
                double point2 = o2.getRate();

                return point1 >= point2 ? -1 : (point1 <= point2 ? 1 : 0);
            }
        });

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).getStage();
        }

        return answer;
    }
}
