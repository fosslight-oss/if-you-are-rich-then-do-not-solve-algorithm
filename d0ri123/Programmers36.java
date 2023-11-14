package d0ri123;

import java.util.Arrays;

/**
 * 최고의 집합
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12938
 */
public class Programmers36 {

    public static void main(String[] args) {
        Programmers36 sol = new Programmers36();

        int n = 2;
        int s = 9;

//        int n = 2;
//        int s = 1;
//
//        int n = 2;
//        int s = 8;

        System.out.println(Arrays.toString(sol.solution(n,s)));
    }

    public int[] solution(int n, int s){
        int[] answer = new int[n];
        int[] errAnswer = {-1};

        if(s<n) return errAnswer;

        if(s%n == 0) {
            Arrays.fill(answer, s/n);
        } else if(s%n == 1) {
            Arrays.fill(answer, s/n);
            answer[n-1] += 1;
        } else if(s%n < n) {
            Arrays.fill(answer, s/n);
            int number = s%n;
            int index = n-1;
            while(number != 0){
                answer[index--] += 1;
                number--;
            }
        }

        return answer;
    }

}
