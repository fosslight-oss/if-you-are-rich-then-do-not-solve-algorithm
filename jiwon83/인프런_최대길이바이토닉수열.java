import java.util.*;
class 인프런_최대길이바이토닉수열 {
    public int solution(int[] nums){
        int answer = 0;
        for(int i = 0; i<nums.length; i++){
            while (i+1 < nums.length && nums[i] >= nums[i+1]) ++i; //전처리
            //바이토닉 수열 구하기
            int j = i;
            int asc =0, des =0;
            while (j+1 <nums.length && nums[j] < nums[j+1]){
                j++; asc++;
            }
            while (j+1 <nums.length && nums[j] > nums[j+1]){
                j++; des++;
            }
            if( des > 0 ) answer = Math.max(answer, asc + des + 1);

        }
        return answer;
    }
    public int solution2(int[] nums){
        int answer = 0;
        //peak 꼭짓점을 찾는다.
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i< nums.length-1; i++){
            if (nums[i-1] < nums[i] && nums[i] > nums[i+1]){
                peaks.add(i);
            }
        }
        //각 꼭짓점에 따라서 왼쪽과 오른쪽 길이를 측정
        for (int peak : peaks){
            int len = 1;
            int L = peak;
            int R = peak;
            while (L-1 >= 0 && nums[L-1] < nums[L]){
                len++; L--;
            }
            while (R+1 < nums.length && nums[R] > nums[R+1]){
                len++; R++;
            }
            answer = Math.max(answer, len);
        }
        return answer;
    }


    public static void main(String[] args){
        인프런_최대길이바이토닉수열 T = new 인프런_최대길이바이토닉수열();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}