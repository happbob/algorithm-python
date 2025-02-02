import java.io.BufferedReader;  
import java.io.InputStreamReader;  
import java.util.StringTokenizer;  
  
public class Main {  
    static int N, K;  
    static int[] score;  
  
    public static void main(String[] args) throws Exception {  
        init();  
        System.out.println(binarySearch(0, 2000000));  
    }  
  
    static void init() throws Exception {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");  
        N = Integer.parseInt(st.nextToken());  
        K = Integer.parseInt(st.nextToken());  
  
        st = new StringTokenizer(br.readLine(), " ");  
        score = new int[N];  
        for (int n = 0; n < N; n++) {  
            score[n] = Integer.parseInt(st.nextToken());  
        }  
    }  
  
    static int binarySearch(int start, int end) {  
        while (start <= end) {  
            int mid = (start + end) / 2;  
            int sum = 0, groupCount = 0;  
            for (int n = 0; n < N; n++) {  
                sum += score[n];  
                if (mid <= sum) {  
                    sum = 0;  
                    groupCount++;  
                }  
            }  
  
            if (K <= groupCount) {  
                start = mid + 1;  
            } else {  
                end = mid - 1;  
            }  
        }  
        return end;  
    }  
  
}