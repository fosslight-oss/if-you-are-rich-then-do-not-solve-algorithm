import java.util.*;
class Solution {
   public int solution(int n, int[][] meetings){
      int answer = 0;
      int maxCnt = 0;
      int [] rooms = new int[n];
      HashMap<Integer, Integer> cnt = new HashMap<>();
      for (int i = 0; i<n; i++) cnt.put(i, 0);

      ArrayDeque<int[]> q = new ArrayDeque<>();
      Arrays.sort(meetings, (o1,o2) -> o1[0] - o2[0]);
      for (int i = 0; i< meetings.length; i++){
         int [] meet = meetings[i];
         int room = n+1;
         int possTime = Integer.MAX_VALUE;
         for(int j = 0; j<n; j++){
            if (rooms[j] <= meet[0]){
               room = j;
               break;
            }
            if(rooms[j] < possTime){
               possTime = rooms[j];
               room = j;
            }
         }
         cnt.put(room, cnt.getOrDefault(room, 0) + 1);
         rooms[room] = Math.max(meet[1], rooms[room] + (meet[1] - meet[0]));
      }
      for (Map.Entry<Integer,Integer> entry : cnt.entrySet()){
         if (maxCnt < entry.getValue()){
            maxCnt = entry.getValue();
            answer = entry.getKey();
         }
      }
      return answer;
   }

   public static void main(String[] args){
      Solution T = new Solution();
      System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
      System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
      System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
      System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
   }
}