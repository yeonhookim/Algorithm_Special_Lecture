package pg;


import java.util.LinkedList; // LinkedList 클래스를 사용하기 위해 import 합니다. Queue 인터페이스를 구현한 클래스 중 하나입니다.
import java.util.Queue;      // Queue 인터페이스를 사용하기 위해 import 합니다.
public class pg0527 {
  public int solution(int[] queue1, int[] queue2) {
        // 1. 큐 초기화 및 각 큐의 합 계산
        Queue<Integer> q1 = new LinkedList<>(); // 첫 번째 큐 (LinkedList로 구현)
        Queue<Integer> q2 = new LinkedList<>(); // 두 번째 큐 (LinkedList로 구현)
        long sum1 = 0; // 첫 번째 큐의 원소 합 (int 배열의 합이 int 범위를 넘을 수 있으므로 long 타입 사용)
        long sum2 = 0; // 두 번째 큐의 원소 합

        // queue1 배열의 원소들을 q1에 추가하고 sum1을 계산합니다.
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            q1.add(queue1[i]);
        }
        // queue2 배열의 원소들을 q2에 추가하고 sum2을 계산합니다.
        for (int i = 0; i < queue2.length; i++) {
            sum2 += queue2[i];
            q2.add(queue2[i]);
        }

        // 2. 두 큐의 전체 합 계산 및 목표 합 설정
        long totalSum = sum1 + sum2; // 두 큐의 전체 원소 합
        long targetSum = totalSum / 2; // 각 큐가 가져야 할 목표 합

        // 3. 불가능한 경우 처리: 전체 합이 홀수이면 두 큐의 합을 같게 만들 수 없습니다.
        if (totalSum % 2 != 0) {
            return -1; // 홀수이면 -1 반환
        }

        // 4. 작업 횟수 및 최대 시도 횟수 설정
        int count = 0; // 작업 횟수를 저장할 변수
        // 최대 작업 횟수 제한: 한쪽 큐의 모든 원소가 다른 쪽으로 갔다가 다시 돌아오는 최악의 경우를 고려하여 설정합니다.
        // queue1.length * 2 (모든 원소가 한 번씩 이동) + queue1.length (원위치) = queue1.length * 3 정도면 충분합니다.
        // 문제에 따라서는 queue1.length * 4 정도로 더 넉넉하게 잡기도 합니다.
        int limit = queue1.length * 3; // 최대 작업 횟수 (무한 루프 방지)

        // 5. 큐의 합을 같게 만드는 작업 수행
        // sum1이 targetSum과 같아질 때까지 반복합니다.
        while (sum1 != targetSum) {
            // 최대 작업 횟수를 초과하면 불가능한 경우로 판단하고 -1을 반환합니다.
            if (count > limit) {
                return -1;
            }

            // sum1이 targetSum보다 크면, q1에서 원소를 빼서 q2로 옮깁니다.
            if (sum1 > targetSum) {
                if (q1.isEmpty()) return -1; // 옮길 원소가 없으면 불가능 (이론상 이 경우는 limit에 먼저 걸림)
                int num = q1.poll(); // q1에서 원소 추출 (제일 앞에 있는 원소)
                sum1 -= num;         // q1의 합에서 추출한 원소 값 빼기
                sum2 += num;         // q2의 합에 추출한 원소 값 더하기
                q2.add(num);         // q2에 원소 추가
            }
            // sum1이 targetSum보다 작으면 (즉, sum2가 targetSum보다 크면), q2에서 원소를 빼서 q1로 옮깁니다.
            else { // sum1 < targetSum
                if (q2.isEmpty()) return -1; // 옮길 원소가 없으면 불가능
                int num = q2.poll(); // q2에서 원소 추출
                sum2 -= num;         // q2의 합에서 추출한 원소 값 빼기
                sum1 += num;         // q1의 합에 추출한 원소 값 더하기
                q1.add(num);         // q1에 원소 추가
            }
            count++; // 작업 횟수 증가
        }

        // 6. 결과 반환
        return count; // 두 큐의 합을 같게 만드는 데 필요한 최소 작업 횟수 반환
    }
}