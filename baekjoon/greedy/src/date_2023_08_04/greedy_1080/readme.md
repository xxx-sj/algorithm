### 문제
0과 1로만 이루어진 행렬 A와 행렬 B가 있다. 이때, 행렬 A를 행렬 B로 바꾸는데 필요한 연산의 횟수의 최솟값을 구하는 프로그램을 작성하시오.
행렬을 변환하는 연산은 어떤 3×3크기의 부분 행렬에 있는 모든 원소를 뒤집는 것이다. (0 → 1, 1 → 0)

### 입력
첫째 줄에 행렬의 크기 N M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 행렬 A가 주어지고, 그 다음줄부터 N개의 줄에는 행렬 B가 주어진다.

### 출력
첫째 줄에 문제의 정답을 출력한다. 만약 A를 B로 바꿀 수 없다면 -1을 출력한다.


## 문제해결
이 문제에서는 행렬의 크기 N, M이 주어진다. 또한 값을 바꿀 때는 3x3크기의 부분 행렬의 값을 모두 뒤집는다. 예를 들어 [0, 0] 의 값이 다를 경우
[0, 0], [0, 1], [0, 2],  
[1, 0], [1, 1], [1, 2],    
[2, 0], [2, 1], [2, 2]   
의 값을 모두 뒤집게 된다.
이를 이용하여 이차원 배열에 값을 모두 입력받고, 0,0 부터 시작하여 N -2, M -2 만큼 순회하며 값을 변경해 나간다.   
이후 모든 값을 변경하고 나서 다를경우 -1를 출력한다.

- 행렬 값 N, M 을 입력받고 이차원 배열 A, B륾 만든다.
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

StringTokenizer st = new StringTokenizer(br.readLine(), " ");

int N = Integer.parseInt(st.nextToken());
int M = Integer.parseInt(st.nextToken());

int[][] A = new int[N][M];
int[][] B = new int[N][M];
```
- 다음으로 입력받는 값으로 A, B 배열을 초기화한다.
  - 이 때는 char와 아스키 코드를 이용하여 값을 0, 1로 초기화한다.
```java
for(int i = 0; i < N; i++) {
    String str = br.readLine();
    for(int j = 0; j < M; j++) {
        A[i][j] = str.charAt(j) - '0';
    }
}

for(int i = 0; i < N; i++) {
    String str = br.readLine();
    for(int j = 0; j < M; j++) {
        B[i][j] = str.charAt(j) - '0';
    }
}
```
- 해당 문제는 3x3만큼 값을 통째로 바꾸기 때문에 배열이 out of bounds 나지 않도록 
  - 행 [N - 2]만큼 loop를 돌고
  - 렬 [M - 2] 만큼 loop를 돌면서 A, B가 다르면 A 배열의 값을 변경한다.
  - flip method는 배열과 해당 위치 i, j를 받아서 해당 위치 기준으로 3x3만큼의 값을 뒤집는다.
    - 예를 들어 [1, 1] 값이 다르다면
    - [1, 1], [1, 2], [1, 3] | [2, 1], [2, 2], [2, 3] | [3, 1], [3, 2], [3, 3]   
    - 값을 뒤집는다.
    - 그래서 초깃값으로 i, j 는 행렬의 값 x, y로 초기화가 되는 것이고,
    - +3 만큼만 loop를 도는 이유는 3x3만큼의 값을 변경하기 위해서 이다.
      - x에 1이 넘어오면 [i < 1 + 3 = 4] -> [1, 2, 3] i의 초기값은 넘어온 x = 1; 의 값
```java
int result = 0;
for(int i = 0; i < N - 2; i++) {
    for(int j = 0; j < M - 2; j++) {
        if(A[i][j] != B[i][j]) {
            flip(A, i, j);
            result++;
        }
    }
}

private static void flip(int[][] matrix, int x, int y) {
    for(int i = x; i < x + 3; i++) {
        for(int j = y; j < y + 3; j++) {
            matrix[i][j] = 1 - matrix[i][j];
        }
    }
}
```
- 마지막으로 2차원배열을 모두 순회하면서 다르다면 -1을 반환한다.
```java
if (isSameMatrix(A, B)) {
    System.out.println(result);
} else {
    System.out.println(-1);
}

private static Boolean isSameMatrix(int[][] m1, int[][] m2) {
    for(int i = 0; i < m1.length; i++) {
        for(int j = 0; j < m1[i].length; j++) {
            if(m1[i][j] != m2[i][j]) {
                return false;
            }
        }
    }
    return true;
}
```