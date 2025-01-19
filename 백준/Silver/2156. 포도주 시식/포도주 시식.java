import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
  private static int[] arr;
  private static int n;
  private static Integer[] dp;
  
  public static void input() throws IOException{
    n = Integer.parseInt(bufferedReader.readLine());
    dp = new Integer[n+1];
    arr = new int[n+1];
    for(int i=1; i<=n; i++){
      arr[i] = Integer.parseInt(bufferedReader.readLine());
    }
    dp[0] = 0;
    for(int i=1; i<=n;i++){
      if(i ==1){
          dp[i]=arr[i];
      }else if(i==2){
          dp[i]=arr[i]+arr[i-1];
      }else{
          dp[i]= Math.max(dp[i-1],Math.max(dp[i-2]+arr[i],dp[i-3]+arr[i]+arr[i-1]));
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