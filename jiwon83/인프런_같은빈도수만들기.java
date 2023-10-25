import java.util.*;
class Solution {
    public int[] solution(String s){
        int[] answer = new int[5];
        int maxCnt = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i<s.length(); i++){
            char key = s.charAt(i);
            hm.put(key, hm.getOrDefault(key, 0)+1);
            maxCnt = Math.max(maxCnt, hm.get(key));
        }
        for (int i =0; i<5; i++){
            char key = (char)(i+'a');
            answer[i] = maxCnt - hm.getOrDefault(key, 0);
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
