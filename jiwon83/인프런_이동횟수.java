import java.util.*;
class Solution {
    public int solution(int[] nums){
        int answer = 0;
        Integer [] a = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(a, Collections.reverseOrder());

        int R = a.length-1; //다음으로 이동할 가장 작은 물건의 위치
        int L = 0; //다음으로 이동할 가장 큰 물건의 위치
        while (L <= R){ //큰 물건 기준으로  이동
            if ( L != R && a[L] + a[R] <= 5) R--; //다음으로 이동할 작은 물건을 같이 들 수 있다면 든다.
            L++;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}