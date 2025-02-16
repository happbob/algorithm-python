import java.util.*;
import java.io.*;

public class Main {
  static int W,H,count;
  static int[][] vector = {{1,0},{1,-1},{1,1},{0,1},{0,-1},{-1,0},{-1,1},{-1,-1}};
  static int[][] board;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String buffer;
    while(!(buffer=br.readLine()).equals("0 0")){
      StringTokenizer st = new StringTokenizer(buffer);
      W = Integer.parseInt(st.nextToken());
      H = Integer.parseInt(st.nextToken());
      board = new int[H][W];
      for(int i=0;i<H;i++){
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int j=0;j<W;j++){
          board [i][j] = Integer.parseInt(st1.nextToken());
        }
      }
      count = 0;
      for(int i=0;i<H;i++){
        for(int j=0;j<W;j++){
          if(board[i][j]==1){
            countIsland(i,j);
            count++;
          }
        }
      }
      bw.write(count + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
  public static void countIsland(int x, int y){
    if(board[x][y]==0) return;
    board[x][y]=0;
    for(int i=0;i<8;i++){
      int newx = x + vector[i][0];
      int newy = y + vector[i][1];
      if(0<=newx && newx<H && 0<=newy && newy<W && board[newx][newy]==1){
        countIsland(newx,newy);
      }
    }
  }
}