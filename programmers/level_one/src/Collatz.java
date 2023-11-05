public class Collatz {

    public static void main(String[] args) {
        System.out.println(solution(6));
    }

    public static int solution(int num) {
        if (num == 1) return 0;

        int i = 1;
        while(true) {
            if (i == 500) break;
            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 2 == 1){
                num = num * 3 + 1;
            }
            if (num == 1) break;
            i++;
        }

        if (i == 500) return -1;
        return i;
    }

    private static boolean isEven(int num) {

       return num % 2 == 0;
    }
}
