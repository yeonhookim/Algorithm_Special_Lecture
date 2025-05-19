package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {

    // 계단은 한 번에 한 계단 또는 두 계단씩 오를 수 있다.
    // 연속된 세 개의 계단을 모두 밟아서는 안 된다.
    // 마지막 계단은 반드시 밟아야 한다.
    // 각 계단에는 점수가 있으며, 밟은 계단의 점수 합을 최대로 해야 한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =  Integer.parseInt(br.readLine()); // 계단의 개수
        int[] stairs = new int[n+1]; // 계단의 점수 배열

        // 각 계단의 점수 입력 받기
        for (int i= 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // dp배열 초기화
        int[] dp = new int[n+1];

        // 기본 케이스 설정
        if (n >= 1) {
            dp[1] = stairs[1]; // 첫 번째 계단의 점수
        }
        if (n >= 2) {
            dp[2] = stairs[1] + stairs[2]; // 첫 번째와 두 번째 계단의 점수 합
        }
        if (n >= 3) {
            // 세 번째 계단은 (첫 번째 + 세 번째) 또는 (두 번째 + 세 번째) 중 큰 값
            dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);
        }
        // 점화식을 이용해 DP 배열 채우기
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);
        }
        System.out.println(dp[n]);
    }
}
