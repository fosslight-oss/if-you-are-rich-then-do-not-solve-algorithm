import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BOJ_21756_지우개 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, Q;
    static int [] a;
    static HashMap<Integer, Integer> hmCnt = new HashMap<>();

    static void input() throws IOException{

    }
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());

        int i = 8;
        while (i >= 0){
            int num = (int)Math.pow(2,i--);
            if (N >= num){
                System.out.println(num);
                break;
            }
        }
    }

}