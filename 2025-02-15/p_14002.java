package study.d_250215;

import java.util.*;
import java.io.*;

public class p_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 초기화
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] D = new int[n]; // D 배열 구하기

        int max = 0; // 부분 수열 중 가장 큰 수열의 길이
        int maxIdx = 0; // 가장 큰 값의 인덱스 저장

        for (int i = 0; i < n; i++) {
            D[i] = 0;
            int length = D[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && length < D[j]) length = D[j];
            }
            D[i] = length + 1;

            if (max < D[i]) {
                max = D[i];
                maxIdx = i;
            }
        }


        int idx = maxIdx;
        ArrayList<Integer> list = new ArrayList<>(); // 가장 긴 수열을 저장할 리스트 (역순으로 저장)
        list.add(arr[idx]);

        while (D[idx] - 1 > 0) {
            for (int i = 0; i < idx; i++) {
                if (arr[i] < arr[idx] && D[i] == (D[idx] - 1)) { // arr의 idx 요소보다 작으면서, D의 idx 요소보다 1 작은 값
                    list.add(arr[i]);
                    idx = i;
                    break;
                }
            }
        }

        // 역순으로 출력
        bw.write(max + "\n");
        for (int i = list.size() - 1; i >= 0; i--) {
            bw.write(list.get(i) + " ");
        }

        br.close();
        bw.close();
    }
}
