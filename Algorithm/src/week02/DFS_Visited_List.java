package week02;

import java.util.*;

public class DFS_Visited_List {
    // visited를 list로 구현
    public void dfs(List<List<Integer>> graph, boolean[] visited, int curVertex) {
        visited[curVertex] = true;
        for (int nextVertex : graph.get(curVertex)) {
            if (!visited[nextVertex]) {
                dfs(graph, visited, nextVertex);
            }
        }
    }

    public void solve(List<List<Integer>> graph) {
        final int N = graph.size();
        boolean[] visited = new boolean[N];
        dfs(graph, visited, 0);
    }

    // 실행용 메소드
    public static void main(String[] args) {
        (new DFS_Visited_List()).solve(makeGraph());
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
