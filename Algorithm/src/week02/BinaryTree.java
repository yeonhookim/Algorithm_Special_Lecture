package week02;

// 이진 트리 노드 클래스 정의
class TreeNode {
    int value; // 노드의 값
    TreeNode left;  // 왼쪽 자식
    TreeNode right; // 오른쪽 자식

    // 생성자
    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

// 이진 탐색 트리(BST) 클래스
public class BinaryTree {
    TreeNode root; // 트리의 루트(시작점)

    // 트리에 노드 삽입 (순서대로 넣으면 BST로 만듦)
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    // 재귀로 노드 삽입하는 함수
    private TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null) {
            // 현재 위치가 비어있으면 새 노드 생성
            return new TreeNode(value);
        }
        if (value < node.value) {
            // 현재 값보다 작으면 왼쪽 서브트리에 삽입
            node.left = insertRecursive(node.left, value);
        } else if (value > node.value) {
            // 현재 값보다 크면 오른쪽 서브트리에 삽입
            node.right = insertRecursive(node.right, value);
        }
        // 같으면 아무 것도 안 함 (중복 허용 안 함)
        return node;
    }

    // 중위순회(Inorder Traversal): 왼쪽 → 노드 → 오른쪽 (오름차순 출력)
    public void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);    // 왼쪽 서브트리 방문
            System.out.print(node.value + " "); // 현재 노드 값 출력
            inorderTraversal(node.right);   // 오른쪽 서브트리 방문
        }
    }

    // 메인 함수 테스트용
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        // 트리에 값 삽입
        tree.insert(7);
        tree.insert(3);
        tree.insert(10);
        tree.insert(5);
        tree.insert(8);

        // 중위순회 결과 출력 (오름차순)
        System.out.print("중위순회 결과: ");
        tree.inorderTraversal(tree.root); // 3 5 7 8 10 출력
    }
}

