import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int answer, N;
    static ArrayDeque<Integer> [] deques;

    static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        deques = new ArrayDeque[N+1];
        for (int i = 1; i<=N; i++) deques[i] = new ArrayDeque<>();
        for (int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=N; j++){
                deques[j].addLast(Integer.parseInt(st.nextToken()));
            }

        }
    }
    public static void main(String[] args) throws IOException{
        input();
        int ans = -1;
        for (int i = 0; i<N; i++){
            int max = Integer.MIN_VALUE;
            int idx = -1;
            for (int j = 1; j<=N; j++){
                if( !deques[j].isEmpty() && max < deques[j].peekLast()){
                    max = deques[j].peekLast();
                    idx = j;
                }
            }
            int num = deques[idx].pollLast();
            ans = num;
        }
        System.out.println(ans);


    }
    // N = 1,450,000
    // 1 MB = 1000 KB * 1000byte / 4 = int 갯수 250,000
    // 12 MB = 250,000 * 12

}