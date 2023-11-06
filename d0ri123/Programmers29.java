package d0ri123;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 소수 찾기
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */
public class Programmers29 {
    public static void main(String[] args) {
        Programmers29 sol = new Programmers29();
        String numbers = "17";
//        String numbers = "011";
        System.out.println(sol.solution(numbers));
    }

    public static HashSet<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        permutation("", numbers);

        Iterator<Integer> it = numberSet.iterator();
        while(it.hasNext()){
            int num = it.next();
            if(isPrime(num))
                answer++;
        }
        return answer;
    }

    public static void permutation(String origin, String others){
        if(!origin.equals(""))
            numberSet.add(Integer.parseInt(origin));

        for(int i=0; i<others.length(); i++){
            permutation(origin+others.charAt(i), others.substring(0,i)+others.substring(i+1));
        }
    }

    public static boolean isPrime(int number){
        if(number == 1 || number == 0) return false;
        for(int i=2; i<=Math.sqrt(number); i++){
            if(number%i == 0) return false;
        }
        return true;
    }

}
