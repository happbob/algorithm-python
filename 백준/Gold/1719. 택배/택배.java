import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Integer[][] board;
    static PriorityQueue<Vertex> queue;
    static Integer[][] first;
    static Integer[][] cost;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new Integer[N+1][N+1];
        first = new Integer[N+1][N+1];
        cost = new Integer[N+1][N+1];

        queue = new PriorityQueue<Vertex>();

        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[v1][v2] = c;
            board[v2][v1] = c;
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j) cost[i][j] = 0;
                else cost[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=1;i<=N;i++){
            daik(i);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j) sb.append("- ");
                else sb.append(first[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void daik(int start){
        Integer[] firstToGo = new Integer[N+1];
        for(int i=1;i<=N;i++){
            if(i==start) firstToGo[i] = 0;
            else firstToGo[i] = i;
        }
        queue.offer(new Vertex(start,0));

        while(!queue.isEmpty()){
            Vertex v = queue.poll();
            for(int i=1;i<=N;i++){
                if(board[v.v][i]!=null){
                    if(cost[start][i] > cost[start][v.v] + board[v.v][i]){
                        cost[start][i] = cost[start][v.v] + board[v.v][i];
                        
                        queue.offer(new Vertex(i,board[v.v][i]));

                        if(v.v==start) continue;
                        firstToGo[i] = firstToGo[v.v];
                    }
                }
            }
        }
        first[start] = firstToGo;
    }

    static class Vertex implements Comparable<Vertex>{
        int v, c;
        Vertex(int v, int c){
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.c - o.c;
        }
    }
}