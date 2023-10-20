package d0ri123;

import java.util.PriorityQueue;

/**
 * 더 맵게
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class Programmers14 {
  public static void main(String[] args) {
    Programmers14 sol = new Programmers14();
    int[] scoville = {1, 2, 3, 9, 10, 12};
    int K = 7;
    System.out.println(sol.solution(scoville, K));
  }

  public int solution(int[] scoville, int K) {
    PriorityQueue<Integer> pqScoville = new PriorityQueue<>();
    for (int s: scoville) {
      pqScoville.add(s);
    }

    int cnt = 0;
    while (pqScoville.size() > 1 && pqScoville.peek() < K) {
      pqScoville.add(pqScoville.remove() + pqScoville.remove() * 2);
      cnt++;
    }

    return pqScoville.peek() >= K ? cnt : -1;
  }

}
