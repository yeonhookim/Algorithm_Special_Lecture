public class NQueens {
    private static final int N = 4; // 체스판 크기

    // 체스판 출력 함수
    public static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // (row, col)에 퀸을 놓을 수 있는지 체크
    public static boolean isSafe(int[][] board, int row, int col) {
        // 같은 열에 퀸이 있는지 확인
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        // 왼쪽 위 대각선
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // 오른쪽 위 대각선
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    // 백트래킹을 이용한 N-Queen 풀이
    public static boolean solveNQueens(int[][] board, int row) {
        if (row == N) { // 모든 행에 퀸을 놓았으면 성공
            printSolution(board);
            return true;
        }
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1; // 퀸 놓기
                if (solveNQueens(board, row + 1)) {
                    return true;
                }
                board[row][col] = 0; // 백트래킹(퀸 제거)
            }
        }
        return false; // 놓을 수 없는 경우
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        if (!solveNQueens(board, 0)) {
            System.out.println("Solution does not exist");
        }
    }
}
