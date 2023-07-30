# 문제
등산가 김강산은 가족들과 함께 캠핑을 떠났다. 하지만, 캠핑장에는 다음과 같은 경고문이 쓰여 있었다.
캠핑장은 연속하는 20일 중 10일동안만 사용할 수 있습니다.
강산이는 이제 막 28일 휴가를 시작했다. 이번 휴가 기간 동안 강산이는 캠핑장을 며칠동안 사용할 수 있을까?
강산이는 조금 더 일반화해서 문제를 풀려고 한다.
캠핑장을 연속하는 P일 중, L일동안만 사용할 수 있다. 강산이는 이제 막 V일짜리 휴가를 시작했다. 강산이가 캠핑장을 최대 며칠동안 사용할 수 있을까? (1 < L < P < V)

# 입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있고, L, P, V를 순서대로 포함하고 있다. 모든 입력 정수는 int범위이다. 마지막 줄에는 0이 3개 주어진다.

# 출력
각 테스트 케이스에 대해서, 강산이가 캠핑장을 최대 며칠동안 사용할 수 있는지 예제 출력처럼 출력한다.


#### 문제해결 
이 문제는 연속하는 P일 중 L일을 캠핑장을 사용할 수 있으며, 김강산에게 부여된 휴가일 수는 V이다.   
예제 입력에 5, 8, 20을 예로 보면 8일 중 5일을 사용할 수 있으며 20일을 부여받은 것이다.   
20일을 기준으로 16일중 10일을 사용할 수 있고, 짜투리 날짜인 4일을 더 사용할 수 있다.  
즉, (5 x 2) + 4 인 것이다.   
이 값은 (5 x (20 / 8)) + (20 % 8) 이다.   
8일 중 5일, 휴가를 3일 받았을 경우에는  
result = (5 x ( 3 / 8 = 0)) + (3 % 8 = 3) 으로 잘 나오지만,   
만약 8일 중 5일, 휴가가 6일일 경우에는  
result = (5 x (6 / 8 = 0)) + (6 % 8 = 6) 으로 뒤에 맞지 않게 된다.   
이 예외를 추가하기 위해 뒤에 계산을, [V % P(v는 휴가, p는 연속하는 일 수)] 과 [L(연속 일 수 중 사용 가능한 일 수)]   
일 중 더 작은 것을 선택하면 된다.
(L * (V / P)) + (Math.min(L, (V % P)));

- 값을 입력받는다. 
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb = new StringBuilder();
StringTokenizer st;
```
- idx는 출력할 값의 idx 표시를 위해서 이다.
- token으로 잘긴 값을 순서대로 L, P, V를 담는다.
  - 만약 0,0,0 일 경우 while문을 빠져 나간다.
- 문자를 StringBuilder에 추가하고 아까의 계산식을 추가한다.

```java
int idx = 1;
while(true) {
    st = new StringTokenizer(br.readLine());
    int L = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    //P일중 L 일동안 사용가능 부여받은 휴가 V
    if(L == 0 && P == 0 && V == 0) {
        break;
    }

    sb.append("Case ");
    sb.append(idx++);
    sb.append(": ");
    sb.append((V / P) * L + Math.min(V % P, L));
    sb.append("\n");
}

System.out.println(sb.toString());
```

##### 참고: https://propercoding.tistory.com/240