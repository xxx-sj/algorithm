### 문제
기숙사에서 살고 있는 준규는 한 개의 멀티탭을 이용하고 있다. 준규는 키보드, 헤어드라이기, 핸드폰 충전기, 디지털 카메라 충전기 등 여러 개의 전기용품을 사용하면서 어쩔 수 없이 각종 전기용품의 플러그를 뺐다 꽂았다 하는 불편함을 겪고 있다. 그래서 준규는 자신의 생활 패턴을 분석하여, 자기가 사용하고 있는 전기용품의 사용순서를 알아내었고, 이를 기반으로 플러그를 빼는 횟수를 최소화하는 방법을 고안하여 보다 쾌적한 생활환경을 만들려고 한다.
예를 들어 3 구(구멍이 세 개 달린) 멀티탭을 쓸 때, 전기용품의 사용 순서가 아래와 같이 주어진다면,

1.키보드
2.헤어드라이기
3.핸드폰 충전기
4.디지털 카메라 충전기
5.키보드
6.헤어드라이기
키보드, 헤어드라이기, 핸드폰 충전기의 플러그를 순서대로 멀티탭에 꽂은 다음 디지털 카메라 충전기 플러그를 꽂기 전에 핸드폰충전기 플러그를 빼는 것이 최적일 것이므로 플러그는 한 번만 빼면 된다.

### 입력
첫 줄에는 멀티탭 구멍의 개수 N (1 ≤ N ≤ 100)과 전기 용품의 총 사용횟수 K (1 ≤ K ≤ 100)가 정수로 주어진다. 두 번째 줄에는 전기용품의 이름이 K 이하의 자연수로 사용 순서대로 주어진다. 각 줄의 모든 정수 사이는 공백문자로 구분되어 있다.

### 출력
하나씩 플러그를 빼는 최소의 횟수를 출력하시오.


## 문제해결법
이 문제는 멀티탭에 대하여 몇 가지 조건을 가지고 풀어야 한다.   
먼저 첫 번째로는 멀티탭에 콘센트가 꼽혀 있는가? 이다.   
만약 꼽혀있지 않다면 다른 조건을 볼 필요없이 콘센트를 꽂으면 된다.  
다음으로 두 번째 조건으로는 현재 멀티탭에 꽂혀있는 콘센트가 지금 꽂으려는   
콘센트와 같은 콘센트인가 이다.   예를들어 [키보드, 헤어드라이기] 가 현재 꽂혀있는데,   
다음으로 사용해야 하는 것이 키보드이라면 콘센트를 빼고 꽂지않아도 되기 때문이다.   
다음으로는 멀티탭에 다 꽂혀있고, 사용하려는 기기의 콘센트가 꽂혀있지 않을때이다.   
이것이 이번 문제의 중요 포인트인데, 이제 사용하려는 콘센트를 꽂으려할 때 비교해야봐야 하는것은   
현재 꽂혀있는 콘센트 중 어떤것을 뽑을까? 인 것이다.   
이것에 대한 문제는 현재 꽂으려는 [사용하려는] 콘센트 다음으로 현재 꽂혀있는 콘센트 중에서 먼저 사용되는   
콘센트를 구별해 내야 하는 것이다.   
예를 들어, [키보드, 헤어드라이기] 가 꽂혀잇는데, 다음으로 [핸드폰 충전기]를 사용하려 할 때   
[키보드, 헤어드라이기] 중에 하나를 뽑아야한다. 여기서 둘 중 어떤것을 뽑아야 할지 고민이 될텐데,   
이제 사용하려는 [핸드폰 충전기] 다음으로 [키보드, 헤어드라이기] 중 먼저 사용되는 것을 찾아 해당하는 콘센트를   
두고 다른 하나를 뽑아 [핸드폰 충전기]를 꽂아주면 된다.   
이유는 [핸드폰 충전기] 이 후로 먼저 사용되는 것을 뽑으면 다시 위와 같은 일을 반복해야 하지만,   
이 후 먼저 사용되는 것을 뽑지 않았다면, 이미 꽂혀 있을테니, 고민하지 않고 해당 기기사용 타이밍에서는 넘어갈 수 있기 때문이다.   
마지막으로 뽑았다면 결과를 하나를 증가시켜준다.

- 플러그 숫자와 사용할 전기 용품을 수를 입력받는다
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

StringTokenizer st = new StringTokenizer(br.readLine(), " ");

int N = Integer.parseInt(st.nextToken());
int K = Integer.parseInt(st.nextToken());
```
- 입력받은 수로 멀티탭[] 과, 전기 용품[] 배열을 각각 만들고 
- 다음으로 입력받는 전기용품 번호를 입력받는다.
```java
int[] multiTap = new int[N];
int[] devices = new int[K];

st = new StringTokenizer(br.readLine(), " ");

for(int i = 0; i < K; i++) {
    devices[i] = Integer.parseInt(st.nextToken());
}
```
- 결과 변수를 초기화하고, 입력받은 전기용품 [device[]] 만큼 순회하며
- 위의 로직을 실행한다.
  - 현재 사용해야하는 기기가 멀티탭에 꽂혀있는지 비교한다.
  - 이때는 멀티탭과 현재 기기를 변수로 넘겨 멀티탭만큼 for loop를 돌면서 
  - 현재 device와 같은 숫자가 있는지 비교한다. 있다면 true 반환
  - 현재 멀티탭에 존재한다면 다음 기기로 넘어간다.
```java
for(int i = 0; i < K; i++) {

    if(contains(multiTap, devices[i])) {
        continue;
    }


private static boolean contains(int[] multiTap, int device) {
    for(int i = 0; i < multiTap.length; i++) {
        if(multiTap[i] == device) {
            return true;
        }
    }
    return false;
}
```
- 다음 로직으로는 멀티탭에 비어있는 공간이 있는지 확인한다.
  - 비어있는지 체크하는 방법은 멀티탭 loop를 돌면서 0이 있다면 비어있는 공간이 있는 것이다.
  - 비어있는 공간이 있다면 현재 사용하려는 기기를 꽂는다.
  - 이때는 멀티탭을 loop를 돌면서 0인 곳에 사용하려는 기기를 꽂는다.
```java
if (hasEmptyHole(multiTap)) {
    for(int j = 0; j < multiTap.length; j++) {
        if(multiTap[j] == 0) {
            multiTap[j] = devices[i];
            break;
        }
    }
}

private static boolean hasEmptyHole(int[] multiTap) {
    for(int i = 0 ; i < multiTap.length; i++) {
        if(multiTap[i] == 0) {
    return true;
        }
    }
    return false;
}
```
- 마지막으로 모든 멀티탭에 콘센트가 꽂혀있고, 현재 사용하려는 기기의 콘센트가 꽂혀있지 않다면
  - 현재 사용하려는 기기 콘센트 다음으로 멀티탭에 꽂혀있는 기기 콘센트들 중
  - 가장 늦게 사용되는 콘센트를 찾는다.
    - 가장 늦게 사용되는 콘센트를 찾는 이유는, 꽂혀있는 콘센트들중에서 곧 사용될 콘센트는 
    - 뽑지않아야 다음 반복적으로 로직을 실행하지 않아도 되기 때문이다.
    - 예를 들어 [1, 2]인데, 현재 사용하려는 기기 콘센트 다음으로 사용되는 콘센트가 2인데
    - 2를 뽑아버린다면 다음으로 2를 사용하려 할 때 멀티탭에 2가 없기 때문에 멀티탭에서 다른 하나를 
    - 뽑아야 하기 때문이다.
  - 가장 늦게 사용되는 콘센트를 뽑고, result를 하나 증가시킨다.
  - 그리고 뽑은 위치에 현재 사용하려는 기기의 콘센트를 꽂는다.
- findChangeTargetIndex는 멀티탭을 순회하며 멀티탭에 꽂혀있는 기기의 콘센트 중에서
- findLastUsedIndex method를 통해
- 현재 사용하려는 기기 다음의 index부터 기기 사용을 찾기 시작하여 해당하는 index를 반환한다. 
- 없다면 length마지막값을 반환한다.
- findChangeTargetIndex에서는 해당 index값을 받아
- lastUsedIndex[멀티탭 순회를 통해 현재사용하려는 기기 다음으로 멀티탭에 꽂혀있는 기기의 사용 index]를 초기화한다.
  - if condition은 lastUsed가 크다면 lastusedIndex값에 리턴받은 lastIndex값을 초기화하는데
  - 위에서 말한 멀티탭에 꽂혀있는 콘센트 중에서 늦게 사용되는 기기를 찾기 위해서이다.
- targetIdx[현재 기기를 꽂아야하는 멀티탭 index값]을 초기화하고, 
- targetIdx를 반환한다.
  - 이 때 targetIdx의 값은 멀티탭에 꽂혀있는 값들 중 가장 늦게 사용되는 값이다.
- 리턴받은 멀티탭 targetIndx에 현재 사용하려는 기기의 콘센트를 꽂아준다.
- 다음으로 result를 하나 증가시켜준다.
```java
else {
//현재 디바이스를 꽂을 위치 찾기
    int targetIdx = findChangeTargetIndex(devices, multiTap, i + 1);
    multiTap[targetIdx] = devices[i];
    result++;
    }
}

System.out.println(result);

private static int findChangeTargetIndex(int[] devices, int[] multiTap, int startIndex) {
    int targetIndex = -1;
    int lastUsedIndex = -1;
    for(int i = 0; i < multiTap.length; i++) {
        int currentDevice = multiTap[i];
        int lastUsed = findLastUsedIndex(devices, currentDevice, startIndex);
        if (lastUsed > lastUsedIndex) {
            lastUsedIndex = lastUsed;
        targetIndex = i;
        }
    }
    return targetIndex;
}

private static int findLastUsedIndex(int[] devices, int currentDevice, int startIndex) {
    for(int i = startIndex; i < devices.length; i++) {
        if(currentDevice == devices[i]) {
            return i;
        }
    }
    return devices.length;
}
```

