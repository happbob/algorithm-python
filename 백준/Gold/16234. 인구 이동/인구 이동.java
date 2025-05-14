import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer; 

public class Main {
    static int N,L,R;
    static int[][] board;
    static boolean[][] visited;
    static int[][] vector = {{0,1},{0,-1},{1,0},{-1,0}};
    static ArrayList<int[]> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int ii=0;ii<N;ii++){
                int buff = Integer.parseInt(st.nextToken());
                board[i][ii] = buff;
            }
        }

        int ans = 0;
        while(true){ 
            boolean isMove = false;
            visited = new boolean[N][N];
            for(int i=0;i<N;i++){
                for(int ii=0;ii<N;ii++){
                    if(!visited[i][ii]){
                        int sum = DFS(i,ii);
                        if(list.size()>1){
                            changePopulation(sum);
                            isMove = true;
                        }
                    }
                }
            }

            if(!isMove){
                break;
            }
            ans++;

        }
        System.out.println(ans);
    }


    public static void changePopulation(int sum) {
        int avg = sum / list.size();
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            board[x][y] = avg;
        }
    }


    static public int DFS(int x,int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        list = new ArrayList<>();
        list.add(new int[]{x, y});

        visited[x][y] = true;
        int sum = board[x][y];
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            for(int i=0;i<4;i++){
                int newx = tmp[0] + vector[i][0];
                int newy =  tmp[1] + vector[i][1];

                if(newx >=0 && newx<N &&newy >=0 && newy<N &&!visited[newx][newy] &&  Math.abs(board[ tmp[0]][ tmp[1]]-board[newx][newy])<=R&& Math.abs(board[ tmp[0]][ tmp[1]]-board[newx][newy])>=L){
                    visited[newx][newy] = true;
                    queue.offer(new int[]{newx, newy}); // 새로 큐에 담아줌
                    list.add(new int[]{newx, newy}); // 연결된 나라끼리는 따로 좌표를 담아줌
                    sum += board[newx][newy];
                }
            
                
            }
            
        }
        return sum;
    }
}
