import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static List<Node> chickens;
    static List<Node> houses;
    static Boolean[] visit;
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chickens = new ArrayList<Node>();
        houses = new ArrayList<Node>();
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int buff = Integer.parseInt(st.nextToken());
                if(buff == 2) chickens.add(new Node(j,i));
                if(buff == 1) houses.add(new Node(j,i));
            }
        }
        visit=new Boolean[chickens.size()];
        Arrays.fill(visit,false);

        dfs(0,0);

        System.out.println(min);
    }

    static void dfs(int start, int count) {
        if(count==M){
            int sum=0;
            for(int i=0;i<houses.size();i++){
                int buff = Integer.MAX_VALUE;
                for(int j=0;j<chickens.size();j++){
                    if(visit[j]){
                        int dist = Math.abs(houses.get(i).x-chickens.get(j).x) + Math.abs(houses.get(i).y - chickens.get(j).y);
                        buff = Math.min(buff, dist);
                    }
                }
                sum+=buff;
            }
            min = Math.min(sum,min);
            return;
        }

        // 백트래킹
        for(int i = start;i<chickens.size();i++){
            visit[i] = true;
            dfs(i+1, count+1);
            visit[i] = false;
        }
    }

    static class Node{
        int x,y;
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}