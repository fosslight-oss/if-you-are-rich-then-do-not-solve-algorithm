package d0ri123;

import java.util.HashMap;
import java.util.Map;

public class Programmers47 {

    public static void main(String[] args) {

    }

    public int solution(String s) {
        Map<Character, Integer> resultTable = new HashMap<>();

        for (char ch : s.toCharArray()) {
            resultTable.put(ch, resultTable.getOrDefault(ch, 0) + 1);
        }

        return (int)resultTable.entrySet()
            .stream()
            .filter(entry -> isOddNumber(entry.getValue()))
            .count();
    }

    private boolean isOddNumber(int value) {
        return (value%2 == 1);
    }

}
