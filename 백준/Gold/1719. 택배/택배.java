import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Integer[][] board;
    static Integer[][] cost;
    static Integer[][] first;
    static PriorityQueue<Vertex> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new Integer[N+1][N+1];
        cost = new Integer[N+1][N+1];
        first = new Integer[N+1][N+1];
        
        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            board[a][b] = c;
            board[b][a] = c;
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j) cost[i][j] = 0;
                else cost[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=1;i<=N;i++){
            go(i);
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

    static public void go(int start){
        Integer[] firstToGo = new Integer[N+1];
        for(int i=1;i<=N;i++){
            if(i==start) firstToGo[i] = 0;
            else firstToGo[i] = i;
        }

        queue = new PriorityQueue<Vertex>((v1,v2)->v1.c - v2.c);
        queue.offer(new Vertex(start,0));
        while(!queue.isEmpty()){
            Vertex current = queue.poll();
            for(int i=1;i<=N;i++){
                if(i==current.v) continue;
                if(board[current.v][i]!=null){
                    if(cost[start][i] > cost[start][current.v] + board[current.v][i]){
                        cost[start][i] = cost[start][current.v] + board[current.v][i];
                        queue.offer(new Vertex(i, board[current.v][i]));
                        if(start==current.v) continue;
                        firstToGo[i] = firstToGo[current.v];
                    }
                }
            }
        }
        first[start] = firstToGo;
    }

    static class Vertex {
        int v;
        int c;
        Vertex(int v, int c){
            this.v = v;
            this.c = c;
        }
    }
}