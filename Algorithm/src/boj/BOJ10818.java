package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10818 {

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int N = Integer.parseInt(br.readLine());

       StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;  // 최솟값 초기화 (가장 큰 값)
        int max = Integer.MIN_VALUE;  // 최댓값 초기화 (가장 작은 값)

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x < min) min = x;  // 더 작은 값이면 min 갱신
            if (x > max) max = x;  // 더 큰 값이면 max 갱신
        }
        bw.write(min + " " + max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
