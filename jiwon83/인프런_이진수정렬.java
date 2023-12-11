import java.util.*;
class Solution {
  public int[] solution(int[] nums){
    int[] answer = new int[nums.length];
    Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
    Arrays.sort(arr, new Comparator<Integer>(){
      @Override
      public int compare(Integer a, Integer b){
        int cntA = getBinary1count(a);
        int cntB = getBinary1count(b);
        if (cntA != cntB) return cntA - cntB;
        return a.compareTo(b);

      }
    });
    for (int i = 0; i< nums.length; i++) answer[i] = arr[i];
    return answer;
  }
  private int getBinary1count(Integer num){
//    System.out.println(Integer.toBinaryString(num));
    int count=0;
    while (num > 1){
      if(num % 2 == 1) count++;
      num /= 2;
    }
    if (num == 1) count++;
    return count;
  }

  public static void main(String[] args){
    Solution T = new Solution();
    System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
    System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
    System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
  }
}