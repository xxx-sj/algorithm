# 삽입 정렬   

현재 비교하고자 하는 타켓과 그 이전의 원소들과 비교하며 자리를 교환한다.   
여기서도 동일하게 [3,1,2,4,6] 이란 배열을 예시로 들며 **size=5** 이다.    

위에서도 말 했듯이 이 전의 원소들과 비교를하기 때문에 첫 시작은 idx = 1 부터 시작한다.    
이 전의 원소들을 비교하기 때문에 j의 값은 i보다 1 감소한 값 0이 된다.   
j는 i보다 1 감소한 인덱스 부터 시작하여 target[i]와 비교해나가면서 감소한다.   
만약 비교해나가다가 비교군a[j]가 target보다 작다면 그때 순회를 멈추고 a[j+1]에 target값을 넣는다.   

정리하자면, size=5인 배열이 있을 때    
i는 0부터가 아닌 1부터 4 까지 순회하며 [배열의 끝까지]   
j 에서는 이 전 요소와 비교해야 하기 때문에 1감소한 값부터 시작하게 된다.   
i = 1, j = 0   
i = 2, j = 1 ~ 0    
i = 3, j = 2 ~ 0    
i = 4, j = 3 ~ 0    
i와 j의 값은 이렇게 결정된다.   
다음으로 자리바꿈인데, 이때는 다음과 같다.   
j가 순회하며 target(즉, idx[i]의 값)과 비교하게 되는데,    
비교군 a[j]의 값이 target보다 크다면 (a[j] > target)   
비교군 a[j]의 값을 한칸 뒤로 밀어버린다. 예를들어 j의 값이 2였다면 3으로 밀어버리는 것이다.   
따라서 a[j] > target 일 때 a[j + 1] = a[j] 하여 값을 저장한다.    
만약에 (a[j] < target)이 된다면 순회를 종료하고 target의 값을 a[j + 1]에 저장한다.    
여기서 a[j + 1] 인 이유는 생각해보면 단순하다. a[j]와 비교하여 target의 값이 더 크다면   
현재 a[j]의 값 뒤에 저장되어야 하기 때문에 a[j + 1]에 target을 저장하게 되는 것이다.   
(a[j] < target) 일때는 a[j + 1] = target이 되는것이다.   

```java
size = 5;
for(int i = 1; i < size; i++) {
    int target = a[i];
    for(int j = i - 1; j >= 0; j--) {
        if(target < a[j]) {
            a[j + 1] = a[j];
        } else {
            a[j + 1] = target;
            break;
        }
    }
        
}
```


