# 문제
세계적인 도둑 상덕이는 보석점을 털기로 결심했다.
상덕이가 털 보석점에는 보석이 총 N개 있다. 각 보석은 무게 Mi와 가격 Vi를 가지고 있다. 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다. 가방에는 최대 한 개의 보석만 넣을 수 있다.
상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.

# 입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)
다음 N개 줄에는 각 보석의 정보 Mi와 Vi가 주어진다. (0 ≤ Mi, Vi ≤ 1,000,000)
다음 K개 줄에는 가방에 담을 수 있는 최대 무게 Ci가 주어진다. (1 ≤ Ci ≤ 100,000,000)
모든 숫자는 양의 정수이다.

# 출력
첫째 줄에 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 출력한다.


#### 문제해결
가방을 K개 가지고 담을 수 있는 최대 보석의 가격을 구하는 것이다.    
쉽게말해, 적은 무게를 드는 가방에는 들 수 있는 가장 비싼 보석을 넣는 것이다.   
그렇다면 가방은 최소한의 무게부터 시작해야 하므로, 오름차순으로 정렬하고,   
입력받는 보석또한 작은 무게부터 시작해야하므로 오름차순으로 정렬한다.    
그 다음 가방 K개 만큼 for문을 돌면서 현재 가방이 들 수 있는 보석들을 구한다.    
그 보석들 중 가장 비싼 보석을 선택하면 된다. 이제 코드로 보면 아래와 같다.  
편의를 위해 보석의 무게와 가격을 변수로 갖는 class를 생성하였다.  

- 보석에 대한 class를 만든다.
```java
class Gem {
    int m,v;

    public Gem(int m, int v) {
        this.m = m;
        this.v = v;
    }
}
```
- 첫 줄에 N[보석 수] K[가방 수]를 입력받는다.
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine(), " ");
int N = Integer.parseInt(st.nextToken());
int K = Integer.parseInt(st.nextToken());
```
- 보석정보를 입력받는다. m은 무게, v는 가격이다.
```java
Gem[] gems = new Gem[N];
for(int i = 0; i < N; i++) {
    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());

    gems[i] = new Gem(m, v);
}
```
- 보석을 무게 오름차순으로 정렬한다. 이때, 무게가 같을경우, 가격내림차순으로 정렬한다.
```java
Arrays.sort(gems, new Comparator<Gem>() {
    @Override
    public int compare(Gem o1, Gem o2) {
        if (o1.m == o2.m) return o2.v - o1.v;

        return o1.m - o2.m;
    }
});
```
- 가방 무게를 입력받는다.
  - 가방무게를 오름차순으로정렬한다.
```java
int[] bags = new int[K];

for(int i = 0; i < K; i++) {
    bags[i] = Integer.parseInt(br.readLine());
}

Arrays.sort(bags);
```
- 우선순위 큐를 만들어 내림차순으로 설정한다.
- 결과 sum을 선언한다.
```java
PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
  long sum = 0;
```
- 가방만큼 for문을 돌면서 가방과 보석의 무게를 비교하며 가방이 들 수 있는 보석을 큐에 담는다.
  - 이 때, 가방은 오름차순으로 되어있어, 작은 무게를 들 수 있는 가방부터 for문을 돌게 되는데, 
  - 해당 가방이 들 수 있는 무게의 보석을 모두 큐에 담고나면 이제 내림차순으로 정렬된 보석들 중 가장 위 보석을 꺼낸다.
  - 여기서, 큐를 클리어 하지 않는 이유는
    - 가방은 현재 오름차순으로 정렬되어 있으며, 현재 작은 무게를 드는 가방이 들 수 있는 보석들은 그 다음 가방도 들 수 있기 때문이다.
    - 예를들어, 1이 들 수있는 보석은 10의 가방도 들 수 있기 때문에 clear하지 않는다. 
  - while문 내에서는 예를 들어 2가 들 수 있는 보석의 갯수가 담겨져 있고, 그 위로는 들 수 없기 때문에 j의 값은 멈춘다.
  - 다음 for문에서 가방의 무게가 결정되고 while문에서 이어서 j에 해당하는 보석을 비교하게 되기 때문에 j의 수를 컨트롤 하지는 않는다.

```java
for(int i = 0, j = 0; i < K; i++) {

    while(j < N && gems[j].m <= bags[i]) {
        queue.add(gems[j++].v);
    }

    if (!queue.isEmpty()) {
        sum += queue.poll();
//                queue.clear();
    }
}

System.out.println(sum);
```
