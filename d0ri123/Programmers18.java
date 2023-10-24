package d0ri123;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 디스크 컨트롤러
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42627
 */

public class Programmers18 {

  public static void main(String[] args) {
    Programmers18 sol = new Programmers18();
    int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
    System.out.println(sol.solution(jobs));
  }

  public int solution(int[][] jobs) {
    int answer = 0;

    Arrays.sort(jobs, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0]-o2[0];
      }
    });

    PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1]-o2[1];
      }
    });

    int idx = 0;
    int time = jobs[0][0];
    while(idx<jobs.length || !q.isEmpty()){
      while(idx < jobs.length && jobs[idx][0]<=time){
        q.offer(jobs[idx++]);
      }
      if(q.isEmpty()){
        time = jobs[idx][0];
        q.offer(jobs[idx++]);
      }

      int[] work = q.poll();
      time += work[1];
      answer += time - work[0];
    }
    return answer/jobs.length;
  }
}
