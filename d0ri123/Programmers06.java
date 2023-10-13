package d0ri123;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 의상
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
public class Programmers06 {
  public static void main(String[] args) {
    Programmers06 sol = new Programmers06();

//    String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
    String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

    System.out.println(sol.solution(clothes));
  }

  public int solution(String[][] clothes) {
    int answer = 1;
    HashMap<String, ArrayList<String>> closet = new HashMap<>();

    for(String[] clothing : clothes) {
      closet.putIfAbsent(clothing[1], new ArrayList<>());
      closet.get(clothing[1]).add(clothing[0]);
    }

    for(String kind : closet.keySet()) {
      int possibleCase = closet.get(kind).size();
      answer *= (possibleCase+1);
    }

    return answer-1;
  }
}

