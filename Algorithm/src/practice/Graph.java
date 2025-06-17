package practice;

import java.util.*;


public class Graph {
    private int vertices; // 정점의 개수
    private LinkedList<Integer>[] adjacencyList; // 인접 리스트

    /**
     * 생성자: 정점 개수를 받아 그래프 초기화
     * @param vertices 정점의 개수
     */
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    /**
     * 간선 추가
     * @param source 출발 정점
     * @param destination 도착 정점
     */
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    /**
     * BFS(너비 우선 탐색) 구현
     * @param start 시작 정점
     */
    public void BFS(int start) {
        boolean[] visited = new boolean[vertices]; // 방문 여부 배열
        Queue<Integer> queue = new LinkedList<>(); // BFS용 큐

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjacencyList[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    /**
     * DFS(깊이 우선 탐색) 구현
     * @param start 시작 정점
     */
    public void DFS(int start) {
        boolean[] visited = new boolean[vertices]; // 방문 여부 배열
        DFSUtil(start, visited);
    }

    // DFS 재귀 보조 함수
    private void DFSUtil(int current, boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " ");

        for (int neighbor : adjacencyList[current]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    /**
     * 사용 예시
     */
    public static void main(String[] args) {
        Graph graph = new Graph(4); // 4개의 정점 그래프 생성
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.print("BFS 탐색 결과: ");
        graph.BFS(2); // 2번 정점에서 시작

        System.out.print("\nDFS 탐색 결과: ");
        graph.DFS(2); // 2번 정점에서 시작
    }
}
