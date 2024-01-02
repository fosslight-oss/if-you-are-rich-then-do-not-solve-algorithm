import java.util.*;
class Solution {
   static int ans;
   public int solution(int[][] cans){
      ans = Integer.MAX_VALUE;
      int N = cans.length;
      recur(0, 0, N/2, N/2, cans,"");
      return ans;
   }
   static void recur(int k, int gap, int teamA, int teamB, int[][] cans, String route){
      if(k == cans.length){
//         System.out.println( " gap = "+ gap + " :  "+ route);
         ans = Math.min(ans, Math.abs(gap));
         return;
      }
      if (teamA > 0){
         recur(k+1, gap + cans[k][0], teamA-1, teamB, cans, route+" W("+ cans[k][0]+")");
      }
      if(teamB > 0){
         recur(k+1, gap - cans[k][1], teamA, teamB-1, cans, route+" B("+ cans[k][1]+")");
      }

   }

   public static void main(String[] args){
      Solution T = new Solution();
      System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
      System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
      System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
   }
}
