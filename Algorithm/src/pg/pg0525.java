package pg;

import java.util.LinkedList; // LinkedList 클래스 import (Queue로 사용)
import java.util.Queue;      // Queue 인터페이스 import

public class pg0525 { // 클래스 선언
    // 게임 맵에서 최단 거리를 구하는 메서드
    public int solution(int[][] maps) {
        int n = maps.length;        // 맵의 행(세로) 크기
        int m = maps[0].length;     // 맵의 열(가로) 크기

        boolean[][] visited = new boolean[n][m]; // 방문 여부를 체크하는 2차원 배열
        // 방문여부를 파악하기 때문에 방문(참), 미방문(거짓) -> boolean

        // 상, 하, 좌, 우 방향을 나타내는 배열
        int[] dx = {-1, 1, 0, 0}; // 행 변화량 (상, 하)
        int[] dy = {0, 0, -1, 1}; // 열 변화량 (좌, 우)

        Queue<int[]> queue = new LinkedList<>(); // BFS에 사용할 큐 생성
        // BFS는 시작점에서 가까운 노드(혹은 칸)부터 차례대로 탐색함
        // 즉, 먼저 방문한 곳을 먼저 처리해야 하므로, “선입선출(FIFO, First-In-First-Out)” 구조가 필요함

        // 시작점 (0, 0)과 이동 횟수 1을 큐에 추가(시작점이므로 1로 시작)
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true; // 시작점 방문 처리 [0][0]=true 시작점이므로 방문했다고 표시

        // 큐가 빌 때까지 반복 (BFS)
        // 큐에 탐색할 곳이 없으면 종료
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 큐에서 현재 위치와 이동 횟수 꺼내기
            int x = current[0];           // 현재 행 위치
            int y = current[1];           // 현재 열 위치
            int cnt = current[2];         // 현재까지 이동한 칸 수

            // 도착 지점에 도달하면 이동 횟수 반환 (최단거리)
            // 현재 위치가 도착지점(오른쪽 아래 끝)이라면, 지금까지의 이동 칸 수(cnt)를 즉시 반환함
            // BFS의 특성상, 도착지에 처음 도달한 경로가 항상 “최단 거리”임
            if (x == n-1 && y == m-1) return cnt;


            // 4방향 모두 확인
            for (int i=0; i<4; i++) {
                int nx = x + dx[i]; // 다음 행 위치
                int ny = y + dy[i]; // 다음 열 위치

                //	nx, ny가 맵 범위 내에 있는지 (음수이거나 맵 크기 이상이면 안 됨)
                //	maps[nx][ny]==1 벽이 아니라 지나갈 수 있는 길인지
                //	!visitednxny: 아직 방문하지 않은 곳인지

                // 맵 범위 내에 있고, 길이 있으며, 방문하지 않은 곳이면
                if (nx >=0 && ny >=0 && nx <n && ny <m
                        && maps[nx][ny]==1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;         // 방문 처리
                    queue.add(new int[]{nx, ny, cnt+1}); // 큐에 다음 위치와 이동 횟수 추가
                }
            }
        }
        // 도착 지점에 도달할 수 없는 경우 -1 반환
        return -1;
    }
}
