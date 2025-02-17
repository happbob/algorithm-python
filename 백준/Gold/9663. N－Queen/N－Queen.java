import java.util.*;
import java.io.*;

public class Main {
  static int N;
	static boolean[][] board;
	static int count=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<N+1; i++) {
			board = new boolean[N+1][N+1];
			board[1][i] = true;
			queeeeeeeeeeeeen(2);
		}
		System.out.println(count);
	}
	
	
	static void queeeeeeeeeeeeen(int depth) {
		if(depth == N+1) {
			count++;
			return;
		}
		
    // 가로로 ㄱㄱ
		for(int i=1; i<N+1; i++) {
			if(ohMyQueen(i, depth)) {
				board[depth][i] = true;
				queeeeeeeeeeeeen(depth+1);
        // 방문했던거 해제
				board[depth][i] = false;
			}
		}
		
	}
	
	static boolean ohMyQueen(int x, int depth) {
    // 세로 체크
		for(int i=1; i<depth; i++) {
			if(board[i][x]) return false;
		}
		
		int px = x-1;
		int py = depth-1;
    // 왼쪽 대각선 체크
		while(px > 0 && py > 0) {
			if(board[py--][px--])
				return false;
		}
	    
    // 오른쪽 대각선 체크
		px = x+1;
		py = depth-1;
		while(px < N+1 && py > 0) {
			if(board[py--][px++])
				return false;
		}

		return true;
	}

}