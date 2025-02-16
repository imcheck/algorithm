package study.d_250215;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2중 (누적합과 차를 이용한 방식)
 */
public class p_1912_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sumArr = new int[n];

        // 0 ~ i 누적합 구하기
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int s = 0; s < i + 1; s++) {
                sum += arr[s];
            }
            sumArr[i] = sum;
            if(max < sum) max = sum;
        }
        // i번째 누적합에서 각각 0 ~ j 만큼의 차 구하기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                int diff = sumArr[i] - sumArr[j];
                if(max < diff) max = diff;
            }
        }

        bw.write(max+"");

        br.close();
        bw.close();
    }
}
