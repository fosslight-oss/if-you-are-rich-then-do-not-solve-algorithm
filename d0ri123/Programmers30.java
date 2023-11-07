package d0ri123;

import java.util.Arrays;

/**
 * 땅따먹기
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12913
 */
public class Programmers30 {
    public static void main(String[] args) {
        Programmers30 sol = new Programmers30();
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println(sol.solution(land));
    }

    public int solution(int[][] land) {
        for(int l=1; l<land.length; l++){
            int[] arr = land[l];
            for(int i=0; i<4; i++){
                switch(i){
                    case 0:
                        arr[0] += Math.max(Math.max(land[l-1][1], land[l-1][2]),land[l-1][3]);
                        break;
                    case 1:
                        arr[1] += Math.max(Math.max(land[l-1][0], land[l-1][2]),land[l-1][3]);
                        break;
                    case 2:
                        arr[2] += Math.max(Math.max(land[l-1][0], land[l-1][1]),land[l-1][3]);
                        break;
                    case 3:
                        arr[3] += Math.max(Math.max(land[l-1][0], land[l-1][1]),land[l-1][2]);
                        break;
                }
            }
        }

        int[] result = land[land.length-1];
        return Arrays.stream(result).max().getAsInt();
    }
}
