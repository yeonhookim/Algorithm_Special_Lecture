package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10807 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr =  new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int find = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == find){
                count++;
            }
        }
        bw.write(count + "\n");
        // 여기서 count는 int(정수), "\n"은 String(문자열)
        // 'count + "\n"'을 만나면, 자바는 정수 count를 문자열로 변환해서 두 문자열을 이어 붙인다.
        // 내부적으로는 String.valueOf(count)가 호출된다. -> 자바의 문자열 결합 규칙때문.
        bw.flush();
        br.close();
        bw.close();
    }

}
