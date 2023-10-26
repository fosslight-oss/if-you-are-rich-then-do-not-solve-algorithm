class Solution {
    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];

        int idx = 0;
        while (n != 0) {
            answer[idx] = (int) (n % 10);
            idx ++;
            n /= 10;
        }
        
        return answer;
    }
}
