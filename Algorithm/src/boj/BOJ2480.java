package boj;

import java.util.Scanner;

public class BOJ2480 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        int third = sc.nextInt();

        if (first == second && second == third) { // 세 눈이 같음
            System.out.println(10000 + first * 1000);
        } else if (first == second && first != third) { // 첫 - 두 번째 눈 같음
            System.out.println(1000 + first * 100);
        } else if (second == third && first != third) { // 두 - 세 번째 눈 같음
            System.out.println(1000 + second * 100);
        } else if (first == third &&  first != second) { // 첫 - 세 번째 눈 같음
            System.out.println(1000 + third * 100);
        } else {
            int max = first; // 세 눈이 다를 경우 가장 높은 눈 * 1
            if (second > max) max = second;
            if (third > max) max = third;
            System.out.println(max * 100);
        }
    }
}
