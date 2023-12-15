import java.util.*;
class Solution {
  public int solution(int[] num, int k){
    int answer = 0;
    Integer [] nums = Arrays.stream(num).boxed().toArray(Integer[]::new);

    Arrays.sort(nums, (o1, o2) -> o2- o1);
    int [][] desc = new int[num.length/2][2];
    for (int i = 0; i+1 < nums.length; i+=2){
      desc[i/2] = new int [] {nums[i], nums[i+1]};
      answer += nums[i+1];
    }
    Arrays.sort(desc, (o1, o2) -> (o2[0]-o2[1]) - (o1[0] - o1[1]));
    for(int i = 0; i <k; i++) answer += (desc[i][0] - desc[i][1]);
    return answer;
  }

  public static void main(String[] args){
    Solution T = new Solution();
    System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
    System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
    System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
    System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
    System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
  }
}