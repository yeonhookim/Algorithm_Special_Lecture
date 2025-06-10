package practice;

/**
 * FibonacciCalculator 클래스는 피보나치 수열을 계산하는 다양한 메서드를 제공합니다.
 * - 반복문을 이용한 방식
 * - 재귀 호출을 이용한 방식
 *
 * 알고리즘 연습 및 주석 작성 예시로 활용할 수 있습니다.
 */
public class FibonacciCalculator {

    /**
     * 반복문을 이용해 n번째 피보나치 수를 반환합니다.
     * @param n 구하고자 하는 피보나치 수열의 인덱스(0부터 시작)
     * @return n번째 피보나치 수
     */
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n; // 0 또는 1일 때는 자기 자신 반환

        int prev = 0; // n-2번째 피보나치 수
        int curr = 1; // n-1번째 피보나치 수
        int result = 0;

        // 2번째부터 n번째까지 반복
        for (int i = 2; i <= n; i++) {
            result = prev + curr; // 이전 두 수의 합이 현재 피보나치 수
            prev = curr;          // n-2 <- n-1
            curr = result;        // n-1 <- n
        }
        return result;
    }

    /**
     * 재귀 호출을 이용해 n번째 피보나치 수를 반환합니다.
     * (비효율적이지만, 알고리즘 이해에 도움)
     * @param n 구하고자 하는 피보나치 수열의 인덱스(0부터 시작)
     * @return n번째 피보나치 수
     */
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n; // 재귀 종료 조건
        // n번째 피보나치 수는 n-1, n-2번째의 합
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        int n = 10; // 예시: 10번째 피보나치 수 구하기

        // 반복문 방식 테스트
        System.out.println("반복문 방식: " + fibonacciIterative(n));

        // 재귀 방식 테스트
        System.out.println("재귀 방식: " + fibonacciRecursive(n));
    }
}
