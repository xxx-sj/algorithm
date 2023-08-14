### 문제
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

1. 1+1+1+1
2. 1+1+2
3. 1+2+1
4. 2+1+1
5. 2+2
6. 1+3
7. 3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

### 입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.

### 출력
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.

## 문제해결
이 문제는 예시를 들어준 4를 보면 쉽게 해결할 수 있다.   
4를 만들기 위해서는 
1. 1 에 + 3 을 해주거나
2. 2 에 + 2 를 해주거나
3. 3 에 + 1 을 해주면 된다.
위의 덧셈을 가지고 점화식을 만든다면 아래와 같다.
T[N] = T[N - 1] + T[N + 2] + T[N + 3];     
좀 더 자세히 보자면,
1을 만들기 위해서는 1만 사용하면 된다.   
2를 만들기 위해서는 1 + 1, 2 가 사용된다.   
3을 만들기 위해서는 1 + 1 + 1, 2 + 1, 1 + 2 가 사용되는데   
3을 만들 때를 자세히 보면 1을 만들기 위한 방법 중에 1 만을 사용하는데 여기에 + 2를 통해
1 + 2 = 3 을 만들 수 있다.   
또한 2를 만들기 위해 사용된 1+1, 2에 + 1을 하게되면 3을 만들 수 있다. [1 + 1 + 1, 2 + 1];   


- N을 입력받는다. 위의 조건에 자연수 11보다 작다고 하였으니 배열의 크기는 11로 초기화 한다. [N < 11]
  - + 1을 하는 이유는 인덱스는 0부터 시작하는데, 양의 정수를 입력받기 때문이다.
```java
static Integer[] dp;

 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

int N = Integer.parseInt(br.readLine());

// 1<= N < 11
//        dp = new Integer[N + 1];
dp = new Integer[11];

```
- 초기값을 설정한다.
```java
dp[0] = dp[1] = 1;
```
- 점화식을 이용하여 memoization 배열을 초기화해준다.
```java
private static int recur(int N) {

    if(N == 1) {
        return 1;
    } else if (N == 2) {
        return 2;
    } else if (N == 3) {
        return 4;
    }

    if(dp[N] == null) {
        dp[N] = recur(N - 1) + recur(N - 2) + recur(N - 3);
    }
    return dp[N];
}
```
- StringBuilder를 만들어 케이스를 입력받아 출력한다.
```java
StringBuilder sb = new StringBuilder();

for(int i = 0; i < N; i++) {
    int number = Integer.parseInt(br.readLine());
    sb.append(recur(number)).append("\n");
}

System.out.println(sb);
```
