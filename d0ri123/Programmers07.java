package d0ri123;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * K번째 수
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
public class Programmers07 {
  public static void main(String[] args) {
    Programmers07 sol = new Programmers07();
    int[] array = {1, 5, 2, 6, 3, 7, 4};
    int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    System.out.println(Arrays.toString(sol.solution(array, commands)));
  }

  public int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];
    int a = 0;
    for(int[] info : commands){
      int i = info[0];
      int j = info[1];
      int k = info[2];

      int[] buf = Arrays.copyOfRange(array,i-1,j);
      Arrays.sort(buf);
      answer[a] = buf[k-1];
      a++;
    }
    return answer;
  }
}
