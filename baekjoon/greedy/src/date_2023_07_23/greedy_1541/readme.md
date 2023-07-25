# 문제
세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

# 입력
첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.

# 출력
첫째 줄에 정답을 출력한다.


### 문제 해결 법

연산자는 "-", "+" 만 들어온다면 최소한의 값을 구하기 위해서는    
최대한 값을 모두 더한 후 -를 통해 모든 값을 빼는 것이다.
먼저 -를 기준으로 입력받은 값을 split한다.
이후 스플릿 값을 순회하면서 더하고 첫번 째 값 이후의 모든 것은 뺀다.

Integer.MAX_VALUE는   
많은 문제들의 초기값은 중간 계산 혹은
결과로 나오지 않는 수로 초기화 해주는게 일반적인 방식이라고 합니다.

##### 출처: https://st-lab.tistory.com/148