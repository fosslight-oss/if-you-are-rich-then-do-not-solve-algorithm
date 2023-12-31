import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

class Main{
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   static int N;
   static int answer = 1;
   static int [][] dp;
   static int [] a;

   static void sol(int [] a){
      Arrays.sort(a);
      dp = new int[N][N]; // dp[i][j] = i ~ j 를 마지막 등차수열로 하는 수열의 최대 길이
      for (int i = 0; i< N; i++) dp[i][i] = 1;
      
      for (int i= 0; i<N; i++){
         for (int j = i+1; j<N; j++){
            dp[i][j] =2;
            int d = a[j] - a[i];
            int w = i;
            while (w-1 >= 0 && a[i] - a[w-1] <= d){
               if (a[i]-  a[--w]== d) break;
            }
            if (a[i] - a[w] == d) dp[i][j] = Math.max(dp[i][j], dp[w][i] + 1);
            answer = Math.max(answer, dp[i][j]);
         }
      }
   }
   static void input() throws IOException{
      N = Integer.parseInt(br.readLine());
      a = new int[N];
      for (int i = 0; i<N; i++){
         a[i] = Integer.parseInt(br.readLine());
      }
   }
   public static void main(String[] args) throws IOException {
      input();
      sol(a);
      System.out.println(answer);
   }
}