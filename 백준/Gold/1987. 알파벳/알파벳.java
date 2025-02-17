import java.util.*;
import java.io.*;

public class Main {
  static int R, C;
  static char[][] board;
  static int ans = 0;
  static int[][] vector={{0,-1},{0,1},{1,0},{-1,0}};
  static HashSet<Character> hash;
  public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    hash = new HashSet<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    board = new char[R][C];
    
    for(int i=0;i<R;i++){
      String buff = br.readLine();
      for(int j=0;j<C;j++){
        board[i][j] = buff.charAt(j);
      }
    }

    letsgo(0,0,1);

    System.out.println(ans);
	}

  public static boolean letsgo(int x, int y, int count){
    ans = Math.max(ans, count);
    hash.add(board[x][y]);
    for(int i=0;i<4;i++){
      int newx = x+vector[i][0];
      int newy = y+vector[i][1];
      // System.out.println(hash);
      if(0<=newx && newx<R && 0<=newy && newy<C && !hash.contains(board[newx][newy])){
        // System.out.println(newx + ", " +newy + " => "+count);
        letsgo(newx,newy,count+1);
      }
    }
    hash.remove(board[x][y]);
    return false;
  }
}