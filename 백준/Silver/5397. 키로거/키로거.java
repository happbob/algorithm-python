  import java.io.*;
  import java.util.*;

  public class Main {
    static HashSet<String> hashSet = new HashSet<>();
    static int ans = 0;
    static Deque<Character> leftWord = new LinkedList<Character>();
    static Deque<Character> rightWord = new LinkedList<Character>();
    public static void main(String args[]) throws IOException { 
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();
      while(T-- > 0){
        String initWord = br.readLine();
        for(int i=0;i<initWord.length();i++){
          if(initWord.charAt(i) == '<'){
            if(!leftWord.isEmpty()){
              rightWord.offerFirst(leftWord.pollLast());
            }
          }else if(initWord.charAt(i) =='>'){
            if(!rightWord.isEmpty()){
              leftWord.offerLast(rightWord.pollFirst());
            }
          }else if(initWord.charAt(i) == '-'){
            if(!leftWord.isEmpty()){
              leftWord.pollLast();
            }
          }else {
            leftWord.offerLast(initWord.charAt(i));
          }
          
        }
        while(!leftWord.isEmpty()){
          sb.append(leftWord.pollFirst());
        }
        while(!rightWord.isEmpty()){
          sb.append(rightWord.pollFirst());
        }
        if(T!=0) {
          sb.append('\n');
        }
      }
      System.out.println(sb);
    }
  }