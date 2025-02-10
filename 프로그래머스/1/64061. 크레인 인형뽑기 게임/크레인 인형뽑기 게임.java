import java.util.*;
class Solution {
    public static int solution(int[][] array, int[] moves) {
          Deque<Integer> basket = new ArrayDeque<>();
          int answer = 0;
    
          Deque<Integer>[] deque_board = new ArrayDeque[array[0].length]; 
          for (int i = 0; i < array.length; i++) {
              deque_board[i] = new ArrayDeque<>();
          }
    
          for (int i = 0; i < array.length; i++) { // 수평으로 이동 해보자
              for (int j = 0; j < array[i].length; j++) {
                  if (array[i][j] != 0) {
                      deque_board[j].offerFirst(array[i][j]); 
                  }
              }
          }
          
          for(Deque<Integer> deque: deque_board){
            System.out.println(Arrays.toString(deque.toArray()));
          }
          // 크레인 동작
          for (int move : moves) {
            int col = move - 1;
            if (!deque_board[col].isEmpty()) {
                int buff = deque_board[col].pollLast(); 
                if (!basket.isEmpty() && basket.peekLast() == buff) {
                    answer += 2;  
                    basket.pollLast();
                } else {
                    basket.offer(buff); 
                }
            }
          }

      return answer;
  }
}