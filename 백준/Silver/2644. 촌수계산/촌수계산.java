  import java.io.*;
  import java.util.*;

  public class Main {
    static Boolean[] visited;

    static List<Integer>[] relation;
    static Integer answer = 0;

	  static int res = -1;
    static int X, Y;
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      X = Integer.parseInt(st.nextToken());
      Y = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(br.readLine());
      visited = new Boolean[N+1];
      relation = new ArrayList[N+1];

      for(int i=1; i<N+1; i++) {
        relation[i] = new ArrayList<>();
      }
      
      for(int i=1;i<=N;i++){
        visited[i] = false;
      }

      while(M-- > 0){
        st = new StringTokenizer(br.readLine());
        int person1 = Integer.parseInt(st.nextToken());
        int person2 = Integer.parseInt(st.nextToken());
        relation[person1].add(person2);
        relation[person2].add(person1);
      }
      dfs(X,Y, 0);

      System.out.println(res);
    }

    public static void dfs(int start, int end, int cnt) {
      if(start == end) {
        res = cnt;
        return; 
      }
      
      visited[start] = true;
      for(int i=0; i<relation[start].size(); i++) { 
        int next = relation[start].get(i);
        if(!visited[next]) {
          dfs(next, end, cnt+1);
        }
      }
    }
  }