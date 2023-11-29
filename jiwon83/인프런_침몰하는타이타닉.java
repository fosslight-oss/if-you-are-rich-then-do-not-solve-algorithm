import java.util.*;

class Solution {
    public int solution(int[] nums, int m){
        int boat = 0;

        Integer [] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, Collections.reverseOrder());

        int min = arr.length-1;

        boolean [] ch = new boolean[nums.length]; //보트에 탔는 지 체크

        //큰 수 부터 보트를 태운다.
        for (int i = 0; i < arr.length; i++) {
            if (ch[i]) break;
            // i번째 사람을 태운다.
            int weight = arr[i];
            ch[i] = true;
            // 몸무게가 작은 사람부터 가능하다면 태운다.
            while (min > i && weight + arr[min] <= m){
                weight += arr[min];
                ch[min--] = true;
            }
            boat++;
        }

        return boat;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println("test1 " + T.solution(new int[]{90, 50, 70, 100, 60}, 60)); // 5
        System.out.println("test2 " + T.solution(new int[]{90, 80, 70, 10, 10}, 100)); // 3
        System.out.println("test3 " + T.solution(new int[]{90, 80, 70, 30, 10, 20}, 100)); // 3
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}