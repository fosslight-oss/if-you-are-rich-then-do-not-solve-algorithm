import java.util.*;
class Solution {

    public String solution(String s){
        // (( )) ( ) ( ) / (( ) (  ))
         return recur(s,0,s.length()-1);
    }

    public String recur(String s, int start, int end){
//        System.out.println(" 압축해재 시작 "+ s.substring(start, end+1) + " "+ start + " : "+ end);
        StringBuilder sb = new StringBuilder();
        for(int i = start; i<= end; i++){
            char c = s.charAt(i);

            if (isNumber(c)){
                int lastNumIndex = getLastNumIndex(s,i);
                int K = Integer.parseInt(s.substring(i,lastNumIndex + 1));
//                System.out.println(i+"에서 K = "+ K);
                int bracketEndIdx = getBracketEndIdx(s, lastNumIndex + 1, end);
//                System.out.println(" bracket  = "+ s.substring(lastNumIndex + 1 , bracketEndIdx+1 ));
                String unzipped = recur(s, lastNumIndex+2, bracketEndIdx-1);
                for (int r = 1; r<= K; r++){
                    sb.append(unzipped);
                }
//                System.out.println(i+"에서 압축해제 완료 "+ sb);
                i = bracketEndIdx;

            }else {
                sb.append(c);
            }
        }
//        System.out.println(" 압축 완성 "+ sb);
        return sb.toString();

    }
    static int getBracketEndIdx(String s, int startBracket, int end){
        int endBracket = startBracket + 1;
        ArrayDeque<Character> q = new ArrayDeque<>();
        q.add(s.charAt(startBracket));

        for (; endBracket <= end; endBracket++){
            char c = s.charAt(endBracket);
            if (c == '(') q.add(c);
            if (c == ')') q.poll();
            if (q.size()==0) break;
        }
        return endBracket;

    }
    static int getLastNumIndex(String s, int start){
        int k = start;
        while (k + 1 < s.length() && isNumber(s.charAt(k+1))){
            k++;
        }
        return k;
    }
    static boolean isNumber(char c){
        return '0' <= c && c <= '9';
    }

    public static void main(String[] args){
        Solution T = new Solution();
//        System.out.println(T.solution("10(a)"));
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}