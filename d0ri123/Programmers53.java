package d0ri123;

import java.util.Arrays;
import java.util.HashMap;

public class Programmers53 {
    public static void main(String[] args) {
        Programmers53 sol = new Programmers53();
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};
        System.out.println(Arrays.toString(sol.solution(keymap, targets)));
    }

    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] answer = new int[targets.length];


        for(char ch = 'A'; ch <= 'Z'; ch++) {
            int idx = Integer.MAX_VALUE;
            for(String key : keymap) {
                int a = key.indexOf(String.valueOf(ch));
                if(a >= 0) {
                    idx = Math.min(a, idx);
                    map.put(ch, idx+1);
                }
            }
        }

        for(int i=0; i< targets.length; i++) {
            int tapped = 0;
            for(char ch : targets[i].toCharArray()) {
                if(!map.containsKey(ch)) {
                    tapped = -1;
                    break;
                }
                tapped += map.get(ch);
            }
            answer[i] = tapped;
        }

        return answer;
    }

}
