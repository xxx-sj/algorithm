/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/82612
 */
public class InsufficientAmount {

    public static void main(String[] args) {
//        System.out.println(solution(3, 20 ,4));
        System.out.println(solution(14, 12312 ,221));
    }


    /**
     * price = 3, money = 20 count = 4 result 10
     * price * count = 12;
     * 3 + 12 = 15;
     * count / 2 = 2;
     * if (count % 2 != 0)  += 3 + 12 / 2
     * price의 마지막 값을 구한다 (price * count);
     * maxPirce 값과 price 값을 더한다 (maxPrice + price);
     * 구해진 값을 곱할 값을 구한다 (count / 2);
     * 만약에 count % 2 == 1 나머지가 존재한다면 maxPrice + price를 더한 값의 반을 한번 더
     * 더해준다
     * if (count % 2 == 1) result = (maxPrice + price) / 2
     * 가진돈(money) 에서 총 지불해야 하는 값 (result) 를 빼서 가진돈이 부족하지 않다면
     *  if (money - result >= 0)
     *  0을 반환한다
     *  아니라면 부족한 돈을 반환한다
     *  return result - money (총 지불해야 하는 값이 더 크기 때문에)
     * @param price
     * @param money
     * @param count
     * @return
     */
    public static long solution(int price, int money, int count) {
        long maxPrice = price * count;
        long result = (maxPrice + price) * (count / 2);
        if (count % 2 == 1) {
            result += ((maxPrice + price) / 2);
        }

        return (money - result) >= 0 ? 0 : result - money;
    }
}
