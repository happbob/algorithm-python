import java.io.*;
import java.util.*;
 
public class Main {
  static int N, M;
  static boolean[] visited;
  static int[] result;
  
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      
      visited = new boolean[N + 1];
      result = new int[M];
      
      perm(0);
  }
  
  static void perm(int depth) {
      if (depth == M) {
          for (int num : result) {
              System.out.print(num + " ");
          }
          System.out.println();
          return;
      }
      for (int i = 1; i <= N; i++) {
          if (!visited[i]) {
              visited[i] = true;
              result[depth] = i;
              perm(depth + 1);
              visited[i] = false;
          }
      }
  }
}