package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String numbers = br.readLine();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += numbers.charAt(i) - '0'; // 문자를 숫자로 변환
            // 각 문자의 아스키 값에서 '0'의 아스키 값을 빼면 실제 숫자가 된다.
        }
        System.out.println(sum);
    }
}
