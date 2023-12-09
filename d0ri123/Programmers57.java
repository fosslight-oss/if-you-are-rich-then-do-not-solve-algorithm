package d0ri123;

public class Programmers57 {
    public static void main(String[] args) {
        Programmers57 sol = new Programmers57();
        String[] babbling = {"aya", "yee", "u", "maa"};
        System.out.println(sol.solution(babbling));
    }

    public int solution(String[] babbling) {
        int answer = 0;
        for (String s : babbling) {
            s = s.replaceAll("ayaaya|yeye|woowoo|mama", " ");
            s = s.replaceAll("aya|ye|woo|ma", "");
            if (s.equals(""))
                answer++;
        }
        return answer;
    }

}
