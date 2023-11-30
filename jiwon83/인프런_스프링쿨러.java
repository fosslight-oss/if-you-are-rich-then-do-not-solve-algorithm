import java.util.*;
class 인프런_스프링쿨러 {
    public int solution(int n, int[] nums){
        int answer =0;
        //1. 스프링 쿨러의 범위를 정해서 배열을 만든 후 정렬한다.
        int[][] a = new int[n+1][2];
        for (int i = 0; i<=n; i++){
            a[i][0] = Math.max(0, i - nums[i]);
            a[i][1] = Math.min(i + nums[i], n);
        }

//        Arrays.sort(a, (o1, o2) -> {
//            if (o1[0] != o2[0]){
//                return Integer.compare(o1[0], o2[0]);
//            }else{
//                return Integer.compare(o1[1], o2[1]);
//            }
//        });

        Arrays.sort(a, (o1, o2) ->  o1[0] - o2[0] );

        System.out.println(Arrays.deepToString(a));

        //2. 배열을 순회하면서 필요없는 스프링 쿨러는 넘어간다.
        int S = 0 ; // 물을 뿌려야 하는 시작 위치
        int E = -1; // 현재 스프링 쿨러의 물을 뿌릴 수 있는 최대 위치
        int i = 0;
        while (i <= n){

            while ( i <= n &&  a[i][0] <= S){
                E = Math.max(E, a[i+1][1]);
                i++;
            }
            answer++;
            if( E == n ) break; //마지막 잔디까지 뿌려졌다면
            if (S == E) return -1; //시작에 해당하는 아무 스프링쿨러도 찾을 수 없었거나, 범위가 0이여서 자기자신만 뿌린 경우
            S = E;
        }
        return answer;
    }
    public static void main(String[] args){
        인프런_스프링쿨러 T = new 인프런_스프링쿨러();
//        System.out.println(T.solution(3, new int[]{3,1,0,0}));
        System.out.println(T.solution(3, new int[]{0,1,0,3}));
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}