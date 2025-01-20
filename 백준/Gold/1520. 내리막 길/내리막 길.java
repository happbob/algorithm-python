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
  private static int n,m;
  private static int[][] dp, arr;
  static int[] rangeX = { -1, 0, 1, 0 };
	static int[] rangeY = { 0, 1, 0, -1 };

  public static void input() throws IOException{
    StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    dp = new int[m+1][n+1];
    arr = new int[m+1][n+1];

    for(int i=1;i<=m;i++){
      StringTokenizer bf = new StringTokenizer(bufferedReader.readLine());
      for(int u=1;u<=n;u++){
        arr[i][u] = Integer.parseInt(bf.nextToken());
      }
    }

    for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = -1;
			}
		}
  }

  private static int recur(int y, int x) {
    if(dp[y][x] != -1){
      return dp[y][x];
    }
    
    if(y==m && x==n) {
      return 1;
    }

    dp[y][x] = 0;
    for (int i = 0; i < 4; i++) {
			int dx = x + rangeX[i];
			int dy = y + rangeY[i];

			if (dx < 1 || dy < 1 || dx > n || dy > m) {
				continue;
			}
			
			// arr[x][y]보다 arr[dx][dy]가 높이가 더 낮다면
			// arr[dx][dy]에서 끝점까지 도달하는 경로의 개수를 더한다.
			if (arr[y][x] > arr[dy][dx]) {
				dp[y][x] += recur(dy, dx);
			}
		}

		return dp[y][x];
  }

  private static void solve() throws IOException {
    System.out.println(recur(1,1));
  } 

  public static void main(String args[]) throws IOException {
    input();
    solve();
  }
}