package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // N의 최대값이 40이므로 41까지 배열 생성
        int[][] dp = new int[41][2];

        // 초기값 설정
        dp[0][0] = 1; // N=0일 때 0이 출력되는 횟수
        dp[0][1] = 0; // N=0일 때 1이 출력되는 횟수
        dp[1][0] = 0; // N=1일 때 0이 출력되는 횟수
        dp[1][1] = 1; // N=1일 때 1이 출력되는 횟수

        // DP로 미리 계산
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        // 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}
