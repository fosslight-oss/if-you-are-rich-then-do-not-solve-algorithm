import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2696_중앙값구하기 {

    static int M, T;
    static List<Integer> nums;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <=T; t++){
            nums = new ArrayList<>();
            M = Integer.parseInt(br.readLine());
            if (M > 10){
                for (int r =0; r < M/10; r++){
                    st = new StringTokenizer(br.readLine());
                    for (int i = 1; i <=Math.min(M, 10); i++){
                        nums.add(Integer.parseInt(st.nextToken()));
                    }
                }
                if (M % 10 != 0){
                    st = new StringTokenizer(br.readLine());
                    while (st.hasMoreTokens()){
                        nums.add(Integer.parseInt(st.nextToken()));
                    }
                }
            }else{
                st = new StringTokenizer(br.readLine());
                for (int i = 1; i <=Math.min(M, 10); i++){
                    nums.add(Integer.parseInt(st.nextToken()));
                }
            }
            sol();
        }
        System.out.println(sb);
    }

    public static void sol(){
        int ansCnt = 0;
        sb.append(M/2 + 1).append("\n");
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 중앙값 초과의 숫자
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // 중앙값 이하의 숫자

        for (int i = 0; i <M ; i++){
            //일단 넣고
            int num = nums.get(i);
            if (maxHeap.size() == minHeap.size()) maxHeap.add(num);
            else if( maxHeap.size() > minHeap.size()) minHeap.add(num);
            else maxHeap.add(num);

            //swap
            while (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
                minHeap.add(maxHeap.poll());
                maxHeap.add(minHeap.poll());
            }
            
            if ((i & 1)== 0){
                ansCnt++;
                if (ansCnt > 10 && ansCnt % 10 == 1) sb.append("\n");
                sb.append(maxHeap.peek()+" ");
            }
        }
        sb.append("\n");
    }
}