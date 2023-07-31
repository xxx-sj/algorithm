package date_2023_07_31.greedy_11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Lesson {
    long startTime;
    long endTime;

    public Lesson(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Lesson[] lessons = new Lesson[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long startTime = Long.parseLong(st.nextToken());
            long endTime = Long.parseLong(st.nextToken());
            lessons[i] = new Lesson(startTime, endTime);
        }

        Arrays.sort(lessons, new Comparator<Lesson>() {
            @Override
            public int compare(Lesson o1, Lesson o2) {
                if(o1.startTime == o2.startTime) {
                    return Long.compare(o1.endTime, o2.endTime);
                }

                return Long.compare(o1.startTime, o2.startTime);
            }
        });

//        List<Lesson> lessonList = new LinkedList<>();
//        lessonList.add(lessons[0]);
//
//        for(int i = 1; i < N; i++) {
//            Boolean isAdd = true;
//            for(int j = 0; j < lessonList.size(); j++) {
//                if(lessonList.get(j).endTime <= lessons[i].startTime) {
//                    lessonList.remove(j);
//                    lessonList.add(lessons[i]);
//                    isAdd = false;
//                    break;
//                }
//            }
//            if(isAdd) {
//                lessonList.add(lessons[i]);
//            }
//        }

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(lessons[0].endTime);

        for(int i = 1; i < N; i++) {
            if(pq.peek() <= lessons[i].startTime) {
                pq.poll();
            }
            pq.offer(lessons[i].endTime);
        }

        System.out.println(pq.size());


    }
}
