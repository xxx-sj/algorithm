public class EvenOrOdd {

    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    public static String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }
}
