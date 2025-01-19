import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
  private static Integer[] arr;
  private static int n;
  private static Integer[] dp;
  private static int ans = 0;
  
  public static void input() throws IOException{
    n = Integer.parseInt(bufferedReader.readLine());
    dp = new Integer[n+1];
    arr = new Integer[n+1];
    dp[0] = 0;
    StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
    for(int i=1; i<=n; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    for(int i=1; i<=n ;i++) {
      dp[i] = 0;
      for(int j=1; j<=i;j++){
        dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);
      }
    }
  }

  private static void solve() throws IOException {
    System.out.println(dp[n]);
  } 

  public static void main(String args[]) throws IOException {
    input();
    solve();
  }
}