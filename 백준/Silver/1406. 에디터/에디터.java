import java.io.*;
import java.util.*;

public class Main {
  static HashSet<String> hashSet = new HashSet<>();
  static int ans = 0;
  static Deque<Character> leftWord = new LinkedList<Character>();
  static Deque<Character> rightWord = new LinkedList<Character>();
  public static void main(String args[]) throws IOException { 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String initWord = br.readLine();
    
    int N = Integer.parseInt(br.readLine());
    for(int i=0;i<initWord.length();i++){
      leftWord.offerLast(initWord.charAt(i));
    }
    while(N-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      // System.out.println();
      // System.out.println("----------------");
      // System.out.println(N);
      // System.out.println(Arrays.toString(leftWord.toArray()));
      // System.out.println(Arrays.toString(rightWord.toArray()));
      if(command.equals("P")) {
        String buffer = st.nextToken();
        leftWord.offerLast(buffer.charAt(0));
      }else if(command.equals("L")){
        Character buff = leftWord.pollLast();
        if(buff != null){
          rightWord.offerFirst(buff);
        }
      }else if(command.equals("D")){
        Character buff = rightWord.pollFirst();
        if(buff != null){
          leftWord.offerLast(buff);
        }
      }else if(command.equals("B")){
        leftWord.pollLast();
      }
    }
    StringBuilder sb = new StringBuilder();
    while(leftWord.size()>0) {
      sb.append(leftWord.pollFirst());
    }
    while(rightWord.size()>0){
      sb.append(rightWord.pollFirst());
    }
    System.out.println(sb);
  }
}