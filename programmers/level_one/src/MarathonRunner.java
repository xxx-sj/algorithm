import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */
public class MarathonRunner {

    public static void main(String[] args) {
//        System.out.println(solution(new String[]{"leo", "kiki", "eden"} , new String[]{"eden", "kiki"}));
        System.out.println(solution2(new String[]{"leo", "kiki", "eden"} , new String[]{"eden", "kiki"}));
//        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"} , new String[]{"stanko", "ana", "mislav"}));
    }

    public static String solution(String[] participant, String[] completion) {

        List<String> players = new LinkedList();

        for (String player : participant) {
            players.add(player);
        }

        for (String s : completion) {
            players.remove(s);
        }


        for (String player : players) {
            return player;
        }

        return null;
    }

    /**
     * 성능문제 개선
     *
     * hasmap을 만들어서 키값에 해당하는 값의 value를 증가시킨다. (default = 1);
     * 완주한 선수의 값(key)의 value를 감소 시킨다.
     * key에 해당하는 값을 조회했을 때, 1(value)를 갖고있는 key를 반환한다.
     *
     * @param participant
     * @param completion
     * @return
     */
    private static String solution2(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap();

        for (String player : participant) {
            if (map.get(player) == null) {
                map.put(player, 1);
                continue;
            }

            map.put(player, map.get(player) + 1);
        }

        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        for (String player: map.keySet()) {
            if (map.get(player) == 1) {
                return player;
            }
        }

        return null;

    }
}
