package d0ri123;

import java.util.Arrays;
import java.util.Stack;

/**
 * 같은 숫자는 싫어
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12906
 */
public class Programmers12 {
  public static void main(String[] args) {
    Programmers12 sol = new Programmers12();
//    int[] arr = {1,1,3,3,0,1,1};
    int[] arr = {4,4,4,3,3};
    System.out.println(Arrays.toString(sol.solution(arr)));
  }

  public int[] solution(int[] arr) {
    Stack<Integer> stack = new Stack<>();

    stack.add(arr[0]);

    for(int i=1; i<arr.length; i++) {
      Integer number = stack.pop();
      if(number == arr[i]) {
        stack.push(number);
      } else {
        stack.push(number);
        stack.push(arr[i]);
      }
    }

    int[] answer = new int[stack.size()];
    for(int i=answer.length-1; i>=0; i--) {
      answer[i] = stack.pop();
    }

    return answer;
  }

}
