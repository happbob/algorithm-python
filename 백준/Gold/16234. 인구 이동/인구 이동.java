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
    static BufferedReader br; 
    static int N,L,R;
    static int[][] board;
    static boolean[][] visited;
    static ArrayList<int[]> list;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1}; // 상하좌우순서
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int ii=0;ii<N;ii++){
                board[i][ii] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        while (true) {
            boolean isMove = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = dfs(i, j); // 방문하지 않은 곳 dfs 탐색
                        if (list.size() > 1) {
                            changePopulation(sum); // 국경이 열린 노드끼리 인구 이동
                            isMove = true;
                        }
                    }
                }
            }
            if (!isMove) {
                break;
            }
            result++;
        }

        System.out.println(result);
    }
    
    public static void changePopulation(int sum) {
        int avg = sum / list.size();
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            board[x][y] = avg;
        }
    }

    public static int dfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        list = new ArrayList<>();
        list.add(new int[]{x, y});

        visited[x][y] = true;
        int sum = board[x][y];

        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            for (int i = 0; i < 4; i++) { // 4방탐색
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) { // graph 범위 내
                    // 방문한적 없고, L과 R 사이일 때
                    if (!visited[nx][ny] && L <= Math.abs(board[tmp[0]][tmp[1]] - board[nx][ny]) && Math.abs(board[tmp[0]][tmp[1]] - board[nx][ny]) <= R) {
                        visited[nx][ny] = true; // 방문한곳으로 변경
                        queue.offer(new int[]{nx, ny}); // 새로 큐에 담아줌
                        list.add(new int[]{nx, ny}); // 연결된 나라끼리는 따로 좌표를 담아줌
                        sum += board[nx][ny];
                    }
                }
            }
        }
        return sum;
    }
}
