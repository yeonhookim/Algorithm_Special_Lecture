
package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10813 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N];
        // N개의 바구니를 0으로 초기화

        for (int i =0; i < N; i++){
            basket[i] = i + 1;
        }
        // 1번 바구니에 1번 공, 2번 바구니에 2번 공 ... N번 바구니에 N번 공 넣음

        for (int t = 0; t < M; t++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());


            // i번과 j번 바구니의 공 교환 (인덱스는 0부터 시작)
            int temp = basket[i-1];
            basket[i-1] = basket[j-1];
            basket[j-1] = temp;
            }

        StringBuilder sb = new StringBuilder();
        // StringBuilder는 문자열을 효율적으로 이어붙일 수 있는 클래스이다.
        for (int num : basket) {
            // 향상된 for문
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
        }


    }

