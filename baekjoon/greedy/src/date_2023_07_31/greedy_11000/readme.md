### 문제
수강신청의 마스터 김종혜 선생님에게 새로운 과제가 주어졌다.
김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다.
참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (즉, Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)
수강신청 대충한 게 찔리면, 선생님을 도와드리자!

### 입력
첫 번째 줄에 N이 주어진다. (1 ≤ N ≤ 200,000)
이후 N개의 줄에 Si, Ti가 주어진다. (0 ≤ Si < Ti ≤ 109)

### 출력
강의실의 개수를 출력하라.

## 문제 해결 법
이 문제같은 경우 시작시간을 기준으로 오름차순으로 정렬하고 만약 시작시간이 같은경우에는   
종료시간을 기준으로 오름차순으로 정렬한다.   
이후 우선순위큐를 이용하여 만약 현재 진행중인 강의의 종료시간이 다음 강의의 시작시간과 같거나 크다면   
큐에서 값을 꺼내고 아닌경우에는 모두 큐에 종료시간을 넣는다.   
이렇게 하는 이유는 종료시간을 큐에 넣어 만약 종료시간과 시작시간을 비교하여 같거나 큰 경우 해당 강의를 이어서 진행 할 수 있기 때문에   
큐에서 꺼내는 것이다.  
마지막으로 큐의 사이즈를 출력하므로서 필요한 강의실의 수를 알 수 있다.
- 처음에는 리스트, 셋으로 진행하였지만 시간초과가 나서 우선순위큐로 변경하였다.

- 강의실에 해당하는 클래스를 만든다.
```java
class Lesson {
    long startTime;
    long endTime;

    public Lesson(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
```
- 강의실 수를 입력받는다.
  - 강의실 수 만큼의 배열을 만든다.
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int N = Integer.parseInt(br.readLine());
Lesson[] lessons = new Lesson[N];
```
- N만큼 돌면서 강의실을 배열에 넣는다.
  - 시작시간을 기준으로 오름차순 정렬
  - 시작시간이 같은 경우는 종료시간을 기준으로 오름차순 정렬
```java
for(int i = 0; i < N; i++) {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    long startTime = Long.parseLong(st.nextToken());
    long endTime = Long.parseLong(st.nextToken());
    lessons[i] = new Lesson(startTime, endTime);
}

Arrays.sort(lessons, new Comparator<Lesson>() {
    @Override
    public int compare(Lesson o1, Lesson o2) {
        if(o1.startTime == o2.startTime) {
            return Long.compare(o1.endTime, o2.endTime);
        }

        return Long.compare(o1.startTime, o2.startTime);
    }
});
```
- 우선순위 큐를 초기화한다.
- 맨 처음 idx = 0의 값을 우선순위 큐에 담는다.
- 이 후 N만큼 돌면서 큐의 맨 처음 값을 peek으로 꺼내어 
- 꺼낸 종료시간 값과 현재 비교하는 강의실의 시작시간이 같거나 크다면 큐에서 종료시간을 꺼낸다.
- for문 마지막에는 강의를 큐에 넣는다.
```java
PriorityQueue<Long> pq = new PriorityQueue<>();
pq.offer(lessons[0].endTime);

for(int i = 1; i < N; i++) {
    if(pq.peek() <= lessons[i].startTime) {
        pq.poll();
    }
    pq.offer(lessons[i].endTime);
}

System.out.println(pq.size());
```