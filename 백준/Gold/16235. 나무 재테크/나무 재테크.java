import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static int[][] board;
    static int[][] nutrient;
    static List<Tree> trees;
    static int[][] vector = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        board = new int[N+1][N+1];
        nutrient = new int[N+1][N+1];
        List<Tree> trees = new ArrayList<>();
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                nutrient[i][j] = Integer.parseInt(st.nextToken());
                board[i][j] = 5;
            }
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            Tree tree = new Tree(x,y,age);
            trees.add(tree);
            
        }
        Collections.sort(trees);
        
        while(K-->0){
            // System.out.println(K + "년 차례임");
            List<Tree> liveTrees = new ArrayList<>();
            List<Tree> deadTrees = new ArrayList<>();
            // 봄
            for(int i=0;i<trees.size();i++){
                
                Tree buff = trees.get(i); 

                // System.out.println(buff.toString());
                // System.out.println("헤헤 양분 먹어야징" + buff.x + ", " + buff.y + " : " + buff.age);
                if(buff.age <= board[buff.x][buff.y]){
                    // 땅에 양분이 더 높다면?
                    board[buff.x][buff.y] -= buff.age;
                    buff.age++;
                    liveTrees.add(buff);
                }else{
                    deadTrees.add(buff);
                }
            }

            // System.out.println(Arrays.toString(liveTrees.toArray()));
            // System.out.println(Arrays.toString(deadTrees.toArray()));
            // 여름
            for(int i=0;i<deadTrees.size();i++){
                Tree buff = deadTrees.get(i); 
                board[buff.x][buff.y] += (int) buff.age/2;
            }
            // System.out.println("가을이 오기전... 살아남은 녀석들 size : " + liveTrees.size());

            // 가을
            trees = new ArrayList<>();
            for(int i=0;i<liveTrees.size();i++){
                Tree buff = liveTrees.get(i); 
                if(buff.age % 5 == 0){
                    for(int j=0;j<8;j++){
                        int newX = buff.x + vector[j][0];
                        int newY = buff.y + vector[j][1];
                        if(newX > 0 && newX <= N && newY>0 && newY<=N){
                            trees.add(new Tree(newX,newY,1));
                        }
                    }
                }
            }

            // System.out.println("겨울이 왔어... size : " + trees.size());
            // 겨울
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    board[i][j] += nutrient[i][j];
                }
            }
            trees.addAll(liveTrees);
            Collections.sort(trees);
            if(trees.size()==0){
                System.out.println(0);
                return;
            }

            // System.out.println("1년이 갔어... size : " + trees.size());
            // System.out.println(Arrays.toString(trees.toArray()));
        }

        System.out.println(trees.size());
        
    }

    static class Tree implements Comparable<Tree>{
        int x,y,age;
        public Tree(int x, int y, int age){
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree t){
            return this.age - t.age;
        }

        @Override
        public String toString(){
            return x + ", " + y + " = " + age;
        }
    }

}

