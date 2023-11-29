package d0ri123;

import java.util.Arrays;

public class Programmers48 {
    public static void main(String[] args) {
        int n = 2;
        int s = 9;
        Programmers48 sol = new Programmers48();

        System.out.println(Arrays.toString(sol.solution(n, s)));
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
