# DP (dynamic programming) 동적 프로그래밍 (동적 계획)

### 문제푸는 방법
1. 테이블 정의
2. 점화식 찾기
3. 초기값 정하기


먼저 피보나치를 구하는 예시를 생각해보자.   
피보나치를 구할 떄 보면   
f(n) = f(n - 1) + f(n - 2) [n > 2]
f(1) = f(2) = 1;  
란 공식이 적용되어 있으며 이것을 코드로 보면 아래와 같다.   
```java
private int fib(int n) {
    
    if(n == 1 || n == 2) 
        return 1;
    else 
        return fib(n - 2) + fib(n - 1);  
    
}
```
해당 method를 재귀로 호출하며 값을 구하는 것이 일반적이다.   
하지만 피보나치로 값을 구할 때 생각을 해보면 중복되어 구하는 구간이 존재한다.   
예를들어 7에 대한 피보나치를 구할 때 맨 처음 6,5에 대한 피보나치 값을 구하게 된다.   
다시 여기서 6은 5,4 에 대한 피보나치를 구하게 되는데, 위에서 구할 5가 2번 중복되고,  
다시 5에 대한 피보나치를 구할 때 4,3 을 구하며 4가 총 3번 중복되는 것을 확인할 수 있다.   


### Memoization
memoization은 중간 계산 결과를 caching 함으로써 중복 계산을 피하는 것이다.   
위의 피보나치 예시에서 f(5)에 해당하는 값이 중복이 되니 해당 값을 캐싱을 해두는 것이다.  
cache라는 배열에 f(n)에 해당하는 값을 저장해두고 필요할 때 꺼내 쓰는 것이다.   
f[1, 1, 2, 3, 5, 5, 13, 21, 34...]  
먼저 배열의 초기값으로 모두 -1로 초기화 해둔 후 아래와 같은 식으로 값을 저장한다.

```java
private int fib(int n)
{
    if(n == 1|| n == 2) {
        return 1;
    }    
    else if (f[n] > -1) {
        return f[n];
    } else {
        f[n] = fib(n - 2) + fib(n - 1);
        return f[n];
    }
}
```

### bottom-up 방식
1부터 시작하여 위로 올라가는 방식
[1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...]
```java
int fib(int n)
{
    f[1] == f[2] == 1;
    for(int i = 3; i<= n; i++) {
        f[n] = f[n - 1] + f[n -2];
        return f[n];
    }
}
```
예를 들어 f(8)을 구하려 할 때 bottom-up방식은 아래서 부터 값은 구해왔기 때문에  
f(6), f(7)의 값을 미리 알고 있어 해당 값을 더해 f(8)을 구할 수 있다.

### 이항계수 (Binomial Coefficient)
nCk n 개중에서 k개를 선택하는 경우의 수  
공식으로는 nCk = n! / (n - k)! * k! 로 구하는것은 좋은 방법은 아니다.  
이유는 피보나치와 동일하게 중복된 많은 계산이 발생한다.   또한 값이 커지면 overflow가 발생한다.  

다른 식으로는 n개중에 a를 선택하는 것과 a를 선택하지 않는 것에 대한 공식이다.   
n개의 수에 a가 있다고 가정할 때 a를 선택하는 경우일 때는 (n - 1)개 중에서 a를 제외한 k -1 을 뽑는 경우의 수와   
a를 선택하지 않는 경우에는 n개 중에 a를 제외한 (n - 1) 개 중에서 k개를 뽑는 수와 같다.  
여기서 if(n = k or k = 0; 일때는 1이다. )  
순환에서는 베이스 condition에 도달하지 못한다면 무한루프에 빠져든다.  
```java
int binomial(int n, int k) {
    if(n == k || k == 0) 
        return 1;
    else 
        return binomial(n - 1, k) + binomial(n - 1, k - 1);
}
```
위에 식을 보면 n이 줄어든다면 언젠가는 n == k에 도달할 것이고, n과 k가 줄어든다면 k ==0에 도달하게 될 것이다.  
해당 식을 memoization 하면 아래와 같다.
```java

int binomial(int n, int k) {
    
    if(n == k || k == 0)
        return 1;
    else if (binom[n][k] > - 1)
        return binom[n][k];
    else {
        binom[n][k] = binomial(n - 1, k) + binomial(n - 1, k - 1);    
        return binom[n][k];
    }
}
```
여기서도 동일하게 -1로 초기화 되어있다고 가정한다.  

다음으로는 동일한 공식에 대한 bottom-up 방식이다.  
```java
int binomial(int n, int k) {
    
    for(int i = 0; i <= n; i++) {
        for(int j = 0; j <=k && j <= i; j++) {
            if(k == 0 || n == k)
                binom[i][j] = 1;
            else 
                binom[i][j] = binom[i - 1][j - 1] + binom[i - 1][j];
        }       
    }
    return binom[n][k];
}
```

### 예제
2차원 배열이 존재하며 (0,0)에서 (i, j) 까지 가는 길에는 각각의 배열에 
자연수가 정해져있는데 해당 (i, j)까지 가는 최소한의 값을 구하라.   
이동은 오른쪽 또는 아래로만 가능하다.  

여기서 보아야할 것은 (i, j)에 도달하기 위해서는 최소한 [i - 1, j] (i, j)의 위쪽 또는   
[i, j -1] (i,j)의 왼쪽까지 도달해야 한다.  
이것을 식으로 풀면 min([i -1, j], [i, j -1] ((i,j에 도달하기 전까지의 값))) + (i, j) 이다.   
조건으로   
i = 1 이라면 오른쪽으로만 이동하기 때문에 값은 하나이고,   
j = 1 이라면 아래로만 이동하게 된다.  
i = 1, j = 1 이라면 (0,0)에서 이동하지 않기 때문에 출발점이 도착점이 된다.   
여기서 말하는 i, j 는 배열의 크기이다.
```java
int mat(int i, int j) {
    
    if (i == 1 && j == 1) {
        return m[i][j]; 
    } else if (i == 1)
        return mat(1, j - 1) + m[i][j];
    else if (j == 1)
        return mat(i - 1, 1) + m[i][j];
    else 
        return Math.min(mat(i - 1, j), mat(i, j -1)) + m[i][j];
}
```
- memoization 추가
```java
int mat(int i, int j) {
    if(L[i][j] != -1) return L[i][j];
    if (i == 1 && j == 1) {
        L[i][j] = m[i][j]; 
    } else if (i == 1)
        L[i][j] = mat(1, j - 1) + m[i][j];
    else if (j == 1)
        L[i][j] = mat(i - 1, 1) + m[i][j];
    else 
        L[i][j] = Math.min(mat(i - 1, j), mat(i, j -1)) + m[i][j];
    return L[i][j];
}
```
- bottom-up 방식
  - bottom-up 방식은 행에있는 열의 값을 순서대로 계산하여 미리 값을 저장한다.
```java
int mat() {
    
    for(int i = 1; i <=n; i++) {
        for(int j = 1; j<=n; j++) {
            if (i == 1 && j == 1) 
                L[i][j] = m[1][1];
            else if (i == 1)
                L[i][j] = m[i][j] + L[i][j - 1];
            else if (j == 1)
                L[i][j] = m[i][j] + L[i - 1][j];
            else
                L[i]{j} = m[i][j] + Math.min(L[i - 1][j], L[i][j - 1]);
        }    
    }    
return L[n][n];
}
```
시간 복잡도는 n x n => O(n^2)  

- 아래 코드는 L[i][j] 의 값이 어디서 왔는지에 대한 표시이다.
```java
int mat() {
    
        //L[i -1][j] 는 왼쪽에서 오른쪽 이동이고
        //L[i][j - 1] 위쪽에서 아래로 이동이다.
    for(int i = 1; i <=n; i++) {
        for(int j = 1; j<=n; j++) {
            if (i == 1 && j == 1) 
                L[i][j] = m[1][1];
                p[i][j] = "-";
            else if (i == 1)
                L[i][j] = m[i][j] + L[i][j - 1];
            else if (j == 1)
                L[i][j] = m[i][j] + L[i - 1][j];
            else {
                if(L[i - 1][j] < L[i][j - 1]) {
                    L[i][j] = m[i][j] + L[i - 1][j];   
                    p[i][j] = "위쪽";
                }
                else {
                    L[i][j] = m[i][j] + L[i][J - 1];
                    p[i][j] = "왼쪽";
                }   
                
           }   
        }    
    }    
return L[n][n];
}

//출력 메소드
void printPath() {
    
    int i = n; int j = n;
    while(P[i][j] != '-') {
        print(i + " " + j);
        if(P[i][j] == "왼쪽") {
            j = j - 1;
        } else
            i = i - 1;
    }
    print(i + " " + j);
}

//출발점부터 출력하는 메서드
void printPathRecursive(int i, int j) {
    if(p[i][j] == "-")
        print(i + " " + j)
    else {
        if(p[i][j] == "왼쪽")        
            printPathRecursive(i, j - 1);
        else
            printPathRecursive(i - 1, j)
        print(i + " " + j)
    }
}
```


