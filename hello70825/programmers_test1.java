import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {

        Map<Integer, Integer> counter_x = new HashMap<>();
        Map<Integer, Integer> counter_y = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            if (counter_x.containsKey(arr[i][0])) {
                counter_x.put(arr[i][0], 2);
            } else {
                counter_x.put(arr[i][0], 1);
            }
            if (counter_y.containsKey(arr[i][1])) {
                counter_y.put(arr[i][1], 2);
            } else {
                counter_y.put(arr[i][1], 1);
            }
        }

        int x = 0;
        int y = 0;
        for (Integer integer : counter_x.keySet()) {
            if (counter_x.get(integer) == 1) {
                x = integer;
            }
        }
        for (Integer integer : counter_y.keySet()) {
            if (counter_y.get(integer) == 1) {
                y = integer;
            }
        }

        int[] answer = {x, y};

        return answer;
    }
}
