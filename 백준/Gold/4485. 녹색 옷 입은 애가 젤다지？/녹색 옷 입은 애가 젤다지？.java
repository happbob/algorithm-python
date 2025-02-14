import java.util.*;
import java.io.*;

public class Main {

	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
			
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static int n;
	static int[][] board;
	static int[][] vector = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String buff;
		int idx=1;
		while(!(buff = br.readLine()).equals("0")) {
			n = Integer.parseInt(buff);
			board = new int[n][n];
			
			StringTokenizer st = null;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cost = bfs();
			sb.append("Problem " + idx + ": " + cost+"\n");
			idx++;
		}
		System.out.println(sb.toString());
	}
	
	static int bfs() {
		Queue<Node> q = new PriorityQueue<>();
		int[][] move = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(move[i], Integer.MAX_VALUE);
		}
		
		q.add(new Node(0, 0, board[0][0]));
		move[0][0] = board[0][0];
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int cost = node.cost;
			
			if(node.x == n-1 && node.y == n-1) {
				return cost;
			}
			
			for(int i=0; i<4; i++) {
				int nx = node.x + vector[i][0];
				int ny = node.y + vector[i][1];
				
				if(nx<0 || nx>n-1 || ny<0 || ny>n-1) continue;
				
				if(cost+board[ny][nx] < move[ny][nx]) {
					move[ny][nx] =cost+board[ny][nx];
					q.add(new Node(nx,ny,cost+board[ny][nx]));
				}
				
			}
		}
		return -1;
	}
}