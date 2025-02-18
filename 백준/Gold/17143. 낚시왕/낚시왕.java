import java.util.*;
import java.io.*;

public class Main {
  static int R, C, M;
  static int totalSize = 0;
  static Deque<Shark> deque;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    deque = new ArrayDeque<Shark>();

    for(int i=0;i<M;i++){
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int z = Integer.parseInt(st.nextToken());
      int[] direction = checkDirection(d);
      deque.offer(new Shark(r,c,s,direction[0],direction[1],z));
    }

    for (int i = 1; i <= C; i++) {
      catchShark(i);  // 상어 낚아버려
      moveAndEatSharks(); // 다 먹어치워라
    }

    System.out.println(totalSize);
  }

  public static int[] checkDirection(int number){
    int[] direction = new int[2];
    direction[0]=0;
    direction[1]=0;
    if(number == 1){
      direction[1] -= 1;
    }else if(number == 2){
      direction[1] += 1;
    }else if(number == 3){
      direction[0] += 1;
    }else if(number == 4){
      direction[0] -= 1;
    }
    return direction;
  }

  public static void catchShark(int x) {
    Shark caughtShark = null;
    for (Shark shark : deque) {
      if (shark.c == x) { // 현재 열에 있는 상어 중
        if (caughtShark == null || shark.r < caughtShark.r) {
          caughtShark = shark; // 가장 위에 있는 상어 선택
        }
      }
    }
    if (caughtShark != null) {
      totalSize += caughtShark.z; // 상어 크기 합산
      deque.remove(caughtShark);
      // System.out.println("catch : " + caughtShark.z);
    }
  }

  public static class Shark{
    int r,c,s,x,y,z;

    public Shark(int r,int c, int s, int x, int y, int z){
      this.r = r;
      this.c = c;
      this.x = x;
      this.y = y;
      this.z = z;
      // 주기 체크
      int cycle = x==0 ? 2*(R-1) : 2*(C-1);

      // 받은 입력을 주기로 나눈 나머지가 그거임
      this.s = s % cycle;
    }

    public void move(){
      if (this.x != 0) {  // 가로 이동 (좌우 이동)
        int buff = this.c + x * s;

        // 경계를 벗어난 경우
        while (buff < 1 || buff > C) {
          if (buff < 1) {
            buff = 1 + (1 - buff);  // 반대 방향으로
            x *= -1;  // 방향 반전
          } else if (buff > C) {
            buff = C - (buff - C);  // 반대 방향으로
            x *= -1;  // 방향 반전
          }
        }
        this.c = buff;  // 최종 위치 설정
      } else {  // 세로 이동 (상하 이동)
        int buff = this.r + y * s;

        // 경계를 벗어난 경우
        while (buff < 1 || buff > R) {
          if (buff < 1) {
            buff = 1 + (1 - buff);  // 반대 방향으로
            y *= -1;  // 방향 반전
          } else if (buff > R) {
            buff = R - (buff - R);  // 반대 방향으로
            y *= -1;  // 방향 반전
          }
        }
        this.r = buff;  // 최종 위치 설정
      }
    }
  }
  

  public static void moveAndEatSharks() {
    Map<String, Shark> newMap = new HashMap<>();

    while (!deque.isEmpty()) {
      Shark shark = deque.poll();
      shark.move();
      String key = shark.c + "," + shark.r; // 위치 좌표를 키로 설정

      if (newMap.containsKey(key)) { 
        Shark existingShark = newMap.get(key);
        if (existingShark.z < shark.z) { // 현재 상어가 더 크다면
          newMap.put(key, shark);
        }
      } else {
        newMap.put(key, shark);
      }
    }

    deque.addAll(newMap.values()); // 생존한 상어들 다시 덱에 추가
    // System.out.println("---------------");
    for(int i=0;i<deque.size();i++){
      // System.out.println(deque.peek().c +","+deque.peek().r + ","+deque.peek().s +" => " + deque.peek().z);
      deque.offer(deque.poll());
    }
  }
}