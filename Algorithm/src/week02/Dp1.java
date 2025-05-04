package week02;

public class Dp1 {
    public static void main(String[] args) {
        int n = 10; // 구하고 싶은 피보나치 수의 인덱스
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (n <= 2) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

