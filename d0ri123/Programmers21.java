package d0ri123;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 섬 연결하기
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42861
 */
public class Programmers21 {
    public static int[] parent;
    public static void main(String[] args) {
        Programmers21 sol = new Programmers21();

        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        System.out.println(sol.solution(n, costs));
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;

        setting(n);

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        for(int i=0; i<costs.length; i++){
            if(!union(costs[i][0], costs[i][1]))
                answer += costs[i][2];
        }
        return answer;
    }

    public static void setting(int n){
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
    }

    public static boolean union(int u, int v){
        u = find(u);
        v = find(v);
        if(u==v) return true;
        else {
            parent[u] = v;
            return false;
        }
    }

    public static int find(int u){
        if(u == parent[u]) return u;
        return parent[u] = find(parent[u]);
    }

}
