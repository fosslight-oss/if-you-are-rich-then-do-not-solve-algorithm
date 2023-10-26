class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int pCount = 0;
        int yCount = 0;
        for(int i = 0; i < s.length(); i++) {
            char val = s.charAt(i);
            if (val == 'p' || val == 'P') {
                pCount++;
            }
            if (val == 'y' || val == 'Y') {
                yCount++;
            }
        }

        if (pCount != yCount) {
            answer = false;
        }

        return answer;
    }
}
