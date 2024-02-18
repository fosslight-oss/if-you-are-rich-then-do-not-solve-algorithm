import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class BOJ_16926_배열돌리기1 {

    static int [][] map;
    static List<Integer> [] lines;
    static int [] startOfLine;
    static int N, M, R, numOfLine;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;

    public static void main(String[] args) throws IOException {
        input();
        splitLine();
        rotate(R);
        printLines();
    }

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M  = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i <N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        System.out.println(Arrays.deepToString(map));
        numOfLine = Math.min(N,M) / 2;
//        System.out.println("numOfLine : " + numOfLine);
        lines = new ArrayList[numOfLine];
        for (int i = 0; i < numOfLine; i++) lines[i] = new ArrayList<>();
        startOfLine = new int[numOfLine];

    }

    static void splitLine(){
        for (int i = 0; i < numOfLine; i++){
            //down
            for(int r = i; r < N - 1 - i; r ++){
                lines[i].add(map[r][i]);
            }
            //right
            for (int c = i ; c < M -1 - i; c ++){
                lines[i].add(map[N-1-i][c]);
            }
            //up
            for (int r = N - 1 - i; r > i; r--){
                lines[i].add(map[r][M-1-i]);
            }
            //left
            for (int c = M -1 -i; c > i; c --){
                lines[i].add(map[i][c]);
            }
        }

//        System.out.println("splitLine result .... ");
//        for (int i = 0; i< numOfLine; i++){
//            System.out.println(lines[i]);
//
//        }
    }

    private static void printLines() {
        int [][] result = new int[N][M];
        for (int i = 0; i< numOfLine; i++){
            int pos = startOfLine[i];
            //down
            for(int r = i; r < N - 1 - i; r ++){
                result[r][i] = lines[i].remove(getNextPos(i, pos));
            }
            //right
            for (int c = i ; c < M -1 - i; c ++){
                result[N-1-i][c] = lines[i].remove(getNextPos(i, pos));
            }
            //up
            for (int r = N - 1 - i; r > i; r--){
                result[r][M-1-i] = lines[i].remove(getNextPos(i, pos));
            }
            //left
            for (int c = M -1 -i; c > i; c --){
                result[i][c] = lines[i].remove(getNextPos(i, pos));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i =0; i< N; i++){
            for (int j =0; j<M; j++){
                sb.append(result[i][j] +" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static int getNextPos(int line, int pos){
        if (pos < lines[line].size()) return pos;
        else return 0;
    }

    static void rotate(int r){
//        System.out.println("BOJ_16926_배열돌리기1.rotate");
        for (int j = 0; j <numOfLine; j++){
            int move = r % lines[j].size();
            startOfLine[j]  = lines[j].size() - move;
//            System.out.println("start of line " + j  +" = "+startOfLine[j] );
         }
    }

}
