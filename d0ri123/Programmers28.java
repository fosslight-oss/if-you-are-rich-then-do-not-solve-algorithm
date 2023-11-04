package d0ri123;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 과제 진행하기
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/176962
 */
class Assignment implements Comparable<Assignment> {
    String subject;
    int startTime;
    int playTime;

    public Assignment(String subject, String startTime, String playTime) {
        this.subject = subject;
        this.startTime = transform(startTime);
        this.playTime = Integer.parseInt(playTime);
    }

    private int transform(String startTime) {
        int num = 0;
        String[] formatter = startTime.split(":");
        num += ((Integer.parseInt(formatter[0]) * 60) + Integer.parseInt(formatter[1]));
        return num;
    }

    @Override
    public int compareTo(Assignment assignment) {
        return this.startTime - assignment.startTime;
    }
}

public class Programmers28 {
    public static void main(String[] args) {
        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
//        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
//        String[][] plans = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};
        Programmers28 sol = new Programmers28();
        System.out.println(Arrays.toString(sol.solution(plans)));
    }

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int index = 0;
        PriorityQueue<Assignment> pq = new PriorityQueue<>();
        Deque<Assignment> deque = new ArrayDeque<>();
        putPlan(plans, pq);

        int curTime = pq.peek().startTime;
        deque.add(pq.poll());
        while(!pq.isEmpty()) {
            Assignment next;
            if(pq.peek().startTime < curTime + deque.peekLast().playTime){
                // 새 과제 시작전에 진행중인 작업을 끝내지 못함
                next = pq.poll();
                deque.peekLast().playTime -= next.startTime - curTime;
                curTime = next.startTime;
                deque.add(next);
            }
            else{
                // 진행중인 작업 끝
                curTime += deque.peekLast().playTime;
                answer[index++] = deque.pollLast().subject;
            }
            if(deque.isEmpty()) {
                curTime = pq.peek().startTime;
                deque.add(pq.poll());
            }

        }

        while(!deque.isEmpty()){
            answer[index++] = deque.pollLast().subject;
        }

        return answer;
    }

    private void putPlan(String[][] plans, PriorityQueue<Assignment> pq) {
        for(String[] plan : plans) {
            pq.add(new Assignment(plan[0], plan[1], plan[2]));
        }
    }

}
