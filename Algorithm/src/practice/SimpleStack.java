package practice;

public class SimpleStack {
    private int[] stack;  // 스택을 저장할 배열
    private int top;      // 스택의 맨 위 인덱스

    // 생성자: 스택 크기를 지정
    public SimpleStack(int size) {
        stack = new int[size];
        top = -1; // 스택이 비어있음
    }

    // 데이터 추가 (push)
    public void push(int data) {
        if (top == stack.length - 1) {
            System.out.println("스택이 가득 찼습니다.");
            return;
        }
        stack[++top] = data; // 데이터를 스택에 추가
    }

    // 데이터 제거 (pop)
    public int pop() {
        if (isEmpty()) {
            System.out.println("스택이 비어있습니다.");
            return -1;
        }
        return stack[top--]; // 맨 위 데이터 반환 후 인덱스 감소
    }

    // 맨 위 데이터 보기 (peek)
    public int peek() {
        if (isEmpty()) {
            System.out.println("스택이 비어있습니다.");
            return -1;
        }
        return stack[top]; // 맨 위 데이터 반환
    }

    // 스택이 비었는지 확인
    public boolean isEmpty() {
        return (top == -1);
    }

    // 메인에서 예제 사용
    public static void main(String[] args) {
        SimpleStack stack = new SimpleStack(5); // 크기 5의 스택 생성
        stack.push(10);
        stack.push(20);
        System.out.println("Peek: " + stack.peek()); // 20
        System.out.println("Pop: " + stack.pop());   // 20
        System.out.println("Pop: " + stack.pop());   // 10
        System.out.println("스택이 비었는가? " + stack.isEmpty()); // true
    }
}
