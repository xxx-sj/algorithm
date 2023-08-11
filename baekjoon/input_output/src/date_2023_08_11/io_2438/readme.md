### 문제
첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제

### 입력
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

### 출력
첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.

## 문제해결
입력받은 N줄 만큼 for loop를 돌면서   
*를 찍는다.   
별을 찍을 때는 이중 for loop를 이용하여 출력한다.

- 2중 for loop에서는 i 보다 작거나 같을만큼만 순회한다.
- 바깥 for loop에서는 개행을 하여 출력한다.
```java
int N = Integer.parseInt(br.readLine());

for(int i = 0; i < N; i++) {
    for(int j = 0; j <= i; j++) {
        System.out.print("*");
    }
    System.out.println();
}
```