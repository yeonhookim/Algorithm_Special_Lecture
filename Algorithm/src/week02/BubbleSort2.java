package week02;

import java.util.Arrays;

public class BubbleSort2 {
    public static void bubbleSortRecursive(int[] arr, int n) {
        // 종료 조건
        if (n == 1) return;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                // swap
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        // 마지막 원소를 제외하고 재귀 호출
        bubbleSortRecursive(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("원래 배열: " + Arrays.toString(arr));
        bubbleSortRecursive(arr, arr.length);
        System.out.println("정렬된 배열: " + Arrays.toString(arr));
    }
}

