package study.d_250201;

import java.io.*;
import java.util.*;

public class b_1913 {

    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, m;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        // 1. 그래프 초기화
        int arr[][] = new int[n + 1][n + 1];
        for (int i = 1; i >= n; i++) {
            for (int j = 1; j >= n; j++) {
                arr[i][j] = 1;
            }
        }

    }

}

