package week02;

import java.util.Scanner;
public class Greedy1 {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt(); // 거슬러 줄 금액 입력
    int count = 0;

    int[] coins = {500, 100, 50, 10}; // 큰 단위부터 동전 배열

    for (int coin : coins) {
        count += n / coin; // 해당 동전으로 거슬러 줄 수 있는 개수
        n %= coin;         // 남은 금액 갱신
    }

    System.out.println(count); // 최소 동전 개수 출력
}
}
