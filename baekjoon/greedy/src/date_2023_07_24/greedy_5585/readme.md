# 문제
타로는 자주 JOI잡화점에서 물건을 산다. JOI잡화점에는 잔돈으로 500엔, 100엔, 50엔, 10엔, 5엔, 1엔이 충분히 있고, 언제나 거스름돈 개수가 가장 적게 잔돈을 준다. 타로가 JOI잡화점에서 물건을 사고 카운터에서 1000엔 지폐를 한장 냈을 때, 받을 잔돈에 포함된 잔돈의 개수를 구하는 프로그램을 작성하시오.

# 입력
입력은 한줄로 이루어져있고, 타로가 지불할 돈(1 이상 1000미만의 정수) 1개가 쓰여져있다.

# 출력
제출할 출력 파일은 1행으로만 되어 있다. 잔돈에 포함된 매수를 출력하시오.


##### 해결방법
문제에서 타로가 지불하는 돈은 **1000엔**으로 고정되어있다.    
또한 다음으로 지불할 돈 즉, 물건의 값은 1<= x < 1000 의 정수로 1000엔을 넘지 않는다.    
이 문제도 동일하게 오름차순으로 정렬된 500, 100, 50, 10, 5, 1 엔을 순차적으로 나누면서 나머지를 구하며, 몫이 잔돈의 갯수 나머지는 다음 수로 나눈다.   

- JOI가 갖고있는 잔돈을 배열로 만든다.
```java
int[] coin = [500, 100, 50, 10 ,5, 1]
```
- 물건의 값을 입력 받는다. 
```java
Scanner sc = new Scanner(System.in);
// or
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

int N = sc.nextInt(); or Integer.parseInt(br.readLine());
```
- 고정 금액인 1000엔에서 입력받은 값을 뺀다.
```java
int change = 1000 - N; 
```
- 이제 순회하면서 잔돈을 구한다.
  - 이때 조건을 하나 추가하는데, 잔돈이 coin의 값보다 작으면 나누지 않는다.
    - 반대로 말해서, 잔돈이 coin값보다 크거나 같을 때 실행한다.
```java
int cnt = 0;
for(int i = 0; i < coin.length; i++) {
    
    if(change >= coin[i]) {
        cnt += (change / coin[i]);
        change = change % coin[i];
    }
}

return cnt;
```