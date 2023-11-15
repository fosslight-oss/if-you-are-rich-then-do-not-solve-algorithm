package d0ri123;

import java.util.Arrays;

/**
 * 징검다리 건너기
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/64062
 */
public class Programmers37 {
    public static void main(String[] args) {
        Programmers37 sol = new Programmers37();
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(sol.solution(stones, k));
    }

    public int solution(int[] stones, int k) {
        int low = 1;
        int high = Arrays.stream(stones).max().getAsInt();
        int answer = 0;

        while(low <= high){
            int mid = (low + high) / 2;

            if(!binarySearch(k, mid, stones)) {
                high = mid - 1;
            } else {
                low = mid + 1;
                answer = Math.max(answer, mid);
            }
        }

        return answer;
    }

    public static boolean binarySearch(int k, int mid, int[] stones) {
        int count = 0;
        for(int i=0; i< stones.length; i++) {
            if(stones[i] - mid < 0) count++;
            else count = 0;

            if(count == k) return false;
        }
        return true;
    }

}
