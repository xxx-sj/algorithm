public class FIndKim {

    public static void main(String[] args) {
        String[] arr = new String[]{"Jane", "Kim"};

        System.out.println(solution(arr));
    }


    public static String solution(String[] seoul) {
        int idx = 0;

        for(; idx < seoul.length; idx++) {
            if(seoul[idx].equals("Kim")) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();

//        sb.append("김서방은 ");
//        sb.append(idx);
//        sb.append("에 있다");

        return "김서방은 " + idx + "에 있다";
    }

}
