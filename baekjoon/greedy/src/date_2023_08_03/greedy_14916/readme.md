### 문제
춘향이는 편의점 카운터에서 일한다.
손님이 2원짜리와 5원짜리로만 거스름돈을 달라고 한다. 2원짜리 동전과 5원짜리 동전은 무한정 많이 가지고 있다. 동전의 개수가 최소가 되도록 거슬러 주어야 한다. 거스름돈이 n인 경우, 최소 동전의 개수가 몇 개인지 알려주는 프로그램을 작성하시오.
예를 들어, 거스름돈이 15원이면 5원짜리 3개를, 거스름돈이 14원이면 5원짜리 2개와 2원짜리 2개로 총 4개를, 거스름돈이 13원이면 5원짜리 1개와 2원짜리 4개로 총 5개를 주어야 동전의 개수가 최소가 된다.

### 입력
첫째 줄에 거스름돈 액수 n(1 ≤ n ≤ 100,000)이 주어진다.

### 출력
거스름돈 동전의 최소 개수를 출력한다. 만약 거슬러 줄 수 없으면 -1을 출력한다.

## 문제해결 법
입력받은 값이 10보다 크다면 -5 씩 계속해서 빼나간다. 이유는 동전으로 줄 수 있는 값은   
5또는 2인데, 10보다 크다면 먼저 큰 값이 5로 빼주어야하기 때문이다.   
이 후 만약 입력받은 n의 값을 5로 나누어 나머지가 0이라면 N / 5 의 값을    
결과값에 더하여 출력한다. 그것도 아니라면 10보다 작아질 때 까지 -5를 해준다.    
10보다 작아진다면 이 후 5로 나누어 진다면 위와동일하게, 또는 2로 나누어 진다면 2로 계산하여    
N / 2의 값을 결과에 더해 출력한다. 만약 둘 다 나누어 떨어지지않는다면 -2를 계속해서 해주다가   
1이 나온다면 -1을 출력한다.

- 돈 N을 입력받는다.
- 결과를 담을 result를 만든다.
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int N = Integer.parseInt(br.readLine());
int result = 0;
```
- while 문 내부에서 로직을 실행한다.
  - 10보다 크다면 -5를 10보다 작아질 때 까지 진행한다.
  - 10보다 작다면
    - 5로 나누어떨어진다면 결과에 N /5 값을 더한다.
    - 5로 나누어 떨어지지않고 2로 나누어 떨어진다면 결과에 N /2 값을 더한다.
    - 둘 다 해당하지 않다면 -2를 해준다.
    - 위 상황을 반복하다 나누어야 할 값이 1이 된다면 -1을 출력한다.
```java
while(true) {
if (N > 10) {
    N -= 5;
    result++;
    continue;
}

if(N % 5 == 0) {
    result += N / 5;
    break;
} else if (N % 2 == 0) {
    result += N / 2;
    break;
}

N -= 2;
result++;

if(N <= 1) {
    result = -1;
    break;
}

}

System.out.println(result);
```