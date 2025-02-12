import java.util.*;
import java.io.*;

public class Main {
    static int N, R, C, cnt=0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        find(R,C,(int)Math.pow(2, N));
        System.out.println((int)(cnt));
    }

    static void find(int x,int y, int size) {
      if(size==1)
        return;
      
      if(x<size/2&&y<size/2) {	
        find(x,y,size/2);
      }else if(x<size/2&&size/2<=y) {	
        cnt+=(size*size/4);
        find(x,y-size/2,size/2);
      }else if(x>=size/2&&size/2>y) { 
        cnt+=(size*size/4)*2;
        find(x-size/2,y,size/2);
      }else {						
        cnt+=(size*size/4)*3;
        find(x-size/2,y-size/2,size/2);
      }

    }
}