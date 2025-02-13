import java.util.*;
import java.io.*;

class Tomato{
  int x;
  int y;
  int day;
  public Tomato(int x,int y, int day){
    this.x = x;
    this.y = y;
    this.day = day;
  }
}

public class Main {
    static int M,N;
    static int[][] board;
    static int[][] vector = {{1,0},{0,1},{-1,0},{0,-1}};
    static int day = 0;
    public static Deque<Tomato> inffectedTomatos = new ArrayDeque<Tomato>();

    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      board = new int[N+1][M+1];

      for(int i=1;i<=N;i++){
        st = new StringTokenizer(br.readLine());
        for(int u=1;u<=M;u++){
          board[i][u] = Integer.parseInt(st.nextToken());
          if(board[i][u]==1) inffectedTomatos.offer(new Tomato(i,u,0));
        }
      }
      
      while(!inffectedTomatos.isEmpty()){
        Tomato tomato = inffectedTomatos.poll();
        day = tomato.day;

        for(int i=0;i<4;i++){
          int newx = tomato.x + vector[i][0];
          int newy = tomato.y + vector[i][1];

          if(1<=newx && newx<= N && 1<=newy && newy<=M){
            if(board[newx][newy]==0){
              board[newx][newy] = 1;
              inffectedTomatos.offer(new Tomato(newx,newy, day+1));
            }
          }
        }
      }
      if(checkInffected()){
        System.out.println(day);
      }else{
        System.out.println(-1);
      }
    }

    public static boolean checkInffected(){
      for(int i=1;i<=N;i++){
        for(int u=1;u<=M;u++){
          if(board[i][u] == 0) return false;
        }
      }
      return true;
    }
}