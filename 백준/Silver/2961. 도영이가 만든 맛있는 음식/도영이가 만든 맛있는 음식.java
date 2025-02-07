import java.io.*;
import java.util.*;

public class Main {
    static int N, answer = Integer.MAX_VALUE;
    static int[][] ingredient;
    static boolean[] selected;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ingredient = new int[N][2];
        selected = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }
        solve(0, 1, 0, 0);
        System.out.println(answer);
    }

    // 트리의 깊이, 신맛, 쓴맛, 선택한 음식 개수
    static void solve(int depth, int sour, int bitter, int selectedCount) {
        if (depth == N) {
            if (selectedCount != 0) { // 1개 이상의 재료를 선택
                if (Math.abs(sour - bitter) < answer) { // 최솟값으로 갱신
                    answer = Math.abs(sour - bitter);
                }
            }
            return;
        }

        // 완전탐색을 위해 선택한경우와 선택하지 않은 경우를 나누어 진행
        solve(depth + 1, sour * ingredient[depth][0], bitter + ingredient[depth][1], selectedCount + 1); // 선택
        solve(depth + 1, sour, bitter, selectedCount); // 비선택
    }
}