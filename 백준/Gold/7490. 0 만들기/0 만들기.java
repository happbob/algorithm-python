import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
  private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
  private static int n;
  private static int[] arr;

  public static boolean cal(String statement){
    statement = statement.replaceAll(" ", "");
    List<Integer> buffArr = Arrays.stream(statement.split("\\+|-")) // "+" 및 "-"로 분리
                                       .map(Integer::parseInt) // 정수로 변환
                                       .collect(Collectors.toList());
    // System.out.println(buffArr);
    Integer buff = buffArr.get(0);
    int index=1;
    // System.out.println(statement);
    for(int i=0;i<statement.length();i++){
      if(statement.charAt(i) == '+'){
        buff += buffArr.get(index);
        index++;
      }else if(statement.charAt(i) == '-'){
        buff -= buffArr.get(index);
        index++;
      }
    }
    if(buff == 0) {
      return true;
    } else {
      return false;
    }
  }

  public static void recurse(int buff, int index, int sum, int operator, int num, String statement) {
    if(index == buff){
      if(cal(statement)){
        System.out.println(statement);
      }
      return;
    }
    recurse(buff, index+1, sum, operator,(num*10)+index,statement + " " +Character.forDigit(index+1,10));
    recurse(buff,index+1, sum + (operator *  num), +1, index+1, statement+'+'+Character.forDigit(index+1,10));
    recurse(buff,index+1, sum + (operator *  num), -1, index+1, statement+'-'+Character.forDigit(index+1,10));
  }

  public static void input() throws IOException{
    n = Integer.parseInt(bufferedReader.readLine());
    for(int i = 0; i<n;i++){
      int buff = Integer.parseInt(bufferedReader.readLine());
      recurse(buff, 1, 0,1,1,"1" );
      System.out.println();
    }
  }

  public static void main(String args[]) throws IOException {
    input();
    // solve();
  }
}