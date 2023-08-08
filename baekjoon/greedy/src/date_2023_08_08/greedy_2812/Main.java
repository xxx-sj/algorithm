package date_2023_08_08.greedy_2812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 10 4
 * 4177252841
 * 775841
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String number = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (char c : number.toCharArray()) {
            // 스택이 비어있지 않고, 아직 제거해야 할 숫자 개수가 남아있으며, 스택의 가장 위의 숫자가 현재 숫자보다 작은 경우
            while(!stack.isEmpty() && K > 0 && stack.peek() < c) {
                stack.pop();
                K--;
            }
            stack.push(c); // 현재 숫자 스택에 추가
        }

        // 남은 제거할 숫자를 스택에서 제거
        for(int i = 0; i < K; i++) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());  // 스택의 숫자를 앞쪽에 추가
        }

        System.out.println(sb.toString());
    }
}
