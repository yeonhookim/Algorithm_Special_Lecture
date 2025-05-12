package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2562 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MIN_VALUE;
        //최댓값

        int index = 0;

        for (int i = 0; i <9 ; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > max) {
                max = x;
                index = i;
            }

        }
        System.out.println(max);
        System.out.println(index+1); //index+1번째
    }
}
