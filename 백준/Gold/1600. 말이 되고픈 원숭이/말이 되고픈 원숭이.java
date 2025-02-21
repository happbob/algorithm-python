import java.io.*;
import java.util.*;

public class Main {
    static int K, W, H;
    static int[][] board;
    static int[][] horseMove = {{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};
    static int[][] monkeyMove = {{0, 1},{0,-1},{1,0},{-1,0}};
    static boolean[][][] visited;
    static class Monkey{
        int x,y, count,horseMoveCount;
        public Monkey(int x, int y,int count, int horseMoveCount){
            this.x = x;
            this.y = y;
            this.horseMoveCount = horseMoveCount;
            this.count = count;
        }
        public void moveLikeHorse(int i){
            x += horseMove[i][0];
            y += horseMove[i][1];
        }
        public void moveLikeMonkey(int i){
            x += monkeyMove[i][0];
            y += monkeyMove[i][1];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new int[H][W];
        visited = new boolean[H][W][K+1];
        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = movesLikeJagger(0,0);
        System.out.println(result);
    }

    public static int movesLikeJagger(int x, int y){
        Deque<Monkey> monkeys = new ArrayDeque<>();
        monkeys.offer(new Monkey(x,y,0,K));
        visited[y][x][K] = true;
        while(!monkeys.isEmpty()){
            Monkey monkey = monkeys.poll();
            if(monkey.x == W-1 && monkey.y == H-1) return monkey.count;

            for(int i=0;i<4;i++){
                int newx= monkey.x+monkeyMove[i][0];
                int newy= monkey.y+monkeyMove[i][1];
                if(isValid(newx,newy,monkey.horseMoveCount)){
                    visited[newy][newx][monkey.horseMoveCount] = true;
                    monkeys.offer(new Monkey(newx,newy,monkey.count + 1,monkey.horseMoveCount));
                }
            }
            if(monkey.horseMoveCount>0){
                for(int i=0;i<8;i++){
                    int newx= monkey.x+horseMove[i][0];
                    int newy= monkey.y+horseMove[i][1];
                    if(isValid(newx,newy,monkey.horseMoveCount-1)){
                        visited[newy][newx][monkey.horseMoveCount - 1] = true;
                        monkeys.offer(new Monkey(newx,newy,monkey.count + 1,monkey.horseMoveCount-1));
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int x, int y, int k) {
        return x >= 0 && x < W && y >= 0 && y < H && board[y][x] == 0 && !visited[y][x][k];
    }
}
