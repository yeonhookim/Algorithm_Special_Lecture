package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15552 {

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위해 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 빠르게 하기 위해 BufferedWriter 생성
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 줄에서 테스트케이스의 개수 T를 입력받음 (문자열로 읽어서 정수로 변환)
        int T = Integer.parseInt(br.readLine());

        // 각 테스트케이스마다 반복
        for (int i = 0; i < T; i++){
            // 한 줄을 읽어서 공백 기준으로 두 수로 분리하기 위해 StringTokenizer사용
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 첫 번째 수를 정수로 변환하여 저장
            int A =  Integer.parseInt(st.nextToken());
            // 두 번째 수를 정수로 변환하여 저장
            int B =  Integer.parseInt(st.nextToken());
            // 두 수의 합을 문자열로 만들어 BufferedWriter에 저장(개행 포함)
            bw.write((A+B) + "\n");
        }
        // 반복문이 끝난 뒤, 버퍼에 남아있는 모든 데이터를 출력
        bw.flush();
        // BufferedWriter를 닫아 자원을 해제
        bw.close();
    }
}
