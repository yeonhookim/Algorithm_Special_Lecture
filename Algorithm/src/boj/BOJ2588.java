package boj;

import java.util.Scanner;

public class BOJ2588 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        System.out.println(n1*(n2%10)); // 일의 자리
        System.out.println(n1*((n2/10)%10)); // 십의 자리
        System.out.println(n1*((n2/100)%10)); // 백의 자리
        System.out.println(n1*n2); // 최종
    }
}
