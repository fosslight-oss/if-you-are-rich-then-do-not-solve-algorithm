package d0ri123;

import java.util.Arrays;

/**
 * 숫자 게임
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12987
 */
public class Programmers38 {

    public int solution(int[] a, int[] b) {
        int answer = 0;
        Arrays.sort(a);
        Arrays.sort(b);

        int n = a.length;

        int aPoint = 0;
        int bPoint = 0;
        for(int i=0; i<n; i++){
            if(a[aPoint] < b[bPoint]){
                answer++;
                aPoint++;
                bPoint++;
            } else if(a[aPoint] > b[bPoint] || a[aPoint] == b[bPoint]){
                bPoint++;
            }
        }
        return answer;
    }

}
