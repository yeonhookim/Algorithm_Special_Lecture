package boj;

import java.util.Scanner;

public class BOJ2579_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 계단의 개수 입력받기
        int n = sc.nextInt();

        // 2. 각 계단의 점수를 저장할 배열 선언
        int[] stairs = new int[n + 1];

        // 3. 각 계단의 점수 입력받기
        for (int i = 1; i <= n; i++) {
            stairs[i] = sc.nextInt();
        }

        // 4. DP 배열 선언: dp[i]는 i번째 계단까지 올라섰을 때 얻을 수 있는 최대 점수
        int[] dp = new int[n + 1];

        // 5. 초기값 설정
        // 계단이 1개만 있는 경우
        if (n >= 1) {
            dp[1] = stairs[1];
        }

        // 계단이 2개 이상인 경우
        if (n >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        // 6. 점화식을 이용한 DP 배열 채우기
        for (int i = 3; i <= n; i++) {
            // 현재 계단(i)을 밟는 경우는 두 가지 경우가 있음:
            // 1) i-2번째 계단에서 바로 i번째 계단으로 오는 경우
            // 2) i-3번째 계단 -> i-1번째 계단 -> i번째 계단으로 오는 경우
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }

        // 7. 결과 출력: 마지막 계단까지의 최대 점수
        System.out.println(dp[n]);
    }
}
