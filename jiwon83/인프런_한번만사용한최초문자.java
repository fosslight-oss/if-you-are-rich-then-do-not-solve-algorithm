class Solution {
    public int solution(String s){
        int answer = 0;
        //한 번만 사용하는 문자 중 가장 첫번째를 찾는다.
        int [] cnt = new int[26]; //알파벳의 사용 횟수 저장
        int ans = -1;
        for (int i =0; i<s.length(); i++){
            cnt[s.charAt(i)-'a']++;
        }
        for (int i = s.length()-1; i >= 0; i-- ){
            int c = s.charAt(i)-'a';
            if (cnt[c]==1){
                ans = i+1;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}