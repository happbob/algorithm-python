import java.io.*;
import java.util.*;

public class Main {
  static long ans = 0;
  static int N, K;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    K = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    
    Integer[] array = new Integer[K];
    long maxLine = 0;
    for(int i=0;i<K;i++){
      array[i] = Integer.parseInt(br.readLine());
      // 최대 길이 연산
      maxLine = Math.max(maxLine, array[i]);
    }

    // 무조건 최대 길이보다 1은 더 큼 ㅋㅋ
    maxLine++; 
    // 크랙 플레이로 최소 길이 미리 구해 놓음
    long minLine = maxLine / N; 
		long midLine = 0; 

    // 이진탐색 진행
    while(minLine < maxLine) {
      midLine = (maxLine+minLine) / 2;
      long count =0;
      for(int i=0;i<array.length;i++){
        count+=(array[i]/midLine);
      }

      if(count<N) maxLine = midLine;
      else minLine = midLine + 1;
    }
    System.out.println(minLine-1);
  }
}