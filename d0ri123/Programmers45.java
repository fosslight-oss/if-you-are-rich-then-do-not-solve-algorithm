package d0ri123;

public class Programmers45 {

    public static void main(String[] args) {
        Programmers45 sol = new Programmers45();
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};
        System.out.println(sol.solution(sequence));
    }

    public long solution(int[] sequence) {
        long answer;

        int[] arr1 = sequence.clone();
        int[] arr2 = sequence.clone();
        applyPulse1(arr1); //짝수 인덱스의 숫자가 -1로 바뀜
        applyPulse2(arr2); //홀수 인덱스의 숫자가 -1로 바뀜

        long bestSum1 = Integer.MIN_VALUE;
        long endSum1 = 0;
        for(int num : arr1) {
            endSum1 = Math.max(endSum1 + num, num);
            bestSum1  = Math.max(endSum1, bestSum1);
        }

        long bestSum2 = Integer.MIN_VALUE;
        long endSum2 = 0;
        for(int num : arr2) {
            endSum2 = Math.max(endSum2 + num, num);
            bestSum2 = Math.max(endSum2, bestSum2);
        }

        answer = Math.max(bestSum1, bestSum2);
        return answer;
    }

    /**
     * 짝수에는 *(-1), 홀수에는 *1
     */
    private static void applyPulse1(int[] sequence) {
        for(int i=0; i<sequence.length; i++) {
            if(i%2==0) {
                sequence[i] *= -1;
            }
        }
    }

    /**
     * 짝수에는 *1, 홀수에는 *(-1)
     */
    private static void applyPulse2(int[] sequence) {
        for(int i=0; i<sequence.length; i++) {
            if(i%2 != 0) {
                sequence[i] *= -1;
            }
        }
    }

}
