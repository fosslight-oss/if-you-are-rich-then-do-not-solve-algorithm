import java.util.*;
class Solution {
  static class Plant implements Comparable<Plant>{
    int pTime;
    int gTime;

    @Override
    public int compareTo(Plant other){
      int meFirst = this.pTime + Math.max( this.gTime, other.pTime + other.gTime);
      int otherFirst = other.pTime + Math.max( other.gTime, this.pTime + this.gTime);
      return meFirst - otherFirst;
    }

    @Override
    public String toString() {
      return "Plant{" +
              "pTime=" + pTime +
              ", gTime=" + gTime +
              '}';
    }
  }

  public int solution(int[] plantTime, int[] growTime){
    int answer = 0;
    Plant [] plants = new Plant[plantTime.length];
    for (int i =0; i< plants.length; i++) plants[i] = new Plant();
    for (int i =0; i< plants.length; i++) plants[i].pTime = plantTime[i];
    for (int i =0; i< plants.length; i++) plants[i].gTime = growTime[i];

    Arrays.sort(plants);
    int start = 0;
    // 순서에 맞춰 심는다.
    for (int i =0; i< plants.length; i++){
      int flowerTime = start + plants[i].pTime + plants[i].gTime;
      answer = Math.max(answer, flowerTime);
      start += plants[i].pTime;
    }
    // 마지막 피는 시간을 출력한다.
    return answer;
  }

  public static void main(String[] args){
    Solution T = new Solution();
    System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
    System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
    System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
    System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
    System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
  }
}