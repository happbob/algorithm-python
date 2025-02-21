
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] board;
    static int[][] vector ={{0,-1},{1,0},{0,1},{-1,0}};
    static int ans =0;
    static Deque<Virus> virusDeque;
    static int wall=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        virusDeque = new ArrayDeque<>();
        ans = N*M;
        board = new int[N][M];
        for(int i=0;i<N;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st1.nextToken());
                if(board[i][j]==2) virusDeque.offer(new Virus(j,i));
                if(board[i][j]==1) wall++;
            }
        }
        wall+=3;
        backtranking(0,0,0);
        System.out.println(N*M - (ans + wall + virusDeque.size()));

    }

    public static void backtranking(int x, int y, int count){
        if(count == 3){
            affect();
            return;
        }
        for(int i=y;i<N;i++){
            for(int j = (i == y ? x : 0);j<M;j++){
                if( board[i][j]==0){
                    board[i][j] = 1;
                    count++;
                    backtranking(j+1,i,count);
                    board[i][j] = 0;
                    count --;
                }
            }
        }
    }

    public static class Virus{
        int x,y;
        public Virus(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void affect(){
        boolean[][] visited = new boolean[N][M];
        int[][] virusVisted = new int[N][M];

        int virusNum = 0;
        Deque<Virus> queue = new ArrayDeque<>(virusDeque);

        while (!queue.isEmpty()) {
            Virus virus = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newx = virus.x + vector[i][0];
                int newy = virus.y + vector[i][1];

                if (newx >= 0 && newx < M && newy >= 0 && newy < N &&
                    board[newy][newx] == 0 && !visited[newy][newx] && virusVisted[newy][newx]!=2) {
                    visited[newy][newx] = true;
                    virusVisted[newy][newx] = 2;
                    virusNum++;
                    queue.offer(new Virus(newx, newy));
                }
            }
        }
        ans = Math.min(ans, virusNum);
    }
}


