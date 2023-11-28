package d0ri123;

import java.util.Arrays;

public class Programmers44 {

    public static void main(String[] args) {
        Programmers44 sol = new Programmers44();
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        System.out.println(Arrays.toString(sol.solution(n, arr1, arr2)));
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        int idx = 0;
        String[] map = new String[n];
        while(idx < n) {
            String result = Integer.toBinaryString(arr1[idx] | arr2[idx]);
            if(result.length()!=n) {
                int cnt = n - result.length();
                result = "0".repeat(cnt) + result;
            }
            map[idx] = result.replaceAll("1", "#").replaceAll("0", " ");
            idx++;
        }
        return map;
    }

}
