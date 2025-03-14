import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static Integer[][] board;
    static Integer[][] cost;
    static Integer[][] first;
    static PriorityQueue<Vertex> queue;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new Integer[N+1][N+1];
        first = new Integer[N+1][N+1];
        cost = new Integer[N+1][N+1];
        queue = new PriorityQueue<Vertex>();
        for(int i=0;i<M;i++){
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
            // 시작하는 집하장을 변경해주면서 각 집하장 간의 최소 비용 및 제일 먼저 거쳐야 하는 집하장 업데이트
            go(i);
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

    static void go(int start){
        Integer[] firstToGo = new Integer[N+1];
        for(int i=1;i<=N;i++){
            if(i==start) firstToGo[i] = 0;
            else firstToGo[i]=i;
        }
        queue.offer(new Vertex(start,0));
        while(!queue.isEmpty()){
            Vertex vertex = queue.poll();
            for(int i=1;i<=N;i++){
                if(board[vertex.v][i]==null) continue;
                if(i==vertex.v) continue;

                if(cost[start][i] > cost[start][vertex.v] + board[vertex.v][i]){
                    cost[start][i] = cost[start][vertex.v] + board[vertex.v][i];
                    queue.offer(new Vertex(i,board[vertex.v][i]));
                    if(vertex.v==start) continue;
                    firstToGo[i] = firstToGo[vertex.v];
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