import java.util.*;
import java.io.*;

public class Main {
  static int M,N;
  static List<Node> chickens, houses;
  static int[][] board;
  static boolean[] opened;
  static int ans;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    chickens = new ArrayList<>();
    houses = new ArrayList<>();
    board = new int[N][N];
    
    for(int i=0;i<N;i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0;j<N;j++){
        board[i][j] = Integer.parseInt(st.nextToken());
        if(board[i][j]==2) chickens.add(new Node(j,i));
        if(board[i][j]==1) houses.add(new Node(j,i));
      }
    }

    ans = Integer.MAX_VALUE;
    opened = new boolean[chickens.size()];
    DFS(0,0);
    System.out.println(ans);

  }

  public static void DFS(int start, int cnt){
    if(cnt==M){
      int result = 0;
      for(int i=0;i<houses.size();i++){
        int buff = Integer.MAX_VALUE;
        for(int j=0;j<chickens.size();j++){
          if(opened[j]){
            buff = Math.min(buff, Math.abs(houses.get(i).x - chickens.get(j).x) + Math.abs(houses.get(i).y - chickens.get(j).y));
          }
        }
        result += buff;
      }

      ans = Math.min(ans,result);
      return;
    }

    // 백트래킹
    for (int i = start; i < chickens.size(); i++) {
      opened[i] = true;
      DFS(i + 1, cnt + 1);
      opened[i] = false;
  }


  }

  static class Node {
    int x,y;
    public Node(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
  
}