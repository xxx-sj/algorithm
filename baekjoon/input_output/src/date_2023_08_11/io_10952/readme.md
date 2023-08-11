### 문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

### 입력
입력은 여러 개의 테스트 케이스로 이루어져 있다.
각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
입력의 마지막에는 0 두 개가 들어온다.

### 출력
각 테스트 케이스마다 A+B를 출력한다.

## 문제풀이
10951번 문제와 동일하지만 여기서 while의 종료 시점은 문자열을 읽어   
A,B가 모두 0일 때 while문을 종료한다.

```java
while(true) {
    line = br.readLine();
    st = new StringTokenizer(line, " ");
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    if(A == 0 && B == 0) {
        break;
    }

    sb.append(A + B).append("\n");
}
```
