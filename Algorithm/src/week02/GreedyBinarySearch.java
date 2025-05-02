package week02;

import java.util.*;

public class GreedyBinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 집 개수(N)와 공유기 개수(C) 입력
        int N = sc.nextInt();
        int C = sc.nextInt();

        // 집 좌표 배열 생성 및 정렬
        int[] houses = new int[N];
        for(int i=0; i<N; i++) houses[i] = sc.nextInt();
        Arrays.sort(houses);

        // 이진 탐색 수행
        int left = 1; // 최소 간격
        int right = houses[N-1] - houses[0]; // 최대 간격
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2; // 현재 시도할 최대 거리

            // 그리디: 현재 간격(mid)으로 공유기 설치 가능한지 확인
            int cnt = 1;
            int prev = houses[0];

            for(int i=1; i<N; i++) {
                if(houses[i] - prev >= mid) {
                    cnt++;
                    prev = houses[i];
                }
            }

            // 조건 충족 시 결과 갱신
            if(cnt >= C) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("최대 거리: " + result);
    }
}
