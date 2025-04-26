import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static Integer[][] board;
    static int[][] cost;
    static int[][] first;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new Integer[N+1][N+1];
        cost = new int[N+1][N+1];
        first = new int[N+1][N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[x][y] = c;
            board[y][x] = c;
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j) cost[i][j] = 0;
                else cost[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=1;i<=N;i++){
            cal(i);
        }

        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j) sb.append('-');
                else sb.append(first[i][j]);

                if(j==N) sb.append('\n');
                else sb.append(' ');
            }
        }

        System.out.println(sb);
    }

    static void cal(int start){
        // 처음 시작하는 부분부터 연산 시작

        // 우선순위 큐 생성
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();

        // 처음 들르는 곳 초기화
        int[] firstArray = new int[N+1];
        for(int i=1;i<=N;i++){
            if(i==start) firstArray[i] = 0;
            else firstArray[i]=i;
        }
        queue.offer(new Vertex(start, 0));
        while(!queue.isEmpty()){
            Vertex currentV = queue.poll();
            for(int i=1;i<=N;i++){
                if(i == start) continue;
                if(board[currentV.v][i] != null){
                    if(cost[start][i] > cost[start][currentV.v] + board[currentV.v][i]){
                        cost[start][i] = cost[start][currentV.v] + board[currentV.v][i];
                        queue.offer(new Vertex(i, board[currentV.v][i]));
                        if(start==currentV.v) continue;
                        firstArray[i] = firstArray[currentV.v];
                    }
                }
            }
        }

        first[start] = firstArray;
    }

    static class Vertex implements Comparable<Vertex>{
        int v,c;
        public Vertex(int v,int c){
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Vertex vertex){
            return this.c - vertex.c;
        }
    }
}

