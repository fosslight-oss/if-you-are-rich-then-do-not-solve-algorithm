package d0ri123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers56 {
    public static void main(String[] args) {
        Programmers56 sol = new Programmers56();
        int[] answers = {1,2,3,4,5};

        System.out.println(Arrays.toString(sol.solution(answers)));
    }

    public int[] solution(int[] answers){
        int[] students1 = {1,2,3,4,5};
        int[] students2 = {2,1,2,3,2,4,2,5};
        int[] students3 = {3,3,1,1,2,2,4,4,5,5};
        int[] score = {0,0,0};

        int length1 = students1.length;
        int length2 = students2.length;
        int length3 = students3.length;

        for(int i=0; i<answers.length; i++){
            if(answers[i] == students1[i%length1]) {
                score[0]++;
            }
            if(answers[i] == students2[i%length2]) {
                score[1]++;
            }
            if(answers[i] == students3[i%length3]) {
                score[2]++;
            }
        }

        int max = Arrays.stream(score).max()
            .orElse(-1);

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i< score.length; i++){
            if(max == score[i]) ans.add(i+1);
        }

        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }

        return answer;
    }



}
