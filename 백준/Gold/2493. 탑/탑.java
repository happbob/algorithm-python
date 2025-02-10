import java.io.*;
import java.util.*;

public class Main {
  static Deque<Top> basket;
  static Integer[] array;
  static Integer[] indexArray;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    indexArray = new Integer[N];
    array = new Integer[N];
    basket = new ArrayDeque<Top>();
    for(int i=1;i<=N;i++){
      int buff = Integer.parseInt(st.nextToken());
      if(basket.isEmpty()){
        basket.offer(new Top(i, buff));
        sb.append("0 ");
        continue;
      };
      while(true) {
        if(basket.isEmpty()){
          sb.append("0 ");
          basket.offer(new Top(i, buff));
          break;
        }
        Top top = basket.peekLast();
        if(top.value>buff){
          sb.append(top.index + " ");
          basket.offer(new Top(i, buff));
          break;
        }else {
          basket.pollLast();
        }
      }
    }

    System.out.println(sb);
  }
  
}
class Top {
  public Integer index;
  public Integer value;
  public Top(int index, int value){
    this.index = index;
    this.value = value;
  }
}