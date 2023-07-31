# 문제
길이가 N인 수열이 주어졌을 때, 그 수열의 합을 구하려고 한다. 하지만, 그냥 그 수열의 합을 모두 더해서 구하는 것이 아니라, 수열의 두 수를 묶으려고 한다. 어떤 수를 묶으려고 할 때, 위치에 상관없이 묶을 수 있다. 하지만, 같은 위치에 있는 수(자기 자신)를 묶는 것은 불가능하다. 그리고 어떤 수를 묶게 되면, 수열의 합을 구할 때 묶은 수는 서로 곱한 후에 더한다.
예를 들면, 어떤 수열이 {0, 1, 2, 4, 3, 5}일 때, 그냥 이 수열의 합을 구하면 0+1+2+4+3+5 = 15이다. 하지만, 2와 3을 묶고, 4와 5를 묶게 되면, 0+1+(2*3)+(4*5) = 27이 되어 최대가 된다.
수열의 모든 수는 단 한번만 묶거나, 아니면 묶지 않아야한다.
수열이 주어졌을 때, 수열의 각 수를 적절히 묶었을 때, 그 합이 최대가 되게 하는 프로그램을 작성하시오.

# 입력
첫째 줄에 수열의 크기 N이 주어진다. N은 50보다 작은 자연수이다. 둘째 줄부터 N개의 줄에 수열의 각 수가 주어진다. 수열의 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.

# 출력
수를 합이 최대가 나오게 묶었을 때 합을 출력한다. 정답은 항상 231보다 작다.


#### 문제 해결 법
이 문제와 같은 경우 입력받는 값에 대해서 두 가지의 list로 나눈다.   
하나는 1이상의 양수만을 담는 리스트와 다른 하나는 0을 포함한 음의 수를 담는 배열이다.   
0을 양수가 아닌 음수에 담는 이유는 음수 x 0 이 최대의 값을 끌어낼 수 있기 때문이다.   
각각의 배열은 양의 리스트는 내림차순으로 음의 리스트는 오름차순으로 정렬한다.   
이제 while loop에서 조건은 idx + 1[현재 배열과 그 다음 배열이 size를 넘는지에 대해서] 이 size보다 크거가 같으면 break; 한다.   
현재 idx값과 이 후 값 [idx + 1]을 곱하여 sum에 합한다. 그리고 loop의 끝에 idx += 2 를 해준다.   
2번을 건너 뛰기 위해서이다.   
이제 남은 인덱스만큼 for문을 돌면서 sum에 값을 더한다. for 조건은 size - idx 이다.   
음수도 동일하게 해준다. 

- 수열의 크기를 입력받는다.  
  - 음, 양 리스트를 만든다.
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

int N = Integer.parseInt(br.readLine());

List<Integer> negativeList = new ArrayList<>();
List<Integer> positveList = new ArrayList<>();
```
- N만큼 loop를 돌면서 입력받는 값을 리스트에 넣는다
  - 입력받은 값은 정렬한다.
    - 음수는 오름차순, 양수는 내림차순
```java
for(int i = 0; i < N; i++) {
    int number = Integer.parseInt(br.readLine());

    if (number > 0) {
        positveList.add(number);
    } else {
        negativeList.add(number);
    }
}
Collections.sort(negativeList);
Collections.sort(positveList, Collections.reverseOrder());
```
- return할 sum 변수와 idx변수를 생성한다.
- while loop를 돌면서 값을 곱해준다.
  - 이 때 break 조건은 idx + 1 >= list.size() 이다.
    - idx + 1인 이유는 현재 idx값과 그 다음 idx값이 있는지 확인하기 위해서이다.
    - 같거나 큰 이유 [ >, = ]는, 예를 들어 size가 3일 경우 3개의 값을 갖고 있는것인데,
    - idx 0, 1이 이미 사용된 상태에서 idx를 2를 증가 시키고 조건을 만났을 때 
    - idx + 1 = 3 이 되고, size도 3이기에 홀수, 즉 곱할 값이 없기 때문에 while문을 벗어난다.
- 그리고 나머지 값을 for문을 돌면서 더해준다.
  - 이때 for문의 조건식은 list - idx 이다.
```java
int sum = 0;

int idx = 0;
while(true) {
    if (idx + 1 >= positveList.size()) {
        break;
    }

    if(positveList.get(idx + 1) == 1) {
        sum += positveList.get(idx) + positveList.get(idx + 1);
    } else {
        sum += positveList.get(idx) * positveList.get(idx + 1);
    }

    idx += 2;
}

for(int i = 0; i < positveList.size() - idx; i++) {
    sum += positveList.get(idx + i);
}
```
- idx값을 0으로 초기화 해주고 음수도 동일하게 진행한다.
```java
idx = 0;
while(true) {
    if (idx + 1 >= negativeList.size()) {
        break;
    }

    sum += negativeList.get(idx) * negativeList.get(idx + 1);
    idx += 2;
}

for(int i = 0; i < negativeList.size() - idx; i++) {
    sum += negativeList.get(idx + i);
}

System.out.println(sum);
```