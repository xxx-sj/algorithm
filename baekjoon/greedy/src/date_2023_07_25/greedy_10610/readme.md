### 문제
어느 날, 미르코는 우연히 길거리에서 양수 N을 보았다. 미르코는 30이란 수를 존경하기 때문에, 그는 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다.
미르코를 도와 그가 만들고 싶어하는 수를 계산하는 프로그램을 작성하라.

### 입력
N을 입력받는다. N는 최대 105개의 숫자로 구성되어 있으며, 0으로 시작하지 않는다.

### 출력
미르코가 만들고 싶어하는 수가 존재한다면 그 수를 출력하라. 그 수가 존재하지 않는다면, -1을 출력하라.

## 문제 해결 법
N을 입력받아 30의 배수가 되는 가장 큰 수를 구하는 문제이다.   
이 문제는 배수판정법을 이용하여 풀면 쉽게 풀 수 있다.    
30의 배수 판정은 1의 자리가 0이면서 3의 배수인 수 이다.   
달리말해 입력받은N에 0이란 값이 없다면 -1을 반환한다.    
또, 0의 제외한 모든값을 더하여 3의 배수가 아니라면 -1을 반환한다.   
만약 모두 만족하는 수라면 내림차순으로 정렬하여 값을 표현하면 된다.   

- N을 입력받는다
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String str = br.readLine();
```
- 각 문자열을 잘라 배열로 만들고 그 크기만큼의 숫자를 담을 int 배열을 만든다. 
  - 이때 Integer로 감싼 이유는 int[] Arrays.sort에서 Collection.reversOrder()를 사용하기 위해서이다.
```java
String[] split = str.split("");
Integer[] number = new Integer[split.length];
for(int i = 0; i < number.length; i++) {
    number[i] = Integer.parseInt(split[i]);
}
```
- 배열을 내림차순으로 정렬한다.
```java
Arrays.sort(number, Collections.reverseOrder());
```
- 배열을 순회하면서 값을 더하고, 미리 print할 수를 만든다.
```java
int sum = 0;
StringBuilder sb = new StringBuilder();
for(int i = 0; i < number.length; i++) {
    sum += number[i];
    sb.append(number[i]);
}
```
- 배열의 마지막 수가 0이 아니거나, 또는 모든 수의 합이 3의 배수가 아닐 때 -1를 반환한다.
```java
if (sum % 3 != 0 || number[number.length -1] != 0) {
    System.out.println(-1);
} else {
    System.out.println(sb.toString());
}
```

##### 참고: https://ko.wikipedia.org/wiki/%EB%B0%B0%EC%88%98_%ED%8C%90%EC%A0%95%EB%B2%95