### 문제
0과 1로만 이루어진 수를 이진수라 한다. 이러한 이진수 중 특별한 성질을 갖는 것들이 있는데, 이들을 이친수(pinary number)라 한다. 이친수는 다음의 성질을 만족한다.  
이친수는 0으로 시작하지 않는다.  
이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.  
예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다. 하지만 0010101이나 101101은 각각 1, 2번 규칙에 위배되므로 이친수가 아니다.  
N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.  

### 입력
첫째 줄에 N이 주어진다.

### 출력
첫째 줄에 N자리 이친수의 개수를 출력한다.


## 문제해결 1
이 전에 풀던DP와 같은 풀이로 푼다.  자릿수에 해당하는 자릿값으로 문제를 푸는데 dp[digit][val]   
여기서 자릿값은 0 or 1,  2개만 가능하다.   
1. 다음 조건으로는 시작이 0 으로 시작하지 않는다는 점.
2. 1이 연속으로 두 번 나타나지 않는다는 점.   
이 조건들을 조합해보면 아래와같은 재귀함수를 만들 수 있다.
- digit[자릿수] 가 1일때는 digit[digit][val]를 반환한다. [종료시점]
- dp[digit][val] == null 일 때 
  - val이 1일때는 뒤에 올 수 있는 수는 0밖에 없으므로 recur(digit - 1, 0);
  - val이 0일때는 뒤에 0 or 1이 올수 있기 때문에 recur(digit - 1, 0) + recur(digit -1 , 1) 이 된다.  
코드로 보면 아래와 같다.

- N을 입력받는다.
  - 입력받은 N으로 배열을 생성한다.
  - 이 때 이차원 배열은 Long을 사용한다. 2^90이어 값이 넘어갈 수 있기 때문에..?
  - N + 1 인 이유는 인덱스가 0 부터 시작하기 때문이고, 두 번째 크기가 2인 이유는 0 or 1 두개 만 들어가기 때문에.
```java
static Long dp[][];

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int N = Integer.parseInt(br.readLine());
dp = new Long[N + 1][2];
```
- 초기값을 설정한다.
```java
dp[1][0] = dp[1][1] = 1L;
```
- 재귀함수를 선언한다.
  - 종료조건은 digit == 1 일때
  - 아직 배열의 값이 초기화되지 않았다면
    - val == 1 일때는 뒷 값으로 0 밖에 오지 못함.
    - val == 0 일때는 뒷 값으로 0, 1 둘다 가능.
```java
static Long recur(int digit, int val) {

    if(digit == 1) {
        return dp[digit][val];
    }

    if(dp[digit][val] == null) {
        if(val == 1) {
            dp[digit][val] = recur(digit - 1, 0);
        } else {
            dp[digit][val] = recur(digit - 1, 0) + recur(digit - 1, 1);
        }
    }

    return dp[digit][val];
}
```
- 재귀함수를 호출한다.
  - N,1 만 호출하는 이유는 첫번 째 값이 1밖에 오지 못하기 때문이다.
```java
System.out.println(recur(N, 1));
```