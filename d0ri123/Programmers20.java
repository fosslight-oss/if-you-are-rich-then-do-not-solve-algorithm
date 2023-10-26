package d0ri123;

/**
 * 타겟 넘버
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class Programmers20 {
    public static int answer = 0;
    public static void main(String[] args) {
        Programmers20 sol = new Programmers20();
//        int[] numbers = {1, 1, 1, 1, 1};
//        int target = 3;
        int[] numbers = {4, 1, 2, 1};
        int target = 4;

        System.out.println(sol.solution(numbers, target));
    }
    public int solution(int[] numbers, int target){
        dfs(numbers, 0, 0, target);
        return answer;
    }

    public static void dfs(int[] numbers, int n, int level, int target){
        if(level==numbers.length){
            if (n == target) {
                answer++;
            }
        } else {
            int n1 = n+numbers[level];
            int n2 = n-numbers[level];
            dfs(numbers, n1, level+1, target);
            dfs(numbers, n2, level+1, target);
        }
    }

}
