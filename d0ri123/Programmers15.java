package d0ri123;

import java.util.Arrays;

/**
 * 기능 개발
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */

public class Programmers15 {
  public static void main(String[] args) {
    Programmers15 sol = new Programmers15();
    int[] progress = {93, 30, 55};
    int[] speeds = {1, 30, 5};

//    int[] progress = {95, 90, 99, 99, 80, 99};
//    int[] speeds = {1, 1, 1, 1, 1, 1};

    System.out.println(Arrays.toString(sol.solution(progress, speeds)));
  }

  public int[] solution(int[] progresses, int[] speeds) {
    int[] dayOfend = new int[100];
    int day = -1;
    for(int i=0; i<progresses.length; i++) {
      while(progresses[i] + (day*speeds[i]) < 100) {
        day++;
      }
      dayOfend[day]++;
    }
    return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
  }

}
