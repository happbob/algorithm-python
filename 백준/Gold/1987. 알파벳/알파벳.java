import java.util.*;
import java.io.*;

public class Main {
  static int R, C;
  static char[][] board;
  static int ans = 0;
  static int[][] vector = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}; // 탐색 순서 최적화 (위, 왼, 오, 아래) (3차 추가)
  static HashSet<Character> hash;
  static boolean[] visited = new boolean[26]; // 알파벳 방문 체크용 배열 (2차추가)
  public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    hash = new HashSet<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    board = new char[R][C];
    
    for(int i=0;i<R;i++){
      board[i] = br.readLine().toCharArray(); // 빠른 입력 처리 (1차 추가)
    }

    letsgo(0,0,1);

    System.out.println(ans);
	}

  public static void letsgo(int x, int y, int count){
    if (count > ans) {
      ans = count;
      if (ans == 26) return; // 26이면 즉시 종료 (3차 추가)
    }

    visited[board[x][y] - 'A'] = true; // 현재 알파벳 방문 표시 (2차 추가)
    
    for(int i=0;i<4;i++){
      int newx = x+vector[i][0];
      int newy = y+vector[i][1];
      // System.out.println(hash);
      if(0<=newx && newx<R && 0<=newy && newy<C){
        int nextCharIdx = board[newx][newy] - 'A';
        if (!visited[nextCharIdx])  letsgo(newx,newy,count+1); // 방문한 적 없는 알파벳이면 탐색 (2차 추가)
        // System.out.println(newx + ", " +newy + " => "+count);
        
      }
    }
    visited[board[x][y] - 'A'] = false; // 2차 추가
  }
}