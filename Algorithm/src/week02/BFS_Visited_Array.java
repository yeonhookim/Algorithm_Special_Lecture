package week02;

import java.util.*;

public class BFS_Visited_Array {
    public void bfs(List<List<Integer>> graph, int startVertex) {
        // 시작점 예약
        Queue<Integer> queue = new LinkedList<>();
        final int N = graph.size();
        boolean[] visited = new boolean[N];
        queue.add(startVertex);
        visited[startVertex] = true;
        // queue가 비어있을 때까지 반복
        while (!queue.isEmpty()) {
            // 현재 노드 방문
            int curVertex = queue.remove();
            // 다음 노드 예약
            for (int nextVertex : graph.get(curVertex)) {
                if (!visited[nextVertex]) {
                queue.add(nextVertex);
                visited[nextVertex] = true;}
            }
            }
        }

    public void solve(List<List<Integer>> graph) {
        bfs(graph, 0);
    }

    // 실행용 메소드
    public static void main(String[] args) {
        (new BFS_Visited_Array()).solve(makeGraph());
    }

    public static List<List<Integer>> makeGraph() {
        return new ArrayList<>() {{
            add(List.of(1, 3, 6));
            add(List.of(0, 3));
            add(List.of(3));
            add(List.of(0, 1, 2, 7));
            add(List.of(5));
            add(List.of(4, 6, 7));
            add(List.of(0, 5));
            add(List.of(3, 5));
        }};
    }

}