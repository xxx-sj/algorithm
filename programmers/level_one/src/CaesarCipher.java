public class CaesarCipher {

    public static void main(String[] args) {
        System.out.println(solution("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 25));
        System.out.println(solution2("AB C D E FGHIJKLMNOPQRSTUVWXYZ", 25));
    }


    /**
     * 아스키코드
     * 65 ~ 90 A ~ Z
     * 97 ~ 122 a ~ z
     * @param s
     * @param n
     * @return
     */
    public static String solution(String s, int n) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean isSmallLetter = false;

        for (char aChar : chars) {
            if ((int)aChar == 32) {
                sb.append(" ");
                continue;
            }
            int i = aChar + n;

            if ((int)aChar > 64 && (int)aChar < 91) {
                isSmallLetter = false;
            } else {
                isSmallLetter = true;
            }

            if (isSmallLetter && i > 122 || !isSmallLetter && (i > 90)) {
                i -= 26;
            }

            sb.append((char)i);
        }

        return sb.toString();
    }


    public static String solution2(String s, int n) {
        StringBuilder sb = new StringBuilder();
        n = n % 26; //나머지 //n의 숫자가 커지면 반복(알파벳 숫자 26만큼 순회)이기 때문에
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                // 아래와 동일
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            }else if (Character.isUpperCase(ch)) {
                /** ex) ch == 65
                 * 65 - 'A'(65) => 0;
                 * 0 + n(25) => 25;
                 * 25 % 26 => 더해서 알파벳 범위를 벗어날 수 있기 때문에
                 *      ex) 26 + n (25) => 51;
                 *      51 % 26 => 25;
                 *25 % 26 => 25;
                 * 25 + 'A' => 90;
                 */
                ch = (char) ((ch - 'A' + n) % 26 + 'A');

            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
