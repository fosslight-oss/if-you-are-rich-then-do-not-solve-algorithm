import java.util.*;
class Solution {
    public int solution(int[][] fruit){
        int answer = 0;
        int N = fruit.length;
        boolean [] ch = new boolean[N];

        Loop1: for( int i = 0; i<N; i++){

            if(ch[i]) continue;
            int a = getMinIdx(fruit, i);
            if (a == -1) continue;

            for(int j = i+1; j<N; j++){
                if(ch[j]) continue;
                int b = getMinIdx(fruit, j);
                if (b == -1) continue; //최소 수 과일이 여러개라면 무효
                if (a == b) continue;//최소 과일이 같은 과일이라면 무효
                if (upper1thanMin(fruit, j, a, b) || upper1thanMin(fruit, i, b, a)) continue;
                fruit[i][a]++; fruit[i][b]--;
                fruit[j][b]++; fruit[j][a]--;
                ch[j] = true;
                break;


            }
        }

        for (int i = 0; i<N; i++){
            Arrays.sort(fruit[i]);
            answer += fruit[i][0];
        }
        return answer;
    }
    static boolean upper1thanMin(int[][] fruit, int seq, int tar, int min){ // seq : 학생, f = 뺏길 과일 인덱스, minF = 최소 과일인덱스
        return fruit[seq][tar] - fruit[seq][min] <= 1;
    }

    static int getMinIdx(int[][] fruit, int idx){
        int min = 100;
        int minIdx = -1;
        for(int x = 0; x <3; x++){
            if (min > fruit[idx][x]){
                min = fruit[idx][x];
                minIdx = x;
            }
        }
        int cnt = 0;
        for(int x : fruit[idx]){
            if(x == min) cnt++;
        }
        return cnt == 1? minIdx : -1;

//        int min = Arrays.stream(fruit[idx]).min().getAsInt();
//        int count = (int) Arrays.stream(fruit[idx]).filter(v -> v == min).count();
//        return count > 1? -1 : Arrays.binarySearch(fruit[idx], min);
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
