
package boj;

import java.io.*;

public class BOJ2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            bw.write(" ".repeat(N-i) + "*".repeat(i) + "\n");
           // " ".repeat(5-1)을하면 음수까지 포함이라 런타임 에러가 발생함
        }
        bw.close();
    }
}
