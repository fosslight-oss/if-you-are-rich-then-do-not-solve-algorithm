package d0ri123;

public class Programmers52 {
    public static int[] dy;
    public static void main(String[] args) {
        Programmers52 sol = new Programmers52();
        int n = 4;

        System.out.println(sol.solution(n));
    }

    public int solution(int n) {
        dy = new int[n+1];
        dy[1] = 1;
        dy[2] = 2;
        for(int i=3; i<=n; i++){
            dy[i] = (dy[i-1] + dy[i-2]) % 1000000007;
        }
        return dy[n];
    }
}
