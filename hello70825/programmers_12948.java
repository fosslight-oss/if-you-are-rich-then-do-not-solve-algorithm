class Solution {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        
        int length = phone_number.length() - 4;
        answer.append("*".repeat(Math.max(0, length)));
        for(int i = length; i < phone_number.length(); i++) {
            answer.append(phone_number.charAt(i));
        }
        
        return answer.toString();
    }
}
