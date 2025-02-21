import java.util.*;
class Solution {
    
    static Character[][] board;
    static int N,M;
    static int[][] vector={{1,0},{-1,0},{0,1},{0,-1}};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        N = storage.length;
        M = storage[0].length();
        board = new Character[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                board[i][j] = storage[i].charAt(j);
            }
        }

        for(String request : requests){
            if(request.length()==2){
                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                        if(board[i][j]==request.charAt(0)){
                            board[i][j]='1';
                        }
                    }
                }
            }else{
                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                        if(i==0 || i==N-1 || j==0 || j==M-1){
                            if(board[i][j]==request.charAt(0)){
                                board[i][j]='1';
                            }
                        }
                        if(board[i][j]=='0') zeroToNum(j,i,request.charAt(0));
                    }
                }
            }
//            System.out.println("============");
//            for(int i=0;i<N;i++){
//                for(int j=0;j<M;j++){
//                    System.out.print(board[i][j]+" ");
//                }
//               System.out.println();
//            }
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(i==0 || i==N-1 || j==0 || j==M-1){
                        if(board[i][j]=='1' || board[i][j]=='0'){
                            makeEdge1to0(j,i);
                        }
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j]!='0' && board[i][j]!='1') answer++;
            }
        }
        return answer;
    }
    public static void makeEdge1to0(int x,int y){
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(new Node(x,y));
        board[y][x]='0';
        boolean[][] visit = new boolean[N][M];
        visit[y][x] = true;
        while(!deque.isEmpty()){
            Node node = deque.poll();
            for(int i=0;i<4;i++){
                int newx = node.x+vector[i][0];
                int newy = node.y+vector[i][1];
                if(newx<0 || newx>=M || newy<0 || newy>=N || visit[newy][newx]) continue;
                if( board[newy][newx]=='1' || board[newy][newx]=='0') {
                    board[newy][newx] = '0';
                    visit[newy][newx] = true;
                    deque.offer(new Node(newx,newy));
                };
            }
        }
    }

    // 가장자리 훑기
    public static void zeroToNum(int x,int y,char character){
        for(int i=0;i<4;i++){
            int newx=x+vector[i][0];
            int newy=y+vector[i][1];
            if(newx<0 || newx>=M || newy<0 || newy>=N || board[newy][newx]!=character) continue;
            board[newy][newx] = '1';
        }
    }


    static class Node{
        int x,y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}