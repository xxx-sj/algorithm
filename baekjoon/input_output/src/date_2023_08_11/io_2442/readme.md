### 문제
첫째 줄에는 별 1개, 둘째 줄에는 별 3개, ..., N번째 줄에는 별 2×N-1개를 찍는 문제
별은 가운데를 기준으로 대칭이어야 한다.

### 입력
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

### 출력
첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.

## 문제해결
이 문제는 공백과 별을 나누어 생각하면 된다.   
먼저 공백을 위에서부터 보자면 예제입력 5를 기준으로 
4,3,2,1,0 순으로 줄어든다.   
다음으로 별의 숫자를 위에서부터 보자면
1,3,5,7,9 즉, 홀수 만큼 증가하고 있다.    
위에 예제를 for loop에서 코드로 보자면 for은 1 부터 N보다 작거나 같을때 까지 순회할 것이다.
여기서 0이 아닌 1인 이유는 아래에서 별을 찍을 때 알 수 있다.
다음으로 공백은 4,3,2,1,0 즉, 초기값은 N이며, i보다 클 때까지 루프를 돌면서 공백을 추가할것이다.   
마지막으로 별의 숫자이다. 공백을 추가했다면, 별은 초기값은 1, 조건은 (2 * i) - 1 까지 돌면서 별을 찍을것이다.  
코드로 보면 아래와 같다.
![image](https://github.com/xxx-sj/algorithm/assets/62305110/766febfd-b7c9-4714-b397-a1dbd67130a4)


- N을 입력받는다.  
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

int N = Integer.parseInt(br.readLine());
StringBuilder sb = new StringBuilder();
```
- 바깥 for문은 1부터 N까지 순회를 돌면서
- 공백은 초기값은 N, 조건은 j가 i보다 클때까지 도는 것이다.
- 별은 초기값이 0, 조건은 2*i - 1만큼 돌면서 별을 찎는다.

```java
for(int i = 1; i <= N; i++) {
    for(int j = N; j > i; j--) {
        sb.append(" ");
    }

    for(int j = 0; j < 2 * i - 1; j++) {
        sb.append("*");
    }

    sb.append("\n");
}

System.out.println(sb);
```