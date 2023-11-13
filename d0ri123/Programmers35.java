package d0ri123;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 야근 지수
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12927
 */
public class Programmers35 {

    public static void main(String[] args) {
        Programmers35 sol = new Programmers35();
        int n = 4;
        int[] works = {4, 3, 3};

//        int n = 1;
//        int[] works = {2, 1, 2};
//
//        int n = 3;
//        int[] works = {1,1};
        System.out.println(sol.solution(n, works));
    }

    public long solution(int n, int[] works) {

        int totalWork = 0;
        for(int work : works) {
            totalWork += work;
        }

        if(totalWork <= n) {
            return 0;
        }


        Comparator<Integer> maxComp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(maxComp);

        for(int work : works) {
            pq.add(work);
        }

        while(n > 0) {
            int workTime = pq.poll();
            workTime--;
            pq.add(workTime);
            n--;
        }

        return pq.stream()
            .mapToLong(i -> i*i)
            .sum();
    }

}
