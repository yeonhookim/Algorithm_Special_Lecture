package pg;
import java.util.Stack;

public class pg0530 {
class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (isValid(s, len)) answer++;
            // 문자열을 한 칸 왼쪽으로 회전
            s = s.substring(1) + s.charAt(0);
        }
        return answer;
    }

    private boolean isValid(String s, int len) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
}