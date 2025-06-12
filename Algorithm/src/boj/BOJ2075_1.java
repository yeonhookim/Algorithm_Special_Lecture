package boj;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ2075_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 최소 힙 (작은 수가 먼저 나감)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 총 N x N 개의 수 중
        // 항상 힙에 N개만 유지
        // 3이면 9개
        // 4면 16개
        // 5면 25개
        for (int i = 0; i < N * N; i++) {
            int num = sc.nextInt();
            pq.offer(num); // 수 삽입
            // offer(num) -> num 을 삽입

            // N이 3이면 [1 , 2, 3] -> [2, 3, 4] 이런식으로 3개의 칸을 넘어가면 삭제
            // N이 4이면 [1, 2, 3, 4] -> [2, 3, 4, 5] 이런식으로 4개의 칸을 넘어가면 삭제
            if (pq.size() > N) {
                pq.poll();
                // pq.poll() -> 가장 작은 값을 꺼내는 함수
                // 기본 설정은 MinHeap
                // PriorityQueue는 기본적으로 작은 값이 우선순위가 높다고 판단해.
                // 그래서 가장 큰 값을 먼저 꺼내고 싶다면 → MaxHeap으로 만들어야 해! => (maxHeap.poll());


            }
        }
        // 힙에는 N개의 가장 큰 수만 남고,
        // 그 중 가장 작은 값 = N번째 큰 수
        System.out.println(pq.peek());
        // pd.peek() -> 꺼내지 않고 확인만 함
    }
}