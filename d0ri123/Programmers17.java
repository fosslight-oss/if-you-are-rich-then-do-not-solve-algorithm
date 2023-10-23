package d0ri123;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 가장 큰 수
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */
public class Programmers17 {

  public static void main(String[] args) {
    Programmers17 sol = new Programmers17();
//    int[] numbers = {6, 10, 2};
    int[] numbers = {3, 30, 34, 5, 9};
    System.out.println(sol.solution(numbers));
  }

  public String solution(int[] numbers) {
    String[] nums = new String[numbers.length];

    for (int i=0; i<nums.length; i++)
      nums[i] = numbers[i] + "";

    Arrays.sort(nums, new Comparator<String>() {
      public int compare(String o1, String o2) {
        return (o2 + o1).compareTo(o1 + o2);
      }
    });

    String ans = "";
    for (int i=0; i<numbers.length; i++)
      ans += nums[i];

    return ans.charAt(0) == '0' ? "0" : ans;
  }

}
