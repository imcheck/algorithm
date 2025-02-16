package study.d_250215;

import java.util.*;
import java.io.*;

/**
 *
 */
public class p_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] D = new int[n]; // arr의 i 번째 요소 보다 작으면서 D의 요소중 가장 큰 값의 다음 값을 저장

        for (int i = 0; i < n; i++) {
            D[i] = 0;

            int max = D[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && max < D[j]) { // i 번째 요소보다 작으면서, D의 요소 중 가장 큰값
                    max = D[j];
                }
            }

            D[i] = max + 1;
        }

        int length = 0;
        for (int i = 0; i < n; i++) {
            if (length < D[i]) length = D[i];
        }

        bw.write(length + "");

        br.close();
        bw.close();
    }
}
