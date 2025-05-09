package boj;

import java.util.Scanner;

public class BOJ8393 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += i+1;
        }System.out.println(sum);

    }
}
//1 = 1
//2 = 1 + 2
//3 = 1 + 2 + 3
//4 = 1 + 2 + 3 + 4