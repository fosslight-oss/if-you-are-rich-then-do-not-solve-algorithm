package d0ri123;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Programmers46 {

    public static void main(String[] args) {
        Programmers46 sol = new Programmers46();
        int[] numbers = {6,1,6,6,7,6,6,7};

        System.out.println(sol.solution(numbers));
    }

    public int solution(int[] numbers) {
        Map<Integer, Integer> resultTable = new HashMap<>();
        int targetNumber = numbers.length/2;
        for(int number : numbers) {
            resultTable.put(number, resultTable.getOrDefault(number, 0) + 1);
        }

        return resultTable.entrySet()
            .stream()
            .filter(entry -> entry.getValue() > targetNumber)
            .mapToInt(Entry::getKey)
            .findAny()
            .orElse(-1);
    }

}
