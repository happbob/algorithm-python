import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static Integer[] arr;
	public static void main(String[] args) throws IOException, EmptyStackException {
    Integer N = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<Integer>();
    
    Integer start = 0;
    
    while(N --> 0){
      int value = Integer.parseInt(br.readLine());
      if(value > start) {
        for(int i = start+1;i<=value;i++){
          stack.push(i);
          sb.append('+').append('\n');
        }
        start = value;
      }else if(stack.peek() != value) {
        System.out.println("NO");
        return;
      }
      stack.pop();
      sb.append('-').append('\n');
    }
    System.out.println(sb);
	}
}