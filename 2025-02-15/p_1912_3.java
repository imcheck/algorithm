package study.d_250215;

import java.util.*;
import java.io.*;

/**
 * 1중 (다이내믹 방식)
 */
public class p_1912_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        // 배열 초기화
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] D = new int[n]; // 이전 요소를 더할 것인지, 아니면 홀로 설 것인지 결정하여 저장

        for (int i = 0; i < n; i++) {
            if (i == 0) D[i] = arr[i]; // D[0] 초기화

            if (i >= 1) {
                if (arr[i] > (D[i - 1] + arr[i])) { // 홀로 서는 것이 클 경우 더하지 않음
                    D[i] = arr[i];
                } else { // 합치는 게 클 경우 더함
                    D[i] = D[i - 1] + arr[i];
                }
            }
        }

        // 최댓값 찾기
        int max = D[0];
        for (int i = 0; i < n; i++) {
            if (max < D[i]) max = D[i];
        }

        bw.write(max + "");

        br.close();
        bw.close();
    }
}
