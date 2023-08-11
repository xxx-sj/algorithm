### 문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

### 입력
첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

### 출력
첫째 줄에 A+B를 출력한다.

## 문제해결
이 문제는 한줄의 문자열을 받아 [" "]로 나누어 두 숫자를 더한다.
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

StringTokenizer st = new StringTokenizer(br.readLine(), " ");

System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
```