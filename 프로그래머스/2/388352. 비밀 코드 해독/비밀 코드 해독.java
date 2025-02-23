import java.util.*;
class Solution {
    static int[] src;
    static int finalAnswer;
    public static int solution(int n, int[][] q, int[] ans) {
        src = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            src[i] = i+1;
        }
        comb(src,deque,0,5,q,ans);
        return finalAnswer;
    }
    
    static void comb(int[] arr, Deque<Integer> visited, int start, int r, int[][] question, int[] answer) {
        if(r == 0) {
            // 조합 이뤄짐
            if(checkPassword(visited,question,answer)) finalAnswer++;
            return;
        } else {
            for(int i = start; i < arr.length; i++) {
                visited.offer(arr[i]);
                comb(arr, visited, i + 1, r - 1,question,answer);
                visited.pollLast();
            }
        }
    }

    static boolean checkPassword(Deque<Integer> visited,int[][] question, int[]answer) {
        for(int i=0; i<question.length; i++) {
            int buffAnswer=0;
            for(int j=0; j<question[i].length; j++) {
                if(visited.contains(question[i][j])) {
                    buffAnswer++;
                }
            }
            if(buffAnswer != answer[i]) return false;
        }
        return true;
    }
}