### 문제
N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

### 입력
첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.

### 출력
입력으로 주어진 숫자 N개의 합을 출력한다.

## 문제해결
숫자의 개수를 입력받고 두 번쨰 문자열을 입력받아   
각각 인덱스의 값을 더하면 해결할 수 있는 문제이다. 
여기서 주의해야 하는 점은 String으로 입력받은 값에 대해 
char를 통해 문제를 해결하였는데, 타입 캐스팅일 때 char -> int로 변환하게 되면   
아스키코드로 해석되어 48~ 값이 할당된다. 따라서 char를 string으로 변환한 후 int로   
다시 변환하여 값을 더해야 한다.   
