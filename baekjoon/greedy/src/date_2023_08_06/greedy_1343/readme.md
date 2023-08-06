### 문제
민식이는 다음과 같은 폴리오미노 2개를 무한개만큼 가지고 있다. AAAA와 BB
이제 '.'와 'X'로 이루어진 보드판이 주어졌을 때, 민식이는 겹침없이 'X'를 모두 폴리오미노로 덮으려고 한다. 이때, '.'는 폴리오미노로 덮으면 안 된다.
폴리오미노로 모두 덮은 보드판을 출력하는 프로그램을 작성하시오.

### 입력
첫째 줄에 보드판이 주어진다. 보드판의 크기는 최대 50이다   

### 출력
첫째 줄에 사전순으로 가장 앞서는 답을 출력한다. 만약 덮을 수 없으면 -1을 출력한다.   


## 문제해결 법
이 문제는 입력값을 받아 순회하면서 X를 count한다. 그러다가 "."이 나오면 이 전까지   
카운트한 X값을 기준으로 검증을한다. A=4, B=2인데, 4로 나누어볼 필요 없이 2로 나누어보면   
검증할 수 있다. x카운트한 값을 2로 나누어 0이 아니라면 -1를 출력한다.   
그것이 아니라면 count값이 4보다 크다면 먼저 4로 나누어 몫을 구하고 나머지 값을 2로 나누어     
몫을 구한다. 이 후 StringBuilder에 값을 추가한다.   
마지막까지 순회한 후에 출력 전 마지막에 한번 더 검증을 한다.    

- 문자열을 입력받는다.
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb = new StringBuilder();

String str = br.readLine();
```
- X를 카운트할 변수를 만들고 문자열만큼 순회하며 검증을한다.
  - 문자열이 X라면 countX를 증가시키고
  - 아니라면 지금까지 카운트할 X값을 가지고 검증을한다.
  - 카운트한 x값을 2로 나누어 떨어지지 않는다면 -1을 출력한다.
  - 나누어떨어진다면 4보다 크다면 4로 먼저 나누어 몫을 구한다.
  - 4로 나눈 후 나머지를 가지고 2로 나누어 몫을 구한다.
  - 구한 몫을 가지고 sb에 AAAA, BB를 추가한다.
- 모두 순회한 후 마지막 출력 전 한번 더 동일한 검증을 한 후 출력한다.
```java
int countX = 0;
for (int i = 0; i < str.length(); i++) {
    if(str.charAt(i) == 'X') {
        countX++;
    } else {
        if(countX % 2 != 0) {
            System.out.println(-1);
            return;
        }

        Main.appendAAndB(sb, countX);

        countX = 0;
        sb.append(".");
    }
}

if(countX % 2 != 0) {
    System.out.println(-1);
    return;
}

Main.appendAAndB(sb, countX);

System.out.println(sb.toString());


private static void appendAAndB(StringBuilder sb, int countX) {
    int numberA = 0;
    int numberB = 0;

    if (countX >= 4) {
        numberA = countX / 4;
        countX = countX % 4;
    }
    numberB = countX / 2;

    for(int j = 0; j < numberA; j++) {
        sb.append("AAAA");
    }

    for(int j = 0; j < numberB; j++) {
        sb.append("BB");
    }
}
```