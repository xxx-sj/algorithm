### 문제
옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.
길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
S = A[0] × B[0] + ... + A[N-1] × B[N-1]
S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.
S의 최솟값을 출력하는 프로그램을 작성하시오.

### 입력
첫째 줄에 N이 주어진다. 둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고, 셋째 줄에는 B에 있는 수가 순서대로 주어진다. N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.

### 출력
첫째 줄에 S의 최솟값을 출력한다.

## 해결방법
재배열하면 안된다고 하지만 재배열 후 값을 계산하면된다.
S값을 가장 작게 만들기 위해서는 하나는 내림차순 하나는 오름차순으로 계산하면 된다.

- 각각의 배열의 수를 받는다.
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int N = Integer.parseInt(br.readLine());
```
- 받은 N수 만큼 배열을 A,B를 만들고
    한 줄로 받을 값을 StringTokenazer로 자른다.
- 이 때 Collections.reverseOrder() 또는 Comparator.reverseOrder()를
    사용하기 위해서는 primitive type은 사용이 불가하므로 wapper class인 Integer를 사용한다.

```java
int[] A = new int[N];
Integer[] B = new Integer[N];

StringTokenizer stA = new StringTokenizer(br.readLine(), " ");
StringTokenizer stB = new StringTokenizer(br.readLine(), " ");
```
- 하나의 배열은 오름차순 또 다른 하나의 배열은 내림차순으로 정렬한다.
```java
Arrays.sort(A);
Arrays.sort(B, Collections.reverseOrder());
```
- 마지막으로 모든 값을 곱하여 sum을 구한다
```java
int sum = 0;
for(int i = 0; i < N; i++) {
    sum += A[i] * B[i];
}

System.out.println(sum);
```