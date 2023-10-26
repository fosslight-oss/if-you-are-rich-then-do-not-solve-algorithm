class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        int[] val = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        for (int i : val) {
            boolean flag = false;
            for (int number : numbers) {
                if (number == i) {
                    flag = true;
                }
            }
            if (!flag) {
                answer += i;
            }
        }
        
        return answer;
    }
}
