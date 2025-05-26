package pg;

import java.util.*;

class pg0526 {
    // 최소 변환 횟수를 저장할 변수
    static int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited, 0);
        // 만약 변환할 수 없다면 0 반환
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    // DFS로 모든 경우 탐색
    void dfs(String current, String target, String[] words, boolean[] visited, int count) {
        if (current.equals(target)) { // 목표 단어에 도달하면
            answer = Math.min(answer, count); // 최소 횟수 갱신
            return;
        }

        for (int i = 0; i < words.length; i++) {
            // 아직 방문하지 않았고, 한 글자만 다르면
            if (!visited[i] && canChange(current, words[i])) {
                visited[i] = true; // 방문 표시
                dfs(words[i], target, words, visited, count + 1); // 다음 단어로 이동
                visited[i] = false; // 백트래킹
            }
        }
    }

    // 두 단어가 한 글자만 다른지 확인
    boolean canChange(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}
