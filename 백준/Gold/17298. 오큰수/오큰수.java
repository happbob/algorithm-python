import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Integer n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n+1];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i = 1;i<=n;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Stack<Integer> stack = new Stack<Integer>();
    for(int i=1; i<=n;i++){
      while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
        arr[stack.pop()] = arr[i];
      }
      stack.push(i);
    }
    while(!stack.isEmpty()){
      arr[stack.pop()] = -1;
    }
		for(int i = 1; i <= n; i++) {
			sb.append(arr[i]).append(' ');
		}
		
		System.out.println(sb);
  }
}