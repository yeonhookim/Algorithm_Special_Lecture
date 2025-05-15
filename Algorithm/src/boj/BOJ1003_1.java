package boj;

import java.io.BufferedReader; // 빠른 입력을 위한 클래스
import java.io.IOException; // 입출력 예외 처리
import java.io.InputStreamReader; // 바이트 스트림을 문자 스트림으로 변환

public class BOJ1003_1 {
    public static void main(String[] args) throws IOException {
        // throws IOException은 입출력 작업 시 발생 가능한 예외를 던짐
        // -> throws IOException에 대해 공부하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 스트림 초기화

        int T = Integer.parseInt(br.readLine());
        // 테스트 케이스 수(T) 입력
        // br.readLine() 한 줄 읽기
        // Integer.parseInt() 문자열 -> 정수 변환

        int[][] dp = new int[41][2];
        // N의 최대값이 40이므로 41까지 배열 생성
        // ?

        dp[0][0] = 1; // N=0일 때 0이 출력되는 횟수
        dp[0][1] = 0; // N=0일 때 1이 출력되는 횟수
        dp[1][0] = 0; // N=1일 때 0이 출력되는 횟수
        dp[1][1] = 1; // N=1일 때 1이 출력되는 횟수
        // 초기값 설정
        // fib(0) 호출 시 : 0이 1번, 1이 0번
        // fib(1) 호출 시 : 0이 0번, 1이 1번
        // ?

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }
        // DP(동적 계획법)으로 값 계산
        // 피보나치 점화식 적용 f(n) = f(n-1) + f(n-2)
        // 0과 1의 호출 횟수를 각각 누적 계산
        // ?

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n][0] + " " + dp[n][1]);
            // 각 테스트 케이스에 n 입력 받음
            // 미리 계산된 dp값에서 즉시 결과 추출 -> O(1) 시간 복잡도
            // ?

        }
    }
}


// DP (다이나믹 프로그래밍 또는 동적계획법)의 해결 방식은 크게 2가지,
// 1) Bottom-Up (Tabulation 방식) - 반복문 사용
// Bottom-Up 방식은 작은 부분 문제부터 차례대로 해결하여 전체 문제를 해결하는 방식
// 이를 위해 반복문을 사용하여 반복적으로 부분 문제들을 해결하고, 결과를 배열 등에 저장함

// 2) Top-Down (Memoiztion 방식) - 재귀 사용
// 큰 문제들을 작은 부분 문제로 나누어 해결하는 방식
// 이를 위해 귀 함수를 사용하여 문제를 작은 부분 문제들로 쪼개고,
// 중복 계산을 피하기 위해 이전에 계산한 값을 저장하는 Memoization을 활용한다.
// Memoization은 캐싱을 통해 이전 계산 결과를 저장하여 중복 계산을 피하는 것을 의미한다.

// 장점으로는 중복 계산을 줄일 수 있고, 효율적인 시간 복잡도를 가질 수 있다.
// 단점으로는 메모리 사용량이 크다. DP는 중간 결과를 저장하기 위해 추가적인 메모리를 사용한다.
// 따라서 문제의 크기가 커질수록 필요한 메모리도 증가할 수 있다.

// 그리디는 앞만 보고 가는 느낌 (늘 최선의 선택)
// dp는 뒤를 보고 가는 느낌 (과거의 이력이 앞의 영향을 끼침)