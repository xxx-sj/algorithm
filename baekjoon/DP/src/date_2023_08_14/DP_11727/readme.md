### 문제
세로 x 가로
2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.


### 입력
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

### 출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

## 문제해결

이 문제는 작은문제부터 먼저 생각하면 된다.   
2 x 1 를 채울 수 있는 방법 1가지이다.

2 x 2를 채울 수 있는 방법은 1 x 2 두개 또는 2 x 2 한 개이다.     
여기서 2 x 2 를 채울 수 있는 방법이 2 x 1 두 개를 사용하는 방법도 있지만   
추가하지 않은 이유는 이 후에도 나오겠지만 2 x 2인 상태에서 2 x 1를 추가하게 되면   
2 x 1에서 3개를 추가할 때와 겹치기 때문에 따로 추가하지 않았다.   
![img.png](img.png)
하나의 예를 들어 점화식을 찾아보도록 하겠다.   
N = 3[가로3칸]가 주어졌을 때 방법의 수는    
N = 1[가로1칸] 일 때 가로 2칸을 추가해 주면 된다. 위에서 봤듯이   
가로 2칸을 채우는 방법은 2가지가 있다. [2 x 2 or 1 x 2 (2개)]   
또한 N = 2[가로2칸] 일때 2 x 1 타일 1개를 추가해주면 N = 3를 만들 수 있다.   
위의 방법을 가지고 점화식을 만든다면 
T[N] = T[N - 2] x 2 + T[N - 1] 이 된다.

- N을 입력받고 N + 1 만큼의 memoization 배열을 초기화한다.
  - 여기서 N + 1 인 이유는 양의 정수가 입력받기 때문이다 .
```java
static Integer[] dp;

 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

int N = Integer.parseInt(br.readLine());
dp = new Integer[N + 1];
```
- 초기값을 설정한다.
```java
dp[0] = dp[1] = 1;
```
- 재귀를 통해 memoization 배열에 값을 초기화 한다.
  -재귀 내부의 로직은 위에서 선언한 점화식이 사용된다.
```java
System.out.println(recur(N));

private static int recur(in\t N) {
    if (N == 2) {
        dp[N] = 3;
    }
    if(dp[N] == null) {
        dp[N] = ((recur(N - 2) * 2) + recur(N - 1)) % 10007;
    }
    return dp[N];
}
```

