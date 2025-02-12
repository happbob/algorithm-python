import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] board;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Integer[][] arr = new Integer[N][N];
        StringBuilder sb = new StringBuilder();

        board = new char[N][N];
        
        // 초기 빈칸 설정
        for (char[] row : board) Arrays.fill(row, ' '); 
        
        // 드가자
        gaza(0, 0, N);
        
        
        for (char[] row : board) {
          sb.append(row).append("\n");
      }
      System.out.print(sb); 
    }

    static void gaza(int x, int y, int size) {
      if (size == 1) {
          board[x][y] = '*';
          return;
      }

      int newSize = size / 3;
      for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
              
            // 가운데는 비우셈 ㅋㅋ
              if (i == 1 && j == 1) continue;
              
              gaza(x + i * newSize, y + j * newSize, newSize);
          }
      }
  }
}