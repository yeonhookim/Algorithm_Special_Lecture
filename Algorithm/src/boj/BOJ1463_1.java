package boj;
import java.util.Scanner;

// 정수 N이 주어질 때, N을 1로 만들기 위한 최소 연산 횟수를 구하는 문제

// N을 1로 만드는 최소 연산 횟수를 구해야 하므로, 각 숫자마다 1로 만드는 데 필요한 최소 연산 횟수를 저장해가며
// 작은 수부터 차례대로 계산하는 DP(동적 프로그래밍)방법을 사용한다. 바텀업 방식


public class BOJ1463_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // dp[i]: i를 1로 만들 때 필요한 최소 연산 횟수
        int[] dp = new int[N + 1];

        dp[1] = 0; // 1은 이미 1이므로 연산 0번

        // 2부터 N까지 각 숫자에 대해 최소 연산 횟수 계산
        for (int i = 2; i <= N; i++) {
            // 1을 빼는 경우 (항상 가능)
            dp[i] = dp[i - 1] + 1;
//            dp[5] + 1; => 이게 왜 3인지?

            // 2로 나누어 떨어지면, 2로 나누는 경우와 비교
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3으로 나누어 떨어지면, 3으로 나누는 경우와 비교
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);

                //10의 경우에 10 → 9 → 3 → 1 로 3번 만에 만들 수 있다.
            }
        }

        // 정답 출력: N을 1로 만드는 최소 연산 횟수
        System.out.println(dp[N]);
    }
}

/*
이 문제는 N을 1로 만들 때 최소 연산 횟수를 구하는 문제입니다.
DP 배열 dpi를 i를 1로 만드는 최소 연산 횟수로 정의하고,
1을 빼거나, 2 또는 3으로 나누는 연산을 모두 고려해서
dpi = min(dpi-1+1, dpi/2+1, dpi/3+1)
이렇게 점화식을 세울 수 있습니다.
반복문을 돌며 dp 배열을 채우고, 마지막에 dpN을 출력하면 정답이 됩니다.
 */