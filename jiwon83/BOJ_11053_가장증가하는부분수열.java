import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
소수점 출력 시 그냥 print 하면 안됨 -> E 사용한 표현식으로 출력된다.
String.format()으로 해야함
 */
public class BOJ_11053_가장증가하는부분수열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int [] a;
    static int [] dp;

    static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        a = new int[N + 1];
        dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=N; i++){
            dp[i] = 1;
            a[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        int ans = 0;
        for (int L = 1; L <= N; L++){ // dp[i] = i번 째 까지의 최대 길이
            for (int R = 1; R < L; R++ ){
                if (a[R] < a[L]) dp[L] = Math.max(dp[L], dp[R]+1);
            }
            ans = Math.max(ans, dp[L]);
        }
        // dp[i]는 항상 i를 포함한다. 따라서, i를 포함하지 않은 값도 갱신해주어야 함.
        System.out.println(Arrays.toString(dp));
//        System.out.println(ans + " , "+ dp[N]);
        System.out.println(ans);
    }
}