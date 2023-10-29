package d0ri123;

/**
 * 네트워크
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */
public class Programmers22 {

    public static void main(String[] args) {
        Programmers22 sol = new Programmers22();
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

//        int n = 3;
//        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        System.out.println(sol.solution(n, computers));
    }

    public static int[] parent;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(computers[i][j] == 1 && computers[j][i] == 1) {
                    union(i, j);

                }
            }
        }

        for(int i=0; i<n; i++){
            if(parent[i]==i) answer++;
        }
        return answer;
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return;
        parent[a] = b;
    }

    public static int find(int a){
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

}
