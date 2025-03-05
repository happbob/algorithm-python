import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static PriorityQueue<Vertex> queue;
    static int[][] first;
    static int[][] cost;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N+1][N=1];
        first = new int[N+1][N+1];
        cost = new int[N+1][N+1];

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
            daik(i);
        }
    }

    static void daik(int start){
        int[] firstToGo = new int[N+1];
        queue.offer(new Vertex(start,0));

        while(!queue.isEmpty()){
            
        }

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