//CPU 스케쥴링
import java.util.*;
class Solution {
   class Work{
      int callTime, runTime, idx;
      public Work(int callTime, int runtime, int idx){
         this.callTime = callTime;
         this.runTime = runtime;
         this.idx = idx;

      }
   }
   public int[] solution(int[][] tasks){
      int[] answer = new int[tasks.length];
      //sol1 : 시간 단위로 순회 => 10,000 * log 10,000 => ok
      //sol2 : 작업 시간 단위로 순회
      List<Work> works = new ArrayList<>();
      for (int i = 0; i <tasks.length; i++){
         works.add(new Work(tasks[i][0], tasks[i][1],i));
      }
      Collections.sort(works, (o1, o2)->(o1.callTime - o2.callTime));

      int endTime = 0;
      final int maxTime = 10000;
      int idx = 0;
      int ansIdx = 0;
      PriorityQueue<Work> pq = new PriorityQueue<>((o1,o2)->(o1.runTime!= o2.runTime?o1.runTime-o2.runTime:o1.idx-o2.idx));
      while (endTime <= maxTime || !pq.isEmpty() ){
         //0. 대기큐에 처리
         while (idx < works.size() && works.get(idx).callTime <= endTime){
            pq.add(works.get(idx++));
         }
         if(!pq.isEmpty()){ //1. 가능한 작업 호출
            Work now = pq.poll();
            answer[ansIdx++] = now.idx;
            endTime += now.runTime;
         }else {
            endTime++;
         }
      }
      return answer;
   }

   public static void main(String[] args){
      Solution T = new Solution();
      System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
      System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
      System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
      System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
   }
}