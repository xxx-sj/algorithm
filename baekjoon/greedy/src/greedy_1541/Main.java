package greedy_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Integer.MAX_VALUE로 초기화한 이유는 맨 처음 초깃값을 초기화하기 위해서이다.
        //조건에서도 5자를 초과할수 없다라는 조건이 있기 때문에 MAX_VALUE인 53556을 넘을 수 없다.
        int sum = Integer.MAX_VALUE;

        StringTokenizer sub = new StringTokenizer(br.readLine(), "-");

//        br.readLine().split("-");

        while(sub.hasMoreTokens()) {
            int temp = 0;

            //+에는 \\를 넣는 이유는 split은 정규식을 사용하는데 + 같은경우는
            // 정규식에서 특수한 의미를 갖기 때문에 문자열로 나타내기 위해서
            // \ (백슬래시)를 추가해 주는것이다. 여기서 백슬래시를 2개 추가한 이유는
            // 하나로는 문자열을 의미하기 때문에 백슬래시 자체를 2번 사용하는 것이다.
//            sub.split("\\+");
            StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");

            while(add.hasMoreTokens()) {
                temp += Integer.parseInt(add.nextToken());
            }

            if(sum == Integer.MAX_VALUE) {
                //맨 앞 값을 초기화해주기 위해
                sum = temp;
            } else {
                //나머지 조건은 모두 뺀다.
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}
