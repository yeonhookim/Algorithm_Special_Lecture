package week02;

class NetWork {
    public int solution(int n, int[][] computers) {
        int answer = 0;
      boolean[] visited = new boolean[n];
      // 컴퓨터의 개수(n)만큼 방문 여부를 저장할 배열을 만드는 부분
        // 예를들어 3이면, visited 배열은 [fasle, false, false]로 시작한다.
        // 각각의 값은 각 컴퓨터가 방문됐는지 아닌지를 기록하는 데 사용된다.
        // 아직 방문하지 않았다면 : false, 방문했다면 : true

        // 다음 단계, 각 컴퓨터를 순회하면서 아직 방문하지 않은 컴퓨터를 발견하면,
        // 새로운 네트워크로 간주하고 탐색(DFS/BFS) 한다.

        for (int i = 0; i < n; i++) {
            // 0번부터 n-1번까지 모든 컴퓨터를 하나씩 확인한다.
            if (!visited[i]) {
                // 자바에서 boolean 배열의 초기값은 모두 false이다.
                // 즉, 처음에는 모든 컴퓨터가 방문하지 않은 상태이다.
                // 방문하지 않았을 때 -> visited[i] == false
                // 방문했을 때 -> visited[i] == true

                // 하지만 여기서 아직 방문하지 않은 컴퓨터를 찾는 문구에
                // 논리 부정연산자, not 연산자(!)를 이용해야한다.
                // !false는 true, !true는 false 이런식으로 반대의 값을 만들어준다.

                // if(visited[i]) -> 이미 방문한 컴퓨터만 잡음
                // if(!visited[i]) -> 아직 방문하지 않은 컴퓨터만 잡음

                // if(!visited[i])는 "i번 컴퓨터가 아직 방문하지 않았다면"이라는 뜻이다.
                dfs(i, computers, visited);
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
