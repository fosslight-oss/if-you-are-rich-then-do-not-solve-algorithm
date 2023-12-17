import java.util.*;
class Solution {
  public int[] solution(int[] nums){
    int[] answer = new int[nums.length / 2];
    HashMap<Integer, Integer> hm = new HashMap<>(); //숫자당 남은 갯수
    int idx = 0;
    Arrays.sort(nums);
    for (int i = 0; i< nums.length; i++){
      hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
    }

    for (int i = 0; i< nums.length; i++){
      int num = nums[i];
      if (hm.get(num) == 0) continue;
      answer[idx++] = num;
      hm.put(num, hm.get(num)-1);
      hm.put(num*2, hm.get(num*2)-1);
    }
    return answer;
  }

  public static void main(String[] args){
    long startTime = System.currentTimeMillis();
    Solution T = new Solution();
    System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
    System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
    System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    long endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);
  }
}