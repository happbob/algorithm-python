import java.util.*;
import java.io.*;

public class Main {
  static int N, M;
  static int R,C,D;
  static int count =0;
  static int[][] room;
  static int[][] vector ={{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북, 동, 남, 서

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    room = new int[N][M];
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st1.nextToken());
    C = Integer.parseInt(st1.nextToken());
    D = Integer.parseInt(st1.nextToken());
    
    Robot robot = new Robot(R,C);

    for(int i=0;i<N;i++){
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      for(int j=0;j<M;j++){
        room[i][j] = Integer.parseInt(st2.nextToken());
      }
    }
    robot.c = C;
    robot.r = R;
    robot.start();
    System.out.println(count);
  }

  public static class Robot{
    int r,c;
    public Robot(int r, int c ){
      this.r = r;
      this.c = c;
    }

    public void start(){
      int direction = D;
      while(true){
        if(room[r][c]==0) {
          room[r][c] = 2;
          count++;
        }
        boolean flag = false;
        for(int i=0;i<4;i++){
          direction = (direction + 3) % 4; // 왼쪽으로 회전
          int newy = r + vector[direction][0];
          int newx = c + vector[direction][1];
          if(0<=newx && newx<M && 0<=newy && newy<N && room[newy][newx]==0){
            r = newy;
            c = newx;
            flag=true;
            break;
          }
        }
        // 만약 네 방향 모두 청소할 공간이 없으면 후진
        if (!flag) {
          int backY = r - vector[direction][0];
          int backX = c - vector[direction][1];

          // 후진 가능하면 후진, 벽이면 종료
          if (backY >= 0 && backY < N && backX >= 0 && backX < M && room[backY][backX] != 1) {
              r = backY;
              c = backX;
          } else {
              break;
          }
      }
      }
    }
  }
}