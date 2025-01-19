import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
  private static int[][] arr;
  private static int n;
  private static long[][] dp;
  private static int ans = 0;
  
  public static void input() throws IOException{
    n = Integer.parseInt(bufferedReader.readLine());
    dp = new long[n+1][n+1];
    arr = new int[n+1][n+1];
    dp[1][1]=1;
    for(int i=1; i<=n; i++){
      StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
      for(int u=1; u<=n; u++){
        arr[i][u] = Integer.parseInt(st.nextToken());
      }
    }
    for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				int next = arr[i][j];
				if(next==0) break;
				if(j+next<=n) dp[i][j+next] += dp[i][j];
				if(i+next<=n) dp[i+next][j] += dp[i][j];
			}		
		}
    // recurse(1,1) # 시간 초과 뜸
  }

  // private static void recurse(int y,int x){
  //   if(y==n && x==n){
  //     ans += 1;
  //     return;
  //   }
  //   if(y>n || x>n){
  //     return;
  //   }

  //   recurse(y + arr[y][x],x);
  //   recurse(y, x + arr[y][x]);
  // }
  
  private static void solve() throws IOException {
    System.out.println(dp[n][n]);
  } 

  public static void main(String args[]) throws IOException {
    input();
    solve();
  }
}