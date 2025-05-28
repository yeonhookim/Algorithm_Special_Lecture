package pg;

import java.util.Arrays;

public class pg0528 {
    class Solution {
        public boolean solution(String[] phone_book) {
            Arrays.sort(phone_book); // 전화번호 사전순 정렬
            for (int i = 0; i < phone_book.length - 1; i++) {
                // 바로 다음 번호가 현재 번호로 시작하는지 확인
                if (phone_book[i + 1].startsWith(phone_book[i])) {
                    return false;
                }
            }
            return true;
        }
    }

}
