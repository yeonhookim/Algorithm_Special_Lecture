package practice;

public class BinaryTree_v2 {
    /**
     * 이진 트리 노드 클래스
     */
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 이진 트리 구현 클래스
     */
    public static class BinaryTree {
        private Node root;

        public BinaryTree() {
            root = null;
        }

        /**
         * 노드 삽입 메서드 (재귀 구현)
         * @param current 현재 노드
         * @param value 삽입할 값
         * @return 새로 생성된 노드
         */
        private Node insertRecursive(Node current, int value) {
            if (current == null) {
                return new Node(value);
            }

            // 왼쪽 서브트리로 이동
            if (value < current.data) {
                current.left = insertRecursive(current.left, value);
            }
            // 오른쪽 서브트리로 이동
            else if (value > current.data) {
                current.right = insertRecursive(current.right, value);
            }

            return current;
        }

        public void insert(int value) {
            root = insertRecursive(root, value);
        }

        /**
         * 전위 순회 (Root → Left → Right)
         */
        public void preOrderTraversal(Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                preOrderTraversal(node.left);
                preOrderTraversal(node.right);
            }
        }

        /**
         * 중위 순회 (Left → Root → Right)
         */
        public void inOrderTraversal(Node node) {
            if (node != null) {
                inOrderTraversal(node.left);
                System.out.print(node.data + " ");
                inOrderTraversal(node.right);
            }
        }

        /**
         * 후위 순회 (Left → Right → Root)
         */
        public void postOrderTraversal(Node node) {
            if (node != null) {
                postOrderTraversal(node.left);
                postOrderTraversal(node.right);
                System.out.print(node.data + " ");
            }
        }

        /**
         * 값 검색 메서드
         * @return 값이 존재하면 true, 아니면 false
         */
        public boolean containsValue(Node current, int value) {
            if (current == null) return false;
            if (value == current.data) return true;

            return value < current.data
                    ? containsValue(current.left, value)
                    : containsValue(current.right, value);
        }

        public static void main(String[] args) {
            BinaryTree tree = new BinaryTree();

            // 노드 삽입 예시
            tree.insert(50);
            tree.insert(30);
            tree.insert(20);
            tree.insert(40);
            tree.insert(70);
            tree.insert(60);
            tree.insert(80);

            System.out.println("전위 순회:");
            tree.preOrderTraversal(tree.root);

            System.out.println("\n중위 순회:");
            tree.inOrderTraversal(tree.root);

            System.out.println("\n후위 순회:");
            tree.postOrderTraversal(tree.root);

            System.out.println("\n값 40 존재 여부: " + tree.containsValue(tree.root, 40));
        }
    }


}
