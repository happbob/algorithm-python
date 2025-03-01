import java.util.*;
import java.io.*;


public class Main {
    static int M,N;
    static int[][] board;
    static int ans=Integer.MAX_VALUE;
    static List<Chicken> chickenDeque;
    static List<Node> houseDeque;
    static boolean[] opened;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        chickenDeque = new ArrayList();
        houseDeque = new ArrayList();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int u=0;u<N;u++){
                board[i][u] = Integer.parseInt(st.nextToken());
                if(board[i][u]==1){
                    houseDeque.add(new Node(i,u));
                }else if(board[i][u]==2){
                    chickenDeque.add(new Chicken(i,u,false));
                }
            }
        }

        opened = new boolean[chickenDeque.size()];
        dfs(0,0);
        System.out.println(ans);
    }

    public static void dfs(int start, int count){
        if(count == M){
            int result = 0;
            for (int i=0;i<houseDeque.size();i++){
                int temp = Integer.MAX_VALUE;
                for (int j=0;j<chickenDeque.size();j++){
                    if(opened[j]){
                        int distance = Math.abs(houseDeque.get(i).x - chickenDeque.get(j).x) + Math.abs(houseDeque.get(i).y - chickenDeque.get(j).y);
                        temp = Math.min(temp,distance);
                    }
                }
                result += temp;
            }
            ans = Math.min(ans, result);
            return;
        }

        for(int i=start;i<chickenDeque.size();i++){
            opened[i]=true;
            dfs(i+1,count+1);
            opened[i]=false;
        }
    }

    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Chicken extends Node{
        boolean opened;

        Chicken(int x, int y, boolean opened) {
            super(x, y);
            this.opened = opened;
        }
    }
}