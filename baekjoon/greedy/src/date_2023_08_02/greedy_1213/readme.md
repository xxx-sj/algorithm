### 문제
임한수와 임문빈은 서로 사랑하는 사이이다.
임한수는 세상에서 팰린드롬인 문자열을 너무 좋아하기 때문에, 둘의 백일을 기념해서 임문빈은 팰린드롬을 선물해주려고 한다.
임문빈은 임한수의 영어 이름으로 팰린드롬을 만들려고 하는데, 임한수의 영어 이름의 알파벳 순서를 적절히 바꿔서 팰린드롬을 만들려고 한다.
임문빈을 도와 임한수의 영어 이름을 팰린드롬으로 바꾸는 프로그램을 작성하시오.

### 입력
첫째 줄에 임한수의 영어 이름이 있다. 알파벳 대문자로만 된 최대 50글자이다.

### 출력
첫째 줄에 문제의 정답을 출력한다. 만약 불가능할 때는 "I'm Sorry Hansoo"를 출력한다. 정답이 여러 개일 경우에는 사전순으로 앞서는 것을 출력한다.

## 문제풀이법
이 문제는 먼저 살펴보면 알파벳 배열에 값을 하나씩 추가해야하는 문제인것을 알 수 있을 것이다.  
26크기를 갖는 int배열을 만들고 char를 통해 'A' - i 만큼의 해당하는 인덱스에 값을 증가시키면 된다.   
그 다음에는 핵심문제풀이는 홀수의 갯수이다. 이 문제는 문자열이 좌우대칭이며, 만약 홀수가 있을 경우 홀수는   
단 하나만 존재해야 한다. BBB, A 같이 홀수가 2개일경우는 문자열을 만들 수 없다.   
따라서 홀수가 한개 또는 0개이여야 하며, 알파벳만큼의 배열을 돌면서 앞뒤로 반복하니    
현재 인덱스에 해당하는 값의 /2 만큼의 값을 for문으로 돌면서 stringBuilder에 추가한다.   

- 이름을 입력받는다.
- 출력할 문자열을 만들기 위해 대칭 중에서 앞을 담당할 Stringbuilder와 뒤를 담당할 Stringbuilder 2개를 만든다.
- 그리고 알파벳크기의 int배열을 만든다.
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuilder front = new StringBuilder();
StringBuilder back = new StringBuilder();

String name = br.readLine();
int[] alpha = new int[26];
```
- for문을 돌면서 charAt(i)에 해당하는 index에 1을 추가한다.
  - charAt(i) - 'A' 인 이유는 아스키코드의 'A'의 값은 65인데 그중
```java
for(int i = 0; i < name.length(); i++) {
    alpha[name.charAt(i) - 'A']++;
}
```
- 홀수의 알파벳 갯수가 몇 개인지 확인한다
  - 동시에 홀수의 index 값을 저장한다.
```java
int oddNumber = 0;
Integer oddIdx = null;
for(int i = 0; i < alpha.length; i++) {
    if(alpha[i] % 2 == 1) {
        oddIdx = i;
        oddNumber++;
    }
}
```
- 홀수가 1개 초과라면 I'm Sorry Hansoo를 출력한다.
```java
if(oddNumber > 1) {
    System.out.println("I'm Sorry Hansoo");
    return;
}
```
- 알파벳 만큼 for문을 돌면서 2중 for문으로 내부에서는 
- alpha / 2만큼 돌면서 StringBuilder에 추가한다.
  - alpha /2 만큼 도는 이유는 팰린드롬은 좌우 대칭의 문자열이기 때문에 앞 뒤 즉, /2로 나눈것이다.
  - front.append를 통해 앞에 사용할 문자열을 만들고 back을 index0부터 집어넣으면서 뒤 문자열을 만든다.
```java
for(int i = 0; i < alpha.length; i++) {
    for(int j = 0; j < alpha[i] / 2; j++) {
        front.append((char)('A' + i));
        back.insert(0, (char)('A' + i));
    }
}
```
- 홀수가 있다면 중간에 홀수 index + 'A'의 알파벳을 추가하고
- 짝수라면 앞 뒤를 합쳐서 출력한다.
```java
if(oddIdx != null) {
    System.out.println(front.toString() + (char)('A' + oddIdx) + back.toString());
} else {
    System.out.println(front.toString() + back.toString());
}
```