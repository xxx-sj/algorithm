/**
 * https://programmers.co.kr/learn/courses/30/lessons/12948
 */
public class PhoneNumber {

    public static void main(String[] args) {
        String result = solution3("12334123123");
        System.out.println("result = " + result);

    }

    public static String solution(String phoneNumber) {
        StringBuilder answer = new StringBuilder();

        int phoneLength = phoneNumber.length();
        String numberForVisible = phoneNumber.substring(phoneLength - 4, phoneLength);

        String hideNumber = phoneNumber.replaceAll("[0-9]", "*");
        hideNumber = hideNumber.substring(0, phoneLength - 4);
        answer.append(hideNumber);
        answer.append(numberForVisible);

        return answer.toString();
    }

    public static String solution2(String phoneNumber) {
        StringBuilder answer = new StringBuilder();

        int phoneLength = phoneNumber.length();
        for (int i = 0; i < phoneLength - 4; i++) {
            answer.append("*");
        }

        answer.append(phoneNumber.substring(phoneLength - 4, phoneLength));

        return answer.toString();
    }

    public static String solution3(String phoneNumber) {
        char[] ch = phoneNumber.toCharArray();
        for(int i = 0; i < ch.length - 4; i ++){
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }

}
