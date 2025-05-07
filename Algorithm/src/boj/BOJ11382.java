package boj;

import java.util.Scanner;

public class BOJ11382 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        // 10의 12제곱이기 때문에(범위가) int가 아닌 long을 쓴다.
        System.out.print(A+B+C);
    }
}
