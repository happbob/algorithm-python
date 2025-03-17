import java.io.*;
import java.util.*;

public class Main {
    static Integer N, K;
    static boolean[] visit;
    static int ans=0;
    static Character[][] board;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
		visit = new boolean[26];
        visit['a'-'a'] = true;
        visit['n'-'a'] = true;
        visit['t'-'a'] = true;
        visit['i'-'a'] = true;
        visit['c'-'a'] = true;
        board = new Character[N][7];
        	// K가 필수적으로 필요한 알파벳 수보다 적으면 바로 끝	
		if(K<5) {
			System.out.println(0);
			return;
		}
		// 모든 알파벳을 가르친 경우
		if(K==26) {
			System.out.println(N);
			return;
		}
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=4;j<str.length()-4;j++){
                board[i][j-4] = str.charAt(j);
            }
        }
		backTracking(0,K-5);

        System.out.println(ans);
    }

	static void backTracking(int al, int teach) {
		if(teach == 0) {
			int cnt = 0;
			for(int i=0; i<N; i++) {
				boolean flag = true;
				for(int j=4; j<11; j++) {
                    if(board[i][j-4]==null) continue;
                    // System.out.println(board[i][j-4]);
					if(!visit[board[i][j-4]-'a']) {
						flag = false;
						break;
					}
				}
				if(flag) cnt++;
			}
			ans = Math.max(ans, cnt);
			return;
		}
		
		for(int i=al; i<26; i++) {
			if(!visit[i]) {
				visit[i] = true;
				backTracking(i+1,teach-1);
				visit[i] = false;
			}
		}
	}
}