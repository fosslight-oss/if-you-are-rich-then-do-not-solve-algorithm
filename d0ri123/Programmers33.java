package d0ri123;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 요격 시스템
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181188
 */
public class Programmers33 {
    public static void main(String[] args) {
        Programmers33 sol = new Programmers33();
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};

        System.out.println(sol.solution(targets));
    }

    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) { //x좌표를 기준으로 오름차순 정렬, y좌표를 기준으로 오름차순 정렬. 끝나는 시간을 기준으로 오름차순 정렬..??
                if(o1[1] == o2[1])
                    return o1[0] - o2[0]; //시작하는 시간을 기준으로 오름차순
                return o1[1] - o2[1]; //끝나는 시간을 기준으로 오름차순
            }
        });

        int idx = 1;
        int shootingPoint = targets[0][1]; //첫번째 원소의 end 지점이 있다고 하자.

        while(idx < targets.length) {
            if(shootingPoint <= targets[idx][0]) {
                shootingPoint = targets[idx][1];
                answer++;
            }
            idx++;
        }

        return answer;
    }

}
