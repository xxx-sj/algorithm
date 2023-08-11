### 문제
첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.

### 입력
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

### 출력
첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.

## 문제해결
2가지로 문제를 해결하였다.   
가장 바깥 for loop에서는 N만큼 순회하며,   
내부 for loop에서는 2가지 for문을 만든다.  
하나는 N으로 초기 할당한 j를 i 보다 작을 때까지 돌며   
빈 공백을 출력하고, 다른 하나는 0으로 초기 할당한 j를 i 보다 작거나   
같을 때까지 별을 출력한다.  

```java
for(int i = 0; i < N; i++) {
    for(int j = N; j > i + 1; j--) {
        System.out.print(" ");
    }
    for(int j = 0; j <= i; j++) {
        System.out.print("*");
    }
    System.out.println();
}
```
다른 하나는 출력해야하는 별의 숫자를 변수로 만들어 출력하는 것이다.   
변수는 for loop값이 하나씩 증가할때마다, 별의 숫자를 1 증가시킨다.   
빈 공백은 j =0으로 초기화하고 바깥 loop i보다 작을 때 까지 출력한다.

```java

int star = 1;
for(int i = N - 1; i >= 0; i--) {

    for(int j = 0; j < i; j++) {
        sb.append(" ");
    }

    for(int j = 0; j < star; j++) {
        sb.append("*");
    }

    sb.append("\n");
    star++;
}

System.out.println(sb);
```