package week02;

class NetWork {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        return answer;
    }

    void dfs(int current, int[][] computers, boolean[] visited) {
        visited[current] = true;
        for (int neighbor = 0; neighbor < computers.length; neighbor++) {
            if (computers[current][neighbor] == 1 && !visited[neighbor]) {
                dfs(neighbor, computers, visited);
            }
        }
    }
}