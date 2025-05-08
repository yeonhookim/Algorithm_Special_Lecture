package boj;

import java.util.Scanner;

public class BOJ2525 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        int Z = sc.nextInt();

        M = M + Z;

        if (M >= 60) {
            H = H + M / 60;
            M = M % 60;
            }

        if (H >= 24) {
            H = H % 24;
        }
        System.out.println(H + " " + M);
    }
}
