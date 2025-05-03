package week02;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i + 1);
            System.out.println("push: " + stack.peek());
        }
        stack.pop();
        System.out.println("pop 후 peek: " + stack.peek());
        System.out.println("1의 위치: " + stack.search(1));
        System.out.println("스택이 비었나요? " + stack.empty());
    }
}

