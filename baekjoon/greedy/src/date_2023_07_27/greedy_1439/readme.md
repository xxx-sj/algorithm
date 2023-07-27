# 문제
다솜이는 0과 1로만 이루어진 문자열 S를 가지고 있다. 다솜이는 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 한다. 다솜이가 할 수 있는 행동은 S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다. 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.
예를 들어 S=0001100 일 때,
전체를 뒤집으면 1110011이 된다.
4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 2번 만에 모두 같은 숫자로 만들 수 있다.
하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있다.
문자열 S가 주어졌을 때, 다솜이가 해야하는 행동의 최소 횟수를 출력하시오.

# 입력
첫째 줄에 문자열 S가 주어진다. S의 길이는 100만보다 작다.

# 출력
첫째 줄에 다솜이가 해야하는 행동의 최소 횟수를 출력한다.

##### 문제 해결 법
- 이 문제는 첫 번째 문자를 기준으로 잡고, 이전 문자를 갖고있으며
- 첫 번째와 다르고 이전 문자와 다르면 카운팅을 하면된다.
- 다시말해, 첫 번째와 다르다는 것은 숫자를 뒤집어야 한다는 말이고, 
- 첫 번째 숫자와 다르고, 이 전과 숫자가 다른다는 것은 숫자를 뒤집어야 하는 시작을 말하며,
- 첫 번째와는 다르고, 이 전 숫자와 같다는 것은 연속적으로 숫자를 뒤집어야 한다는 말이다.


- 문자를 입력받고 문자열을 split한다.
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

String S = br.readLine();
String[] numbers = S.split("");
```
- 첫 번째 수와 이 전 수를 처음 시작인 index 0의 값으로 초기화 한다.
  - 뒤집을 수를 누적할 cnt 변수를 만든다.
```java
String firstNumber = numbers[0];
String prev_number = numbers[0];
int cnt = 0;
```
- split한 배열을 순회하며, 첫번 째 숫자와 다르고, 이 전 숫자와 다를 때 cnt를 증가시킨다.
  - for의 끝에는 현재 문자를 이 전 문자에 대입한다.
- 결과를 콘솔에 출력한다.
```java
for(int i = 1; i < numbers.length; i++) {
//            if(firstNumber.equals(numbers[i])) {
//            }
//            if(!firstNumber.equals(numbers[i]) && prev_number.equals(numbers[i])) {
//            }
    if(!firstNumber.equals(numbers[i]) && !prev_number.equals(numbers[i])) {
        cnt++;
    }
    prev_number = numbers[i];
}
    
System.out.println(cnt);
```
