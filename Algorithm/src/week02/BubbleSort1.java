package week02;

import java.util.Arrays;

public class BubbleSort1 {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 두 원소의 위치 교환
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // 교환이 한 번도 일어나지 않았다면 이미 정렬된 상태
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("원래 배열: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("정렬된 배열: " + Arrays.toString(arr));
    }
}
