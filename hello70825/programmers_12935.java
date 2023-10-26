import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
                List<Integer> vec = new ArrayList<>();
        for (int i : arr) {
            vec.add(i);
        }
        Collections.sort(vec);

        int min = vec.get(0);
        List<Integer> temp = new ArrayList<>();
        for (int i : arr) {
            if (i != min) {
                temp.add(i);
            }
        }
        if (temp.size() == 0) {
            temp.add(-1);
        }

        answer = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        
        return answer;
    }
}
