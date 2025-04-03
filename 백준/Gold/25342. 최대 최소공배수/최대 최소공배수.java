import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            Long n = Long.parseLong(br.readLine());

            Long tmp1 = getLCMByGCD(getLCMByGCD(n-3,n-2),n-1);
            Long tmp2 = getLCMByGCD(getLCMByGCD(n-2,n-1),n);
            Long tmp3;
            if(n%2==0L){
                tmp3 = getLCMByGCD(getLCMByGCD(n-3,n-1),n);
            }else{
                tmp3 = getLCMByGCD(getLCMByGCD(n-3,n-2),n);
            }
            System.out.println(Math.max(Math.max(tmp1,tmp2),tmp3));
            
        }
    }

    public static Long getGCD(Long a, Long b){
        if(b==0){
            return a;
        }
        return getGCD(b, a%b);
    }

    public static Long getLCMByGCD(Long a, Long b){
        return a*b/getGCD(a,b);
    }
}