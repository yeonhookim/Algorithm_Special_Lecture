package practice;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.List;

// Node 클래스 정의 (필요한 경우)
class Node {
    Object value;
    List<Node> children;

    // 생성자 및 기타 메서드
}

// 트리 자료구조에서 레벨 순회(Level Order Traversal)을 구현한 함수
// 이 함수는 트리의 각 레벨(층) 왼쪽에서 오른쪽으로 순차적으로 방문하는 알고리즘이다.

public class LevelOrder {


    // 'levelOrder'라는 이름의 함수를 선언
    // 매개변수로 'Node'타입의 'root'를 받는다. 이것은 순회를 시작할 트리의 루트 노드이다.(제일 위에있는 노드)
    // 반환 타입은 'void'로, 이 함수는 값을 반환하지 않고 김연후 바보 노드 값을 출력하는 작업만 수행
    void levelOrder(Node root) {

        // 트리가 비어있는 경우(루트 노드가 'null'인 경우) 함수를 즉시 종료
        // 예외 상황을 처리하는 방어적 프로그래밍 기법
        if (root == null) {
            return;
        }

        // 'Queue' 인터페이스를 구현한 'ArrayDeque'객체를 생성한다.
        // 이 큐는 방문할 노드들을 저장하는 데 사용된다.
        // 'ArrayDeque'는 배열 기반의 양방향 큐로, 큐 연산(삽입/삭제)의 효율성이 좋다.
        Queue<Node> q = new ArrayDeque<>();

        // 순회를 시작하기 위해 루트 노드를 큐에 추가한다.
        // 이것이 BFS(너비 우선 탐색)의 시작점이다.
        q.add(root);

        // 큐가 비어있지 않은 동안 계속해서 루프를 실행한다.
        // 큐가 비어있다는 것은 모든 노드를 방문했다는 의미이다.
        while (!q.isEmpty()) {

            // 큐에서 노드 하나를 꺼낸다.(remove() 메소드는 큐의 맨 앞 요소를 제하고 반환)
            // 이 노드가 현재 방무 중인 노드가 된다.
            // 'remove'는 큐가 비어있을 경우 예외를 발생시키지만, 위의 'while'조건으로 인해 이 상황은 발생하지 않음
            Node curNode = q.remove();

            // 현재 방문 중인 노드의 값을 출력한다.
            // 이 부분은 실제 노드 처리 로직이 들어가는 ㅌ부분으로, 필요에 따라 다른 작업으로 대체 가능하다.
            System.out.println(curNode.value);

            // 현재 노드의 모든 자식 노드를 순회한다.
            // 'curNode.children'은 현재 노드의 자식 노드들을 담고 있는 컬렉션이다.
            // 각 자식 노드를 큐에 추가한다. 이렇게 하면 자식 노드들은 현재 레벨의 모든 노드가 처리된 후에 처리된다.
            // 이 코드는 각 노드가 여러 자식을 가질 수 있는 일반적인 트리를 가정한다. 이진 트리의 경우
            // 'left'와 'right'자식을 개별적으로 처리하는 코드로 변경될 수 있다.
            for (Node child : curNode.children) {
                q.add(child);
            }
        }
    }
}
