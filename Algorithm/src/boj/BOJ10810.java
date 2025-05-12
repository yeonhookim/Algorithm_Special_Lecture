package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10810 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N];
        // N개의 바구니를 0으로 초기화

        for (int t = 0; t < M; t++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            // i, j, k 입력받기

            for (int idx = i -1; idx < j; idx++){
                basket[idx] = k;
                // i-j 범위에 k값 덮어쓰기
            }
        }

//        // 마지막 바구니를 제외하고 공백을 추가한다.
//        for (int n =0; n < N; n++){
//            System.out.print(basket[n]);
//            if (n != N-1) System.out.print(" ");
//        }
        // 문자열 빌더 사용 : 반복 출력 시 `System.out.print`보다 효율적
        StringBuilder sb = new StringBuilder();
        for(int num : basket){
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());

    }
}
