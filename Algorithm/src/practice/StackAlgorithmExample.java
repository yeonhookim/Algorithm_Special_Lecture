package practice;

import java.util.EmptyStackException;

public class StackAlgorithmExample {
    // 내부적으로 노드 클래스를 사용하여 스택 구현
    private static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // 스택의 top을 가리키는 포인터
    private Node top;

    // 생성자: 스택 초기화
    public StackAlgorithmExample() {
        this.top = null;
    }

    // 스택이 비었는지 확인
    public boolean isEmpty() {
        return top == null;
    }

    // 스택에 값 추가 (push)
    public void push(char data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // 스택에서 값 꺼내기 (pop)
    public char pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        char data = top.data;
        top = top.next;
        return data;
    }

    /**
     * 괄호 짝 맞추기 알고리즘
     * @param str 검사할 괄호 문자열
     * @return 짝이 맞으면 true, 아니면 false
     */
    public boolean isBalanced(String str) {
        StackAlgorithmExample stack = new StackAlgorithmExample();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (!((top == '(' && ch == ')') ||
                        (top == '[' && ch == ']') ||
                        (top == '{' && ch == '}'))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // 테스트 메인
    public static void main(String[] args) {
        StackAlgorithmExample example = new StackAlgorithmExample();
        String testStr1 = "{[()]}"; // 짝이 맞음
        String testStr2 = "{[()]}("; // 짝이 안 맞음

        System.out.println("테스트1: " + testStr1 + " → " + example.isBalanced(testStr1));
        System.out.println("테스트2: " + testStr2 + " → " + example.isBalanced(testStr2));
    }
}
