import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class BOJ_1269_대칭차집합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        Set<Integer> union = new HashSet<>();
        int A, B;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            union.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            union.add(Integer.parseInt(st.nextToken()));
        }
        int intersection = A + B - union.size();
        System.out.println(union.size()-intersection);
        // 2*union.size() - (A+B)




    }

}