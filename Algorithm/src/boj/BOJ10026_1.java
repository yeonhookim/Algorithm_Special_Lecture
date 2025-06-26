package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026_1 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 일반인 시점
        visited = new boolean[N][N];
        int normalCount = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    normalCount++;
                }

        // 적록색약 시점: G → R 변환
        visited = new boolean[N][N];
        int colorBlindCount = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') map[i][j] = 'R'; // 색약 처리
            }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    colorBlindCount++;
                }

        System.out.println(normalCount + " " + colorBlindCount);
    }

    // DFS 탐색
    static void dfs(int x, int y, char color) {
        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (!visited[nx][ny] && map[nx][ny] == color) {
                dfs(nx, ny, color);
            }
        }
    }
}