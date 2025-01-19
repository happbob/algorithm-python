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
  private static int[][] dp;
  private static final int MOD = 1000000000;

  public static int sumUpToIndex(int[] array, int index) {
    int sum = 0;
    for (int i = 0; i <= index; i++) {
        sum += array[i];
    }
    return sum;
}
  
  public static void input() throws IOException{
    StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    dp = new int[k+1][n+1];
    Arrays.fill(dp[1], 1);
    for (int i = 1; i <= k; i++) dp[i][0] = 1;

    for(int i=2;i<=k;i++){
      for(int u=1;u<=n;u++){
         dp[i][u] = dp[i-1][u] + dp[i][u-1];
          dp[i][u] %= MOD;
      }
    }

    // System.out.println("DP Table:");
    // for (int[] row : dp) {
    //     System.out.println(Arrays.toString(row));
    // }

  }

  private static void solve() throws IOException {
    System.out.println(dp[k][n]);
  } 

  public static void main(String args[]) throws IOException {
    input();
    solve();
  }
}