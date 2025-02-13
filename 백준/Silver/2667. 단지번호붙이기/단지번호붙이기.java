import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[][] board;
    static int[][] vector = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visited;
    static PriorityQueue<Integer> complex;
    static int num;

    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      visited = new boolean[N+1][N+1];
      board = new int[N+1][N+1];
      complex = new PriorityQueue<Integer>();
      for(int i=1;i<=N;i++){
        String buff = br.readLine();
        for(int j=1;j<=N;j++){
          board[i][j] = Character.getNumericValue(buff.charAt(j-1));
        }
      }
      for(int i=1;i<=N;i++){
        for(int j=1;j<=N;j++){
          if(board[i][j]==0 || visited[i][j]) continue;
          else{
            num = 0;
            dfsHouse(i,j);
            complex.offer(num);
          }
        }
      }
      System.out.println(complex.size());
      while(!complex.isEmpty()){
        System.out.println(complex.poll());
      }
    }

    public static void dfsHouse(int x,int y){
      visited[x][y] = true;
      num++;
      for(int u=0;u<4;u++){
        int newx = x + vector[u][0];
        int newy = y + vector[u][1];

        if(1<=newx && newx<=N && 1<=newy && newy<=N && !visited[newx][newy] && board[newx][newy]==1){
          dfsHouse(newx,newy);
        }
      }
    }
}