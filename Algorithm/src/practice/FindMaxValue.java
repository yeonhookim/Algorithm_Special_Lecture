package practice;

/**
 * 배열에서 최대값을 찾는 알고리즘 예시 클래스
 */
public class FindMaxValue {

    /**
     * 배열에서 최대값을 찾는 메서드
     * @param arr 최대값을 찾을 배열
     * @return 배열 내 최대값
     */
    public int findMax(int[] arr) {
        // 배열이 비어있으면 예외 처리
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("배열이 비어 있습니다.");
        }

        int max = arr[0]; // 첫 번째 값을 최대값으로 초기화

        // 배열을 순회하며 최대값 갱신
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max; // 최대값 반환
    }

    /**
     * 메인 메서드: 예시 실행
     * @param args 사용하지 않음
     */
    public static void main(String[] args) {
        FindMaxValue finder = new FindMaxValue();

        int[] numbers = {3, 5, 7, 2, 8, 1};
        int max = finder.findMax(numbers);

        System.out.println("최대값: " + max);
    }
}
