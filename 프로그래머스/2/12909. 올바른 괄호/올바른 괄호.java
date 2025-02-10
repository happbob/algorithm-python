import java.util.*;
class Solution {
    boolean solution(String s) {
        ArrayDeque<String> left = new ArrayDeque<>();
        boolean answer = true;
        for(int i=0;i<s.length();i++){
            if(!left.isEmpty() && left.peek().equals("(") && s.substring(i,i+1).equals(")")){
                left.pollLast();
            }
            else if(s.substring(i,i+1).equals("(")){
                left.push(s.substring(i,i+1));
            }else{
                answer = false;
                break;
            }
        }
        if(!left.isEmpty()) answer = false;
        
        return answer;
    }
}