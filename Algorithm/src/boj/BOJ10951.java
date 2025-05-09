package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10951 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // System.in - 표준 입력(키보드 입력) 의미
        // InputStreamReader(System.in) - 바이트 입력을 문자 입력으로 변환
        // BufferedReader(...) - 입력을 버퍼에 저장해서, 한 줄 씩 효율적으로 읽을 수 있게 해준다.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // System.out - 표준 출력(콘솔 출력) 의미
        // OutputStreamWriter(System.out) - 문자 데이터를 바이트로 변환해서 출력
        // BufferedWriter(...) - 출력 내용을 버퍼에 모았다가 한 번에 출력
       String str;
        // 문자열에 저장할 변수 'str' 선언
        while((str = br.readLine()) != null) {
/*	•	`br.readLine()` : 입력에서 한 줄을 읽어옵니다.
            (엔터를 칠 때까지 입력한 문자열 전체를 읽어옴)
	•	`str = br.readLine()` : 읽어온 한 줄을 `str` 변수에 저장합니다.
	•	`!= null` : 입력이 끝나지 않았다면(즉, EOF가 아니라면) 반복문을 계속 실행합니다.
	    -> MAC에서 EOF는 Command + D
	•	전체적으로: 입력에서 한 줄을 읽어와 `str`에 저장하고, 입력이 끝날 때까지(EOF) 반복문을 실행한다는 뜻입니다.

	•	BufferedReader : 입력을 빠르게 한 줄씩 읽기 위해 사용
	•	BufferedWriter : 출력을 빠르게 모아서 한 번에 내보내기 위해 사용
	•	while((str = br.readLine()) != null) : 입력이 끝날 때까지 한 줄씩 읽어서 반복*/
           StringTokenizer st = new StringTokenizer(str);
         int A = Integer.parseInt(st.nextToken());
         int B = Integer.parseInt(st.nextToken());
         bw.write((A+B)+"\n");
       }
       br.close();
       bw.close();
    }
}
