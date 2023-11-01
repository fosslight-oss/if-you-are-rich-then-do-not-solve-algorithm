package d0ri123;

/**
 * 피로도
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
public class Programmers25 {
    public static boolean[] visited;
    public static int answer = 0;

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        Programmers25 sol = new Programmers25();
        System.out.println(sol.solution(k, dungeons));
    }

    public static void dfs(int depth, int k, int[][] dungeons){
        for(int i=0; i<dungeons.length ; i++){
            if(!visited[i] && dungeons[i][0]<=k){
                visited[i] = true;
                dfs(depth+1, k-dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }

    public int solution(int k, int[][] dungeons){
        int depth = 0;
        visited = new boolean[dungeons.length+1];

        dfs(depth, k, dungeons);

        return answer;
    }

}
