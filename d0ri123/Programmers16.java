package d0ri123;

/**
 * 모음사전
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */
public class Programmers16 {
  public static void main(String[] args) {
    Programmers16 sol = new Programmers16();
    String word = "AAAAE";
//    String word = "AAAE";
//    String word = "I";
//    String word = "EIO";

    System.out.println(sol.solution(word));
  }

  public int solution(String word){
    String str = "AEIOU";
    int[] rule = {781,156,31,6,1};
    int answer = word.length();

    for(int i=0; i<word.length(); i++){
      int index = str.indexOf(word.charAt(i));
      answer += rule[i] * index;
    }
    return answer;
  }

}
