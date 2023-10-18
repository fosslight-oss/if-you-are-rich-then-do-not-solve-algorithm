package d0ri123;

import java.util.Stack;

/**
 * 큰 수 만들기
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42883
 */

public class Programmers11 {
  public static void main(String[] args) {
    Programmers11 sol = new Programmers11();
    String number = "1924";
    int k = 2;

//    String number = "1231234";
//    int k = 3;

//    String number = "4177252841";
//    int k = 4;

    System.out.println(sol.solution(number, k));
  }

  public String solution(String number, int k) {
    int len = number.length()-k;
    Stack<Character> stk = new Stack<>();

    for (char c : number.toCharArray()) {
      while(!stk.isEmpty() && stk.peek() < c && k-- > 0)
        stk.pop();
      stk.push(c);
    }
    StringBuilder sb = new StringBuilder();
    for (Character c : stk) {
      sb.append(c);
      if(sb.length() == len)
        break;
    }
    return sb.toString();
  }
}
