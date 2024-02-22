import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20164_홀수홀릭호석 {

    static int max, min;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        // _ +  _
        // 9자리
        // 모든 경우의 수 가능할듯?
        min = Integer.MAX_VALUE;
        String input = br.readLine();
        recur(0, input);

        System.out.println(min + " "+ max);

    }
    static void recur(int odd, String card){
//        System.out.println("odd = " + odd + " card = "+ card);
        int oddCount = getOddCount(card);
        if (card.length() == 1){
            max = Math.max(max, odd+oddCount);
            min = Math.min(min, odd+oddCount);
        }else if (card.length() == 2){
            int newNum = card.charAt(0)-'0' + card.charAt(1)-'0';
            recur(odd+oddCount, newNum+"");

        }else{
            // 3개로 분할
            //3426445
//            System.out.println("3개로 분할");
            for (int sp1 = 0; sp1 < card.length()-2; sp1++){
                for(int sp2 = sp1 + 1; sp2 < card.length()-1; sp2++){
                    String str1 = card.substring(0, sp1+1);
                    String str2 = card.substring(sp1+1, sp2+1);
                    String str3 = card.substring(sp2+1);
//                    System.out.println("str1 = " + str1);
//                    System.out.println("str2 = " + str2);
//                    System.out.println("str3 = " + str3);
                    int newNum = Integer.parseInt(str1) + Integer.parseInt(str2) + Integer.parseInt(str3);
                    recur(odd + getOddCount(str1)+ getOddCount(str2) + getOddCount(str3)
                            , newNum+""
                            );

                }
            }
        }
    }
    static int getOddCount(String str){
        int cnt = 0;
        for (char c : str.toCharArray()){
            if ( ((c -'0') & 1) == 1 ) cnt++;
        }
        return cnt;
    }
}

