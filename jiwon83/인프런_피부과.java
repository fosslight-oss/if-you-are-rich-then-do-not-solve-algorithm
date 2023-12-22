import java.util.*;
import java.util.LinkedList;

class Solution {
  public int solution(int[] laser, String[] enter){
    int answer = 0;
    Queue<Integer> q = new LinkedList<>();
    //피부과에 온 손님 순서대로
    //if 진료중이라면 대기 큐에 넣는다.
    //else 대기 큐 손님을 받거나 없다면 다음에 오는 손님을 진료
    int enterIdx = 0;
    int time = getTime(enter[0]);
    int endTime = -1;
    while (time<= getTime("20:00")){
      if (enterIdx < enter.length && getTime(enter[enterIdx]) == time){ // 현재 시간에 방문한 손님이 있다면
          q.add(getRuntime(enter[enterIdx], laser)); //대기 큐에 등록
          enterIdx++;
      }
      if (endTime <= time && !q.isEmpty()){ // 이전 손님 진료가 끝난 이후에 대기큐에 손님이 있다면
        // System.out.println(idx+" 번째 고객 진료 시작");
        int runTime = q.poll();
        endTime = time + runTime; //진료 시작
      }
      answer = Math.max(answer, q.size());
      time++;
    }
    return answer;
  }
  private static int getRuntime(String s, int[] laser){
    String [] tmp = s.split(" ");
    return laser[Integer.parseInt(tmp[1])];
  }
  private static int getTime(String s){
    String [] tmp = s.split(" ");
    int hour = Integer.parseInt(tmp[0].split(":")[0]);
    int min = Integer.parseInt(tmp[0].split(":")[1]);
    return hour*60+min;
  }

  public static void main(String[] args){
    Solution T = new Solution();
    System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
    System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
    System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
  }
}