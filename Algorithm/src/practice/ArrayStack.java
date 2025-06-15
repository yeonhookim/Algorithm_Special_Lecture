package practice;

public class ArrayStack {
    private int maxSize;    // 스택의 최대 크기
    private int top;        // 스택의 맨 위 인덱스
    private int[] stackArray;// 스택을 위한 배열

    // 생성자: 스택의 크기 설정
    public ArrayStack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;           // 스택이 비어있음을 나타냄
    }

    // 데이터를 스택에 추가 (push)
    public void push(int data) {
        if (top == maxSize - 1) {
            System.out.println("스택이 가득 찼습니다.");
            return;
        }
        stackArray[++top] = data; // top을 증가시키고 데이터 저장
    }

    // 스택에서 데이터를 제거 (pop)
    public int pop() {
        if (isEmpty()) {
            System.out.println("스택이 비어있습니다.");
            return -1;      // 예외 처리 대신 -1 반환 (실제 사용시 예외를 던지는 것이 더 좋음)
        }
        return stackArray[top--]; // top 위치의 데이터 반환 후 top 감소
    }

    // 스택의 맨 위 데이터 확인 (peek)
    public int peek() {
        if (isEmpty()) {
            System.out.println("스택이 비어있습니다.");
            return -1;
        }
        return stackArray[top];
    }

    // 스택이 비어있는지 확인
    public boolean isEmpty() {
        return (top == -1);
    }

    // 스택에 저장된 데이터의 개수 반환
    public int size() {
        return top + 1;
    }

    // 메인 메서드: 스택 사용 예시
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("스택 크기: " + stack.size());   // 출력: 3
        System.out.println("맨 위 데이터: " + stack.peek()); // 출력: 30
        System.out.println("Pop한 데이터: " + stack.pop());  // 출력: 30
        System.out.println("Pop한 데이터: " + stack.pop());  // 출력: 20
        System.out.println("스택이 비어있는지 확인: " + stack.isEmpty()); // 출력: false
    }
}

