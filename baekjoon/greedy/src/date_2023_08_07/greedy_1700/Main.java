package date_2023_08_07.greedy_1700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] multiTap = new int[N];
        int[] devices = new int[K];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < K; i++) {
            devices[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for(int i = 0; i < K; i++) {

            if(contains(multiTap, devices[i])) {
                continue;
            }

            if (hasEmptyHole(multiTap)) {
                for(int j = 0; j < multiTap.length; j++) {
                    if(multiTap[j] == 0) {
                        multiTap[j] = devices[i];
                        break;
                    }
                }
            } else {
                //현재 디바이스를 꽂을 위치 찾기
                int targetIdx = findChangeTargetIndex(devices, multiTap, i + 1);
                multiTap[targetIdx] = devices[i];
                result++;
            }
        }

        System.out.println(result);

    }

    private static boolean contains(int[] multiTap, int device) {
        for(int i = 0; i < multiTap.length; i++) {
            if(multiTap[i] == device) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasEmptyHole(int[] multiTap) {
        for(int i = 0 ; i < multiTap.length; i++) {
            if(multiTap[i] == 0) {
                return true;
            }
        }
        return false;
    }

    private static int findChangeTargetIndex(int[] devices, int[] multiTap, int startIndex) {
        int targetIndex = -1;
        int lastUsedIndex = -1;
        for(int i = 0; i < multiTap.length; i++) {
            int currentDevice = multiTap[i];
            int lastUsed = findLastUsedIndex(devices, currentDevice, startIndex);
            if (lastUsed > lastUsedIndex) {
                lastUsedIndex = lastUsed;
                targetIndex = i;
            }
        }
        return targetIndex;
    }

    private static int findLastUsedIndex(int[] devices, int currentDevice, int startIndex) {
        for(int i = startIndex; i < devices.length; i++) {
            if(currentDevice == devices[i]) {
                return i;
            }
        }
        return devices.length;
    }
}
