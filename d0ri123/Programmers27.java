package d0ri123;

import java.util.Arrays;

/**
 * 삼각 달팽이
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/68645
 */
public class Programmers27 {
    public static void main(String[] args) {
        Programmers27 sol = new Programmers27();
        int n = 4;
//        int n = 5;
//        int n = 6;
        System.out.println(Arrays.toString(sol.solution(n)));
    }

    public int[] solution(int n) {
        int[] answer = new int[(n* (n+1))/2];
        int val = 1; int idx = 0; int cnt = 0;
        int stg = 0;
        int stg_n = n;

        while(n>0){
            if(stg == 0){
                idx = idx + cnt;
                answer[idx] = val++;
                cnt++;
                stg_n--;
                // Down -> Side
                if(stg_n == 0){
                    stg = 1; // Side
                    stg_n = --n;
                }
            }
            // Side
            else if(stg == 1){
                answer[++idx] = val++;
                stg_n--;
                // Side -> Up
                if(stg_n == 0){
                    stg = 2; // Up
                    stg_n = --n;
                }
            }
            // Up
            else{
                idx = idx - cnt;
                answer[idx] = val++;
                cnt--;
                stg_n--;
                // Up -> Down
                if(stg_n == 0){
                    stg = 0; // Down
                    stg_n = --n;
                }
            }
        }
        return answer;
    }

}
