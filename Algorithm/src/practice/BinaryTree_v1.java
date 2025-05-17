package practice;

import java.util.Stack;

/**
 * 이진 트리 노드 클래스
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

/**
 * 이진 트리 운영 클래스
 */
public class BinaryTree_v1 {
    TreeNode root;

    // 1. 노드 삽입 (재귀적 구현)
    public TreeNode insertNode(TreeNode current, int val) {
        if (current == null) {
            return new TreeNode(val);
        }

        if (val < current.val) {
            current.left = insertNode(current.left, val);
        } else if (val > current.val) {
            current.right = insertNode(current.right, val);
        }
        return current;
    }

    // 2. 전위 순회 (Root → Left → Right)
    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");  // 현재 노드 처리
            preOrder(node.left);               // 왼쪽 서브트리 순회
            preOrder(node.right);              // 오른쪽 서브트리 순회
        }
    }

    // 3. 중위 순회 (Left → Root → Right) - 오름차순 정렬
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);                // 왼쪽 서브트리 순회
            System.out.print(node.val + " ");  // 현재 노드 처리
            inOrder(node.right);               // 오른쪽 서브트리 순회
        }
    }

    // 4. 후위 순회 (Left → Right → Root)
    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);              // 왼쪽 서브트리 순회
            postOrder(node.right);             // 오른쪽 서브트리 순회
            System.out.print(node.val + " ");  // 현재 노드 처리
        }
    }

    // 5. 반복적 중위 순회 (스택 사용)
    public void iterativeInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;  // 가장 왼쪽 노드까지 이동
            }
            current = stack.pop();
            System.out.print(current.val + " ");
            current = current.right;     // 오른쪽 서브트리 처리
        }
    }
}
