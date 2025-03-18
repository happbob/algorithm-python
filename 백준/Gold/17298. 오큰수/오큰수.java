import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] number = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int[] ret = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            ret[i] = -1;

            while (!stack.isEmpty() && number[i] >= stack.peekFirst()) {
                stack.pollFirst();
            }
            if (!stack.isEmpty()) {
                ret[i] = stack.peekFirst();
            }
            stack.addFirst(number[i]);
        }

        for (int r : ret) {
            bw.write(String.valueOf(r));
            bw.write(' ');
        }
        bw.flush();
        br.close();
        bw.close();
    }


}