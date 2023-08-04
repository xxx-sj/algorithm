### 문제
Day Of Mourning의 기타리스트 강토가 사용하는 기타에서 N개의 줄이 끊어졌다. 따라서 새로운 줄을 사거나 교체해야 한다. 강토는 되도록이면 돈을 적게 쓰려고 한다. 6줄 패키지를 살 수도 있고, 1개 또는 그 이상의 줄을 낱개로 살 수도 있다.
끊어진 기타줄의 개수 N과 기타줄 브랜드 M개가 주어지고, 각각의 브랜드에서 파는 기타줄 6개가 들어있는 패키지의 가격, 낱개로 살 때의 가격이 주어질 때, 적어도 N개를 사기 위해 필요한 돈의 수를 최소로 하는 프로그램을 작성하시오.

### 입력
첫째 줄에 N과 M이 주어진다. N은 100보다 작거나 같은 자연수이고, M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 M개의 줄에는 각 브랜드의 패키지 가격과 낱개의 가격이 공백으로 구분하여 주어진다. 가격은 0보다 크거나 같고, 1,000보다 작거나 같은 정수이다.

### 출력
첫째 줄에 기타줄을 적어도 N개 사기 위해 필요한 돈의 최솟값을 출력한다.


## 문제 해결 법
이 문제는 3가지 조건을 보고 해결하면 된다.   
1. N개의 줄을 낱개로 사는 가격과, N개를 묶음의 수 만큼 살 때 N개의 묶음 가격이 더 쌀 때
   - package * (N / 6) + N % 6 > 0 ? package : 0;
2. 다음으로는 낱개로 살 때의 가격이 더 쌀 때
   - single * N;
3. 마지막으로 묶음과 낱개를 같이 살 때이다.

- 끊어진 기타 줄과 가게의 수를 입력받는다.
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  StringTokenizer st = new StringTokenizer(br.readLine(), " ");
  int N = Integer.parseInt(st.nextToken());
  int M = Integer.parseInt(st.nextToken());
```
- 패키지와 낱개의 배열을 각각 만든다.
```java
int[] packages = new int[M];
int[] single = new int[M];
```
- 가게의 수 만큼 for문을 돌면서 값을 배열에 넣고 오름차순으로 정렬한다.
```java
for (int i = 0; i < M; i++) {
   st = new StringTokenizer(br.readLine(), " ");
   packages[i] = Integer.parseInt(st.nextToken());
   single[i] = Integer.parseInt(st.nextToken());
}

Arrays.sort(packages);
Arrays.sort(single);
```
- N에 대한 기타줄 묶음 가격을 계산한다.
  - N / 6 에 정렬된 배열에서 0번 째 값을 꺼내어 계산하는데, 이 때 N이 6으로 떨어지지 않고
  - 나머지가 남는다면 package[0]의 값을 한번 더 더해준다.
```java
int packagePrice = packages[0] * (N / 6);
packagePrice += N % 6 > 0 ? packages[0] : 0;
```
- 패키지로만 산 가격이 single로만 산 가격보다 작다면 패키지 가격계산 값을 출력한다.
```java
if (packagePrice < single[0] * N) {
   System.out.println(packagePrice);
   return;
}
```
- 위 조건에서 패키지만 출력하는 조건은 계산되었으니 다음으로는, 낱개로 사는 가격이 묶음보다 쌀 때이다.
```java
if (packages[0] > single[0] * 6) {
   System.out.println(single[0] * N);
   return;
}
```
- 마지막으로 묶음과 낱개를 사는 가격이다.
  - 여기서 package[0]을 한번 뺸 이유는 위에서 패키지로만 사는 가격에서 더 한 값을 빼주는 것이다.
    - 뺀 만큼의 수를 낱개로 구입하는 것이다.
```java
int singlePrice = single[0] * (N % 6);
System.out.println((packagePrice - packages[0]) + singlePrice);
```
