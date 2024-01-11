import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int answer, N;
    static int [][] a;

    static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        a = new int[N][2];
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            a[i] = new int[]{x,y};
        }
        Arrays.sort(a, (o1,o2) ->o1[0] - o2[0]);

    }
    public static void main(String[] args) throws IOException{
        input();
 
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            int height = a[i][1];
            if(deque.isEmpty() || deque.peekLast() < height){
                if( height != 0) deque.addLast(height);
            }else if(deque.peekLast() == height){
                continue;
            }else if( deque.peekLast() > height){
                while (!deque.isEmpty() && deque.peekLast() > height){
                    deque.pollLast();
                    answer++;
                }
                while (!deque.isEmpty() && deque.peekLast() == height){
                    deque.pollLast();
                }
                if( height != 0) deque.addLast(height);
            }
        }
        answer += deque.size();
        System.out.println(answer);

    }


}