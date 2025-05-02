import java.util.stream.IntStream;

class NetWork__v2 {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        return (int) IntStream.range(0, n)
                .filter(i -> !visited[i] && (dfs(i, computers, visited) || true))
                .count();
    }

    private boolean dfs(int current, int[][] computers, boolean[] visited) {
        visited[current] = true;
        IntStream.range(0, computers.length)
                .filter(neighbor -> computers[current][neighbor] == 1 && !visited[neighbor])
                .forEach(neighbor -> dfs(neighbor, computers, visited));
        return true;
    }
}
