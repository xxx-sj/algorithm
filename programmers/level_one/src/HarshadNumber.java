public class HarshadNumber {

    public static void main(String[] args) {
        boolean solution = solution(10);

    }

    public static boolean solution(int x) {
        String strX = x + "";
        int sum = 0;

        for (int i = 0; i < strX.length(); i++) {
            char c = strX.charAt(i);
            sum += Integer.parseInt(String.valueOf(c));
        }
        if (x % sum == 0) return true;
        return false;
    }
}
