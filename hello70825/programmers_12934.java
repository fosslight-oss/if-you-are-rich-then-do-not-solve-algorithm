class Solution {
    public long solution(long n) {
        long answer = -1;
        for(int i = 1; i < Math.sqrt(n) + 1; i++) {
            if (n % i == 0 && n / i == i) {
                answer = (long) (i + 1) * (i + 1);
                break;
            }
        }
        return answer;
    }
}
