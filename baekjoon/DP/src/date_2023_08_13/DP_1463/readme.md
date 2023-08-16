### 문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
2. X가 2로 나누어 떨어지면, 2로 나눈다.
3. 1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

### 입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

### 출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.

## 문제해결
해당 문제는 memoization으로 풀 수 있다.    
memoization의 배열에 값을 저장하는 조건은 4가지가 있다.   
첫 번째로는 N이 2로 나누어 질 때 N을 2로 나눈값과 -1을 한 값중에 적은 값을 dp배열에 값을 저장한다.   
두 번째로는 N이 3으로 나누어 떨어질 때 N % 3 과 N - 1값 중 적은 값을 해당 dp배열에 저장한다.   
세 번째로는 N이 6으로 나누어 떨어질 때[2 x 3 = 6]를 비교하는 것인데 총 2번 비교를 해야한다.   
N % 2 , N % 3를 비교하고 N - 1를 비교하여 가장 작은 값을 해당 배열에 값을 저장한다.   
마지막으로는 모두 해당되지 않는다면 N - 1를 배열에 저장한다.   

- N을 입력받는다.
- memoization배열을 생성한다.
  - N + 1을 하는 이유는 인덱스 값은 0 부터 시작하기 때문이다.
```java
static Integer DP[];

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int N = Integer.parseInt(br.readLine());

DP = new Integer[N + 1];
```
- 초기값을 설정한다.
```java
 DP[0] = DP[1] = 0;
```
- 재귀를 통해 값을 저장할 메서드를 생성한다.
```java
private static int recur(int N) {
    if (DP[N] == null) {
        if (N % 6 == 0) {
            DP[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
        } else if (N % 3 == 0) {
            DP[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
        } else if (N % 2 == 0) {
            DP[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
        } else {
            DP[N] = recur(N - 1) + 1;
        }
    }
    return DP[N];
}
```

