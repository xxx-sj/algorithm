### 문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

### 입력
입력은 여러 개의 테스트 케이스로 이루어져 있다.
각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

### 출력
각 테스트 케이스마다 A+B를 출력한다.

## 문제해결
이 문제는 다른 문제와 동일하게 한 줄을 읽어들여 두 숫자를 합치는데   
문제는 케이스가 정해져있지 않다는 것이다. 이번 문제에서는 BufferedReader를 이용하여   
문자열을 읽어들이는데 만약 입력한 문자열이 없을 경우 br.readLine();는 null을 반환한다.   
while문의 종료시점은 br.readLine()의 반환이 null일 때이다.  
```java
while(true) {
    str = br.readLine();
    if(str == null) break;;
    st = new StringTokenizer(str, " ");
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    sb.append((A + B));
    sb.append("\n");
}
System.out.println(sb);
```