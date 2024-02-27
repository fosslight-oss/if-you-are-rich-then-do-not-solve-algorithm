import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_21939_문제추천시스템v1 {

    static class Problem implements Comparable<Problem>{
        int problem;
        int level;
        public Problem(int problem, int level){
            this.problem = problem;
            this.level = level;
        }
        @Override
        public int compareTo(Problem o){
            if(this.level != o.level){
                return this.level - o.level;
            }else{
                return this.problem - o.problem;
            }
        }
    }

    static TreeSet<Problem> ts = new TreeSet<>(); //오름차순
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static HashMap<Integer, Integer> solved = new HashMap<>();

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <=N; i++){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            add(P, L);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i <M; i++){

            st = new StringTokenizer(br.readLine());
                        String cmd = st.nextToken();
            String pbl = st.nextToken();

            if (cmd.equals("add")){
                int lv = Integer.parseInt(st.nextToken());
                add(Integer.parseInt(pbl), lv);

            } else if (cmd.equals("solved")){
                solve(Integer.parseInt(pbl));

            } else{ //recommend
                Problem problem = recommend(Integer.parseInt(pbl));
                sb.append(problem.problem + "\n");
            }
        }
        System.out.println(sb);
    }
    static void add(int problem, int level){
        ts.add(new Problem(problem, level));
        solved.put(problem, level);
    }
    static void solve(int problem){ //
        // 이전에 있던 문제 번호가 다른 난이도로 들어올 수 있음.
        // 문제당 현재 들어있는 난이도를 저장하면, 현재 들어있는 난이도에 대해서만 방문 처리 or 삭제
        ts.remove(new Problem(problem, solved.get(problem)));
//        boolean solved = ts.removeIf(p -> p.problem == problem); -> O(N)
    }
    static Problem recommend(int com){ // O(1)
        if (com == -1) {
            return ts.first();
        } else{
            return ts.last();
        }
    }
}
