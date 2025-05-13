package practice;

import java.io.*;

public class BufferedReader_v1 {

    public static void main(String[] args) throws IOException {
        // BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 입력받기
        String[] line = br.readLine().split("");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        // 나머지 데이터 입력받기
        int[][] data = new int[n][m];
        for (int i = 0; i < n; i++) {
            line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                data[i][j] = Integer.parseInt(line[j]);
            }
        }
        System.out.println("hello JAVA");
        // 출력량이 적은 경우라면 System.out.println()메소드를 이용해서 간편하게 출력 가능
        //23
        //123
        //456
        // 하지만 편리한 대신 성능이 떨어짐, 출력량이 많을 때는 BufferedWriter를 사용함
        // 밑의 코드는 10만 줄의 결과를 출력하는 코드
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 100000; i++) {
           // writer.write(result[i]); // result는 결과가 담긴 배열
            writer.newLine(); // 줄 바꿈
        }
        writer.flush(); // *중요*

        //출력 마지막에 flush() 메소드를 호출하지 않으면 종종 아무것도 출력되지 않는 것을 확인할 수 있다.
        // 그 이유는 BufferedWriter가 writer() 메소드 호출 시에 출력 스트림에 바로 쓰는 것이 아니라 우선 내부 버퍼에 쓰기 때문
        // BufferedWriter는 효율성을 위해 우선 내부 버퍼에 출력을 해 두었다가 버퍼가 가득 차면 그 때 출력 스트림에 버퍼의 내용을 출력한다.
        // flush() 메소드는 버퍼에 있는 내용을 즉시 출력 스트림에 출력하는 메소드로, 반드시 출력의 마지막에 호출되어야 한다.

    }

}
