package d0ri123;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 체육복
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42862
 */
class Student {
  int number;
  boolean isParticipateIn;

  public Student(int number, boolean isParticipateIn) {
    this.number = number;
    this.isParticipateIn = isParticipateIn;
  }

  public void changeStat(boolean status) {
    this.isParticipateIn = !status;
  }
}

public class Programmers10 {

  public static void main(String[] args) {
    Programmers10 sol = new Programmers10();
//    int n = 5;
//    int[] lost = {2, 4};
//    int[] reserve = {1, 3, 5};

//    int n = 5;
//    int[] lost = {2, 4};
//    int[] reserve = {3};

//    int n = 3;
//    int[] lost = {3};
//    int[] reserve = {1};

    int n = 5;
    int[] lost = {1, 2, 3};
    int[] reserve = {2, 3, 4};

    System.out.println(sol.solution(n, lost, reserve));
  }

  public int solution(int n, int[] lost, int[] reserve) {
    Set<Integer> hasExtra = new HashSet<>();
    Student[] taken = new Student[lost.length];
    int answer = 0;

    for(int student : reserve) { //여벌을 가진 학생들을 set에 넣는다.
      hasExtra.add(student);
    }

    Arrays.sort(lost);
    for(int i=0; i<lost.length; i++) { //잃어버린 학생들을 배열에 넣는다.
      taken[i] = new Student(lost[i], false);
    }

    for(Student student : taken) {
      if(hasExtra.contains(student.number)) {
        hasExtra.remove(student.number);
        student.changeStat(student.isParticipateIn);
      }
    }

    for(Student student : taken) {
      if(student.isParticipateIn) continue;
      if(bothOrSmaller(hasExtra, student.number)) {
        hasExtra.remove(student.number - 1); // 모든게 다 들어가면 무조건 -1인 번호를 지우도록 방식 통일
        student.changeStat(student.isParticipateIn);
      } else if(larger(hasExtra, student.number)) {
        hasExtra.remove(student.number + 1);
        student.changeStat(student.isParticipateIn);
      }
    }

    int notPossibleToParticipate = 0;
    for(Student student : taken) {
      if(!student.isParticipateIn) {
        notPossibleToParticipate++;
      }
    }


    answer = n - notPossibleToParticipate;

    return answer;
  }

  private boolean bothOrSmaller(Set<Integer> set, int number) {
    int prev = number - 1;
    int next = number + 1;
    return (set.contains(prev) && set.contains(next))
        || (set.contains(prev) && !set.contains(next));
  }

  private boolean larger(Set<Integer> set, int number) {
    int prev = number - 1;
    int next = number + 1;
    return (!set.contains(prev) && set.contains(next));
  }

}
