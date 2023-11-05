public class Squared {

    public static void main(String[] args) {
        System.out.println(Math.pow((int)Math.sqrt(123), 2) == 123);
        System.out.println(Math.pow((int)Math.sqrt(121), 2) == 121);
    }

    public static long solution(long n) {
        double sqrt = Math.sqrt(n);
        String stringOfNumber = String.valueOf(sqrt);
        int indexOfDot = stringOfNumber.indexOf(".");
        
        int lengthOfEtcNUmber = stringOfNumber.substring(indexOfDot + 1).length();

        if (lengthOfEtcNUmber > 1) {
            return -1;
        }
        char numberOfAfterDot = stringOfNumber.charAt(indexOfDot + 1);

        if (lengthOfEtcNUmber == 1 && numberOfAfterDot == '0') {
            return (long) Math.pow(sqrt + 1, 2);
        }

        return 0;
    }

    public static long solution2(long n) {
        if (Math.pow((int)Math.sqrt(n), 2) == n) {
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }

        return -1;
    }
}
