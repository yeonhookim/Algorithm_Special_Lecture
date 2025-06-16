package practice;

/**
 * 배열 기반 선형 탐색(Linear Search) 예제 클래스
 * 알고리즘: 선형 탐색(Linear Search)
 * 자료구조: 배열(Array)
 */
public class AlgorithmExample {

    /**
     * 배열에서 특정 값의 인덱스를 찾는 선형 탐색 메서드
     * @param arr 탐색할 배열
     * @param target 찾고자 하는 값
     * @return 값이 있으면 인덱스, 없으면 -1 반환
     */
    public static int linearSearch(int[] arr, int target) {
        // 배열의 모든 요소를 순회
        for (int i = 0; i < arr.length; i++) {
            // 현재 요소가 찾는 값과 같으면 인덱스 반환
            if (arr[i] == target) {
                return i;
            }
        }
        // 배열에 값이 없으면 -1 반환
        return -1;
    }

    /**
     * 메인 메서드: 선형 탐색 예시 실행
     */
    public static void main(String[] args) {
        int[] numbers = { 10, 20, 30, 40, 50 };
        int target = 30;

        // 선형 탐색 실행
        int index = linearSearch(numbers, target);

        if (index != -1) {
            System.out.println("값 " + target + "의 인덱스: " + index);
        } else {
            System.out.println("값 " + target + "은 배열에 없습니다.");
        }
    }
}
