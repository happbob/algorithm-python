import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static Deque<Integer> queue;
    static boolean[] isQueue;
    static StringBuilder sb;

    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      sb = new StringBuilder();
      N = Integer.parseInt(br.readLine());
      isQueue = new boolean[N+1];
      StringTokenizer st = new StringTokenizer(br.readLine());

      queue = new ArrayDeque<>();
      for(int i=1;i<=N;i++){
        if(st.nextToken().equals("1")) isQueue[i] = false;
        else isQueue[i] = true;
      }
      st = new StringTokenizer(br.readLine());
      for(int i=1;i<=N;i++){
        int buff = Integer.parseInt(st.nextToken());
        if(isQueue[i]) queue.offer(buff);
      }
      
      int M = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      while(M-->0){
        // System.out.println(Arrays.toString(queue.toArray()));
        queue.offerFirst(Integer.parseInt(st.nextToken()));
        sb.append(queue.pollLast()).append(" ");
      }
      System.out.println(sb);
    }
}