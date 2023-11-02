package d0ri123;

import java.util.Arrays;

/**
 * 카펫
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */
public class Programmers26 {

    public static void main(String[] args) {
        Programmers26 sol = new Programmers26();

        int brown = 10;
        int yellow = 2;

//        int brown = 8;
//        int yellow = 1;

//        int brown = 24;
//        int yellow = 24;

        System.out.println(Arrays.toString(sol.solution(brown, yellow)));
    }

    public int[] solution(int brown, int yellow){
        int totalArea =  brown + yellow;
        int init = 2;
        int width = totalArea, height = totalArea;
        int[] answers = new int[2];

        while(init <= Math.sqrt(totalArea)){
            if(totalArea % init == 0) {
                width = init;
                height = totalArea/init;
                int w = width - 1; int h = height - 1;
                if(brown == (w*2) + (h*2)) break;
            }
            init++;
        }

        if(width>=height){
            answers[0] = width;
            answers[1] = height;
        } else{
            answers[0] = height;
            answers[1] = width;
        }
        return answers;
    }

}
