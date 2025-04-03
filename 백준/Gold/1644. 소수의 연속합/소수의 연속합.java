import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isPrime;
    static boolean[] visit;
    static List<Integer> primes;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        isPrime = new boolean[N+1];
        getPrimesByEratosthenes(N);
        for(int i=0;i<primes.size();i++){
            int buff=i;
            int sum=0;
            while(buff < primes.size()){
                sum+=primes.get(buff);
                if(sum==N) {
                    answer++;
                    break;
                }
                if(sum > N) {
                    break;
                }

                buff++;
                
            }
        }
        System.out.println(answer);
    }

    public static void getPrimesByEratosthenes(int N) {
        primes = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i=2; i<=(int)Math.sqrt(N); i++) {
            if(!isPrime[i]) continue;
            for(int j=2*i; j<=N; j+=i) {
                isPrime[j] = false;
            }
        }

        for (int i=2; i<isPrime.length; i++) {
            if(isPrime[i]) {
                primes.add(i);
            }
        }
    }
}