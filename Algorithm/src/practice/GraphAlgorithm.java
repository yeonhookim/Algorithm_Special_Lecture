package practice;

import java.util.*;

/**
 * 그래프 알고리즘 연습용 클래스
 */
public class GraphAlgorithm {

    // 그래프를 인접 리스트로 표현
    private Map<Integer, List<Integer>> graph;

    /**
     * 생성자: 그래프 초기화
     */
    public GraphAlgorithm() {
        this.graph = new HashMap<>();
    }

    /**
     * 간선 추가
     * @param u 출발 정점
     * @param v 도착 정점
     */
    public void addEdge(int u, int v) {
        // 정점 u가 없으면 새로 리스트 생성
        graph.putIfAbsent(u, new ArrayList<>());
        // u의 인접 리스트에 v 추가
        graph.get(u).add(v);
        // 무방향 그래프라면 아래 주석 해제
        // graph.putIfAbsent(v, new ArrayList<>());
        // graph.get(v).add(u);
    }

    /**
     * BFS(너비 우선 탐색)
     * @param start 시작 정점
     */
    public void bfs(int start) {
        // 방문 체크용 집합
        Set<Integer> visited = new HashSet<>();
        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        // 시작 정점 큐에 삽입 및 방문 처리
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            // 인접 노드 탐색
            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    /**
     * DFS(깊이 우선 탐색)
     * @param start 시작 정점
     */
    public void dfs(int start) {
        // 방문 체크용 집합
        Set<Integer> visited = new HashSet<>();
        // 스택 생성
        Stack<Integer> stack = new Stack<>();
        // 시작 정점 스택에 삽입 및 방문 처리
        stack.push(start);
        visited.add(start);
        System.out.print(start + " ");

        while (!stack.isEmpty()) {
            int current = stack.peek();
            boolean hasUnvisited = false;

            // 인접 노드 중 방문하지 않은 노드 탐색
            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                    System.out.print(neighbor + " ");
                    hasUnvisited = true;
                    break;
                }
            }
            if (!hasUnvisited) {
                stack.pop();
            }
        }
        System.out.println();
    }

    /**
     * Floyd-Warshall 알고리즘(가상의 코드, 실제 구현은 인접 행렬 필요)
     * @param n 정점 개수
     */
    public void floydWarshall(int n) {
        // 실제로는 인접 행렬 필요
        int[][] dist = new int[n][n];
        // 초기화 생략, 예시용 출력
        System.out.println("Floyd-Warshall: 인접 행렬 필요 (구현 생략)");
    }
}

