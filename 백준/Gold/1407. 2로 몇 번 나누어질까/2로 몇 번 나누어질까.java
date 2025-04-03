import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        System.out.println(howManyTwo(b) - howManyTwo(a-1));
    }

    private static long howManyTwo(long n) {
        long result = 0;
        long divisor = 1;  //2^0
        long beforeDivisor = 0; //이전의 divisor 담아두기


        while(true){
            long val = n / divisor;
            // 추가분만 더 해줌
            if(val > 0)result += val * (divisor - beforeDivisor);
            else break;
            beforeDivisor = divisor;    //이전 divisor
            divisor *= 2; //2의 제곱수
        }


        return result;
    }
}