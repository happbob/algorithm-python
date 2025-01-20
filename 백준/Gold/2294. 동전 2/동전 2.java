import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
  private static int n,k;
  private static int[] dp, arr;

  public static void input() throws IOException{
    StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    arr = new int[n+1];
    for(int i=1;i<=n;i++){
      arr[i]= Integer.parseInt(bufferedReader.readLine());
    }
    dp = new int[k+1];
    Arrays.fill(dp,10001);
    dp[0] = 0;
    for(int i=1; i<=n ;i++){
      for(int u=arr[i]; u<=k; u++){
        dp[u] = Math.min(dp[u], dp[u - arr[i]] + 1);
      }
    }
  }

  private static void solve() throws IOException {
    if(dp[k] == 10001) {
      System.out.println(-1);
    }else {
      System.out.println(dp[k]);
    }
    
  } 

  public static void main(String args[]) throws IOException {
    input();
    solve();
  }
}