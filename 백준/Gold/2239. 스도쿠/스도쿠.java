import java.util.*;
import java.io.*;

public class Main {
  static int N;
	static int[][] board = new int[9][9];
  static boolean[][] rowArr = new boolean[9][10];
  static boolean[][] colArr = new boolean[9][10];
  static boolean[][][] square = new boolean[3][3][10];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
      String line = br.readLine();
      for (int j = 0; j < 9; j++) {
        board[i][j] = line.charAt(j) - '0'; 
        if (board[i][j] != 0) { 
          // 이미 숫자가 있으면 체크
          rowArr[i][board[i][j]] = true;
          colArr[j][board[i][j]] = true;
          square[i / 3][j / 3][board[i][j]] = true;
        }
      }
    }

    solve(0,0);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        sb.append(board[i][j]);
      }
      sb.append("\n");
    }
    System.out.print(sb);
	}
	
	// 스도쿠 백트래킹 함수
  static boolean solve(int row, int col) {
    if (row == 9) {
      return true;
    }

    // 다음 위치 설정 크랙 플레이
    int nextRow = (col == 8) ? row + 1 : row;
    int nextCol = (col + 1) % 9;

    // 이미 숫자가 있는 경우
    if (board[row][col] != 0) {
      return solve(nextRow, nextCol);
    }

    // 1~9 숫자를 넣어보며 탐색
    for (int i = 1; i <= 9; i++) {
      if (!rowArr[row][i] && !colArr[col][i] && !square[row / 3][col / 3][i]) {
        // 숫자 배치
        board[row][col] = i;
        rowArr[row][i] = true;
        colArr[col][i] = true;
        square[row / 3][col / 3][i] = true;

        // 다음 칸 탐색
        if (solve(nextRow, nextCol)) return true;

        // 백트래킹 (원래 상태로 되돌리기)
        board[row][col] = 0;
        rowArr[row][i] = false;
        colArr[col][i] = false;
        square[row / 3][col / 3][i] = false;
      }
    }

    return false;
  }
}