class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        long copyX = x;
        int num = 0;
        while (copyX != 0) {
            num += copyX % 10;
            copyX /= 10;
        }

        if (x % num != 0) {
            answer = false;
        }
        
        return answer;
    }
}
