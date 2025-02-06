import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();
      while(T-- > 0) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer[]> queue = new LinkedList<Integer[]>();
        st = new StringTokenizer(br.readLine());
        Integer ans=0;
        for(int i=0;i<N;i++){
          queue.add(new Integer[]{i,Integer.parseInt(st.nextToken())});
        }
        while(!queue.isEmpty()){
          Integer[] subQ = queue.poll();
          boolean isMax = true;
          for(int i=0;i<queue.size();i++){
            if(subQ[1] < queue.get(i)[1]) {
              queue.add(subQ);
              for(int j=0;j<i;j++){
                queue.add(queue.poll());
              }
              isMax = false;
              break;
            }
          }
          if(isMax==false){
            continue;
          }
          ans++;

          if(subQ[0] == M) {
            break;
          }
        }
        sb.append(ans).append("\n");
      }
      System.out.println(sb);
    }
}