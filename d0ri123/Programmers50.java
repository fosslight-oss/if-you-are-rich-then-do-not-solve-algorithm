package d0ri123;

public class Programmers50 {
    public static int[] board;
    public static int count;

    public static void main(String[] args) {
        Programmers50 sol = new Programmers50();
        int n = 4;

        System.out.println(sol.solution(n));
    }

    public int solution(int n) {
        board = new int[n];
        dfs(0,n);
        return count;
    }

    public void dfs(int L, int n) {
        if(L == n) {
            count++;
            return;
        }
        for(int j=0; j<n; j++) {
            board[L] = j;
            if(isValid(L)) {
                dfs(L+1, n);
            }
        }
    }

    public static boolean isValid(int depth) {
        for (int j = 0; j < depth; j++) {
            if (board[depth] == board[j]) return false;
            //(depth, board[depth]) 와 (j, board[j])의 기울기가 1이다.
            //2차원 배열에서 대각선을 나타내는 기울기는 1이기 때문이다. <=> 행과 열 인덱스가 모두 같은 경우
            if (Math.abs(depth - j) == Math.abs(board[depth] - board[j])) return false;
        }
        return true;
    }
}
