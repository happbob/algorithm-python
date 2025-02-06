import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      StringBuilder sb = new StringBuilder();
      LinkedList<Integer> list = new LinkedList<Integer>();

      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      for(int i=0;i<N;i++){
        list.add(i+1);
      }

      
      sb.append('<');
      boolean isLast = false;
      while(!list.isEmpty()){
        if(list.size()==1){
          isLast = true;
        }else{
          for(int i=0;i<K-1;i++){
            list.add(list.poll());
          }
        }
        sb.append(list.poll());
        if(!isLast){
          sb.append(", ");
        }else{
          sb.append('>');
        }
      }
      System.out.println(sb);
    }
}