package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//중위 순회 - 순회 정리

public class BOJ9934 {
    /**
     * 전역 변수로 선언하여 main 메서드와 build 메서드 간 데이터를 공유한다.
     * 재귀 호출 시 매개변수로 계속 전달하는 것보다 효율적이며 코드가 간결해진다.
     */
    // 트리의 깊이(K)를 저장할 전역 변수, 문제에서 주어지는 입력값
    static int K;

    // 입력으로 주어지는 중위 순회의 결과를 저장할 배열
    static int[] nodes;
/**
 •	각 레벨(깊이)별로 노드 값을 저장하기 위해 2차원 구조를 사용합니다.
 •	answer.get(0): 레벨 0(루트)의 노드들
 •	answer.get(1): 레벨 1의 노드들
 •	answer.get(2): 레벨 2의 노드들… 등
 **/
    // 각 레벨(깊이)별로 노드 값을 저장할 2차원 ArrayList
    static ArrayList<ArrayList<Integer>> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 트리의 깊이 K를 입력받아 정수로 변환
        K = Integer.parseInt(br.readLine());

        // 두 번째 줄의 입력(중위 순회 결과)을 공백 기준으로 분리하기 위한 StringTokenizer를 생성
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         •	비트 연산자 << (왼쪽 시프트)를 사용하여 2의 K제곱을 계산합니다.
         •	1 << K는 이진수 1을 K번 왼쪽으로 시프트하여 2^K 값을 얻습니다.
         •	예: 1 << 3 = 00001000(이진수) = 8(십진수) = 2^3
         **/
        // 깊이가 K인 완전 이진 트리의 총 노드 수를 계산
        // (1 << K)는 2의 K제곱을 의미하며, 완전 이진 트리의 노드 수는 2^K-1이다.
        int N = (1 << K) - 1; // 2^K - 1

        // 총 노드 수(N)만큼의 크기를 가진 배열을 생성
        nodes = new int[N];

        //중위 순회 결과를 하나씩 읽어서 nodes 배열에 저장
        //StringTokenizer를 통해 공백으로 구분된 각 숫자를 가져와 정수로 변환한 후 배열에 순서대로 저장
        // 예: 입력이 “1 6 4 3 5 2 7”이라면 nodes = 로 저장
        // 중위 순회 결과를 하나씩 읽어서 nodes 배열에 저장
        for (int i = 0; i < N; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }
        // 각 레벨별 노드를 저장할 2차원 ArrayList를 초기화
        // answer는 K개의 ArrayList를 포함하는 ArrayList로, 각 내부 ArrayList는 해당 레벨의 노드들을 저장
        // 각 레벨별 노드를 저장할 2차원 ArrayList를 초기화
        answer = new ArrayList<>();


        // K개의 레벨에 대해 각각 빈 ArrayList를 생성하여 answer에 추가
        // 예: K=3인 경우 answer = [[], [], []] 형태로 초기화되며, 각 빈 리스트는 레벨 0, 1, 2의 노드를 저장할 공간
        // 이후 build 함수에서 이 구조에 각 노드를 해당 레벨에 맞게 추가
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

// build함수와 완전이진트리와의 관계가 무엇일까?


/**
작동 예시
        예를 들어, 입력이 “1 6 4 3 5 2 7”이고 K=3인 경우:
        1.	첫 호출: `build(0, 0, 6)`
        •	mid = (0+6)/2 = 3
        •	nodes = 3 (인덱스 3의 값)
        •	answer.get(0).add(3) → 레벨 0에 3 추가
	•	왼쪽: `build(1, 0, 2)`
        •	오른쪽: `build(1, 4, 6)`
        2.	왼쪽 서브트리: `build(1, 0, 2)`
        •	mid = (0+2)/2 = 1
        •	nodes = 6 (인덱스 1의 값)
        •	answer.get(1).add(6) → 레벨 1에 6 추가
	•	왼쪽: `build(2, 0, 0)`
        •	오른쪽: `build(2, 2, 2)`
        3.	왼쪽의 왼쪽: `build(2, 0, 0)`
        •	mid = (0+0)/2 = 0
        •	nodes = 1 (인덱스 0의 값)
        •	answer.get(2).add(1) → 레벨 2에 1 추가
	•	왼쪽/오른쪽: 범위 초과로 종료
	4.	왼쪽의 오른쪽: `build(2, 2, 2)`
        •	mid = (2+2)/2 = 2
        •	nodes = 4 (인덱스 2의 값)
        •	answer.get(2).add(4) → 레벨 2에 4 추가
	•	왼쪽/오른쪽: 범위 초과로 종료
	5.	오른쪽 서브트리: `build(1, 4, 6)` (비슷한 방식으로 처리)
        •	결과적으로 레벨 1에 2가 추가되고, 레벨 2에 5와 7이 추가됨
최종 결과:
        •	answer.get(0) =
        •	answer.get(1) =
        •	answer.get(2) =
이렇게 각 레벨별로 노드가 저장된다.
        **/
