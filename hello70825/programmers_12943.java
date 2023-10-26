class Solution {
    public int solution(int num) {
        int answer = 0;
        
        int count = 0;
        long val = num;
        while (val != 1) {
            if (count == 500) {
                answer = -1;
                break;
            }
            if (val % 2 == 0) {
                val /= 2;
            } else {
                val = val * 3 + 1;
            }
            count++;
        }

        if (answer != -1) {
            answer = count;
        }
        
        return answer;
    }
}
