### 문제
민식이는 수학학원에서 단어 수학 문제를 푸는 숙제를 받았다.
단어 수학 문제는 N개의 단어로 이루어져 있으며, 각 단어는 알파벳 대문자로만 이루어져 있다. 이때, 각 알파벳 대문자를 0부터 9까지의 숫자 중 하나로 바꿔서 N개의 수를 합하는 문제이다. 같은 알파벳은 같은 숫자로 바꿔야 하며, 두 개 이상의 알파벳이 같은 숫자로 바뀌어지면 안 된다.
예를 들어, GCF + ACDEB를 계산한다고 할 때, A = 9, B = 4, C = 8, D = 6, E = 5, F = 3, G = 7로 결정한다면, 두 수의 합은 99437이 되어서 최대가 될 것이다.
N개의 단어가 주어졌을 때, 그 수의 합을 최대로 만드는 프로그램을 작성하시오.

### 입력
첫째 줄에 단어의 개수 N(1 ≤ N ≤ 10)이 주어진다. 둘째 줄부터 N개의 줄에 단어가 한 줄에 하나씩 주어진다. 단어는 알파벳 대문자로만 이루어져있다. 모든 단어에 포함되어 있는 알파벳은 최대 10개이고, 수의 최대 길이는 8이다. 서로 다른 문자는 서로 다른 숫자를 나타낸다.

### 출력
첫째 줄에 주어진 단어의 합의 최댓값을 출력한다.


## 문제해결 법
이 문제는 입력받은 알파벳에 대해 10^x 값을 더하여 해당 값중 높은 알파벳에 9부터 차등으로    
값을 부여하면된다.  
예를들어, ABC + BBA 일경우,   
(100A + 10B + 1C) + (100B + 10B + 1A) = 120B + 101A + 1C 인것이다.   
즉, B에 9를 부여하고 A에 8 그리고 C에 7을 부여하면 된다.   

A부터~Z에 대해서는 26의 길이를 가지 배열을 만들어 계산하고,    
각각의 알파벳을 받을 때 A에 해당하는 배열 idx에 값을 더해 나간다.   

- 단어의 개수 N을 입력받는다.
  - 26길이를 가진 배열을 만든다.
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

int N = Integer.parseInt(br.readLine());
int[] alpha_arr = new int[26]; //A ~ Z
```

- N만큼 돌면서 알파벳을 입력받는다.
  - 각각의 갑은 10의 제곱만큼의 값을 더해나갈 예정이여서 base를 10으로 잡는다.
  - 입력받은 알파벳를 charAt을 통해 앞에서 부터 하나씩 꺼내어서
  - 그 알파벳에 해당하는 배열에 10의 제곱의 값을 더해 나간다.
  - alpha_arr의 인덱스값은 charAt을 통해 얻은 c값 - A를 해준다.
  - 빼주는 이유는 아스키 코드에서 A의 값에서 A를 빼면 0이 되기 때문이다. 
    - 예를 들어 AAA를 입력받았다면, alpha = AAA;
      - char c = A;
      - alpha_arr['A' - 'A'] += 100 .. 10.. 1..
```java
for(int i = 0; i < N; i++) {
    String alpha = br.readLine();
    int base = 10;
    for(int j = 1; j <= alpha.length(); j++) {
        char c = alpha.charAt(j - 1);
        alpha_arr[c - 'A'] += Math.powㅇ(10, (alpha.length() - j));
    }
}

```
- 입력받은 모든 알파벳에 해당하는 인덱스에 값을 더한 후, 오름차순 정렬을 해준다.
```java
Arrays.sort(alpha_arr);
```
- 모든 값을 더한 결과를 나타낼 result 변수와 0~9부터 알파벳에 매길 값을 초기화 시켜준다.
- 오름차순이므로 배열의 끝부터 순회하면서 값을 9부터 곱해 나간다. 
  - 배열의 값이 0일경우 [입력받은 알파벳 값은 모두 계산되었다는 말]
```java
int result = 0;
int number = 9;
for(int i = alpha_arr.length - 1; i >= 0; i--) {
    if (alpha_arr[i] == 0) {
        break;
    }

    result += alpha_arr[i] * number;
    number--;
}

System.out.println(result);


```

