import java.io.*;
import java.util.*;
 
public class Main {
  static int[][] dp = new int[30][30];
  static int[] src;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    long[] answer = new long[T];
    for (int t = 0; t < T; t++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        src = new int[M];
        for (int i = 0; i < M; i++) {
            src[i] = i+1;
        }
        
        answer[t] = comb(M, N);
    }
    for(int t = 0; t < T; t++) {
      sb.append(answer[t]).append('\n');
    }
    System.out.println(sb);
  }
  static long comb(int n, int r) {
    long result = 1;
    for(int i=0;i<r;i++){
      result *= n - i;
      result /= i + 1;
    }
    return result;
  }
}