package d0ri123;

public class Programmers58 {

    public static void main(String[] args) {
        Programmers58 sol = new Programmers58();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        System.out.println(sol.solution(sizes));
    }

    public int solution(int[][] sizes) {
        int[] height = new int[sizes.length];
        int[] width = new int[sizes.length];

        int maxW = Integer.MIN_VALUE;
        int maxH = Integer.MIN_VALUE;

        for(int i=0; i<sizes.length; i++) {
            width[i] = Math.max(sizes[i][0], sizes[i][1]);
            height[i] = Math.min(sizes[i][0], sizes[i][1]);
            maxH = Math.max(maxH, height[i]);
            maxW = Math.max(maxW, width[i]);
        }

        return maxW * maxH;
    }

}
