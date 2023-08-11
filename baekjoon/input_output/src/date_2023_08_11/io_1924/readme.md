### 문제
오늘은 2007년 1월 1일 월요일이다. 그렇다면 2007년 x월 y일은 무슨 요일일까? 이를 알아내는 프로그램을 작성하시오.

### 입력
첫째 줄에 빈 칸을 사이에 두고 x(1 ≤ x ≤ 12)와 y(1 ≤ y ≤ 31)이 주어진다. 참고로 2007년에는 1, 3, 5, 7, 8, 10, 12월은 31일까지, 4, 6, 9, 11월은 30일까지, 2월은 28일까지 있다.

### 출력
첫째 줄에 x월 y일이 무슨 요일인지에 따라 SUN, MON, TUE, WED, THU, FRI, SAT중 하나를 출력한다.

## 문제해결
이 문제는 요일에 대한 배열을 만들고, 또 다른 하나는 달에 대한 일수 배열을 만든다.   
다음 입력받는 월 일에 대해 월 이전 일수와 입력받은 일을 더해 7로 나누어  
배열에서 찾아 출력한다.

- 월,일을 입력받고 2개의 배열을 만든다.
  - 하나의 배열은 요일에 대한 배열이고
  - 다른 하나는 1~12월에 해당하는 일 수 배열을 만든다.
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

StringTokenizer st = new StringTokenizer(br.readLine(), " ");
int month = Integer.parseInt(st.nextToken());
int day = Integer.parseInt(st.nextToken());
```
- 입력받은 달과 일 수를 더한다.
- 이 때는 month - 1 까지 순회한다.
  - 예를 들어 2월1일을 입력받았을 때
  - 1월에 해당하는 요일만 더해야 하기 때문에 -1를 해준다.
```java
int result = day;
for(int i = 0; i < month - 1; i++) {
    result += months[i];
}
```
- 마지막으로 다 더한 요일을 7로 나누어 나머지에 해당하는 배열값을 출력한다.
```java
System.out.println(days[result % 7]);
```