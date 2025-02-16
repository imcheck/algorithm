package study.d_250215;

import java.util.*;
import java.io.*;

/**
 * 3중
 */
public class p_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];
        for (int size = 1; size <= n; size++) {
            for (int j = 0; j < n - size + 1; j++) {
                int sum = 0;
                for (int k = j; k < j + size; k++) {
                    sum += arr[k];
                }
                if (sum >= max) max = sum;
            }
        }

        bw.write(max + "");
        br.close();
        bw.close();
    }


}
