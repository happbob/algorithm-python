import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] primes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        primes = new int[5000001];
        getPrimes();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            int buff = Integer.parseInt(st.nextToken());
            while(true){
                if(buff==1) {
                    sb.append("\n");
                    break;
                }
                sb.append(primes[buff]).append(" ");
                buff = buff/primes[buff];
            }
        }
        System.out.println(sb);
    }

    // 소인수 분해를 하면서 각 숫자에 대한 최소 소수를 저장해보자
    public static void getPrimes(){
        for(int i=2;i<5000000;i++){
            if(primes[i]!=0) continue;
            primes[i] = i;
            for(int j=2*i;j<=5000000;j+=i){
                if(primes[j]==0){
                    primes[j] = i;
                }
            }
        }
    }
}

