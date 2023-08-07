package date_2023_08_07.greedy_1700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 멀티탭 구멍 개수
        int K = Integer.parseInt(st.nextToken()); // 전자기기 개수

        int[] devices = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            devices[i] = Integer.parseInt(st.nextToken());
        }

        int[] multiTap = new int[N];
        int answer = 0;

        for (int i = 0; i < K; i++) {
            // 이미 멀티탭에 꽂혀있는 전자기기라면 스킵
            if (contains(multiTap, devices[i])) {
                continue;
            }

            // 빈 구멍이 있는 경우
            if (hasEmptySlot(multiTap)) {
                for (int j = 0; j < N; j++) {
                    if (multiTap[j] == 0) {
                        multiTap[j] = devices[i];
                        break;
                    }
                }
            } else {
                // 멀티탭에 꽂혀있는 기기 중 가장 나중에 사용되는 기기를 찾아 뽑음
                int targetIndex = findLastUsedDeviceIndex(devices, multiTap, i + 1);
                multiTap[targetIndex] = devices[i];
                answer++;
            }
        }

        System.out.println(answer);
    }

    // 멀티탭에 기기가 이미 꽂혀있는지 확인하는 메소드
    private static boolean contains(int[] multiTap, int device) {
        for (int i = 0; i < multiTap.length; i++) {
            if (multiTap[i] == device) {
                return true;
            }
        }
        return false;
    }

    // 멀티탭에 빈 구멍이 있는지 확인하는 메소드
    private static boolean hasEmptySlot(int[] multiTap) {
        for (int device : multiTap) {
            if (device == 0) {
                return true;
            }
        }
        return false;
    }

    // 멀티탭에 꽂혀있는 기기 중 가장 나중에 사용되는 기기를 찾는 메소드
    private static int findLastUsedDeviceIndex(int[] devices, int[] multiTap, int startIndex) {
        int targetIndex = -1;
        int lastUsedIndex = -1;
        for (int i = 0; i < multiTap.length; i++) {
            int device = multiTap[i];
            int lastUsed = findLastUsedIndex(devices, device, startIndex);
            if (lastUsed > lastUsedIndex) {
                lastUsedIndex = lastUsed;
                targetIndex = i;
            }
        }
        return targetIndex;
    }

    // 기기가 마지막으로 사용되는 인덱스를 찾는 메소드
    private static int findLastUsedIndex(int[] devices, int device, int startIndex) {
        for (int i = startIndex; i < devices.length; i++) {
            if (devices[i] == device) {
                return i;
            }
        }
        return devices.length;
    }
}

