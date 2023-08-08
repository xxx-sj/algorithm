### 문제
N자리 숫자가 주어졌을 때, 여기서 숫자 K개를 지워서 얻을 수 있는 가장 큰 수를 구하는 프로그램을 작성하시오.

### 입력
첫째 줄에 N과 K가 주어진다. (1 ≤ K < N ≤ 500,000)
둘째 줄에 N자리 숫자가 주어진다. 이 수는 0으로 시작하지 않는다.

### 출력
입력으로 주어진 숫자에서 K개를 지웠을 때 얻을 수 있는 가장 큰 수를 출력한다.

### 예제
4  2   
1924    => 94   
7  3   
1231234    => 3234   
10  4   
4177252841    =>   775841   
4  2  
5555    => 55    


## 문제풀이법 
이 문제는 스택을 이용해서 푼다. 입력받은 숫자를 String으로 받은 다음 순회하면서 스택에 넣는다.    
이때 스택에 넣기 전 스택이 비어있지않고, 제거해야하 할 값 k 가 0보다크고, 스택의 가장 상위 값과 현재 넣으려는 값을 비교하여    
현재 넣으려는 값이 스택의 상위값보다 크다면 상위의 값을 스택에서 빼고 k를 감소시킨다. 이 작업을 반복하며 조건에 만족하지 않을 때   
즉, 1.스택이 비어있거나 2.제거해야하는 숫자 수를 다 사용하였거나, 3.현재 스택에 넣으려는 값이 스택의 상단[peek]의 값보다 작을 때   
현재 값을 스택에 넣는다.   
여기서 k가 감소하지 않고 스택에 값을 계속넣는 경우가 있는데 동일한 수를 입력 받았을 때이다. 동일한 수를 입력받게 되면, 위의 조건에 맞지않아   
k가 감소하지않고 stack에 값만을 입력하게 된다. 그래서 추가로 for문을 돌면서 k 수 만큼 pop을 통해 stack에서 값을 제거한다.   
이후 stack에서 하나씩 꺼내면서 [pop] StringBuilder의 insert를 통해 앞쪽에 계속해서 추가해준다.    
append는 현재 string에 뒤쪽에 추가되는것이고, insert(0, "")은 index 0번째에 값, 즉 앞쪽에 값을 추가할 때 사용한다.    

- 숫자N과 제거해야하는 숫자 갯수 K를 입력받는다.
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine(), " ");
int N = Integer.parseInt(st.nextToken());
int K = Integer.parseInt(st.nextToken());
```
- 다음으로 숫자를 입력받고 stack을 초기화한다.
```java
String number = br.readLine();

Stack<Character> stack = new Stack<>();
```
- 입력받은 number를 순회한다.
  - 순회할때는 내부에서 while문을 통해 조건을 비교한다.
    - 스택이 비어있지않거나, 
      - 스택이 비어있지않다면, 이전에 값이 stack에 쌓였다는 것이고, 이 전 값과 현재값을 비교해서 제거해야 하는지 아닌지를 판단해야 하기 때문이다.
    - 아직 제거해야 할 숫자 k 개수가 남아있거나,
      - k가 남아있다면 입력받은 숫자중에서 제거해야 하는 숫자가 남아있다는 뜻이기 때문이다. k가 없다면 더 이상 제거할 필요가 없기 때문이다.
    - 현재 비교하는 숫자가 stack의 가장 위의 값보다 크다면
      - stack의 가장 윗 값이 현재 값보다 작다는 것은 제거 대상이라는 뜻이기 때문이다.
    - stack에서 가장 위 값을 꺼내고 k를 하나 빼준다.
    - while문을 지나면 stack에 값을 추가한다.
```java
for (char c : number.toCharArray()) {
    // 스택이 비어있지 않고, 아직 제거해야 할 숫자 개수가 남아있으며, 스택의 가장 위의 숫자가 현재 숫자보다 작은 경우
    while(!stack.isEmpty() && K > 0 && stack.peek() < c) {
        stack.pop();
        K--;
    }
    stack.push(c); // 현재 숫자 스택에 추가
}
```
- 위의 예시에서 들었던 같은 숫자가 반복될경우에 대해서 for loop를 아직 제거하지 않은 k 만큼 순회하며 stack에서 제거한다.
```java
// 남은 제거할 숫자를 스택에서 제거
for(int i = 0; i < K; i++) {
    stack.pop();
}
```
- 마지막으로 StringBuilder를 초기화하고,
- stack에서 하나씩 뽑아 StringBuilder의 앞쪽에 붙인다.
```java
StringBuilder sb = new StringBuilder();
while(!stack.isEmpty()) {
    sb.insert(0, stack.pop());  // 스택의 숫자를 앞쪽에 추가
}

System.out.println(sb.toString());
```