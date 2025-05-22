package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//중위 순회 - 순회 정리

public class BOJ9934 {

    // 트리의 깊이(K)를 저장할 전역 변수, 문제에서 주어지는 입력값
    static int K;

    // 입력으로 주어지는 중위 순회의 결과를 저장할 배열
    static int[] nodes;

    // 각 레벨(깊이)별로 노드 값을 저장할 2차원 ArrayList
    static ArrayList<ArrayList<Integer>> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 트리의 깊이 K를 입력받아 정수로 변환
        K = Integer.parseInt(br.readLine());

        // 두 번째 줄의 입력(중위 순회 결과)을 공백 기준으로 분리하기 위한 StringTokenizer를 생성
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 깊이가 K인 완전 이진 트리의 총 노드 수를 계산
        // (1 << K)는 2의 K제곱을 의미하며, 완전 이진 트리의 노드 수는 2^K-1이다.
        int N = (1 << K) - 1; // 2^K - 1

        // 총 노드 수(N)만큼의 크기를 가진 배열을 생성
        nodes = new int[N];

        // 중위 순회 결과를 하나씩 읽어서 nodes 배열에 저장
        for (int i = 0; i < N; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }

        // 각 레벨별 노드를 저장할 2차원 ArrayList를 초기화
        answer = new ArrayList<>();

        // K개의 레벨에 대해 각각 빈 ArrayList를 생성하여 추가
        // 각 레벨별로 노드를 저장할 공간을 미리 준비
        for (int i = 0; i < K; i++) {
            answer.add(new ArrayList<>());
        }

        // 트리를 재구성하는 build 함수를 호출
        // 첫 번째 매개변수 0: 현재 레벨(깊이)
        // 두 번째 매개변수 0: 현재 구간의 시작 인덱스
        // 세 번째 매개변수 N-1: 현재 구간의 끝 인덱스
        build(0, 0, N - 1);

        // 출력을 빠르게 하기 위한 StringBuilder 객체 생성
        StringBuilder sb = new StringBuilder();

        // 각 레벨(깊이)별로 저장된 노드들을 순회
        for (ArrayList<Integer> level : answer) {
            // 해당 레벨의 모든 노드 값을 StringBuilder에 추가하고, 각 값 뒤에 공백 추가
            for (int n : level) {
                sb.append(n).append(" ");
            }
            // 한 레벨의 모든 노드 출력이 끝나면 줄바꿈 문자를 추가
            sb.append('\n');
        }
        System.out.print(sb); // 출력 개행 수정
    }

    // 트리를 재구성하는 재귀 함수
    // depth : 현재 레벨(깊이), start : 현재 구간의 시작 인덱스, end : 현재 구간의 끝 인덱스
    static void build(int depth, int start, int end) {

        // 기저 조건 : 시작 인덱스가 끝 인덱스보다 크면 더 이상 처리할 노드가 없으므로 함수를 종료
        if (start > end) return;

        // 현재 구간의 중간 인덱스를 계산, 중위 순회에서 중간 인덱스는 해당 구간의 루트(부모)노드이다.
        int mid = (start + end) / 2;
        // 현재 레벨(depth)의 ArrayList에 중간 인덱스에 해당하는 노드 값을 추가
        answer.get(depth).add(nodes[mid]);
        // 왼쪽 서브트리를 처리하기 위해 재귀 호출
        // 다음 레벨(depth+1)로 내려가고, 구간은 start부터 mid-1까지
        build(depth + 1, start, mid - 1);
        // 오른쪽 서브트리를 처리하기 위해 재귀 호출
        // 다음 레벨(depth+1)로 내려가고, 구간은 mid+1부터 end까지
        build(depth + 1, mid + 1, end);
    }
}
