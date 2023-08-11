package date_2023_08_11.io_11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String number = br.readLine();

        int result = 0;
        for(int i = 0; i < number.length(); i++) {
            /**
             * 여기서 주의해야할 점은 String.valueOf(number.charAt(i))를 사용해야 하지
             * (int)number.charAt(i);를 사용해버리면 해당 char값을 아스키 코드 값으로 변경하여 48~ 부터 시작하는 값으로 변경되어 버린다.
             */
            int num = Integer.parseInt(String.valueOf(number.charAt(i)));
            result += num;
        }

        System.out.println(result);
    }
}
