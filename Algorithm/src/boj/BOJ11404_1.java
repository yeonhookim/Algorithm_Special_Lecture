package boj;

import java.util.Scanner;

public class BOJ11404_1 {
    static final int INF = 1_000_000_000; // 갈 수 없는 경우를 나타내는 큰 값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력 받기
        int n = sc.nextInt(); // 도시 개수
        int m = sc.nextInt(); // 버스 노선 수

        // 2. 거리 배열 초기화
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dist[i][j] = 0; // 자기 자신까지는 거리 0
                } else {
                    dist[i][j] = INF; // 초기에는 갈 수 있는지 없는지 모름 (미지의 거리)
                    // 채워 놔야 나중에 다른 경로를 통해 갈 수 있다면 갱신 가능 INF(예.1,000,000,000 보다는 작을테니)
                }
            }
        }

        // 3. 버스 정보 입력 및 최소 비용 갱신
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); // 출발 도시
            int b = sc.nextInt(); // 도착 도시
            int c = sc.nextInt(); // 비용

            // 같은 경로가 여러 개 있을 수 있으므로 최소값으로 저장
            dist[a][b] = Math.min(dist[a][b], c);
        }

        // 4. 플로이드 워셜 알고리즘 수행
        for (int k = 1; k <= n; k++) { // 경유지
            for (int i = 1; i <= n; i++) { // 출발지
                for (int j = 1; j <= n; j++) { // 도착지
                    // 경유해서 가는 경우가 더 짧으면 갱신
                    // 점화식
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 5. 출력
        for (int i = 1; i <= n; i++) {
            // 출발 도시 i (1번 도시부터 n번 도시까지)
            for (int j = 1; j <= n; j++) {
                //도착 도시 j에 대해 반복
                // i에서 j까지의 최소 비용을 2차원 배열 dist[i][j]로 출력

                if (dist[i][j] == INF) {
                    //INF는 도달할 수 없는 경우를 의미함
                    System.out.print("0 ");
                    // 갈수 없는 경우에 0으로 표시
                } else {
                    System.out.print(dist[i][j] + " ");
                    // 갈 수 있다면 i -> j로 가는 최소 비용을 출력함
                }
            }
            System.out.println();
            //줄바꿈
        }
    }
}
