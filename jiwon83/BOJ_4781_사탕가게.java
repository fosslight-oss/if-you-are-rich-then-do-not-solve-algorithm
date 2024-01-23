import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main2 {
   static class Candy{
      int kcal, price;
      public Candy(int kcal, int price) {
         this.kcal = kcal;
         this.price = price;
      }
   }
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static StringTokenizer st;
   static StringBuilder sb = new StringBuilder();
   static int N,M;
   static int [] memo;
   static Candy [] candies;

   static void input() throws IOException{
      while (true){
         st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         if (N == 0 ) {
            return;
         }
         M = toX100(st.nextToken());
         candies = new Candy[N];
         memo = new int[M+1];
         for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int kcal = Integer.parseInt(st.nextToken());
            int price = toX100(st.nextToken());
            candies[i] = new Candy(kcal, price);
         }
         sol();
      }

   }
   static void sol(){
      for (int i = 0; i<N; i++){
         Candy candy = candies[i];
         for (int m = candy.price; m <= M; m++){
            memo[m] = Math.max(memo[m], memo[m-candy.price]+ candy.kcal);
         }
      }
      System.out.println(memo[M]);

   }
   public static void main(String[] args) throws IOException{
      input();
   }
   public static int toX100(String s){
      String tmp [] = s.split("\\.");
      return Integer.parseInt(tmp[0])*100 + Integer.parseInt(tmp[1]);
   }
}