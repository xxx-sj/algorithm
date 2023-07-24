# 문제
서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?
# 입력
첫째 줄에 자연수 S(1 ≤ S ≤ 4,294,967,295)가 주어진다.
# 출력
첫째 줄에 자연수 N의 최댓값을 출력한다.

### 해결 방법
서로 다른 N개의 자연수이며, 결과로는 자연수 N의 최댓값을 구하는 문제이다.
즉, 최소한의 값부터 시작하여 하나씩 증가하면서 누적한 값을 구하면 된다.
20을 예로 들자면, 1 + 2 + 3 + 4 + 5 + 6 = 21 이런식으로 구하면 된다. 만약, 서로다른 자연수의 합 S를 넘어갈 경우   
더한 그 수를 빼주면 된다. 위의 예시에서는 1을 빼면 되기 때문에 N의 값은 (6 - 1) = 5 가 된다.   
다른 조건으로는 1 또는 2와 같은 경우는 최댓값이 1 이며, 더한 값이 S와 같을 경우 -1 하지 않은 값을 반환하면 된다.   

- 자연수의 합 S를 받는다.
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
long S = Long.parseLong(br.readLine());
```
- S가 1또는 2 일경우 1을 반환한다.
```java
if(S == 1 || S == 2) {
    System.out.println(1);
    return;
}
```
- 값을 하나씩 증가하며 누적값을 구한다. 누적 값이 S와 같으면, 순회한 숫자 i 를 반환하고, 누적 값이 S보다 커질 경우 i -1 값을 반환한ㄷ.
```java
long sum = 0;
for(int i = 1; i < S; i++) {
    sum += i;
    if (sum > S) {
        System.out.println(i - 1);
        break;
    } else if (sum == S) {
        System.out.println(i);
        break;
    }
}
```