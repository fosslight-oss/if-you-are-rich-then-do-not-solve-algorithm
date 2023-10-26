import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        List<Long> arr = new ArrayList<>();
        while (n != 0) {
            arr.add(n % 10);
            n /= 10;
        }
        Collections.sort(arr);

        for (int i = arr.size() - 1; i >= 0; i--) {
            answer *= 10;
            answer += arr.get(i);
        }
        
        return answer;
    }
}
