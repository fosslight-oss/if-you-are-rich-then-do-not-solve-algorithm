import java.util.*;
class Solution {
  public int[] solution(int[] arrival, int[] state){
    int[] answer = new int[arrival.length];
    int N = arrival.length;
    int lastInfo = 1; //마지막으로 나간 정보 0 1
    int empNo = 0; // 탐색 사원 번호
    ArrayDeque<Integer> inQ = new ArrayDeque<>(); // 같은 도착시간에 있는 사원 번호 대기 큐
    ArrayDeque<Integer> outQ = new ArrayDeque<>();
    for (int t = 0; t <=200000; t++){
      while (empNo < N && arrival[empNo] == t){
        if (state[empNo]==0) inQ.addLast(empNo);
        else outQ.addLast(empNo);
        empNo++;
      }
      int emp = -1;
      if (lastInfo == 1){
        if (!outQ.isEmpty()){
          emp = outQ.pollFirst();
        }else if(!inQ.isEmpty()){
          emp = inQ.pollFirst();
        }else{
          continue;
        }
      }else if(lastInfo == 0){
        if (!inQ.isEmpty()){
          emp = inQ.pollFirst();
        }else if(!outQ.isEmpty()){
          emp = outQ.pollFirst();
        }else{
          continue;
        }
      }
//      System.out.println("time :"+t + " , emp = "+emp + " last  ="+ lastInfo);
      answer[emp] = t;
      lastInfo = state[emp];
      if (empNo == N && inQ.isEmpty() && outQ.isEmpty()) break;
    }
    return answer;
  }

  public static void main(String[] args){
    Solution T = new Solution();
    System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
    System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
    System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
  }
}