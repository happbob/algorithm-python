import java.io.*;
import java.util.*;

public class Main {
  static HashSet<String> hashSet = new HashSet<>();
  static int ans = 0;
  public static void main(String args[]) throws IOException { 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String statement = br.readLine();
    substr(statement);
    System.out.println(hashSet.size());

  }

  public static void substr(String word) {
    // substring의 길이 표현
    for(int i=0;i<word.length();i++){
      // substr 재귀 돌리기
      for(int u=i+1;u<=word.length();u++){
        hashSet.add(word.substring(i,u));
      }
    }
  }

}