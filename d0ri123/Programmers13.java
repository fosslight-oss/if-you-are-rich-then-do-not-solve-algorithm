package d0ri123;

/**
 * 올바른 괄호
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */

public class Programmers13 {
  public static void main(String[] args) {
    Programmers13 sol = new Programmers13();
//    String s = "()()";
//    String s = "(())()";
//    String s = ")()(";
//    String s = "(()(";
    String s = "((())))(()";

    System.out.println(sol.solution(s));
  }

  boolean solution(String s) {
    boolean answer = false;
    int count = 0;
    for(int i=0; i<s.length(); i++){
      if(s.charAt(i) == '('){
        count++;
      }
      if(s.charAt(i) == ')'){
        count--;
      }
      if(count < 0){
        break;
      }
    }
    if(count == 0){
      answer = true;
    }

    return answer;
  }


}
