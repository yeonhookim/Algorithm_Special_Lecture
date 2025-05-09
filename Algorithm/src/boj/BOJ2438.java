package boj;

import java.io.*;

public class BOJ2438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            bw.write("*".repeat(i) + "\n");
            // .repeat(i)는 자바 11부터 추가된 String 클래스의 메서드로,
            // 문자열을 지정한 횟수만큼 반복해서 이어붙인 새로운 문자열을 반환한다.
            // "*".repeat(5) -> "*****"
        }
        bw.close();
    }
}
