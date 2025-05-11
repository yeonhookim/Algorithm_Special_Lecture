package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 한 줄을 통재로 읽고, 공백 기준으로 나누려면 StringTokenizer 또는 split("")사용
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        // nextToken은 StringTokenizer에서 사용하는 메서드이다.
        // 입력을 연속적으로 쓸 수 있음

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i =0; i<N; i++) {
            int num =  Integer.parseInt(st2.nextToken());
            if (num < X) {
                bw.write(num + " ");
            }

        }
        bw.flush();
        bw.close();
        br.close();

    }
}
