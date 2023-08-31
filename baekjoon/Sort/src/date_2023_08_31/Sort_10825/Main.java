package date_2023_08_31.Sort_10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            students[i] = new Student(name, korean, english, math);
        }

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                if (o1.korean == o2.korean && o1.english == o2.english && o1.math == o2.math) {
//                모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
                    return o1.name.compareTo(o2.name);
                }
                if (o1.korean == o2.korean && o1.english == o2.english) {
//                국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
                    return Integer.compare(o2.math, o1.math);
                }

                if (o1.korean == o2.korean) {
//                국어 점수가 같으면 영어 점수가 증가하는 순서로
                    return Integer.compare(o1.english, o2.english);
                }

//                국어 점수가 감소하는 순서로
                return Integer.compare(o2.korean, o1.korean);
            }
        });

        for (Student student : students) {
            sb.append(student.name).append("\n");
        }

        System.out.println(sb);
    }

    static class Student {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
}
